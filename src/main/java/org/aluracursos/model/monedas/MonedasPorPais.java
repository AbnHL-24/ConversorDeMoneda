package org.aluracursos.model.monedas;

/**
 * El enum MonedaPorPais se utiliza para almacenar la información de una moneda según un país dado que esto es más
 * fácil de recordar que el nombre de la moneda o su código. Tiene el formato, código de la moneda, nombre de la
 * moneda y país de la moneda, esto para coincidir con la documentación de ExchangeRate-API, ya que es la API
 * que se utilizará en este proyecto.
 * Para más información vea: https://www.exchangerate-api.com/docs/supported-currencies
 */
public enum MonedasPorPais {
    /*
     * A continuación se encuentra la información de todas las monedas soportadas por este programa, no representa la
     * totalidad de las monedas soportadas por la API antes mencionada.
     */
    ARGENTINA("ARS", "peso argentino", "Argentina"),
    BRASIL("BRL", "real brasileño", "Brasil"),
    COLOMBIA("COP", "peso colombiano", "Colombia"),
    ESTADOS_UNIDOS("USD", "dolar estadounidense", "Estados Unidos"),
    GUATEMALA("GTQ", "quetzal guatemalteco", "Guatemala");


    private final String codigoDeMoneda;
    private final String nombreDeLaMoneda;
    private final String paisDeLaMoneda;

    MonedasPorPais(String codigoDeMoneda, String nombreDeLaMoneda, String paisDeLaMoneda) {
        this.codigoDeMoneda = codigoDeMoneda;
        this.nombreDeLaMoneda = nombreDeLaMoneda;
        this.paisDeLaMoneda = paisDeLaMoneda;
    }

    public String getCodigoDeMoneda() {
        return codigoDeMoneda;
    }

    public String getNombreDeLaMoneda() {
        return nombreDeLaMoneda;
    }

    public String getPaisDeLaMoneda() {
        return paisDeLaMoneda;
    }
}
