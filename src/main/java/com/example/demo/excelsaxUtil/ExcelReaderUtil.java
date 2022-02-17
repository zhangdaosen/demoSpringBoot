package com.example.demo.excelsaxUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author y
 * @create 2018-01-19 0:13
 * @desc
 **/
public class ExcelReaderUtil {
	//excel2003扩展名
	public static final String EXCEL03_EXTENSION = ".xls";
	//excel2007扩展名
	public static final String EXCEL07_EXTENSION = ".xlsx";

	public static List<ExcelRow> rowList = new ArrayList<>();

	public static Map<Integer, List<ExcelRow>> sheetList = new HashMap<Integer, List<ExcelRow>>();


	/**
	 * 组装rowList
	 */
	public static void packRowList(String filePath, String sheetName, int sheetIndex, int curRow, List<Object> cellList){
		ExcelRow excelRow=new ExcelRow();
		List<Object> cellArray = new ArrayList<>();
		cellArray.addAll(cellList);
		excelRow.setRowNumber(curRow);
		excelRow.setColList(cellArray);
		rowList.add(excelRow);
	}

	/**
	 * 每获取一条记录，即打印
	 * 在flume里每获取一条记录即发送，而不必缓存起来，可以大大减少内存的消耗，这里主要是针对flume读取大数据量excel来说的
	 * @param sheetName
	 * @param sheetIndex
	 * @param curRow
	 * @param cellList
	 */
	public static void sendRows(String filePath, String sheetName, int sheetIndex, int curRow, List<Object> cellList) {
			StringBuffer oneLineSb = new StringBuffer();
			oneLineSb.append(filePath);
			oneLineSb.append("--");
			oneLineSb.append("sheet" + sheetIndex);
			oneLineSb.append("::" + sheetName);//加上sheet名
			oneLineSb.append("--");
			oneLineSb.append("row" + curRow);
			oneLineSb.append("::");
			for (Object cell : cellList) {
				oneLineSb.append(cell.toString().trim());
				oneLineSb.append("|");
			}
			String oneLine = oneLineSb.toString();
			if (oneLine.endsWith("|")) {
				oneLine = oneLine.substring(0, oneLine.lastIndexOf("|"));
			}// 去除最后一个分隔符

			System.out.println(oneLine);
	}

	public static void readExcel(String fileName) throws Exception {
		int totalRows =0;
		if (fileName.endsWith(EXCEL03_EXTENSION)) { //处理excel2003文件
			ExcelXlsReader excelXls=new ExcelXlsReader();
			totalRows =excelXls.process(fileName);
		} else if (fileName.endsWith(EXCEL07_EXTENSION)) {//处理excel2007文件
			ExcelXlsxReaderWithDefaultHandler excelXlsxReader = new ExcelXlsxReaderWithDefaultHandler();
			totalRows = excelXlsxReader.process(fileName);
		} else {
			throw new Exception("文件格式错误，fileName的扩展名只能是xls或xlsx。");
		}
		System.out.println("发送的总行数：" + totalRows);
	}

	public static void copyToTemp(File file,String tmpDir) throws Exception{
		FileInputStream fis=new FileInputStream(file);
		File file1=new File(tmpDir);
		if (file1.exists()){
			file1.delete();
		}
		FileOutputStream fos=new FileOutputStream(tmpDir);
		byte[] b=new byte[1024];
		int n=0;
		while ((n=fis.read(b))!=-1){
			fos.write(b,0,n);
		}
		fis.close();
		fos.close();
	}

	public static void main(String[] args) throws Exception {
		//String path="D:\\Github\\test.xls";
		//String path="D:\\H3CIDEA\\POIExcel\\test.xlsx";
		String path="C:\\Users\\zds\\Desktop\\商标监控\\1714\\fw\\初审.xlsx";

		/*ExcelReaderUtil.readExcel(file2.getAbsolutePath(),"/home/test/tmp.xlsx");*/
		ExcelReaderUtil.readExcel(path);
		sheetList.put(0,rowList);
		System.out.println(sheetList);
		/*readXlsx(file2.getAbsolutePath());*/
	}
}
