package academy.prog;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ChatRoomAddServlet extends HttpServlet {
    private ChatRoom CR = ChatRoom.getInstance();
    private UsersList ul = UsersList.getInstance();
    private OnOffUsers oou = OnOffUsers.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        byte[] buf = requestBodyToArray(req); // json
        String bufStr = new String(buf, StandardCharsets.UTF_8);

        Message msg = Message.fromJSON(bufStr);
        if (msg != null && ul.add(msg.getFrom(), msg.getPassword()) == true) {
            if (CR.checkCRName(msg.getCrName()) == true) {
                if (msg.isOnOff() == true) {
                    CR.add(msg);
                }
                oou.add(msg.getFrom(), msg.isOnOff());
            }
        } else
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    private byte[] requestBodyToArray(HttpServletRequest req) throws IOException {
        InputStream is = req.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[10240];
        int r;

        do {
            r = is.read(buf);
            if (r > 0) bos.write(buf, 0, r);
        } while (r != -1);

        return bos.toByteArray();
    }
}
