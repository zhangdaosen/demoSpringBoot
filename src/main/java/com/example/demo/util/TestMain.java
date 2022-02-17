package com.example.demo.util;

import org.jxls.util.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {
    public static void main(String[] args) throws Exception {
        exportExcel();
    }

    public static void convert(){
        JxlsUtils.convert("C:\\Users\\zds\\Desktop\\文件\\委托书1.jpg","png","C:\\Users\\zds\\Desktop\\文件\\委托书1.png");
    }

    public static void exportExcel()throws Exception{
        String templatePath = "C:\\Users\\zds\\Desktop\\jiankongduishou.xlsx";
        OutputStream os = new FileOutputStream("C:\\Users\\zds\\Desktop\\送达主体.xlsx");
        // 文件流，输入一张叫fly的png图片
        InputStream imageInputStream = new FileInputStream("C:\\Users\\zds\\Desktop\\zds\\1.png");
        // 使用工具方法把流转成byte数组
        byte[] imageBytes = Util.toByteArray(imageInputStream);
        Map<String,Object> model = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("img",imageBytes);
        map1.put("tmName","商标\n名称");
        map1.put("regnumber","申请号");
        map1.put("goodClass","类别");
        map1.put("category","商品服务");
        map1.put("appDate","2020-11-20");
        map1.put("announcementQH","期号");
        map1.put("appCnName","申请人");
        map1.put("appCnAddress","申请人地址");
        map1.put("agencyName","代理机构");
        list.add(map1);
        list.add(map1);
        model.put("list",list);
        JxlsUtils.exportExcel(templatePath,os,model);
    }

    public static void text(){
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher("123");
        
    }
}
