package com.suite.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) 
//@Target(ElementType.METHOD)
public @interface Index {//Annotaion
	public int value();
}
