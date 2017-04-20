package com.my.web.lib;


import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

//import java.util.logging.SimpleFormatter;

public class HTMLReport extends Formatter {

	private int i = 0; //��¼������Ŀ
	private long setStartTime; // log��ʼʱ��
	private long setEndTime; // log����ʱ��
	private static int p_pass=0; // Pass�����ĸ���
	private static int p_fail=0; // Fail�����ĸ���
	private static String result=""; // case���
	private static Object expected=""; // �ڴ�ֵ
	private static Object actual=""; // ʵ��ֵ
	private static Logger logger = Logger.getLogger(HTMLReport.class.getName());
	static private FileHandler fileHTML;
	static private Formatter formatterHTML;
	
	

	static final String HTML_HEADER = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"
			+ "<META HTTP-EQUIV=\"CACHE-CONTROL\" CONTENT=\"NO-CACHE\">"
			+ "<META HTTP-EQUIV=\"PRAGMA\" CONTENT=\"NO-CACHE\">"
			+ "<link rel=\"stylesheet\" href=\"demo_report_style.css\"/>"
			+ "<html><head><title>���Ա���</title></head>"
			+ "<body>"
			+ "<div class=\"page_title\"><center>"
			+ "<h1>���Ա���</h1></center></div>"
			+ "<div class=\"statistics\"><table id=\"statistics_table\" class=\"sortable\" align=\"center\" border=\"0\"  style=\"width:100%;\"><tr>"
			+ "<th><b>���</b></th>"
			+ "<th><b>��������</b></th>"
			+ "<th><b>�ڴ����</b></th>"
			+ "<th><b>ʵ�ʽ��</b></th>"
			+ "<th><b>ִ��ʱ��</b></th>" + "<th><b>״̬</b></th>" + "</tr>";
	//HTML �ļ���ʽ

	public void setup(String p_logName) throws IOException {

		fileHTML = new FileHandler(p_logName);

		// Create HTML Formatter
		formatterHTML = new HTMLReport();
		fileHTML.setFormatter(formatterHTML);
		logger.addHandler(fileHTML);
	}

	public void closeLog() {
		fileHTML.close();
		p_pass=0; // Pass�����ĸ���
		p_fail=0; // Fail�����ĸ���
		result=""; // case���
		expected=""; // �ڴ�ֵ
		actual=""; // ʵ��ֵ
	}

	public void logWriter(String p_info, Object p_expected,
			Object p_actual, String p_result)  {
		result = p_result;
		actual = p_actual;
		expected = p_expected;
		// setup();
		try {
			logger.info(p_info);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(" logger write exception!");
		}
		

	}
	public void logWriter(String p_info, String p_result)  {
		result = p_result;
		// setup();
		try {
			logger.info(p_info);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(" logger write exception!");
		}
		

	}
	
	public void logWriter(String p_info) throws IOException  {
		
		logger.info(p_info);
		

	}

	public String format(LogRecord rec) {
		StringBuffer buf = new StringBuffer(1000);
		// Bold any levels >= WARNING
		buf.append("<div class=\"statistics\">");
		buf.append("<tr>");
		buf.append("<td>");
		buf.append(recordStep());
		buf.append("</td>");
		buf.append("<td>");
		// buf.append(calcDate(rec.getMillis()));
		// buf.append(' ');
		buf.append(formatMessage(rec));
		buf.append('\n');
		buf.append("</td>");
		buf.append("<td>");
		buf.append(expected);
		buf.append("</td>");
		buf.append("<td>");
		buf.append(actual);
		buf.append("</td>");
		buf.append("<td>");
		buf.append(getCalcDate(rec.getMillis()));
		buf.append("</td>");
		buf.append("<td>");
		if (result.matches("Pass")||result.matches("PASS")) {
			p_pass = p_pass + 1;
			buf.append("<b>");
			buf.append("<font color=Green>");
			buf.append(result);
			buf.append("</font>");
			buf.append("</b>");
		} else if (result.matches("Fail")||result.matches("FAIL")) {
			p_fail = p_fail + 1;
			buf.append("<b>");
			buf.append("<font color=Red>");
			buf.append(result);
			buf.append("</font>");
			buf.append("</b>");
		
			/*	
			//��report�мӽ�ͼ�󣬶����html�ļ���ʽ
			buf.append("<tr>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("<a href=getScreenShotPath()><img src=getScreenShotPath() height=\"150\" /></a>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("</tr>");
			
		*/
		}
		else{
			buf.append("<b>");
			// buf.append("<font color=Black>");
			buf.append("");
			buf.append("</b>");
			
		}
		buf.append("</td>");
		buf.append("</tr>");
		buf.append("</div>\n");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buf.toString();
	}

	
	private int recordStep() {
		i = i + 1;
		return i;
	}
	
