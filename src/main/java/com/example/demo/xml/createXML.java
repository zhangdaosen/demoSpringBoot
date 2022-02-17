package com.example.demo.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;

public class createXML {

    public static void main(String[] args) {
        createCPCXml();
    }

    public static void createCPCXml() {
        try {
            // 1、创建document对象
            Document document = DocumentHelper.createDocument();
            // 2、创建根节点rss
            Element rss = document.addElement("实质审查请求书");
            // 4、生成子节点及子节点内容
            Element channel = rss.addElement("专利申请");
            Element sqh = channel.addElement("申请号");
            sqh.setText("");
            Element fmczmc = channel.addElement("发明创造名称");
            fmczmc.setText("人源化ACE2基因改造小鼠模型的制备方法及应用");
            Element sqrhzl = channel.addElement("申请人或专利权人姓名或名称");
            sqrhzl.setText("生物岛实验室");
            Element fjqd = rss.addElement("附件清单");
            fjqd.setText("");
            // 5、设置生成xml的格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            // 设置编码格式
            format.setEncoding("GBK");
            // 6、生成xml文件
            File file = new File("D:\\cpc\\cpc文档\\rss.xml");
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

    public static void createCPCListXml(){

    }
    /**
     * 生成xml方法
     */
    public static void createXml(){
        try {
            // 1、创建document对象
            Document document = DocumentHelper.createDocument();
            // 2、创建根节点rss
            Element rss = document.addElement("rss");
            // 3、向rss节点添加version属性
            rss.addAttribute("version", "2.0");
            // 4、生成子节点及子节点内容
            Element channel = rss.addElement("channel");
            Element title = channel.addElement("title");
            title.setText("国内最新新闻");
            // 5、设置生成xml的格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            // 设置编码格式
            format.setEncoding("UTF-8");
            // 6、生成xml文件
            File file = new File("D:\\cpc\\cpc文档\\rss.xml");
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
}
