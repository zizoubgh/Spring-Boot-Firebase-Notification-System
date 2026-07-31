import { useEffect, useState } from "react";

import { createUser, deleteUser, getUsers } from "../api/userApi";

import type { User } from "../types/User";

import UserForm from "../components/UserForm";

import UserTable from "../components/UserTable";

export default function Home() {
  const [users, setUsers] = useState<User[]>([]);

  const loadUsers = async () => {
    const data: User[] = await getUsers();

    setUsers(data);
  };

  useEffect(() => {
    loadUsers();
  }, []);

  const saveUser = async (user: User) => {
    await createUser(user);
 console.log(user);
    loadUsers();
  };

  const removeUser = async (id: string) => {
    await deleteUser(id);

    loadUsers();
  };

  return (
    <div style={{ padding: 30 }}>
      <UserForm onSave={saveUser} />

      <UserTable
        users={users}
        onDelete={removeUser}
        onEdit={(user) => console.log(user)}
      />
    </div>
  );
}
