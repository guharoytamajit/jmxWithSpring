package com.mbean;

import javax.management.Notification;

import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;

public class Dog implements NotificationPublisherAware, IDog {
	private NotificationPublisher publisher;
	private String name1;
	int age1 = 9;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jmxExample.AnimalMBean#getName()
	 */
	public String getName() {
		return name1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jmxExample.AnimalMBean#setName(java.lang.String)
	 */
	public void name(String name) {
		publisher.sendNotification(new Notification("key1", this, 0,
				"new name is " + name));
		this.name1 = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jmxExample.AnimalMBean#getAge()
	 */
	/* (non-Javadoc)
	 * @see com.mbean.IDog#age()
	 */
	@Override
	public int age() {
		return age1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jmxExample.AnimalMBean#setAge(int)
	 */
	/* (non-Javadoc)
	 * @see com.mbean.IDog#setAge(int)
	 */
	@Override
	public void setAge(int age) {
		this.age1 = age;
	}

	@Override
	public void setNotificationPublisher(NotificationPublisher publisher) {
		this.publisher = publisher;

	}

}
