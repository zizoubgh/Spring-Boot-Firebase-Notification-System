import { initializeApp } from "firebase/app";
import {
    getMessaging,
    getToken,onMessage
} from "firebase/messaging";


const firebaseConfig = {
  apiKey: "AI",
  authDomain: ".firebaseapp.com",
  projectId: "",
  storageBucket: ".firebasestorage.app",
  messagingSenderId: "",
  appId: "1::web:"

};



const app = initializeApp(firebaseConfig);


export const messaging = getMessaging(app);



export async function getFCMToken(){

   const permission =
        await Notification.requestPermission();


    if(permission !== "granted"){
        return null;
    }

    const token = await getToken(
        messaging,
        {
            vapidKey:"BLrjmjvG77n8q6MG1BV52adSG-p4gbldVTdTKm2k73d_W9YLjhXVhowRL1Jvm_qno_KRE4hmDmW9TCgrGY5lpG8"
        }
    );


    console.log("TOKEN:", token);


    return token;

}
export function listenNotification(){

    onMessage(
        messaging,
        (payload)=>{

            console.log(
                "Foreground:",
                payload
            );


            alert(
                payload.notification?.title
                +
                "\n"
                +
                payload.notification?.body
            );

        }
    );

}