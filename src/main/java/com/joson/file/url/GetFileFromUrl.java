package com.joson.file.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/***
 ** @Author JosonLiu
 ** @Date 2016-07-28
 ** @Version 1.0
 ***/
public class GetFileFromUrl {
	public static void main(String[] args) throws IOException {
		try {
			URL url = new URL("http://yyfinancesmall.bs2dl.yy.com/yyfinance_teacher_channel1.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			
			/*while (reader.read() != -1) { //错误的方式 原因： reader.read() 会自动向前读一个字节 导致每行数据丢失一个字节
				String line = reader.readLine();
				System.out.println(line);
			}*/
			
			String line = "";
			while((line = reader.readLine()) != null ){
				System.out.println(line);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
