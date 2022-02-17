package com.example.demo.xml.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mysqlPlus.dao.master.XmlLabelDao;
import com.example.demo.xml.model.XmlLabel;
import com.example.demo.xml.service.XmlService;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class XmlServiceImpl implements XmlService {

    @Resource
    private XmlLabelDao xmlLabelDao;

    @Override
    public void createXml(Map<String, Object> map, String xmlType) {
//        查询xml标签
        Map<String,Object> map1 = new HashMap<>();
        map1.put("xml_type",xmlType);
        List<XmlLabel> xmlLabels = xmlLabelDao.selectByMap(map1);
//        XmlLabel xmlLabel = xmlLabelDao.queryByXmlType(xmlType);
        XmlLabel xmlLabel = queryXmlLabel(xmlLabels.get(0));
        System.out.println(JSONObject.toJSON(xmlLabel));
        Document document = DocumentHelper.createDocument();
        Element rss = document.addElement(xmlLabel.getLabelName());
        zzXml(xmlLabel.getXmlLabelList(),rss,map);
        // 5、设置生成xml的格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 设置编码格式
        format.setEncoding("GBK");
        // 6、生成xml文件
        File file = new File("D:\\cpc\\cpc文档\\rss.xml");
        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            // 设置是否转义，默认使用转义字符
            writer.setEscapeText(false);
            writer.write(document);
            writer.close();
            System.out.println("生成rss.xml成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成rss.xml失败");
        }
    }

    @Override
    public void updateXml() {
        File file = new File("C:\\Users\\zds\\Desktop\\模板\\cpc\\110401.xml");
        try {
            Map<String, String> map = new HashMap<>();
            map.put("appNumber","123456");
            map.put("zlmc","专利名称");
            map.put("applicationName","申请人名称");
            map.put("sqrsm51CheckBox","<w:checked/>");
            map.put("ycsc1CheckBox","<w:checked/>");
            map.put("pctgjsqszscfbyjmCheckBox","<w:checked/>");
            map.put("agencyName","代理机构名字");
            map.put("agencyYear","2021");
            map.put("agencyMonth","02");
            map.put("agencyDay","01");
            BufferedReader fbr = new BufferedReader(new FileReader(file));
            String buffer = null;
            StringBuffer sb = new StringBuffer();
            while ((buffer = fbr.readLine())!= null){
                sb.append(buffer);
            }
            List<String> dqbl = dqbl(sb.toString());
            String content = strReplace(sb.toString(),map,dqbl);
            System.out.println(content);
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\zds\\Desktop\\模板\\cpc\\ceshi.xml"));
            bw.write(content);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //组装xml
    public static Element zzXml(List<XmlLabel> xmlLabelList,Element element,Map<String,Object> map) {
        try {
            if(xmlLabelList != null && xmlLabelList.size() != 0){
                for (XmlLabel xmlLabel:xmlLabelList
                     ) {
                    Element elm = element.addElement(xmlLabel.getLabelName());
                    String valueProperty = xmlLabel.getValueProperty();
                    List<XmlLabel> xmlLabelarray = xmlLabel.getXmlLabelList();
                    if(xmlLabelarray == null || xmlLabelarray.size() == 0){
                        if (valueProperty != null && !"".equals(valueProperty)){
                            elm.setText(map.get(valueProperty).toString());
                        }else {
                            elm.setText("");
                        }
                    }else {
                        zzXml(xmlLabelarray,elm,map);
                    }
                }
            }
            return  element;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成rss.xml失败");
            return null;
        }
    }

    public XmlLabel queryXmlLabel(XmlLabel xmlLabel){
        Map<String,Object> map = new HashMap<>();
        map.put("parent_id",xmlLabel.getId());
//        List<XmlLabel> xmlLabelList = xmlLabelDao.queryByParentId(xmlLabel.getId());
        List<XmlLabel> xmlLabelList = xmlLabelDao.selectByMap(map);
        if(xmlLabelList != null && xmlLabelList.size() != 0){
            xmlLabel.setXmlLabelList(xmlLabelList);
            for (XmlLabel label:  xmlLabelList
                 ) {
                queryXmlLabel(label);
            }
        }
        return  xmlLabel;
    }


    public String strReplace(String str,Map<String, String> map,List<String> dqbl){
        for (String s : dqbl) {
            if (map.containsKey(s)){
                str = str.replace("${" + s + "}",map.get(s));
            }else {
                str = str.replace("${" + s + "}"," ");
            }
        }
        return str;
    }

    public List<String> dqbl(String str){
        List<String> strings = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?<=\\$\\{)[^\\}]+");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            String bl = matcher.group();
            strings.add(bl);
        }
        return strings;
    }
    public static void main(String[] args) {
        String str = "<w:t>${agencyDay}da${qwewqe}</w:t>";
        Pattern pattern = Pattern.compile("(?=\\$\\{)[^\\}]+");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            System.out.println(matcher.group() + "}");
        }
        }
}
