package com.example.demo.word;

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

public class wordUtil {

    public static void main(String[] args) throws Exception {
        String path="C:\\Users\\zds\\Desktop\\模板\\cpc\\222.docx";
//        String result=ReadDoc(path);
//        System.out.println(result);
        doc2doc(path);
    }

    public static String ReadDoc(String path) throws IOException {
        String resullt = "";
        //首先判断文件中的是doc/docx
        try {
            if (path.endsWith(".doc")) {
                InputStream is = new FileInputStream(new File(path));
                WordExtractor re = new WordExtractor(is);
                resullt = re.getText();
                re.close();
            } else if (path.endsWith(".docx")) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                resullt = extractor.getText();
                extractor.close();
            } else {
                System.out.println("此文件不是word文件");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return resullt;
    }

    public static void doc2doc(String filePath) throws Exception {
        XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(filePath));
        Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
        while (itPara.hasNext()) {
            XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
            List<XWPFRun> runs = paragraph.getRuns();

            for (int i = 0; i < runs.size(); i++) {
                if(runs.get(i).getText(runs.get(i).getTextPosition()) == null){
                    continue;
                }
                String oneparaString = runs.get(i).getText(runs.get(i).getTextPosition()).trim();
                runs.get(i).setText(oneparaString, 0);
            }
        }
        FileOutputStream outStream = null;
        String fileName = "150101.docx";

        String pathName = "C:\\Users\\zds\\Desktop\\模板\\cpc\\" + fileName;
        outStream = new FileOutputStream(pathName);
        document.write(outStream);
        outStream.close();
        File file = new File(pathName);
        TemplateWord.doc2Pdf(file);
    }
}
