package academy.prog;

import java.util.ArrayList;
import java.util.List;

public class OnOffUsersJsonMessages {
    private List<String> list = new ArrayList<>();

    public OnOffUsersJsonMessages(List<String> sourceList) {
        for (String l:sourceList){
        list.add(l);
        }
    }
}
