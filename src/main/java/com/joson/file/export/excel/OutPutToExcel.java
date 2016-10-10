package com.joson.file.export.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/***
 ** @Author JosonLiu
 ** @Date 2016年10月9日
 ** @Version 1.0
 **/
public class OutPutToExcel {
	public static void main(String[] args) throws IOException {
		String filePath = "E:\\Excel写入示例.xls";
		String excelName = "Excel写入示例";
		List<List<String>> excelContent = new ArrayList<List<String>>();
		for (int rowIndex = 0; rowIndex < 6; rowIndex++) {
			List<String> eachRowContent = new ArrayList<String>();
			for(int colIndex = 0 ; colIndex < 6 ; colIndex++){
				String cellContent = String.format("JAVA文件写入第 %d 行，第 %d 列", rowIndex,colIndex);
				eachRowContent.add(cellContent);
			}
			excelContent.add(eachRowContent);
		}
		OutPutToExcelService.OutPutToExcel(filePath, excelName, excelContent);
	}
}

