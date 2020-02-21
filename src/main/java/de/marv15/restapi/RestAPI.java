package de.marv15.restapi;

import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class RestAPI {

    public static JSONObject getObjectFromWebsite(String url) throws IOException {

        InputStream inputStream = new URL(url).openStream();

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String rawJsonText = read(bufferedReader);

            JSONObject jsonObject = new JSONObject(rawJsonText);

            return jsonObject;
        } finally {
            inputStream.close();
        }


    }

    private static String read(Reader reader) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        int counter;

        while((counter = reader.read()) != -1) {
            stringBuilder.append((char)counter);
        }

        return stringBuilder.toString();
    }
}
