package academy.prog;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomJsonMessages {
    private List<Message> list = new ArrayList<>();
    ChatRoom CR = ChatRoom.getInstance();

    public ChatRoomJsonMessages(String key, int fromIndex) {
        List<Message> sourceList = new ArrayList<>();
        sourceList.addAll(CR.backList(key));
        for (int i = fromIndex; i < sourceList.size(); i++)
            list.add(sourceList.get(i));
    }
}
