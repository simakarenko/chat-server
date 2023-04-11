package academy.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;

public class OnOffUsers {
    public static final OnOffUsers oou = new OnOffUsers();
    private static final Map<String, Boolean> onOffMap = new HashMap<>();
    private Gson gson = new GsonBuilder().create();

    public static OnOffUsers getInstance() {
        return oou;
    }

    public synchronized void add(String login, boolean status) {
        onOffMap.put(login, status);
    }

    public static synchronized List<String> onUsers() {
        List<String> result = new ArrayList<>();
        Set<String> keys = onOffMap.keySet();
        for (String k : keys) {
            if (onOffMap.get(k) == true) {
                result.add(k);
            }
        }
        return result;
    }

    public synchronized boolean checkUser(String name) {
        return onOffMap.containsKey(name);
    }

    public synchronized boolean backStatus(String name) {
        return onOffMap.get(name);
    }

    public synchronized String toJSON() {
        List<String> online = OnOffUsers.onUsers();
        return gson.toJson(new OnOffUsersJsonMessages(online));
    }
}
