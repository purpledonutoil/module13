package task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class UserTodos {
    public static final HttpClient CLIENT = HttpClient.newHttpClient();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final String URL_USERS_TODOS = "https://jsonplaceholder.typicode.com/users/";

    public void printTodos(int userId) throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI(URL_USERS_TODOS + userId + "/todos");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .headers("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<Todos> todos = GSON.fromJson(response.body(), new TypeToken<List<Todos>>(){
        }.getType());

        for (Todos todo: todos){
            if (!todo.getCompleted()){
                System.out.println(todo);
            }
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        UserTodos userTodos = new UserTodos();
        userTodos.printTodos(3);
    }
}
