package academy.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrivateMessagesList {
    private static final PrivateMessagesList pmList = new PrivateMessagesList();
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    private final Map<String, List<Message>> pm = new HashMap<>();
    // private List<Message> list = new LinkedList<>();

    public static PrivateMessagesList getInstance() {
        return pmList;
    }


    public synchronized void add(String userName, Message m) {

        List<Message> list = new LinkedList<>();
        if (pm.containsKey(userName) == true) {
            for (Message mm : pm.get(userName)) {
                list.add(mm);
            }
            list.add(m);
            pm.put(userName, list);
        } else {
            list.add(m);
            pm.put(userName, list);
        }
    }

    public synchronized List<Message> backList(String un) {
        List<Message>l=new LinkedList<>();
        for (Message m:pm.get(un)){
            l.add(m);
        }
        System.out.println(l);
        return l;
    }

    public synchronized String toJSON(int n, String nameFrom) {
        if (pm.get(nameFrom) == null || n >= pm.get(nameFrom).size()) return null;
        return gson.toJson(new PrivateJsonMessages(nameFrom, n));
    }
}
