package com.example.demo.http;

import com.fasterxml.jackson.core.JsonParser;
import org.apache.http.HttpHost;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;

public class HttpRequest {


    public static void main(String[] args) throws IOException {
        String url = "https://kyfw.12306.cn/otn/leftTicket/init?linktypeid=dc&fs=%E5%8C%97%E4%BA%AC,BJP&ts=%E4%B8%8A%E6%B5%B7,SHH&date=2021-12-21&flag=N,N,Y";
        httpCline(url);
    }

    public static void httpCline(String destUrl) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(destUrl);
        httpGet.addHeader("User-Agent", "Mozilla/5.0");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        System.out.println("GET Response Status:: "
                + httpResponse.getStatusLine().getStatusCode());

        BufferedInputStream bis = new BufferedInputStream(httpResponse.getEntity().getContent());
//                BufferedReader reader = new BufferedReader(new InputStreamReader(
//                httpResponse.getEntity().getContent()));
        File file = new File("D:\\ipdoc\\upload\\tmcase\\image\\67");
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:\\ipdoc\\upload\\tmcase\\image\\67\\111.png");

        httpClient.close();

    }

    //根据图片地址，获取到图片，并保存到本地
    public static String saveToFile(String destUrl) throws IOException {

        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            File file = new File("D:\\ipdoc\\upload\\tmcase\\image\\67");
            if (!file.exists()) {
                file.mkdirs();
            }
            fos = new FileOutputStream("D:\\ipdoc\\upload\\tmcase\\image\\67\\111.png");
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
//            convert("D:\\ipdoc\\upload\\tmcase\\image\\67\\111.jpg","png","D:\\ipdoc\\upload\\tmcase\\image\\67\\111.png");
            fos.flush();
        } catch (Exception e) {
        } finally {
            try {
                fos.close();
                bis.close();
                httpUrl.disconnect();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
        }
        return null;
    }

    public static void convert(String source, String formatName, String result) {
        try {
            File f = new File(source);
            f.canRead();
            BufferedImage src = ImageIO.read(f);
            ImageIO.write(src, formatName, new File(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
