package academy.prog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrivateJsonMessages {
    private List<Message> list = new ArrayList<>();
    private PrivateMessagesList pmList = PrivateMessagesList.getInstance();

    public PrivateJsonMessages(String fromName, int fromIndex) {
        List<Message> sourceList = new ArrayList<>();
        sourceList.addAll(pmList.backList(fromName));
        for (int i = fromIndex; i < sourceList.size(); i++)
            list.add(sourceList.get(i));
    }
}
