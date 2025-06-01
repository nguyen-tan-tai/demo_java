package com.example.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-31
 * tags: java, http
 */
class HttpRequestTest {

    @Test
    public void testGet() throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("https://postman-echo.com/post");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("{\"hoge\":\"fuga\"}"))
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NEVER)
                .build()
                .send(request, BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