	private String getPercnet(double p_numerator, double p_denominator) {
		double percent = p_numerator / p_denominator;
		NumberFormat nt = NumberFormat.getPercentInstance();
		// ���ðٷ�����ȷ��2��������λС��
		nt.setMinimumFractionDigits(1);
		return nt.format(percent);

	}

	private String getCalcDate(long millisecs) {
		SimpleDateFormat date_format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date resultdate = new Date(millisecs);
		return date_format.format(resultdate);
	}

	private String getDeltaTime(long p_startTime, long p_endTime) {
		long day = (p_endTime - p_startTime) / (24 * 60 * 60 * 1000);
		long hour = ((p_endTime - p_startTime) / (60 * 60 * 1000) - day * 24);
		long min = (((p_endTime - p_startTime) / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = ((p_endTime - p_startTime) / 1000 - day * 24 * 60 * 60 - hour
				* 60 * 60 - min * 60);

		return day + "��" + hour + "Сʱ" + min + "��" + s + "��";
	}
	


	
	public String getHead(Handler h)

	{
		setStartTime = System.currentTimeMillis();
		return HTML_HEADER;
	}


	public String getTail(Handler h)

	{
		setEndTime = System.currentTimeMillis();
		String HTML_Tail;
		int p_total = p_pass + p_fail;
		System.out.println(p_total);
		if (p_total > 0)
			if (p_fail > 0)
				// return HTML_Tail;
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;��ʼʱ��   ��"+ getCalcDate(setStartTime) 
				        + "<br>&nbsp;����ʱ��      ��"+ getCalcDate(setEndTime) 
				        + "<br>&nbsp;����ʱ��      ��"+ getDeltaTime(setEndTime, setStartTime)
						+ "<br>&nbsp;ִ������      ��" + p_total 
						+"<br>&nbsp;�����ɹ�         ��"+ p_pass
						+ "<br>&nbsp;<font color=Red>����ʧ��      ��"+ p_fail + "</font>" 
						+ "<br>&nbsp;�ɹ���(%) ��"+ getPercnet(p_pass, p_total)
						+ "<br>&nbsp;<font color=Red>ʧ����(%) ��"+ getPercnet(p_fail, p_total) + "</font>" 
						+ "<br><br>"
						+ "</BODY></HTML>";
			else
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;��ʼʱ��   ��"
						+ getCalcDate(setStartTime) + "<br>&nbsp;����ʱ��   ��"
						+ getCalcDate(setEndTime) + "<br>&nbsp;����ʱ��   ��"
						+ getDeltaTime(setEndTime, setStartTime)
						+ "<br>&nbsp;ִ������      ��" + p_total 
						+ "<br>&nbsp;�����ɹ�      ��"+ p_pass 
						+ "<br>&nbsp;����ʧ��      ��" + p_fail
						+ "<br>&nbsp;�ɹ���(%) ��" + getPercnet(p_pass, p_total)
						+ "<br>&nbsp;ʧ����(%) ��" + getPercnet(p_fail, p_total)
						+ "<br><br>"
						+ "</BODY></HTML>";
		else
			HTML_Tail = "</table></PRE>" + "<br>&nbsp;����ִ���쳣��" + "<br><br>"
					+ "</BODY></HTML>";

		return HTML_Tail;
	}

	

}
