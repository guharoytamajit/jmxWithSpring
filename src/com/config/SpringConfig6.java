package com.config;

import java.util.HashMap;

import javax.management.MBeanServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.support.MBeanServerFactoryBean;

import com.mbean.Cat;
import com.mbean.Dog;
import com.sun.jdmk.comm.HtmlAdaptorServer;

@Configuration
public class SpringConfig6 {
	@Autowired
	MBeanServer mBeanServer;

	@Bean
	public Dog dog() {
		return new Dog();
	}

	@Bean
	public Cat cat() {
		return new Cat();
	}

	@Bean
	public MBeanServerFactoryBean mbeanServer() {
		return new MBeanServerFactoryBean();
	}

	@Bean
	public MBeanExporter mbeanExporter() {
		MBeanExporter mBeanExporter = new MBeanExporter();
		mBeanExporter.setServer(mBeanServer);
		HashMap<String, Object> beans = new HashMap<String, Object>();
		beans.put("bean:type=dog", dog());
		beans.put("Adapter:name=Html", htmlBeanServer());
		mBeanExporter.setBeans(beans);
		return mBeanExporter;
	}

	@Bean
	public HtmlAdaptorServer htmlBeanServer() {
		return new HtmlAdaptorServer(9000);
	}
}
