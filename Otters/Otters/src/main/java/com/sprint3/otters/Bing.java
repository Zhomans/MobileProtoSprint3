package com.sprint3.otters;


import android.app.Activity;
import android.os.Bundle;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by itgeek25 from http://learn-it-stuff.blogspot.com/2012/09/using-bing-custom-search-inside-your.html
 */
public class Bing extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bing_return);}

        /**
         * @param args
         */
        public static void main(String[] args) {
            //--------------------------------------Bing search------------------------------
            String searchText = "Swag boiii";
            searchText = searchText.replaceAll(" ", "%20");
            String accountKey="NZ1XeynVzaFcm1BXZiwlb5tgmve7OOPcYE8Y3I9zzWs";

            byte[] accountKeyBytes = Base64.encodeBase64((accountKey + ":" + accountKey).getBytes());
            String accountKeyEnc = new String(accountKeyBytes);
            URL url;
            try {
                url = new URL(
                        "https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=%27" + searchText + "%27&$top=50&$format=Atom");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Authorization", "Basic " + accountKeyEnc);
                //conn.setRequestProperty("Accept", "application/json");
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));
                StringBuilder sb = new StringBuilder();
                String output;
                System.out.println("Output from Server .... \n");
                char[] buffer = new char[4096];
                while ((output = br.readLine()) != null) {
                    sb.append(output);
                    //text.append(link + "\n\n\n");//Will print the google search links
                    //}
                }

                conn.disconnect();

//                int find = sb.indexOf("<d:Description");
//                int total = find + 1000;
//                System.out.println("Find index: " + find);
//                System.out.println("Total index: " + total);
//                sb.getChars(find+35, total, buffer, 0);
//                String str = new String(buffer);

//                int find2 = str.indexOf("</d:Description>");
//                int total2 = find2 + 400;
//                System.out.println("Find index: " + find);
//                System.out.println("Total index: " + total);
//                char[] buffer2 = new char[1024];
//                str.getChars(0, find2, buffer2 , 0);
//                String str2 = new String(buffer2);
//                str2 = Jsoup.parse(str2).text();
//                System.out.println(str2);
//            } catch (MalformedURLException e1) {
//                TODO Auto-generated catch block
//                e1.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }

    }


