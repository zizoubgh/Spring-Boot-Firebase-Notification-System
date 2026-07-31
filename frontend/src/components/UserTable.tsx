import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
  Paper,
  Button,
} from "@mui/material";

import type { User } from "../types/User";

interface Props {
  users: User[];

  onDelete: (id: string) => void;

  onEdit: (user: User) => void;
}

export default function UserTable({ users, onDelete, onEdit }: Props) {
  return (
    <Paper sx={{ marginTop: 4 }}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>First Name</TableCell>

            <TableCell>Last Name</TableCell>

            <TableCell>Email</TableCell>

            <TableCell>Age</TableCell>

            <TableCell>Actions</TableCell>
          </TableRow>
        </TableHead>

        <TableBody>
          {users.map((user) => (
            <TableRow key={user.id}>
              <TableCell>{user.firstName}</TableCell>

              <TableCell>{user.lastName}</TableCell>

              <TableCell>{user.email}</TableCell>

              <TableCell>{user.age}</TableCell>

              <TableCell>
                <Button variant="contained" onClick={() => onEdit(user)}>
                  Edit
                </Button>

                <Button
                  color="error"
                  sx={{ ml: 2 }}
                  variant="contained"
                  onClick={() => onDelete(user.id!)}
                >
                  Delete
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </Paper>
  );
}
