import api from "./axios";
import type { User } from "../types/User";

export const getUsers = async (): Promise<User[]> => {

    const response = await api.get("/users");

    return response.data;

};

export const getUser = async (id: string): Promise<User> => {

    const response = await api.get(`/users/${id}`);

    return response.data;

};

export const createUser = async (user: User) => {

    const cleanUser = {
        ...user,
        email: user.email
            .replace(/[\u200E\u200F]/g, "")
            .trim()
    };

    const response = await api.post("/users", cleanUser);

    return response.data;
};

export const updateUser = async (id: string, user: User) => {

    const response = await api.put(`/users/${id}`, user);

    return response.data;

};

export const deleteUser = async (id: string) => {

    await api.delete(`/users/${id}`);

};