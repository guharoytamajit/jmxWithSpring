package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class Main4 {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"beans4.xml");
		HtmlAdaptorServer htmlServer = (HtmlAdaptorServer) context
				.getBean("htmlServerBean");
		htmlServer.start();
	}
}
