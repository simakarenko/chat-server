package academy.prog;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PrivateGetListServlet extends HttpServlet {
    private PrivateMessagesList pmList = PrivateMessagesList.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fromStr = req.getParameter("fromprivate");
        String nameFrom = req.getParameter("from");
        int fromPrivate = 0;
        try {
            fromPrivate = Integer.parseInt(fromStr);
            if (fromPrivate < 0) fromPrivate = 0;
        } catch (Exception ex) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        resp.setContentType("application/json");

        String json = pmList.toJSON(fromPrivate, nameFrom);
        if (json != null) {
            OutputStream os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
            os.write(buf);
        }
    }
}
