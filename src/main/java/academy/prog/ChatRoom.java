package academy.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;

public class ChatRoom {
    private static final ChatRoom CR = new ChatRoom();
    private final Map<String, List<Message>> cr = new HashMap<>();
    private final List<Message> listA = new LinkedList<>();
    private final List<Message> listB = new LinkedList<>();
    private final List<Message> listC = new LinkedList<>();
    private final List<Message> listD = new LinkedList<>();
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static ChatRoom getInstance() {
        return CR;
    }

    public boolean checkCRName(String name) {
        if (name.equals("AAA") || name.equals("BBB") || name.equals("CCC") || name.equals("DDD")) {
            return true;
        } else {
            return false;
        }
    }

    public void add(Message msg) {
        if (msg.getCrName().equals("AAA")) {
            listA.add(msg);
            cr.put("AAA", listA);
        } else if (msg.getCrName().equals("BBB")) {
            listB.add(msg);
            cr.put("BBB", listB);
        } else if (msg.getCrName().equals("CCC")) {
            listC.add(msg);
            cr.put("CCC", listC);
        } else if (msg.getCrName().equals("DDD")) {
            listD.add(msg);
            cr.put("DDD", listD);
        }
    }

    public List<Message> backList(String key) {
        return cr.get(key);
    }

    public synchronized String toJSON(int n, String crN) {
        if (crN.equals("AAA")) {
            if (n >= listA.size()) {
                return null;
            } else {
                return gson.toJson(new ChatRoomJsonMessages(crN, n));
            }
        } else if (crN.equals("BBB")) {
            if (n >= listB.size()) {
                return null;
            } else {
                return gson.toJson(new ChatRoomJsonMessages(crN, n));
            }
        } else if (crN.equals("CCC")) {
            if (n >= listC.size()) {
                return null;
            } else {
                return gson.toJson(new ChatRoomJsonMessages(crN, n));
            }
        } else if (crN.equals("DDD")) {
            if (n >= listD.size()) {
                return null;
            } else {
                return gson.toJson(new ChatRoomJsonMessages(crN, n));
            }
        }
        return null;
    }
}
