package com.joson.file.export.txt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***文本文件导出服务
 ** @Author JosonLiu
 ** @Date 2016年10月9日
 ** @Version 1.0
 **/
public class OutPutToFileService {
	private static final Logger log = LoggerFactory.getLogger(OutPutToFileService.class);
	/**
	 * 以字节流输出到文件
	 * @param file 存储内容的文件
	 * @param content 输出的内容
	 */
	public static void outputWithBytes(File file ,String content){
			try {
				FileOutputStream write = new FileOutputStream(file);
				byte[] contentBytes = content.getBytes();
				write.write(contentBytes);
				write.close();
				log.debug(" output to file success. filePath:{}",file.getAbsolutePath());
			} catch (IOException e) {
				log.debug(" output to file error. filePath:{}",file.getAbsolutePath());
			}
	}
	/**
	 * 以字符流输出
	 * @param file 存储内容的文件
	 * @param content 输出的内容
	 */
	public static void outputWithCharacter(File file ,String content){
		try {
			FileWriter write = new FileWriter(file);
			write.write(content);
			write.close();
			log.debug(" output to file success. filePath:{}",file.getAbsolutePath());
		}catch (IOException e) {
			log.debug(" output to file error. filePath:{}",file.getAbsolutePath());
		}
	}
}

