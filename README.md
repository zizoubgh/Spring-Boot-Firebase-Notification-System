# Spring Boot Firebase Notification System 🔔
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/4abc2701-8bc4-4345-ba40-97b96fd87354" />
![Uploading image.png…]()

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/7197e6d4-de91-40e2-986c-ac6bb16b4bc6" />

A full-stack notification system using:

- Spring Boot REST API
- Firebase Admin SDK
- Firebase Cloud Messaging (FCM)
- React + TypeScript
- Vite
- Swagger OpenAPI

This project demonstrates how to send push notifications from a Spring Boot backend to a React TypeScript frontend using Firebase Cloud Messaging.

---

# 📌 Project Overview

The application allows:

- Getting Firebase Cloud Messaging Token from React.
- Sending notifications from Spring Boot.
- Receiving browser push notifications.
- Testing notification API using Swagger.

Architecture:

```
React TypeScript
        |
        | FCM Token
        |
        ↓
Spring Boot REST API
        |
        | Firebase Admin SDK
        |
        ↓
Firebase Cloud Messaging
        |
        ↓
Browser Notification
```

---

# 🛠 Technologies

## Backend

| Technology | Version |
|---|---|
| Java | 17+ |
| Spring Boot | 3.x |
| Maven | 3.x |
| Firebase Admin SDK | Latest |
| Swagger OpenAPI | Latest |


## Frontend

| Technology | Version |
|---|---|
| React | 18+ |
| TypeScript | 5+ |
| Vite | Latest |
| Firebase Web SDK | Latest |
| Axios | Latest |

---

# 📂 Project Structure

```
Spring-Boot-Firebase-Notification-System

│
├── springbootTS
│   │
│   ├── src/main/java
│   │   │
│   │   └── com.springbootTS.springbootTS
│   │       │
│   │       ├── controller
│   │       │   ├── UserController.java
│   │       │   └── NotificationController.java
│   │       │
│   │       ├── service
│   │       │   └── FirebaseNotificationService.java
│   │       │
│   │       ├── config
│   │       │   └── FirebaseConfig.java
│   │       │
│   │       └── dto
│   │           └── UserDTO.java
│   │
│   ├── src/main/resources
│   │   └── application.properties
│   │
│   └── pom.xml
│
│
└── frontend
    │
    ├── src
    │   ├── firebase.ts
    │   ├── App.tsx
    │   └── api
    │       └── userApi.ts
    │
    ├── public
    │   └── firebase-messaging-sw.js
    │
    └── package.json

```

---

# 🔥 Firebase Setup

## 1. Create Firebase Project

Go to:

Firebase Console

Create a new project.

---

## 2. Enable Cloud Messaging

Open:

```
Firebase Console
      |
      Project Settings
      |
      Cloud Messaging
```

Generate:

```
Web Push Certificate
```

Copy the VAPID Key.

---

## 3. Backend Firebase Configuration

Download:

```
Firebase Service Account Key
```

Rename it:

```
firebase.json
```

Place it:

```
springbootTS/src/main/resources/
```

Example:

```
springbootTS
 └── src
     └── main
         └── resources
             └── firebase.json
```

⚠️ Do not upload this file to GitHub.

---

# Backend Configuration

## Install dependencies

Inside backend folder:

```bash
cd springbootTS
```

Run:

```bash
mvn clean install
```

---

## Run Spring Boot

```bash
mvn spring-boot:run
```

Backend runs:

```
http://localhost:8080
```

---

# Firebase Service

The service is responsible for sending notifications.

Example:

```java
Message message =
Message.builder()
.setToken(token)
.setNotification(
 Notification.builder()
 .setTitle(title)
 .setBody(body)
 .build()
)
.build();


FirebaseMessaging
.getInstance()
.send(message);
```

---

# Notification API

## Send Notification

Endpoint:

```
POST /api/notification/send
```

Example:

```
http://localhost:8080/api/notification/send?token=FCM_TOKEN
```

Response:

```
projects/project-id/messages/message-id
```

---

# Swagger API Testing

Swagger URL:

```
http://localhost:8080/swagger-ui/index.html
```

Steps:

1. Open Swagger.
2. Select:

```
POST /api/notification/send
```

3. Click:

```
Try it out
```

4. Add FCM Token.

5. Execute.

---

# Frontend Setup

Go to frontend:

```bash
cd frontend
```

Install packages:

```bash
npm install
```

---

Run React:

```bash
npm run dev
```

Frontend runs:

```
http://localhost:5173
```

---

# React Firebase Configuration

Create:

```
frontend/src/firebase.ts
```

Add Firebase configuration:

```typescript
const firebaseConfig = {

apiKey:"YOUR_API_KEY",

authDomain:"YOUR_DOMAIN",

projectId:"YOUR_PROJECT_ID",

messagingSenderId:"YOUR_SENDER_ID",

appId:"YOUR_APP_ID"

};
```

---

# Get FCM Token

When the application starts:

```typescript
Notification.requestPermission()
```

After permission:

```
FCM TOKEN:
xxxxxxxxxxxxxxxx
```

This token identifies the browser device.

---

# Service Worker

File:

```
frontend/public/firebase-messaging-sw.js
```

Responsible for receiving notifications when the application is in background.

---

# Notification Flow

```
User opens React App

        ↓

Request Notification Permission

        ↓

Generate FCM Token

        ↓

Send Token to Backend

        ↓

Spring Boot sends message

        ↓

Firebase Cloud Messaging

        ↓

Browser Notification
```

---

# Example Notification

Spring Boot sends:

```
Title:
Hello

Message:
Hello from Spring Boot Firebase
```

Browser receives:

```
🔔 Hello

Hello from Spring Boot Firebase
```

---

# Security

The following files should never be uploaded:

```
firebase.json
firebase-service-account.json
.env
```

They are ignored using:

```
.gitignore
```

---

# Environment Variables

Recommended React configuration:

Create:

```
frontend/.env
```

Example:

```env
VITE_FIREBASE_API_KEY=
VITE_FIREBASE_PROJECT_ID=
VITE_FIREBASE_APP_ID=
VITE_FIREBASE_VAPID_KEY=
```

---

# GitHub Setup

Clone:

```bash
git clone https://github.com/zizoubgh/Spring-Boot-Firebase-Notification-System.git
```

---

# Git Commands

Initial upload:

```bash
git init

git add .

git commit -m "Initial commit"

git branch -M main

git remote add origin repository_url

git push -u origin main
```

Update:

```bash
git add .

git commit -m "update"

git push
```

---

# Future Improvements

- Save FCM Tokens in Database.
- User authentication.
- Notification history.
- Admin dashboard.
- Send notifications from React panel.
- Role based notifications.
- Mobile application support.

---

# Author

**Sayto BGH**

GitHub:

https://github.com/zizoubgh

---

# License

This project is for learning and demonstration purposes.
