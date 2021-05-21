package ui;

//import ui.controller.JournalAppGui;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    private static HttpURLConnection connection;

    public static void main(String[] args) {
//        new JournalAppGui();
//        LocalDate date = LocalDate.now();
//        LocalTime time = LocalTime.now();
//        System.out.println(date);
//        System.out.println(time);

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL("https://api.thecatapi.com/v1/images/search");
            connection = (HttpURLConnection) url.openConnection();

            // Request Setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            // you can print the status out after if you want (a certain number means it was successful)

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        JSONArray array = new JSONArray(responseContent.toString());
        JSONObject object = array.getJSONObject(0);
        System.out.println("url: " + object.getString("url"));



    }
}

