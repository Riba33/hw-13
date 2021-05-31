package javafiles;

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
        List<User> users = execute(client.getUserPosts(id));
        List<Integer> list = new ArrayList<>();
        for (User user : users) {
            list.add(user.getId());
        }
        int maxCommentsId = Collections.max(list);
        List<User> userposts = execute(client.getPostComments(maxCommentsId));
        String output = "";
        for (User user: userposts) {
            output += user.getBody() + "\n\n";
        }
        String outputFile = "src/resources/user-" + id + "-post-" + maxCommentsId + "-comments.json";
        try(FileOutputStream fileOutputStream = new FileOutputStream(outputFile))
        {
            byte[] buffer = output.trim().getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        writeComments(2);
    }
}
