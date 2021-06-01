package javafiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static javafiles.RetrofitConfig.createClient;
import static javafiles.RetrofitConfig.execute;

public class Task2 {
    private static final String baseUrl = "https://jsonplaceholder.typicode.com/";
    public static void writeComments(int id) throws IOException {
        RetrofitClient client = createClient(baseUrl, RetrofitClient.class);
        List<Posts> users = execute(client.getUserPosts(id));
        List<Integer> list = new ArrayList<>();
        for (Posts user : users) {
            list.add(user.getId());
        }
        int maxCommentsId = Collections.max(list);
        List<Comments> userPosts = execute(client.getPostComments(maxCommentsId));
        List<Post> listPosts = new ArrayList<>();
        for (Comments user: userPosts) {
            listPosts.add(new Post(user.getBody()));
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(listPosts);
        String outputFile = "src/resources/user-" + id + "-post-" + maxCommentsId + "-comments.json";
        try(FileOutputStream fileOutputStream = new FileOutputStream(outputFile))
        {
            byte[] buffer = json.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        writeComments(2);
    }
}
