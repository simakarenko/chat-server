package academy.prog;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*

	C-> 			S						List
				/add POST(JSON message) ->  0
				/get?from=3 GET				1
											2'
											3
 */

public class Message {
    private Date date = new Date();
    private String from;
    private String to;
    private String text;
    private String password;
    private String crName;
    private boolean onOff;

    public Message(String from, String text, String password, String to, String crName, boolean onOff) {
        this.from = from;
        this.text = text;
        this.password = password;
        this.to = to;
        this.crName = crName;
        this.onOff = onOff;
    }

    public String toJSON() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        return gson.toJson(this);
    }

    public static Message fromJSON(String s) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        return gson.fromJson(s, Message.class);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(date)
                .append(", From: ").append(from).append(", crName: ").append(crName).append(", To: ").append(to)
                .append("] ").append(text)
                .toString();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCrName() {
        return crName;
    }

    public void setCrName(String crName) {
        this.crName = crName;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }
}
