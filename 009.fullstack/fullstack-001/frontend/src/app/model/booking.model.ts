import { Album } from "./album.model";
import { User } from "./user.model";

export interface Booking {
  id: number;
  startDate: Date;
  finishDate: Date;
  price: number;
  album: Album;
  user?: User; // opcional
}