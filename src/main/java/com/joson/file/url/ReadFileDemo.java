package com.joson.file.url;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

/***
 ** @Author JosonLiu
 ** @Date 2016-08-10
 ** @Version 1.0
 ***/
public class ReadFileDemo {
	public static void main(String[] args) throws Throwable {
		FileReader fileReader = new FileReader("E:\\blacklist.txt");
		BufferedReader reader = new BufferedReader(fileReader);
		List<Integer> areaList = Arrays.asList(9,10,11);
		String temp = "";
		StringBuilder sqlStr = new StringBuilder();
		while ((temp =reader.readLine()) != null)  {
			for(Integer each : areaList){
				sqlStr.append("("+each+","+temp+"),");
			}
		}
		reader.close();
		System.out.println(sqlStr.toString());
	}
}
