package com.example.customer.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Value("${app.firebase-configuration-file}")
    private String configPath;

//    @PostConstruct
//    public void initialize() throws IOException {
//        Resource resource = new ClassPathResource(configPath);
//        FileInputStream serviceAccount = new FileInputStream(resource.getFile());
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//
////        if (FirebaseApp.getApps().isEmpty()) {
////            FirebaseApp.initializeApp(options, "DEFAULT");
////        }
//    }

    @PostConstruct
    public void initialize() {
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(configPath).getInputStream())).build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
//                log.info("Firebase application has been initialized");
            }
        } catch (IOException e) {
            System.out.println("lỗi: " + e);
        }
    }

}
