package task1;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public class HttpTest {
    private static final String URL_ADDRESS_USERS = "https://jsonplaceholder.typicode.com/users";
    private static final String URL_ADDRESS_BY_ID = "https://jsonplaceholder.typicode.com/users/";
    private static final String URL_ADDRESS_BY_USERNAME = "https://jsonplaceholder.typicode.com/users?username=";
    private static final String URL_ADDRESS_POST = "https://jsonplaceholder.typicode.com/users/1";

    public static void main(String[] args) throws IOException, InterruptedException {
        User user = new User(3, "Agatha Harkness", "agahar", "Sincere@april.biz", "Kulas Light", "Apt. 556", "Westview", "92998-3874", "-37.3159", "81.1496", "1-770-736-8031 x56442", "hildegard.org", "Romaguera-Crona","Multi-layered client-server neural-net", "harness real-time e-markets");
        HttpUtil httpUtil = new HttpUtil();

        //METHOD 1
        user = httpUtil.createNewUser(URI.create(URL_ADDRESS_USERS), user);
        System.out.println(user);

        //METHOD 2
        user.setEmail("agathaharkness@witch.evil");
        user = httpUtil.updateUser(URI.create(URL_ADDRESS_POST), user);
        System.out.println(user);

        //METHOD 3
        int id = 2;
        httpUtil.deleteUser(URI.create(URL_ADDRESS_BY_ID + id));

        //METHOD 4
        List<User> users = httpUtil.getAllUsers(URI.create(URL_ADDRESS_USERS));
        for (User u: users){
            System.out.println(u);
        }

        //METHOD 5
        id = 4;
        System.out.println(httpUtil.getUserBYID(URI.create(URL_ADDRESS_BY_ID + id)));

        //METHOD 6
        String username = "Bret";
        System.out.println(httpUtil.getUserBYUsername(URI.create(URL_ADDRESS_BY_USERNAME + username)));


        //System.out.println(json);
    }
}
