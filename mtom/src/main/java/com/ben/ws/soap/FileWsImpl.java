package com.ben.ws.soap;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.*;
import java.nio.file.Files;

public class FileWsImpl implements FileWs{
    @Override
    public void upload(DataHandler attachment) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
             inputStream = attachment.getInputStream();
             outputStream = Files.newOutputStream(new File("/Users/benminh1201/Downloads/ip.jpeg").toPath());
            byte[] b = new byte[100000];
            int bytesRead = 0;
            while ((bytesRead=inputStream.read(b))!=-1){
                outputStream.write(b, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public DataHandler download() {
        return new DataHandler(new FileDataSource(new File("/Users/benminh1201/Downloads/ip.jpeg")));
    }
}
