package com.ben.restws;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class FileClient {
    public static void main(String[] args) throws IOException {
        WebClient client = WebClient.create("http://localhost:8080/restattachments/services/fileService/upload");
        client.type("multipart/form-data");
        ContentDisposition cd = new ContentDisposition("attachment;filename=hinh.png");
        Attachment attachment = new Attachment("root", Files.newInputStream(new File("/Users/benminh1201/Downloads/hinh.png").toPath()), cd);
        client.post(attachment);
    }
}
