package com.joson.file.export.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/***
 ** @Author JosonLiu
 ** @Date 2016年10月10日
 ** @Version 1.0
 **/
public class OutPutToExcelService {
	private static final Logger log = LoggerFactory.getLogger(OutPutToExcelService.class);
	/**
	 * 将给定内容写入到给定路径的Excel中
	 * @param filePath 文件路径
	 * @param excelName Excel名称
	 * @param content 写入内容   内容用一个 List<List<String>> 封装，第一个 list 可以用来做每列的列名，其他为数据
	 * @throws IOException
	 */
	public static void OutPutToExcel(String filePath,String excelName,List<List<String>> content ){
				try {
					FileOutputStream out = new FileOutputStream(filePath);
					Workbook wb = new HSSFWorkbook();
					Sheet s = wb.createSheet();
					for (int rowIndex = 0 ;rowIndex < content.size(); rowIndex++) {
						List<String> eachList = content.get(rowIndex);//获取每一行的内容
						Row eachRow = s.createRow(rowIndex);
						for (int colIndex = 0 ;colIndex < eachList.size();colIndex++) {
							Cell eachCell = eachRow.createCell(colIndex, Cell.CELL_TYPE_STRING);
							String cellVal = eachList.get(colIndex) == null ? "" : eachList.get(colIndex) ;
							eachCell.setCellValue(cellVal);//写入当前行当前列的内容
						}
					}
					wb.setSheetName(0, excelName);
					wb.write(out);
					out.close();
					wb.close();
					log.debug("write to {} success.",filePath);
				} catch (FileNotFoundException e) {
					log.error("file not exist in {},please check.",filePath,e);
				} catch (IOException e) {
					log.error("write file to  {} error.",filePath,e);
				}
	}
}

