package academy.prog;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ChatRoomGetListServlet extends HttpServlet {

    private ChatRoom CR = ChatRoom.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fromStr = req.getParameter("from");
        String crName = req.getParameter("crName");
        int fromChatRoom = 0;
        try {
            fromChatRoom = Integer.parseInt(fromStr);
            if (fromChatRoom < 0) fromChatRoom = 0;
        } catch (Exception ex) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        resp.setContentType("application/json");
        String json = CR.toJSON(fromChatRoom, crName);
        if (json != null) {
            OutputStream os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
            os.write(buf);
        }
    }

}
