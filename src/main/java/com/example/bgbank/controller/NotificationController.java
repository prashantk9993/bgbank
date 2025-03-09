package com.example.bgbank.controller;

 import com.example.bgbank.service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private PushNotificationService pushNotificationService;

    @PostMapping("/send")
    public String sendNotification(@RequestParam String deviceId,
                                   @RequestParam String title,
                                   @RequestParam String message) {
        return pushNotificationService.sendNotification(deviceId, title, message);
    }
}
