package com.miniuber.notification.service;

import com.miniuber.notification.dto.NotificationDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final List<NotificationDTO> notifications = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    @Override
    public NotificationDTO sendNotification(NotificationDTO notificationDTO) {
        notificationDTO.setId(counter.getAndIncrement());
        notifications.add(notificationDTO);
        return notificationDTO;
    }

    @Override
    public List<NotificationDTO> getNotificationsByUserId(Long userId) {
        return notifications.stream()
                .filter(n -> n.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public void markAsRead(Long notificationId) {
        notifications.stream()
                .filter(n -> n.getId().equals(notificationId))
                .findFirst()
                .ifPresent(n -> n.setRead(true));
    }
}
