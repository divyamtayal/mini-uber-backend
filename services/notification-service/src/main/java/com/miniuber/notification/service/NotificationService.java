package com.miniuber.notification.service;

import com.miniuber.notification.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {
    NotificationDTO sendNotification(NotificationDTO notificationDTO);
    List<NotificationDTO> getNotificationsByUserId(Long userId);
    void markAsRead(Long notificationId);
}
