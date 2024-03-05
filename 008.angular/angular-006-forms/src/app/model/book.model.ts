export interface Book {
    id: number;
    title: string;
    price: number;
    available: boolean;
    publishDate: Date;
    // Selectores
    category: string;
    topics: string[]; // indica que es un array de string
}