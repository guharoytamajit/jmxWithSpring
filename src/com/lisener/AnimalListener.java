package com.lisener;

import javax.management.Notification;
import javax.management.NotificationListener;

public class AnimalListener implements NotificationListener {

	@Override
	public void handleNotification(Notification notification, Object handback) {
		System.out.println("Time: " + notification.getTimeStamp());
		System.out.println("Message: " + notification.getMessage());
		System.out.println("sequence: " + notification.getSequenceNumber());
		System.out.println("type: " + notification.getType());
		System.out.println("source object: " + notification.getSource());

	}

}
