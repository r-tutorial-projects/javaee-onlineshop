package de.rubeen.javaee.buch.onlineshop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FotoService implements Runnable {
    private InputStream inputStream;
    private OutputStream outputStream;

    public FotoService(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            byte[] bytes = new byte[1024];
            int i = 0;
            while ((i = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
