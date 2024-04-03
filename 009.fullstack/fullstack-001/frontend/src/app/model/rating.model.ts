import { Album } from "./album.model";
import { User } from "./user.model";

export interface Rating {
  id: number;
  score: number;
  comment: string;
  album?: Album; // declaro '?' para que sea opcional.
  user?: User;

}