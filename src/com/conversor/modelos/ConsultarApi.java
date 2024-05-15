package com.conversor.modelos;
import com.google.gson.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultarApi {
    public MonedaER buscarMoneda(String codigoMoneda, String codigoDestino){ //Lo que va a regresar


        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7e3f29d05e22c2462073d99e/latest/" + codigoMoneda);

        HttpClient client = HttpClient.newHttpClient(); // Este línea es el client
        HttpRequest request = HttpRequest.newBuilder() // Aquí el request
                .uri(direccion)
                .build();


        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
            double rate = jsonObject.getAsJsonObject("conversion_rates").get(codigoDestino).getAsDouble();
            MonedaER monedaER = new MonedaER(codigoMoneda, rate);
            return monedaER;


        } catch (Exception e) {
            throw new RuntimeException("Opción inválida");

        }
    }
}
