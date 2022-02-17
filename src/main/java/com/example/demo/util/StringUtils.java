package com.example.demo.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.map.HashedMap;

public class StringUtils {

	public static String checkFileName(String fileName) {
		Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
		Matcher matcher = pattern.matcher(fileName);
		fileName = matcher.replaceAll(""); // 将匹配到的非法字符以空替换
		return fileName;
	}

	public static String listToString(List list, String separator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(separator);
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}

	//集合转字符串String
	public static String StringCollectionToString(List<String> list) {
		if (list == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (String str : list) {
			if (flag) {
				result.append(",");
			} else {
				flag = true;
			}
			result.append(str);
		}
		return result.toString();
	}

	//集合转字符串
	public static String collectionToString(List<Integer> list) {
		if (list == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (Integer integer : list) {
			if(integer == null) {
				continue;
			}
			if (flag) {
				result.append(",");
			} else {
				flag = true;
			}
			result.append(integer);
		}
		return result.toString();
	}

	//集合转字符串String带有单引号
	public static String CollectionToString(List<String> list) {
		if (list == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (String str : list) {
			if(str.contains("'")) {
				str = str.replace("'", "\\'");
			}
			if (flag) {
				result.append(",");
			} else {
				flag = true;
			}
			result.append("'" + str + "'");
		}
		return result.toString();
	}

	//set集合转String
	public static String setToString(Set<Integer> set) {
		if (set == null || set.isEmpty()) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (Integer integer : set) {
			if (flag) {
				result.append(",");
			} else {
				flag = true;
			}
			result.append(integer);
		}
		return result.toString();
	}

	//
	public static List<Integer> stringToCollection(String ss) {
		List<Integer> list = new ArrayList<>();
		if (ss != null && !"".equals(ss)) {
			String[] arr = ss.split(",");
			for (int i = 0; i < arr.length; i++) {
				list.add(Integer.valueOf(arr[i]));
			}
		}
		return list;
	}

	public static List<String> stringToStringCollection(String ss) {
		List<String> list = new ArrayList<>();
		if (ss != null && !"".equals(ss)) {
			String[] arr = ss.split(",");
			for (int i = 0; i < arr.length; i++) {
				list.add(arr[i]);
			}
		}
		return list;
	}
	
	private static final boolean isChinese(char c) {  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
            return true;  
        }  
        return false;  
    }  
  
    public static final boolean isChinese(String strName) {  
        char[] ch = strName.toCharArray();  
        for (int i = 0; i < ch.length; i++) {  
            char c = ch[i];  
            if (isChinese(c)) {  
                return true;  
            }  
        }  
        return false;  
    }  

	/**
	 * 判断字符串中是否包含中文
	 *
	 * @param str 待校验字符串
	 * @return 是否为中文
	 * @warn 不能校验是否为中文标点符号
	 */
	public static boolean isContainChinese(String str) {
		Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
		Matcher m = p.matcher(str);
		return m.find();
	}
	/**
	 * 判断字符串是否为日文
	 *
	 * @param input
	 * @return
	 */
	public static boolean isContainJapanese(String input) {
		if(input==null){
			return false;
		}
		try {
			return input.getBytes("shift-jis").length >= (2 * input.length());
		} catch (UnsupportedEncodingException e) {
			return false;
		}
	}
	public static boolean isContainLetterNum(String str) {
		boolean isDigit=false;
		boolean isLetter=false;
		for(int i=0 ; i<str.length() ; i++){ //循环遍历字符串   
		
		    char c=str.charAt(i);
            if(Character.isDigit(c)){     //用char包装类中的判断数字的方法判断每一个字符
                isDigit = true;   
            }
            
//            if(Character.isLetter(str.charAt(i))){   //用char包装类中的判断字母的方法判断每一个字符
            if(((c>='a'&&c<='z')   ||   (c>='A'&&c<='Z')))   
            { 
                isLetter = true;
            }
            if (isDigit || isLetter) {
            	return true;
            }             
        }		
		return false;		
	}

	public static String replaceChar(String name) {
		name = name.replaceAll("[/\\\\:*\"?<>|]", "");
		return name;
	}

	// 字符串合并
	public static String addString(String dest, String source) {
		String data = "";
		if (source != null && !source.equals("")) {
			data = dest + source;
		} else {
			data = dest;
		}
		return data;
	}



	public static String getNumber(String str) {
		String number = "";
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			char ca = str.charAt(i);
			if (Character.isDigit(ca)) {
				list.add(ca);
			}
		}
		if (list != null) {
			int size = list.size();
			char[] tt = new char[size];
			for (Character cat : list) {
				char ca = cat.charValue();
				number = number + ca;
			}
		}
		return number;
	}

	// 整型数组排序
	public static void bubbleSort(int[] numbers) {
		int temp; // 记录临时中间值
		int size = numbers.length; // 数组大小
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (numbers[i] > numbers[j]) { // 交换两数的位置
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}

	// 字符串排序
	public static void listSort(List<?> list) {
		Collections.sort(list, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				return new Integer((String) o1).compareTo(new Integer((String) o2));
			}
		});
	}

