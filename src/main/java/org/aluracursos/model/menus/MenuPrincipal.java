package org.aluracursos.model.menus;

import org.aluracursos.model.conexionAPI.ConversorDeValores;
import org.aluracursos.model.monedas.MonedasPorPais;

import java.util.Scanner;

/**
 * La clase MenuPrincipal se encarga de imprimir el menú de la aplicación y utiliza la clase ConversorDeValores
 * para realizar el proceso de la conversion de la moneda escogida por el usuario.
 */
public class MenuPrincipal {
    Scanner entrada = new Scanner(System.in);
    String codigoDeMonedaOrigen;
    String codigoDeMonedaDestino;
    int opcionDeMonedaOrigen;
    int opcionDeMonedaDestino;
    double montoAConvertir;
    boolean repetirLoop = true;

    /**
     * Se encarga de dar el mensaje de bienvenida del programa y realizar el loop infinito hasta que el usuario
     * escoja la opción de salir.
     */
    public void menuPrincipal() {
        //El loop parece infinito, pero este se acaba al escoger la opción de salir gracias a un System.exit(0).
        while (repetirLoop) {
            System.out.println("*********************************************");
            System.out.println("Sea bienveníd@ al conversor de monedas.");
            System.out.println();
            obtenerMonedaOrigen();
            System.out.println();
            obtenerMonedaDestino();
            System.out.println();
            obtenerMontoAConvertir();
            System.out.println();
            System.out.println();
        }
    }

    /**
     * Se encarga de la parte del menú para obtener el monto a convertir. Imprime las instrucciones así como realizar
     * la conversión e imprimir la nueva información.
     * @see ConversorDeValores
     */
    private void obtenerMontoAConvertir() {
        System.out.println("Ingrese el valor que deseas convertir:");
        montoAConvertir = Double.parseDouble(entrada.nextLine());
        //TODO agregar el resultado de la conversion de monedas.
        ConversorDeValores conversor = new ConversorDeValores();
        double montoConvertido = conversor.valorConvertido(codigoDeMonedaOrigen,codigoDeMonedaDestino, montoAConvertir);
        System.out.printf("El valor %f [%s] corresponde al valor final de =>> %f [%s]%n", montoAConvertir, codigoDeMonedaOrigen, montoConvertido, codigoDeMonedaDestino);
    }

    /**
     * Se encarga de la parte del menú que solicita al usuario que escoja la moneda destino.
     */
    private void obtenerMonedaDestino() {
        boolean repetir;
        do {
            System.out.println("Por favor, digite el numero de la moneda destino.");
            listaDeMonedas();
            opcionDeMonedaDestino = Integer.parseInt(entrada.nextLine());
            repetir = false;
            switch (opcionDeMonedaDestino) {
                case 1:
                    codigoDeMonedaDestino = MonedasPorPais.ARGENTINA.getCodigoDeMoneda();
                    break;
                case 2:
                    codigoDeMonedaDestino = MonedasPorPais.BRASIL.getCodigoDeMoneda();
                    break;
                case 3:
                    codigoDeMonedaDestino = MonedasPorPais.COLOMBIA.getCodigoDeMoneda();
                    break;
                case 4:
                    codigoDeMonedaDestino = MonedasPorPais.ESTADOS_UNIDOS.getCodigoDeMoneda();
                    break;
                case 5:
                    codigoDeMonedaDestino = MonedasPorPais.GUATEMALA.getCodigoDeMoneda();
                    break;
                case 6:
                    System.out.println("Gracias por usar nuestro conversor de monedas.");
                    repetirLoop = false;
                    System.exit(0);
                default:
                    System.out.println("ERROR, ingrese una opción valida.");
                    repetir = true;
            }
        }
        while (repetir);
    }

    /**
     * Se encarga de la parte del menú que solicita al usuario que escoja la moneda origen.
     */
    private void obtenerMonedaOrigen() {
        Scanner entrada = new Scanner(System.in);
        boolean repetir;
        do {
            System.out.println("Por favor, digite el numero de la moneda origen.");
            listaDeMonedas();
            opcionDeMonedaOrigen = Integer.parseInt(entrada.nextLine());
            repetir = false;
            switch (opcionDeMonedaOrigen) {
                case 1:
                    codigoDeMonedaOrigen = MonedasPorPais.ARGENTINA.getCodigoDeMoneda();
                    break;
                case 2:
                    codigoDeMonedaOrigen = MonedasPorPais.BRASIL.getCodigoDeMoneda();
                    break;
                case 3:
                    codigoDeMonedaOrigen = MonedasPorPais.COLOMBIA.getCodigoDeMoneda();
                    break;
                case 4:
                    codigoDeMonedaOrigen = MonedasPorPais.ESTADOS_UNIDOS.getCodigoDeMoneda();
                    break;
                case 5:
                    codigoDeMonedaOrigen = MonedasPorPais.GUATEMALA.getCodigoDeMoneda();
                    break;
                case 6:
                    System.out.println("Gracias por usar nuestro conversor de monedas.");
                    repetirLoop = false;
                    System.exit(0);
                default:
                    System.out.println("ERROR, ingrese una opción valida.");
                    repetir = true;
            }
        }
        while (repetir);
    }

    /**
     * Se encarga de imprimir la lista de todas las monedas.
     */
    public void listaDeMonedas() {
        imprimirMonedaYPais(1,MonedasPorPais.ARGENTINA);
        imprimirMonedaYPais(2,MonedasPorPais.BRASIL);
        imprimirMonedaYPais(3,MonedasPorPais.COLOMBIA);
        imprimirMonedaYPais(4,MonedasPorPais.ESTADOS_UNIDOS);
        imprimirMonedaYPais(5,MonedasPorPais.GUATEMALA);
        System.out.println("6). Salir");
    }

    /**
     * Se encarga de imprimir una moneda como opción para el menú, recíbe un número ordinal, y una Enum Moneda.
     * @param numeroOrdinal és el número ordinal a imprimír.
     * @param pais és un Enum Moneda correspondiente a la moneda que se desea imprimir.
     * @see MonedasPorPais
     */
    public void imprimirMonedaYPais(int numeroOrdinal, MonedasPorPais pais) {
        //
        System.out.println(numeroOrdinal + "). " + pais.getNombreDeLaMoneda());
    }
}
