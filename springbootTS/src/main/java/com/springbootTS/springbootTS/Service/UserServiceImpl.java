package com.springbootTS.springbootTS.Service;


import com.springbootTS.springbootTS.dto.UserDTO;
import com.springbootTS.springbootTS.model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private static final String COLLECTION = "users";

    @Override
    public User save(UserDTO dto) {

        try {

            Firestore firestore = FirestoreClient.getFirestore();

            String id = UUID.randomUUID().toString();

            User user = User.builder()
                    .id(id)
                    .firstName(dto.getFirstName())
                    .lastName(dto.getLastName())
                    .email(dto.getEmail())
                    .age(dto.getAge())
                    .build();

            firestore.collection(COLLECTION)
                    .document(id)
                    .set(user);

            return user;

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public List<User> findAll() {

        try {

            Firestore firestore = FirestoreClient.getFirestore();

            ApiFuture<QuerySnapshot> future =
                    firestore.collection(COLLECTION).get();

            List<QueryDocumentSnapshot> docs =
                    future.get().getDocuments();

            List<User> list = new ArrayList<>();

            for (DocumentSnapshot doc : docs) {

                list.add(doc.toObject(User.class));

            }

            return list;

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public User findById(String id) {

        try {

            Firestore firestore = FirestoreClient.getFirestore();

            DocumentSnapshot document =
                    firestore.collection(COLLECTION)
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

    @Override
    public User update(String id, UserDTO dto) {

        Firestore firestore = FirestoreClient.getFirestore();

        User user = User.builder()
                .id(id)
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .age(dto.getAge())
                .build();

        firestore.collection(COLLECTION)
                .document(id)
                .set(user);

        return user;

    }

    @Override
    public void delete(String id) {

        Firestore firestore = FirestoreClient.getFirestore();

        firestore.collection(COLLECTION)
                .document(id)
                .delete();

    }

}