import { Artist } from "./artist.model";

export interface Album{
  id: number;
  catalogNumber: string;
  price: number;
  // Asociación Many to One
  artist: Artist;
}