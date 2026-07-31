package com.springbootTS.springbootTS.controller;


import com.springbootTS.springbootTS.Service.FirebaseNotificationService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/notification")
@CrossOrigin
public class NotificationController {


    private final FirebaseNotificationService service;


    public NotificationController(
            FirebaseNotificationService service
    ){
        this.service = service;
    }



    @PostMapping("/send")
    public String send(
            @RequestParam String token
    ) throws Exception {


        return service.sendNotification(
                token,
                "Hello",
                "Hello from Spring Boot Firebase"
        );

    }

}