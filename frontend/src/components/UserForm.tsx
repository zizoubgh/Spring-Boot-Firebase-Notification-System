import { Button, Stack, TextField } from "@mui/material";

import { useState } from "react";
import type { User } from "../types/User";

interface Props {
  onSave: (user: User) => void;
}

export default function UserForm({ onSave }: Props) {
  const [user, setUser] = useState<User>({
    firstName: "",

    lastName: "",

    email: "",

    age: 0,
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setUser({
      ...user,

      [e.target.name]:
        e.target.name === "age" ? Number(e.target.value) : e.target.value,
    });
  };

  return (
    <Stack spacing={2} sx={{ mt: 3 }}>
      <TextField label="First Name" name="firstName" onChange={handleChange} />

      <TextField label="Last Name" name="lastName" onChange={handleChange} />

      <TextField
        label="Email"
        name="email"
        type="email"
        value={user.email}
        onChange={handleChange}
      />
      <TextField label="Age" name="age" type="number" onChange={handleChange} />

      <Button variant="contained" onClick={() => onSave(user)}>
        Save User
      </Button>
    </Stack>
  );
}
