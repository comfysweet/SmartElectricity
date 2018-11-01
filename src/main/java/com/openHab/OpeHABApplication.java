package com.openHab;

import com.SmartElectricityApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class OpeHABApplication {


    public static void main(String[] args) {
        URL url;
        StringBuilder inline = new StringBuilder();

        {
            try {
                url = new URL("http://localhost:8080/recommendation");
                //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //Set the request to GET or POST as per the requirements
                conn.setRequestMethod("GET");
                //Use the connect method to create the connection bridge
                conn.connect();
                //Get the response status of the Rest API
                int responseCode = conn.getResponseCode();
                System.out.println("Response code is: " + responseCode);

                //Iterating condition to if response code is not 200 then throw a runtime exception
                //else continue the actual process of getting the JSON data
                if (responseCode != 200)
                    throw new

                            RuntimeException("HttpResponseCode: " + responseCode);
                else

                {
                    //Scanner functionality will read the JSON data from the stream
                    Scanner sc = new Scanner(url.openStream());
                    while (sc.hasNext()) {
                        inline.append(sc.nextLine());
                    }
                    System.out.println("\nJSON Response in String format");
                    System.out.println(inline);
                    //Close the stream when reading the data has been finished
                    sc.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

