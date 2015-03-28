package com.mbean;

import javax.management.Notification;

import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;

public class Cat implements NotificationPublisherAware {
	private NotificationPublisher publisher;
	private String name1;
	public int age = 9;

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
		publisher.sendNotification(new Notification("cat.name", this, 10,
				"new name is " + name));
		this.name1 = name;
	}

	@Override
	public void setNotificationPublisher(NotificationPublisher publisher) {
		this.publisher = publisher;

	}

}
