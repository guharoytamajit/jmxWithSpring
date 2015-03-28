package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.SpringConfig6;
import com.sun.jdmk.comm.HtmlAdaptorServer;

public class Main6 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringConfig6.class);

		HtmlAdaptorServer htmlServer = (HtmlAdaptorServer) context
				.getBean("htmlBeanServer");
		htmlServer.start();
	}
}
