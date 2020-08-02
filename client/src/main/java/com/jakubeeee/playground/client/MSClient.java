package com.jakubeeee.playground.client;

import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
abstract class MSClient {

    private static final String PROTOCOL = "http";

    private static final String HOST = "localhost";

    private static final HttpClient client = HttpClient.newHttpClient();

    protected abstract String port();

    protected String urlPrefix() {
        return PROTOCOL + "://" + HOST + ":" + port() + "/";
    }

    void getAsync(String endpointUrl) {
        var request = HttpRequest.newBuilder(URI.create(urlPrefix() + endpointUrl))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(responseBody -> logger.info("The response body: {}", responseBody));
    }

}
