package com.suite.web;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class SortedRunner extends BlockJUnit4ClassRunner{
	private Class<?> clazz;
	
	public SortedRunner(Class<?> klass) throws InitializationError {
		super(klass);
		this.clazz = klass;
		// TODO Auto-generated constructor stub
	}
	private  List<FrameworkMethod> myList;

	
	
	@Override
	public List<FrameworkMethod> computeTestMethods(){		
			myList = super.computeTestMethods();		
			Collections.sort(myList, new Comparator<FrameworkMethod>(){
				public int compare(FrameworkMethod f1, FrameworkMethod f2) {				
					Index o1 = f1.getAnnotation(Index.class);
					Index o2 = f2.getAnnotation(Index.class);
					if(o1 == null || o2 == null)
						return 0;
					return o1.value() - o2.value();
				}			
			});
				
		return myList;
	}
}
