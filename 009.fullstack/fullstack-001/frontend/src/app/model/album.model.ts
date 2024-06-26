import { AlbumType } from "./album-type.model";
import { Artist } from "./artist.model";
import { RecordCompany } from "./recordCompany.model";

export interface Album{
  id: number;
  title: string;
  catalogNumber: string;
  price: number;
  published: boolean;
  releaseDate: Date;
  type: AlbumType;
  // Asociaciones Many to One:
  artist: Artist;
  recordCompany: RecordCompany;
}