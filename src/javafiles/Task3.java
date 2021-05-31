package javafiles;

import java.io.IOException;
import java.util.List;

import static javafiles.RetrofitConfig.createClient;
import static javafiles.RetrofitConfig.execute;

public class Task3 {
    private static final String baseUrl = "https://jsonplaceholder.typicode.com/";

    public static void main(String[] args) throws IOException {
        RetrofitClient client = createClient(baseUrl, RetrofitClient.class);
        List<User> users = execute(client.getTodos(2));
        for (User user: users) {
            System.out.println(user.getTitle());
        }

    }
}
