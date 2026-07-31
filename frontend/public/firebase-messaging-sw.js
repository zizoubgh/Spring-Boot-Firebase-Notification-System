importScripts(
  "https://www.gstatic.com/firebasejs/10.12.2/firebase-app-compat.js"
);

importScripts(
  "https://www.gstatic.com/firebasejs/10.12.2/firebase-messaging-compat.js"
);


firebase.initializeApp({
    apiKey: "A",
  authDomain: ".firebaseapp.com",
  projectId: "",
  storageBucket: "firebasestorage.app",
  messagingSenderId: "",
  appId: "1:"

});


const messaging = firebase.messaging();


messaging.onBackgroundMessage(
(payload)=>{

    console.log(
        "Background message",
        payload
    );


    self.registration.showNotification(
        payload.notification.title,
        {
            body: payload.notification.body
        }
    );

});