package com.springbootTS.springbootTS.config;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

@Configuration
public class FirebaseConfig {
    @Value("${firebase.service-account}")
    private String serviceAccountPath;

    @PostConstruct
    public void initialize() {
        try {

            if (FirebaseApp.getApps().isEmpty()) {

                InputStream inputStream =
                        new ClassPathResource(serviceAccountPath)
                                .getInputStream();

                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(inputStream))
                        .build();

                FirebaseApp.initializeApp(options);

                System.out.println("✅ Firebase Initialized");
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Firebase", e);
        }
    }
}
