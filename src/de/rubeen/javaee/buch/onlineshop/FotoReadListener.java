package de.rubeen.javaee.buch.onlineshop;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

public class FotoReadListener implements ReadListener {
    private AsyncContext asyncContext;

    public FotoReadListener(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void onDataAvailable() throws IOException {
        final HttpServletRequest request = (HttpServletRequest) asyncContext.getRequest();
        final HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();

        OutputStream outputStream;
        InputStream inputStream;
        PrintWriter printWriter;

        try {
            final Part part = request.getPart("foto");
            outputStream = new FileOutputStream(part.getSubmittedFileName());
            inputStream = request.getInputStream();
            printWriter = response.getWriter();

            byte[] bytes = new byte[1024];
            int i = 0;
            while ((i = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, i);
            }
            outputStream.flush();
            printWriter.write("true");
            
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAllDataRead() throws IOException {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
