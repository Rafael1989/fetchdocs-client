package com.mkyong.java11.jep321;

import org.json.simple.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FetchDocsApp {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static void main(String[] args) throws Exception {


        String result = createEnvironment();

        System.out.println(result);

        result = createCustomer();

        System.out.println(result);

        result = createCustomerSupplier();

        System.out.println(result);

        result = testQueue();

        System.out.println(result);

        result = getDocumentsQueue();

        System.out.println(result);

        result = getDocument();

        System.out.println(result);

    }

    private static String createEnvironment() throws InterruptedException, ExecutionException, TimeoutException {
        JSONObject json = new JSONObject();
        json.put("name","Stage");
        json.put("push_notification_url","https://api.getmyinvoices.com/test_portal/notifications/");
        json.put("push_input_request_url","https://api.getmyinvoices.com/test_portal/input_request/");
        json.put("api_key","ASWZ-3U19-5N0P-YKZR-10BN-R2IO-90NH-SNWY");

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .uri(URI.create("https://api.stage.fetchdocs.io/fetch/v1/createEnvironment"))
                .setHeader("Content-Type", "application/json")
                .build();

        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
        return result;
    }

    private static String createCustomer() throws InterruptedException, ExecutionException, TimeoutException {
        JSONObject json = new JSONObject();
        json.put("api_key","ASWZ-3U19-5N0P-YKZR-10BN-R2IO-90NH-SNWY");

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .uri(URI.create("https://api.stage.fetchdocs.io/fetch/v1/createCustomer"))
                .setHeader("Content-Type", "application/json")
                .build();

        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
        return result;
    }

    private static String createCustomerSupplier() throws InterruptedException, ExecutionException, TimeoutException {
        JSONObject json = new JSONObject();
        json.put("customer_prim_uid",163464);
        json.put("supplier_prim_uid",4774);
        json.put("active","true");
        json.put("fields","{\"USERNAME\": \"163464\", \"PASSWORD\": \"1i1c42y3\"}");
        json.put("iv","1i1c42y3");
        json.put("api_key","ASWZ-3U19-5N0P-YKZR-10BN-R2IO-90NH-SNWY");

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .uri(URI.create("https://api.stage.fetchdocs.io/fetch/v1/createCustomerSupplier"))
                .setHeader("Content-Type", "application/json")
                .build();

        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
        return result;
    }

    private static String testQueue() throws InterruptedException, ExecutionException, TimeoutException {
        JSONObject json = new JSONObject();
        json.put("prim_uid",163475);
        json.put("api_key","ASWZ-3U19-5N0P-YKZR-10BN-R2IO-90NH-SNWY");

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .uri(URI.create("https://api.stage.fetchdocs.io/fetch/v1/testQueue"))
                .setHeader("Content-Type", "application/json")
                .build();

        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
        return result;
    }

    private static String getDocumentsQueue() throws InterruptedException, ExecutionException, TimeoutException {
        JSONObject json = new JSONObject();
        json.put("api_key","ASWZ-3U19-5N0P-YKZR-10BN-R2IO-90NH-SNWY");

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .uri(URI.create("https://api.stage.fetchdocs.io/fetch/v1/getDocumentsQueue"))
                .setHeader("Content-Type", "application/json")
                .build();

        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
        return result;
    }

    private static String getDocument() throws InterruptedException, ExecutionException, TimeoutException {
        JSONObject json = new JSONObject();
        json.put("prim_uid","163497");
        json.put("customer_secret","1i1c42y3");
        json.put("api_key","ASWZ-3U19-5N0P-YKZR-10BN-R2IO-90NH-SNWY");

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .uri(URI.create("https://api.stage.fetchdocs.io/fetch/v1/getDocument"))
                .setHeader("Content-Type", "application/json")
                .build();

        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
        return result;
    }

}
