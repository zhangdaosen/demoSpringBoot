package com.example.demo.word;

import com.spire.doc.*;
import com.spire.doc.documents.HorizontalAlignment;
import com.spire.doc.documents.Paragraph;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class spireWord {

    public static void main(String[] args) throws Exception {
//        String str = "PT20210436-FD-P递交的说明书.DOC";
//        String[] filename = str.split("\\.");
//        System.out.println(filename);
//        zl();
//        readWord();
//        splitWord();
//        File file = new File("D:\\ipdoc\\patent\\111\\temporary\\1-0.doc");
//        addYJ(file);

//        replace("D:\\cpc\\cpc文档\\转档前PT20210436-FD\\PT20210436-FD-P 递交的说明书.DOC");
//        split();
        splitWord();
    }

    public static void zl() throws Exception {
        //拆分文档
        splitWord();
        //读取文件夹下所有的文件添加页码
        File file = new File("D:\\cpc\\cpc文档\\caifen");
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                continue;
            }
            addYJ(file1);
        }
    }

    public static void splitWord() throws FileNotFoundException {

        Document doc = new Document();

        long startTime1 = System.currentTimeMillis();
        doc.loadFromFile("D:\\cpc\\cpc文档\\转档前PT20210436-FD\\PT20210436-FD-P 递交的说明书.DOC");
        long endTime1 = System.currentTimeMillis();
        System.out.println("读取文件时间： " + (endTime1 - startTime1) + "ms");
        Document newDoc;
        //遍历源文档中的节
        for (int i = 0; i < doc.getSections().getCount(); i++)
        {
            //初始化新的Document对象
            newDoc = new Document();
            //将源文档中的指定节复制到新文档
            newDoc.getSections().add(doc.getSections().get(i).deepClone());

            //保存新文档到项目文件夹下（也可自定义保存路径）
            newDoc.saveToFile(String.format("D:\\cpc\\cpc文档\\caifen\\1-%d.doc", i));
        }
    }

    public static void addYJ(File file) throws Exception {
        //加载Word文档
        Document document = new Document(new FileInputStream(file));
//        document.loadFromFile("D:\\cpc\\cpc文档\\caifen\\1-2.doc");
        //获取第一个section
        Section section = document.getSections().get(0);
        section.getHeadersFooters().getFooter().getChildObjects().clear();
        //调用insertHeaderAndFooter方法插入页眉页脚到第一个section
        insertHeaderAndFooter(section);
        //保存文档
        String path = file.getPath();
        document.saveToFile(path , FileFormat.Doc);
//        replace(path);
    }

    private static void insertHeaderAndFooter(Section section) {
        //分别获取section的页眉页脚
        HeaderFooter header = section.getHeadersFooters().getHeader();
        HeaderFooter footer = section.getHeadersFooters().getFooter();
        //添加段落到页脚
        Paragraph footerParagraph = footer.addParagraph();
        //添加Field_Page和Field_Num_Pages域到页脚段落，用于显示当前页码和总页数
        footerParagraph.appendField("page number", FieldType.Field_Page);
//        footerParagraph.appendText(" of ");
//        footerParagraph.appendField("number of pages", FieldType.Field_Num_Pages);
        footerParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        //设置页脚段落的顶部边线样式
//        footerParagraph.getFormat().getBorders().getTop().setBorderType(BorderStyle.Single);
//        footerParagraph.getFormat().getBorders().getTop().setLineWidth(1f);
    }

    public static void readWord(){
        String buffer = "";
        String path = "D:\\ipdoc\\patent\\111\\temporary\\1-0.doc";
        try {
            if (path.endsWith(".doc")) {
                FileInputStream is = new FileInputStream(path);
                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
                is.close();
            } else if (path.endsWith("docx")) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                buffer = extractor.getText();
                opcPackage.close();
            } else {
                System.out.println("此文件不是word文件！");
            }
            System.out.println(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
}


    public static void replace(String filePath) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("Evaluation Warning: The document was created with Spire.Doc for JAVA.", "");
//        XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage("D:\\cpc\\cpc文档\\caifen\\页脚.doc"));
        XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(filePath));
        Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
        String concent = "";
        while (itPara.hasNext()) {
            XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
            List<XWPFRun> runs = paragraph.getRuns();

            for (int i = 0; i < runs.size(); i++) {
                if(runs.get(i).getText(runs.get(i).getTextPosition()) == null){
                    continue;
                }
                String oneparaString = runs.get(i).getText(runs.get(i).getTextPosition()).trim();
                concent = concent + oneparaString;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (oneparaString.equals(entry.getKey())) {
                        oneparaString = oneparaString.replace(entry.getKey(), entry.getValue());
                    }

                }
                runs.get(i).setText(oneparaString, 0);
            }
        }
        FileOutputStream outStream = null;
        String fileName = "";
        if(concent.contains("说明书摘要")){
            fileName = "说明书摘要.doc";
        }else if(concent.contains("说明书")){
            fileName = "说明书.doc";
        }else if(concent.contains("权利要求书")){
            fileName = "权利要求书.doc";
        }
        String pathName = "D:\\cpc\\cpc文档\\caifen\\word\\" + fileName;
        outStream = new FileOutputStream(pathName);
        document.write(outStream);
        outStream.close();
        File file = new File(pathName);
        TemplateWord.doc2Pdf(file);
    }


    public static void split() throws IOException {
    }
}
