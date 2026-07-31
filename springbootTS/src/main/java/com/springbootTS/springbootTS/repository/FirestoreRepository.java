package com.springbootTS.springbootTS.repository;



import com.springbootTS.springbootTS.model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FirestoreRepository {

    private static final String COLLECTION = "users";
//
    public void save(User user) {

        Firestore db = FirestoreClient.getFirestore();

        db.collection(COLLECTION)
                .document(user.getId())
                .set(user);
    }

    public User findById(String id) {

        try {

            Firestore db = FirestoreClient.getFirestore();

            DocumentSnapshot document =
                    db.collection(COLLECTION)
                            .document(id)
                            .get()
                            .get();

            if (!document.exists()) {
                return null;
            }

            return document.toObject(User.class);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public List<User> findAll() {

        try {

            Firestore db = FirestoreClient.getFirestore();

            ApiFuture<QuerySnapshot> future =
                    db.collection(COLLECTION).get();

            List<QueryDocumentSnapshot> documents =
                    future.get().getDocuments();

            List<User> users = new ArrayList<>();

            for (DocumentSnapshot document : documents) {

                users.add(document.toObject(User.class));

            }

            return users;

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public void delete(String id) {

        Firestore db = FirestoreClient.getFirestore();

        db.collection(COLLECTION)
                .document(id)
                .delete();

    }

}