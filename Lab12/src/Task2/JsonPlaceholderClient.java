package Task2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

public class JsonPlaceholderClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts/";

    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        // GET
        Random random = new Random();
        int randomId = random.nextInt(100) + 1;
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + randomId))
                .GET()
                .build();

        HttpResponse<String> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("GET Response:");
        System.out.println(getResponse.body());

        // POST
        String newPostJson = "{\"userId\":1,\"title\":\"foo\",\"body\":\"baz\"}";

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(newPostJson))
                .build();

        HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("POST Request:");
        System.out.println(newPostJson);
        System.out.println("POST Response:");
        System.out.println(postResponse.body());
    }
}
