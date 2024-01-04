
package simuladorTarjeta;
import informacionTarjeta.Tarjeta;

public class TarjetaSimulador {

    public static void main(String[] args) {


        Tarjeta tarjeta1 = new Tarjeta("Visa" , "2847290323123124" , "Fernando" , "Ramirez" , "24/10/2024");
        Tarjeta tarjeta2 = new Tarjeta("Nara" , "8970998012490293" , "Jose" , "Gimenez" , "10/02/2023");
        Tarjeta tarjeta3 = new Tarjeta("Amex" , "1290832903200321" , "Fernando" , "Ramirez" , "20/05/2028");


        System.out.println("Informacion Tarjeta 1: ");
        System.out.println(tarjeta1.obtenerInformacionTarjeta());


        System.out.println("La operacion es valida?: " + tarjeta1.operacionValida(800));
        System.out.println("La operacion es valida?: " + tarjeta2.operacionValida(1500));

        System.out.println("La tarjeta 1 es valida para operar?: " + tarjeta1.validaParaOperar());
        System.out.println("La tarjeta 1 es valida para operar?: " + tarjeta2.validaParaOperar());

        System.out.println("La tarjeta 1 es distinta a la tarjeta 2?: " + tarjeta1.tarjetaDistinta(tarjeta2));
        System.out.println("La tarjeta 1 es distinta a la tarjeta 1?: " + tarjeta1.tarjetaDistinta(tarjeta1));


        try {
            double tasaOperacion = Tarjeta.obtenerTasaOperacion("Visa", 1500);
            System.out.println("\n La tasa de operacion es: " + tasaOperacion);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }

    }

}