package org.aluracursos.model.conexionAPI;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.aluracursos.model.ObjetosJson.TasaDeCambio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * La clase ConversorDeValores es la clase encargada de poder realizar en su totalidad aquello referente a la
 * conversion de la moneda, el método valorConvertido se encarga de ello y fuera de este lo único que existe es
 * una cadena llamada apiKey que contiene la clave para acceder a la API de ExchangeRate-API.
 */
public class ConversorDeValores {
    //String que contiene la APIKey para conectarse a ExchangeRate-API
    String apiKEy = "33da070c0af3bd0e41c68346";

    /**
     * Este método recibe los códigos de las monedas origen y destino, así como el valor de la moneda origen y
     * devuelve el valor en la moneda destino. Se encarga de crear la conexión HTTP con la API de ExchangeRate-API.
     * @param codigoDeMonedaOrigen és el código de la moneda origen.
     * @param codigoDeMonedaDestino és el código de la moneda destino.
     * @param montoAConvertir és el monto en la moneda origen.
     * @return és el monot en la moneda destino.
     * @see Gson
     * @see TasaDeCambio
     */
    public double valorConvertido(String codigoDeMonedaOrigen, String codigoDeMonedaDestino, double montoAConvertir) {
        double valorConvertido = 0;
        String direccion = "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s"
                .formatted(apiKEy, codigoDeMonedaOrigen, codigoDeMonedaDestino);
        /*
         El FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES en el Gson es debido a que las claves del JSON vienen
         con ese tipo de nomenclatura, en el caso de que vieran con UpperCamelCase se usaria UPPER_CAMEL_CASE. Esto
         tiene como finalidad que en el Record que se usa para crear un objeto con los datos del JSON, las variables
         de este puedan ser escritas en lowerCamelCase tal como lo indica la convención de código de Java.
        */
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        try { // Try-Catch que necesario para la interfaz HttpResponse.
            // Crear un cliente HttpClient
            HttpClient cliente = HttpClient.newHttpClient();
            // Construir una solicitud HttpResquest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            // Enviar la solicitud y recibir la respuesta HttpResponse
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            // Obtener el json de response.body()
            String json = response.body();
            // Crear el objeto tasaDeCambio
            TasaDeCambio tasaDeCambio = gson.fromJson(json, TasaDeCambio.class);
            // Obteniendo el valorConvertido
            valorConvertido = montoAConvertir * tasaDeCambio.conversionRate();
        } catch (NumberFormatException | IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

        return valorConvertido;
    }
}