package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class Main2 {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"beans2.xml");
		HtmlAdaptorServer htmlServer = (HtmlAdaptorServer) context
				.getBean("htmlServerBean");
		htmlServer.start();
	}
}
