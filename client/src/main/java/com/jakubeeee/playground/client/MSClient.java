package com.jakubeeee.playground.client;

import org.slf4j.Logger;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.slf4j.LoggerFactory.getLogger;

abstract sealed class MSClient permits MSJavaClient, MSKotlinClient {

    private static final Logger logger = getLogger(MSClient.class);

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
                .exceptionally(Throwable::getMessage)
                .thenAccept(responseBody -> logger.info("The response body: {}", responseBody));
    }

}
