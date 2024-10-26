package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class PostComments {
    public static final HttpClient CLIENT = HttpClient.newHttpClient();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final String URL_USERS_POSTS = "https://jsonplaceholder.typicode.com/users/";

    public Post findLatestPost(int userId) throws IOException, InterruptedException, URISyntaxException {
        URI uri = new URI(URL_USERS_POSTS + userId + "/posts");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .headers("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<Post> posts = GSON.fromJson(response.body(), new TypeToken<List<Post>>(){
        }.getType());

        Post latestPost = posts.get(posts.size()-1);
        return latestPost;
    }

    public void createFile(int userId) throws IOException, URISyntaxException, InterruptedException {
        Post post = findLatestPost(userId);
        String nameOfFile = "user-" + userId + "-post-" + post.getId() + "-comments.json";
        File file = new File(nameOfFile);
        String text = GSON.toJson(post, Post.class);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            byte[] buffer = text.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        PostComments postComments = new PostComments();
        postComments.createFile(6);
    }
}
