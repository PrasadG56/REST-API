package com.restapi;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Http2 {
    final CloseableHttpClient httpClient = HttpClients.createDefault();
    String urlGet1 = "https://api.instantwebtools.net/v1/airlines";
    String urlGet2 = "https://reqres.in/api/users?page=2";
    String urlPost1 = "https://reqres.in/api/users";
    String urlPost2 = "https://reqres.in/api/register";
    String urlPost3 = "https://api.instantwebtools.net/v1/passenger";
    String urlPost4 = "https://api.instantwebtools.net/v1/airlines";
    String urlPost5 = "https://reqres.in/api/login";
    String urlPost6 = "https://gorest.co.in/public/v2/users";
    String urlPost7 = "http://desktop-0hnl6qr/Magicxpi4.13/MgWebRequester.dll?appname=IFStestProject2&prgname=HTTP&arguments=-AHTTP_6%23Trigger1";
    String urlDelete1 = "https://reqres.in/api/users/2";
    String urlPut1 = "https://reqres.in/api/users/2";
    String urlPatch1 = "https://reqres.in/api/users/2";
    String magicUrl = "hettp://DESKTOP-0HNL6QR/Magicxpi4.13/MgWebRequester.dll?appname=IFStestProject2&prgname=HTTP&arguments=-AHTTP_6%23Trigger1";
    String magicUrl2 = "http://desktop-0hnl6qr/Magicxpi4.13/MgWebRequester.dll";

    public String get() {
        try {
            HttpGet httpGet = new HttpGet(magicUrl);     //Get the response from the API.
            CloseableHttpResponse response1 = httpClient.execute(httpGet);  //Execute the closable response.
            HttpEntity entity1 = response1.getEntity();  //Get all the entities from the received API.

            return EntityUtils.toString(entity1) + "\n" + response1.getStatusLine(); //Print the JSON response on console.
        } catch (Exception e) {
            return "Failed to get the data! \nException caught: " + e.getCause();
        }
    }

    public String post() throws IOException {
        try {
            HttpPost httpPost = new HttpPost(magicUrl);
            CloseableHttpResponse response2 = httpClient.execute(httpPost);
            List<NameValuePair> nvp = new ArrayList<>();

            nvp.add(new BasicNameValuePair("name", "Tenali Ramakrishna"));


            response2.setEntity(new UrlEncodedFormEntity(nvp));

            HttpEntity entity2 = response2.getEntity();

            return EntityUtils.toString(entity2) + "\n" + response2.getStatusLine();
        } catch (Exception e) {
            return "Unable to Create User! \nException caught: " + e.getCause();
        }
    }

    public String delete() throws IOException {
        HttpDelete httpDelete = new HttpDelete(urlDelete1);
        CloseableHttpResponse response3 = httpClient.execute(httpDelete);
        return "Status Code: " + response3.getStatusLine().getStatusCode();
    }

    public String put() throws IOException {
        HttpPut httpPut = new HttpPut(urlPut1);
        CloseableHttpResponse response4 = httpClient.execute(httpPut);
        List<NameValuePair> nvp = new ArrayList<>();

        nvp.add(new BasicNameValuePair("name", "morpheus"));
        nvp.add(new BasicNameValuePair("job", "zion resident"));
        response4.setEntity(new UrlEncodedFormEntity(nvp));

        HttpEntity entity4 = response4.getEntity();

        return EntityUtils.toString(entity4) + "\n" + response4.getStatusLine();

    }

    public void patch() throws IOException {
        HttpPatch httpPatch = new HttpPatch(urlPatch1);
        CloseableHttpResponse response5 = httpClient.execute(httpPatch);
        List<NameValuePair> nvp = new ArrayList<>();

        nvp.add(new BasicNameValuePair("name", "morpheus"));
        nvp.add(new BasicNameValuePair("job", "zion resident"));
        response5.setEntity(new UrlEncodedFormEntity(nvp));

        HttpEntity entity5 = response5.getEntity();

        System.out.println(EntityUtils.toString(entity5));
        System.out.println(response5.getStatusLine());

    }

    public static void main(String[] args) throws IOException {

        System.out.println(new Http2().post());
//        new Http2().post();
//        new Http().put();
//        new Http().delete();
//        new Http().patch();
    }
}