package com.kodigo.provider;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
public class WeatherProvider {
    public static void doHttpGet(){
        String url = "https://api.openweathermap.org/data/2.5/weather?q=Paris&appid="+ApiKey.getApiKey();

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse resp = null;

        try {
            resp = client.execute(get);
            HttpEntity entity = resp.getEntity();
            System.out.println("Json response");
            System.out.println(EntityUtils.toString(entity));
        }
        catch (IOException ioException) {
            System.err.println("Something went wrong getting the weather");
            ioException.printStackTrace();
        }
        catch (Exception e){
            System.err.println("Unknow error: ");
            e.printStackTrace();
        }
    }
}
