package academy.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserStatus {
    private static final UserStatus us = new UserStatus();
    private Gson gson = new GsonBuilder().create();
    OnOffUsers oou = OnOffUsers.getInstance();

    public static UserStatus getInstance() {
        return us;
    }

    public synchronized String toJSON(String userName) {
        if (oou.checkUser(userName) == false) return null;
        return gson.toJson(new UserStatusJsonMessages(userName, oou.backStatus(userName)));
    }
}
