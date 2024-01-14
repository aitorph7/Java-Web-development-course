

/**
 * Javadoc
 *
 * Ejemplos de bucles for utilizando Arrays
 */
public class BuclesConArrays {

    public static void main(String[] args) {


        // tipodato[] identificador = { valor1, valor2, valor3};
        int[] calificaciones = {5, 9, 4, 7, 10}; // longitud 5
        String[] nombres = {"Patricia", "Ana", "Bob", "Mike"};

        String[] phones = new String[3];
        phones[0] = "666555444";
        phones[1] = "642154656";
        phones[2] = "777888999";
        //  java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 3
        // phones[4] = "777888999"; // Error porque excede la longitud

        // mutable
        phones[1] = "444111222";
        // System.out.println(phones[1]);

        for (int i = 0; i < phones.length; i++) {
            System.out.println(phones[i]);
        }

        // Bucle for tradicional a la inversa: va decrementando de uno en uno
        for (int i = phones.length - 1; i >= 0; i--) {
            System.out.println(phones[i]);
        }

        // Enhanced for, bucle for each
        // Para activar las recomendaciones de IntelliJ IDEA primero escribir phones.for
        for (String phone : phones) {
            System.out.println(phone);
        }

    }
}
