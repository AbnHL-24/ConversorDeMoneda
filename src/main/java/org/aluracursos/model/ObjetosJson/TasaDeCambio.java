package org.aluracursos.model.ObjetosJson;

/**
 * Se encarga de obtener el convertionRate entre dos monedas provenientes de un JSON recibido de ExchanceRate-API.
 * @param conversionRate
 */
public record TasaDeCambio(double conversionRate) {
}
