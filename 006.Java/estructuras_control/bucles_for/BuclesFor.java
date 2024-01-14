

public class BuclesFor {

    public static void main(String[] args) {

        // Bucle for tradicional con paso 1
        for (int i = 0; i < 10; i++) {
            System.out.println("Iteración número " + i);
        }

        // La variable i no existe fuera del bucle
        // System.out.println(i);

        // Bucle for sin llaves, solo es posible si el bucle tiene dentro una sentendia
        for (int i = 0; i < 10; i++ )
            System.out.println("Iteración número " + i);


        // Bucle for tradicional con paso 2
        for (int i = 0; i < 15; i += 2)
            System.out.println("Iteración número " + i);



    }
}
