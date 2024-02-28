export interface Product {
    id: number;
    name: string;
    price: number;
    available: boolean;
    constructionDate: Date;
    imageUrl: string; // Contiene la url a una imagen que puede estar en Internet, en nuestro oredenador etc.
}