package br.com.alura.desafio.conversor;

import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorAPI {

    public Moedas consultaListaDeMoedasAPI(String moeda) {
        String enderecoApi = "https://v6.exchangerate-api.com/v6/b0897a125883d0b542928276/latest/" + moeda.toUpperCase();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(enderecoApi))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject object = gson.fromJson(response.body(), JsonObject.class);

            JsonObject conversionRates = object.getAsJsonObject("conversion_rates");

            double usd = conversionRates.get("USD").getAsDouble();
            double eur = conversionRates.get("EUR").getAsDouble();
            double brl = conversionRates.get("BRL").getAsDouble();
            double ars = conversionRates.get("ARS").getAsDouble();
            double gbp = conversionRates.get("GBP").getAsDouble();

            return new Moedas(usd, eur, brl, ars, gbp);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
