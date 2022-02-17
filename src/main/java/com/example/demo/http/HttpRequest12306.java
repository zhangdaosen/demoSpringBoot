package com.example.demo.http;

import com.example.demo.util.JsonUtil;
import com.example.demo.util.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.velocity.runtime.directive.Foreach;
import org.apache.velocity.runtime.directive.contrib.For;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HttpRequest12306 {

    public static void main(String[] args) throws IOException {
        String url = "https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2021-12-31&leftTicketDTO.from_station=BJP&leftTicketDTO.to_station=JNK&purpose_codes=ADULT";
        httpCline(url);
    }

    public static void httpCline(String destUrl) throws IOException {
        String responseBody = "";

        HttpUriRequest httpUriRequest = new HttpGet(destUrl);
        httpUriRequest.addHeader("Cookie","_uab_collina=159892975202642502517843; JSESSIONID=410E289C6A29EA4B0DD6C218AAB51BA7; _jc_save_wfdc_flag=dc; BIGipServerpassport=954728714.50215.0000; route=9036359bb8a8a461c164a04f8f50b252; _jc_save_fromStation=%u5317%u4EAC%2CBJP; BIGipServerotn=804258314.24610.0000; guidesStatus=off; highContrastMode=defaltMode; cursorStatus=off; _jc_save_toStation=%u4E0A%u6D77%2CSHH; _jc_save_fromDate=2021-12-21; _jc_save_toDate=2021-12-21; RAIL_EXPIRATION=1640370930189; RAIL_DEVICEID=Npp4DuSvEHE912bnuK1kG9R51SmsGbuyNzWBSmsfqoZGlJUylnnrbKhlgXXqlJON8JnVXrB8u6bTWs3KS3FQHB2Wg2ZMtzU9hE0pdbPZAG9GHF2V3O6TfoaLZvtj1WMUuFy7_a8qieuapZgP2e6KO7gRHK4Uh-ay");

        HttpClient httpclient = HttpClientBuilder.create().build();

        try {
//
            HttpResponse response = httpclient.execute(httpUriRequest);
            int status = response.getStatusLine().getStatusCode();
            if(status == 503){
                throw new Exception("服务器503错误，连接不上，"+destUrl);
            }
            responseBody = org.apache.http.util.EntityUtils.toString(response.getEntity());
            ResponseBody responseBody1 = JsonUtil.toObject(responseBody, ResponseBody.class);
            if (responseBody1 != null && responseBody1.isStatus()){
                Map<String, Object> data=(Map<String, Object>)responseBody1.getData();
                if (data!=null && data.size()>0){
                    List<String> list = (List<String>)data.get("result");
                    for (String str  :list ) {
                        List<String> list1 = StringUtils.stringToStringCollection(str.replace("|",","), ",");
                        if(list1.get(3).equals("G135") && (!list1.get(30).equals("无"))){
                            System.out.println("有票");
                        }
                        System.out.println(list1);
                    }
                }
            }
            System.out.println(responseBody);
        } catch (Exception e) {
            System.out.println(e.getMessage());
//			e.printStackTrace();
        } finally {

        }

    }

}
