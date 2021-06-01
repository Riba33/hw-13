package javafiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import static javafiles.RetrofitConfig.createClient;
import static javafiles.RetrofitConfig.execute;
public class Task1 {
    private static final String baseUrl = "https://jsonplaceholder.typicode.com/";

    public static String createNewObject(User user) throws IOException {
        RetrofitClient client = createClient(baseUrl, RetrofitClient.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(execute(client.newUser(user)));
    }
   public static String updateObject(Posts post) throws IOException {
       RetrofitClient client = createClient(baseUrl, RetrofitClient.class);
       Gson gson = new GsonBuilder().setPrettyPrinting().create();
       return gson.toJson(execute(client.updateUser(post)));
   }
   public static int deleteObject(int id) throws IOException {
       RetrofitClient client = createClient(baseUrl, RetrofitClient.class);
       return client.deleteUser(id).execute().code();
   }
   public static String getAllObjects() throws IOException {
       RetrofitClient client = createClient(baseUrl, RetrofitClient.class);
       Gson gson = new GsonBuilder().setPrettyPrinting().create();
       return gson.toJson(execute(client.getUsers()));
   }
    public static String getObject(int id) throws IOException {
        RetrofitClient client = createClient(baseUrl, RetrofitClient.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(execute(client.getUser(id)));
    }
    public static String getObjectFromUsrname(String username) throws IOException {
        RetrofitClient client = createClient(baseUrl, RetrofitClient.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(execute(client.getUserFromUsername(username)));
    }

    public static void main(String[] args) throws IOException {
        User user = new User(2,"Vova");
        Posts post = new Posts(1,1,"Пост1","Тело поста.");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user);
        String postJson = gson.toJson(post);
        System.out.println(json);
        System.out.println("Возвращенный после создания обьект\n" + createNewObject(user));
        System.out.println(postJson);
        System.out.println("Возвращенный после обновления обьект\n" + updateObject(post));
        System.out.println("HTTP-код на запрос удаления обьекта-" + deleteObject(1));
        System.out.println(getAllObjects());
        System.out.println(getObject(2));
        System.out.println(getObjectFromUsrname("Samantha"));
    }
}
