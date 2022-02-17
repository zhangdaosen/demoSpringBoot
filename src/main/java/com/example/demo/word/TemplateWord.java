package com.example.demo.word;

import com.aspose.words.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

//根据模板生成word 通过aspose.words
public class TemplateWord {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\cpc\\cpc文档\\转档前PT20210436-FD\\PT20210436-FD-P 递交的说明书.DOC");
//        doc2Pdf(file);
//        xml2word();
//        doc2Chaifen();
//        docTopdf("D:\\cpc\\cpc文档\\转档前PT20210436-FD\\PT20210436-FD-P 递交的说明书.DOC","");
//        docToPDF1();
        doc2Chaifen();
    }

    public static void createDoc() throws Exception {
        String fxkNull = "☐";
        String fxkValue = "☒";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appNumber", "");
        map.put("fmmc", "用于飞行器推进单元的具有C形可移动结构的推力反向器及其维护方法");
        map.put("applicationName", "赛峰短舱公司");
        map.put("ycqx1",fxkNull);
        map.put("ycqx2",fxkNull);
        map.put("ycqx3",fxkNull);
        map.put("sqrsm51",fxkNull);
        map.put("szscfbyjm",fxkNull);
        map.put("szscfjm20",fxkValue);
        map.put("szscfjm100",fxkNull);
        map.put("dljg","北京市万慧达律师事务所");
        map.put("year","2021");
        map.put("month","03");
        map.put("day","02");

        Document doc = new Document("C:\\Users\\zds\\Desktop\\模板\\cpc\\110401.docx");
        ReportingEngine engine = new ReportingEngine();
        engine.getKnownTypes().add(java.util.List.class);
        engine.getKnownTypes().add(java.util.HashMap.class);
        engine.getKnownTypes().add(java.lang.String.class);
        engine.getKnownTypes().add(java.lang.Integer.class);
        engine.getKnownTypes().add(java.lang.Long.class);
        engine.buildReport(doc, map, "metaInfo");
//        doc.save("C:\\Users\\zds\\Desktop\\模板\\cpc\\110401.pdf", SaveFormat.PDF);
        doc.save("C:\\Users\\zds\\Desktop\\模板\\cpc\\tttt.docx",SaveFormat.DOCX);
    }

    public static void doc2Chaifen() throws Exception {
        Document doc = new Document("D:\\cpc\\cpc文档\\wordToPdf\\chaifenyuan.DOCX");
        PageInfo pageInfo = doc.getPageInfo(0);
        Node firstChild = doc.getFirstChild();

        HtmlSaveOptions hso = new HtmlSaveOptions();
        hso.setExportRoundtripInformation(true);
        hso.setExportHeadersFootersMode(ExportHeadersFootersMode.NONE);
//        hso.setExportImagesAsBase64(true);
        hso.setDocumentSplitCriteria(DocumentSplitCriteria.HEADING_PARAGRAPH);
        hso.setDocumentSplitHeadingLevel(1);

        doc.save("D:\\cpc\\cpc文档\\caifen\\1.doc",hso);
    }

    public static void doc2Pdf(File file) throws Exception {
//        Document doc = new Document("D:\\cpc\\cpc文档\\caifen\\1-2.doc");
        Document doc = new Document(new FileInputStream(file));
//        DocumentBuilder db = new DocumentBuilder(doc);
//        db.getPageSetup().setDifferentFirstPageHeaderFooter(true);
        PdfSaveOptions pso = new PdfSaveOptions();
        String fileName = file.getName();
        fileName = fileName.replace("DOC","pdf");
        doc.save("D:\\cpc\\cpc文档\\caifen\\pdf\\" + fileName,pso);
    }

    public static void docToPDF1() throws Exception {
        File file = new File("D:\\cpc\\cpc文档\\caifen\\1-1.pdf");
        FileOutputStream os = new FileOutputStream(file);
        Document doc = new Document("D:\\cpc\\cpc文档\\转档前PT20210436-FD\\PT20210436-FD-P 递交的说明书.DOC");
        Document document = new Document();//新建一个空白pdf文档
        document.removeAllChildren();
        document.appendDocument(doc, ImportFormatMode.USE_DESTINATION_STYLES);//保留样式
        document.save(os, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
        os.close();
    }

    public static Boolean docTopdf(String wordFile, String htmlFile) throws Exception {

        File file = new File(htmlFile); // 新建一个空白pdf文档
        FileOutputStream os = new FileOutputStream(file);
        Document doc = new Document(wordFile); // wordFile是将要被转化的word文档
        doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换

        return true;
    }

    public static void doc2doc() throws Exception {
        Document doc = new Document("C:\\Users\\zds\\Desktop\\模板\\cpc\\2222.docx");
        DocumentBuilder db = new DocumentBuilder(doc);

        doc.save("C:\\Users\\zds\\Desktop\\模板\\cpc\\cccc.docx",SaveFormat.DOCX);
    }


    public static void  doc2doc2() throws Exception {
        Document doc = new Document("D:\\cpc\\cpc文档\\caifen\\1-01.doc");
        DocumentBuilder builder = new DocumentBuilder(doc);
//        builder.getPageSetup().setOddAndEvenPagesHeaderFooter(false);
//        builder.moveToHeaderFooter(HeaderFooterType.FOOTER_PRIMARY);
//        //靠右
//        builder.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
//        //   设置页脚上下边距
//        builder.getPageSetup().setHeaderDistance(40);
//        builder.getFont().setName("Arial");
//
//        builder.getFont().setBold(true);
//
//        builder.getFont().setSize(10);
        builder.insertFootnote(FootnoteType.FOOTNOTE,"关于引用文本的脚注注释。");
        doc.save("D:\\cpc\\cpc文档\\caifen\\页脚.doc");
    }

    public static void xml2word() throws Exception {
        Document doc = new Document("C:\\Users\\zds\\Desktop\\模板\\cpc\\ceshi.xml");
        doc.save("C:\\Users\\zds\\Desktop\\模板\\cpc\\ceshi.doc",SaveFormat.DOC);
    }
}
