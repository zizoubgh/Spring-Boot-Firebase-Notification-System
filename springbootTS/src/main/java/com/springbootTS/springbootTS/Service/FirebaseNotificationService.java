package com.springbootTS.springbootTS.Service;




import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;


@Service
public class FirebaseNotificationService {
    public String sendNotification(
            String token
    ) throws Exception {


        Message message = Message.builder()

                .setToken(token)

                .setNotification(
                        Notification.builder()
                                .setTitle("Hello")
                                .setBody("Hello from Spring Boot Firebase")
                                .build()
                )

                .build();


        return FirebaseMessaging
                .getInstance()
                .send(message);

    }

    public String sendNotification(
            String token,
            String title,
            String body
    ) throws FirebaseMessagingException {


        Message message = Message.builder()

                .setToken(token)

                .setNotification(
                        Notification.builder()
                                .setTitle(title)
                                .setBody(body)
                                .build()
                )

                .build();


        return FirebaseMessaging
                .getInstance()
                .send(message);

    }

}
