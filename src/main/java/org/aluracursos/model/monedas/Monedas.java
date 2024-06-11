package org.aluracursos.model.monedas;

public enum Monedas {
    GUATEMALA("GTQ", "quetzal guatemalteco", "Guatemala"),
    ESTADOS_UNIDOS("USD", "dolar estadounidense", "Estados Unidos"),
    ARGENTINA("ARS", "peso argentino", "Argentina"),
    BRASIL("BRL", "real brasileño", "Brasil"),
    COLOMBIA("COP", "peso colombiano", "Colombia");


    private String codigoDeMoneda;
    private String nombreDeLaMoneda;
    private String paisDeLaMoneda;

    Monedas(String codigoDeMoneda, String nombreDeLaMoneda, String paisDeLaMoneda) {
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
