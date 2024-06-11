package org.aluracursos.model.menus;

import org.aluracursos.model.monedas.MonedasPorPais;

import java.util.Scanner;

public class MenuPrincipal {
    String codigoDeMonedaOrigen;
    String codigoDeMonedaDestino;
    int opcionDeMonedaOrigen;
    int opcionDeMonedaDestino;

    public void menúPrincipal() {
        System.out.println("*********************************************");
        System.out.println("Sea bienvenid@ al conversor de monenedas.");
        System.out.println();
        obtenerMonedaOrigen();
        System.out.println();
        obtenerMonedaDestino();
        System.out.println();
        obtenerMontoAConvertir();
    }

    private void obtenerMontoAConvertir() {

    }

    private void obtenerMonedaDestino() {
        Scanner entrada = new Scanner(System.in);
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
                    System.exit(0);
                default:
                    System.out.println("ERROR, ingrese una opción valida.");
                    repetir = true;
            }
        }
        while (repetir);
    }

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
                    System.exit(0);
                default:
                    System.out.println("ERROR, ingrese una opción valida.");
                    repetir = true;
            }
        }
        while (repetir);
    }

    public void listaDeMonedas() {
        imprimirMonedaYPais(1,MonedasPorPais.ARGENTINA);
        imprimirMonedaYPais(2,MonedasPorPais.BRASIL);
        imprimirMonedaYPais(3,MonedasPorPais.COLOMBIA);
        imprimirMonedaYPais(4,MonedasPorPais.ESTADOS_UNIDOS);
        imprimirMonedaYPais(5,MonedasPorPais.GUATEMALA);
        System.out.println("6). Salir");
    }

    public void imprimirMonedaYPais(int numeroOrdinal, MonedasPorPais pais) {
        //
        System.out.println(numeroOrdinal + "). " + pais.getNombreDeLaMoneda());
    }
}