package com.example.bgbank.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {

    public String sendNotification(String deviceToken, String title, String messageBody) {
        try {
            // Create notification message
            Message message = Message.builder()
                    .setToken(deviceToken)
                    .setNotification(Notification.builder()
                            .setTitle(title)
                            .setBody(messageBody)
                            .build())
                    .build();

            // Send the message

            String response = FirebaseMessaging.getInstance().send(message);
            System.out.println("Sent message: " + response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending push notification: " + e.getMessage();
        }
    }
}
