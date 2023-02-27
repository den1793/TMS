package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Denis Smirnov
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        User user = new User("Simon", "simon", "simon");
        User user2 = new User("Denis", "denis", "denis");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);

        String s = gson.toJson(users);

        System.out.println(s);

        FileWriter fileWriter = new FileWriter("info.json");
        fileWriter.write(s);
        fileWriter.close();


    }
}
