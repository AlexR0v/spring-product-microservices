package ru.alexrov.notifications.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.alexrov.notifications.email.EmailService;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final EmailService emailService;

    //TODO: выдает ошибку десериализации
//    @KafkaListener(topics = "order-create")
//    public void sendNotification(OrderCreateEvent orderCreateEvent) throws MessagingException {
//        this.emailService.sendEmailCode(
//                orderCreateEvent.getEmail().toString(),
//                orderCreateEvent.getOrderNumber().toString()
//        );
//        log.info("email sent for {}", orderCreateEvent.getEmail().toString());
//    }
}
