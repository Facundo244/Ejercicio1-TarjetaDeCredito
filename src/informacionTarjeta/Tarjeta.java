package informacionTarjeta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Tarjeta {


    private String marca;
    private String numero;
    private String name;
    private String lastName;
    private LocalDate fechaVencimiento;



    //Constructor
    public Tarjeta(String marca, String numero , String name , String lastName , String fechaVencimiento) {

        this.marca = marca;
        this.numero = numero;
        this.name = name;
        this.lastName = lastName;
        this.fechaVencimiento = LocalDate.parse(fechaVencimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));




    }



    public String getNumero() {

        return numero;
    }



    //Metodo que devuelve un String con la informacion de la tarjeta
    public String obtenerInformacionTarjeta() {


        return "Marca:  " + marca +"\n" + "Numero: " + numero +"\n" + "Nombre: " + name +"\n" + "Apellido: " +lastName+ "\n" + "Fecha de Vencimiento: " + fechaVencimiento + "\n" ;
    }

    // Metodo para validar que la fechadeVencimiento sea posterior a la actual
    public boolean validaParaOperar() {

        // use el .isAfter para comparar la fecha que se almacena dentro de fechaVencimiento es posterior a la fecha actual
        return fechaVencimiento.isAfter(LocalDate.now()); // la fecha se obtiene mediante LocalDate.now();


    }


    //Metodo para verificar si una operacion es valida
    public boolean operacionValida (double monto) {

        return monto < 1000;
    }

    //Metodo para comparar si una tarjeta es diferente a otra
    public boolean tarjetaDistinta(Tarjeta otraTarjeta) {


        return this.numero != otraTarjeta.getNumero();
    }


    //Metodo para obtener la tasa de operaciones segun se estipula en el enunciado dado
    public static double obtenerTasaOperacion(String marca, double importe) throws IllegalArgumentException {

        double tasa;
        LocalDate fechaActual = LocalDate.now();


        switch (marca) {

            case "Visa":
                //use  DateTimeFormatter para extraer solo los 2 ultimos digitos del anio
                DateTimeFormatter formatoAnio = DateTimeFormatter.ofPattern("yy");
                int anioDosDigitos = Integer.parseInt(fechaActual.format(formatoAnio));
                tasa = anioDosDigitos / (double) fechaActual.getMonthValue();
                break;

            case "Nara":
                tasa = fechaActual.getDayOfMonth() * 0.5;
                break;

            case "Amex":

                tasa = fechaActual.getMonthValue() * 0.1;
                break;
            default:

                throw new IllegalArgumentException ("Esta marca de tarjeta es invalida");



        }

        return tasa;

    }

}


//

