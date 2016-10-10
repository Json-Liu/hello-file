package com.joson.file.export.txt;

import java.io.File;

/***导出内容到文本
 ** @Author JosonLiu
 ** @Date 2016年10月9日
 ** @Version 1.0
 **/
public class OutPutToTxt {
	public static void main(String[] args) {
		File file = new File("E:\\joson_export.txt");
		String content = "Hello my name is Joson Liu.This is my test to write file.";
		OutPutToFileService.outputWithCharacter(file, content);
	}
}

