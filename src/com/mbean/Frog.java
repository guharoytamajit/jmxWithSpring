package com.mbean;

import javax.management.Notification;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;

@ManagedResource(objectName = "bean:name=frog")
public class Frog implements NotificationPublisherAware {
	private NotificationPublisher publisher;
	private String name1;
	public int age1 = 9;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jmxExample.AnimalMBean#getName()
	 */
	@ManagedAttribute(description = "used to get name")
	public String getName() {
		return name1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jmxExample.AnimalMBean#setName(java.lang.String)
	 */
	@ManagedOperation
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
	@ManagedOperation
	public int age() {
		return age1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jmxExample.AnimalMBean#setAge(int)
	 */
	@ManagedOperation(description = "can be used to set age")
	public void setAge(int age) {
		this.age1 = age;
	}

	@Override
	public void setNotificationPublisher(NotificationPublisher publisher) {
		this.publisher = publisher;

	}

}