	public static boolean isNum(String str) {
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}

	//判断字符串是否是数字， 只要字符串中有一个字符不是数字，就返回false
	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
//				System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static String getPercent(long y, long z, boolean baifenhao) {
		String baifenbi = "";// 接受百分比的值
		double baiy = y * 1.0;
		double baiz = z * 1.0;
		double fen = baiy / baiz;
		// NumberFormat nf = NumberFormat.getPercentInstance();注释掉的也是一种方法
		// nf.setMinimumFractionDigits( 2 ); 保留到小数点后几位
//		DecimalFormat df1 = new DecimalFormat("##.00%");
		DecimalFormat df2 = new DecimalFormat("0.00%");
		// ##.00%
		// 百分比格式，后面不足2位的用0补齐
		// baifenbi=nf.format(fen);
//		baifenbi = df1.format(fen);		
		baifenbi = df2.format(fen);
		if (!baifenhao) {
			if (baifenbi != null) {
				int len = baifenbi.length();
				baifenbi = baifenbi.substring(0, len - 1);
			}
		}
		return baifenbi;
	}

	public static String processTmGroup(String tmType, String tmGroup, String tmGroup2) {
		int tmTypeLen = tmType.length();
		if (tmGroup == null || tmGroup.equals("")) {
			return tmGroup2;
		}
		List<String> tmGroupList2 = Arrays.asList(tmGroup2.split(";"));
		List<String> tmGroupList = Arrays.asList(tmGroup.split(";"));
		List<String> arrayList2 = new ArrayList<String>(tmGroupList2);
		Iterator<String> it = arrayList2.iterator();
		while (it.hasNext()) {
			String group = it.next();
			if (group == null) {
				continue;
			}
			int len = group.length();
			if (len > tmTypeLen) {
				String s = group.substring(0, tmTypeLen);
				if (s.equals(tmType)) {
					it.remove();
				}
			}
		}
		for (String group : tmGroupList) {
			arrayList2.add(group);
		}
		//排序
		StringUtils.listSort(arrayList2);
		String[] b = arrayList2.toArray(new String[arrayList2.size()]);
		String tmGroupResult = String.join(";", b);
		if (tmGroupResult != null && !tmGroupResult.endsWith(";")) {
			tmGroupResult = tmGroupResult + ";";
		}
		return tmGroupResult;
	}

	public static List<String> abstractList(String data) {
		List<String> list = new ArrayList<>();
		String[] arr = data.split("#");
		if (arr.length == 1) {
			list.add(data);
		} else {
			list = Arrays.asList(arr);
		}
		return list;
	}

	public static String getNotDigitString(char[] chars) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; ++i) {
			if (Character.isDigit(chars[i])) {
				break;
			}
			sb.append(chars[i]);
		}
		String result = sb.toString();
		return result;
	}

	public static String getEndDigitString(char[] chars) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; ++i) {
			if (!Character.isDigit(chars[i])) {
				continue;
			}
			sb.append(chars[i]);
		}
		String result = sb.toString();
		return result;
	}

	public static String getDigitString(char[] chars) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; ++i) {
			if (!Character.isDigit(chars[i])) {
				break;
			}
			sb.append(chars[i]);
		}
		String result = sb.toString();
		return result;
	}

	public static List<String> getDigitStrings(char[] chars) {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> digitStrings = new ArrayList<String>();
		boolean findDigit = false;
		for (int i = 0; i < chars.length; ++i) {
			if (!Character.isDigit(chars[i])) {
				if (findDigit) {
					String result = sb.toString();
					digitStrings.add(result);
					sb = new StringBuilder();
					findDigit = false;
				}
				continue;
			}
			sb.append(chars[i]);
			findDigit = true;
		}
		return digitStrings;
	}

	public static List<String> getString(String input, String regex) {
		List<String> strList = new ArrayList<String>();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			strList.add(matcher.group(1));
		}
		return strList;
	}

	//将字符串转成大写
	public static String stringToUpperCase(String str) {
		StringBuffer sbuffer = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			String s = str.charAt(i) + "";
			if (!s.equals(" ") && s.matches("^[a-zA-Z]*")) {
				sbuffer.append(s.toUpperCase());
			} else {
				sbuffer.append(s);
			}
		}
		return sbuffer.toString();
	}

	//替换字符传中所有的符号
	public static String delMark(String str) {
		String regEx = "[\n`~!@#$%^&*()+=\\-_|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
		String replace = "";//这里是将特殊字符替换为""字符串
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);//这里把想要替换的字符串传进来
		String newString = m.replaceAll(replace).trim();
		return newString;
	}
	
	private static List<String> getNumberList(String str) {		
		Pattern pattern = Pattern.compile("\\d+"); 
		Matcher matcher = pattern.matcher(str); 
		List<String> list = new ArrayList<String>();
		while (matcher.find()) { 
			 String s=matcher.group();
			 list.add(s);
		} 
		return list;
	}
	
	public static String getNo(String str) {
		String no=null;

		String key="年费时限";
		int len=key.length();
		int pos=str.indexOf(key);
		if(pos>-1) {
			str=str.substring(pos+len);
		}
		String key2="年";
		int len2=key2.length();
		int pos2=str.indexOf(key2);
		if(pos2>-1) {
			String tempStr=str.substring(pos2+len2);
			no = getDigitString(tempStr.toCharArray()); 
		}
//		if(no!=null) {
//			Integer yearNo=Integer.parseInt(no);
//			if (yearNo!=null && yearNo.intValue()>20) {
//				return null;
//			}
//		}
		
		return no;
	}
	
	
	public static String  getTelNo(String str) {
		String telNo=null;
		List<String> list =getNumberList(str);	
		if (list!=null && list.size()>0) {
			 int index=list.size()-1;
			 //取最后一组数字作为电话号码
			 String number= list.get(index);
			 int len =number.length();
			 if(len>5) { //电话号码至少是6位，否则忽略
				 telNo =number;
			 }			 
		}
//		System.out.println(telNumber); 
		return telNo;
	}

	public static void main(String[] args) {
		
		String str="深圳市南山区科苑南路2666号中国华润大厦54楼 075582668888-3275";
		String result=getTelNo(str);
		System.out.println(result);

		System.out.println(isContainJapanese("麦芽"));
		
		
//		String str="天津新技术产业111园区武清开发区泉发路西59693558";
//		getTelNo(str);
		
//		List<String> list = new ArrayList<String>();
//		list.add("1");
//		list.add("1");
//		list.add("1");
//		list.add("1");
//		Object[] obj =  list.toArray();
//		
//		System.out.println(obj);
		
//		Map<String, Integer> map = new HashedMap();
//		map.put("1", 1);
//		map.put("2", 1);
//		map.put("3", 1);
//		map.put("4", 1);
//		map.put("5", 1);
//		Map<String, Integer> map1 = new HashedMap();
//		map1.put("2", 1);
//		map1.put("3", 1);
//		map1.put("4", 1);
//		map1.put("6", 1);
//
//
//		List<String> mapList = new ArrayList<>(map.keySet());
//		List<String> map1List = new ArrayList<>(map1.keySet());
//		List<String> mapListOnly = new ArrayList<String>();
//		List<String> map1ListOnly = new ArrayList<String>();
//		map1ListOnly.addAll(map1List);
//		mapListOnly.addAll(mapList);
//		mapListOnly.removeAll(map1List);//mapList中单独存在的
//		map1ListOnly.removeAll(mapList);//map1List中单独存在的
//    	Map<String, Integer> mapOnly = new HashMap<String, Integer>();
//		if(mapListOnly != null && mapListOnly.size() != 0) {
//			for (String string : mapListOnly) {
//				mapOnly.put(string, map.get(string));
//			}
//		}
//		if(map1ListOnly != null && map1ListOnly.size() != 0) {
//			for (String string : map1ListOnly) {
//				mapOnly.put(string, map1.get(string));
//			}
//		}
//		System.out.println(mapOnly);
		
	}

	/**
	 * 将字符串拆分成数组根据指定分割符
	 *
	 * @param ss
	 * @param separation
	 * @return
	 * @author zds
	 * @date 2020年11月20日 上午11:18:34
	 */
	public static List<String> stringToStringCollection(String ss, String separation) {
		List<String> list = new ArrayList<>();
		if (ss != null && !"".equals(ss)) {
			String[] arr = ss.split(separation);
			for (int i = 0; i < arr.length; i++) {
				list.add(arr[i]);
			}
		}
		return list;
	}

	public static String encodeUrl(String url) {
		//被转码后的url
		String result = "";
		//需要转码的url
		// url = "/20195-商标图样-5/7/36902000.jpg";
//	    int index = url.indexOf("?");
//	    result = url.substring(0,index+1);
//	    String temp = url.substring(index+1);
		String temp = url;
		try {
			//URLEncode转码会将& ： / = 等一些特殊字符转码,(但是这个字符  只有在作为参数值  时需要转码;例如url中的&具有参数连接的作用，此时就不能被转码)
			String encode = temp;
//	        System.out.println(encode);
			encode = encode.replace("%3D", "=");
			encode = encode.replace("%2F", "/");
			encode = encode.replace("+", "%20");
			encode = encode.replace("%26", "&");
			result += encode;
//	        System.out.println("转码后的url:"+result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
