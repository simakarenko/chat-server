package academy.prog;


public class UserStatusJsonMessages {
    private String text;

    public UserStatusJsonMessages(String t, boolean status) {
        if (status == true) {
            text = t + " - online";
        } else {
            text = t + " - offline";
        }
    }
}
