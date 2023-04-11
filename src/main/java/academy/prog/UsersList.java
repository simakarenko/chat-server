package academy.prog;

import java.util.HashMap;
import java.util.Map;

public class UsersList {
    private static final UsersList usList = new UsersList();
    private final Map<String, String> ul = new HashMap<>();

    public static UsersList getInstance() {
        return usList;
    }

    public synchronized boolean add(String from, String password) {
        if (ul.containsKey(from) == false) {
            ul.put(from, password);
            System.out.println(ul);
            return true;
        } else if (ul.containsKey(from) == true && password.equals(ul.get(from))) {
            return true;
        } else {
            return false;
        }
    }

    public synchronized boolean checkRecipient(String to) {
        return ul.containsKey(to);
    }
}
