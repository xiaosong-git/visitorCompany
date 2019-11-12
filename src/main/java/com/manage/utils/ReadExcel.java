package com.manage.utils;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
     public Map<Integer, Map<String, Object>> read(String filepath) {
    	 if(filepath==null) {
    		 return null;
    	 }
    	 try {
    	 File excel = new File(filepath);
    	 if(excel.exists()&&excel.isFile()) {
    		 String [] split = excel.getName().split("\\.");
    		 String str = split[split.length-1];
    		 Workbook wb;
    		 FileInputStream fs = new FileInputStream(excel);
    		 if("xls".equals(str)) {
    			 wb = new HSSFWorkbook(fs);
    			
    		 }else if("xlsx".equals(str)) {
    			 wb = new XSSFWorkbook(fs);
    			 
    		 }else {
    			 wb=null;
    		 }
    		 Sheet sheet = wb.getSheetAt(0);
    		 int titleRowIndex = sheet.getFirstRowNum();
    		 Row firstRow = sheet.getRow(titleRowIndex);
    		 int firstColNum = firstRow.getFirstCellNum();
    		 int LastColNum = firstRow.getLastCellNum();
    		 int colNum = firstRow.getPhysicalNumberOfCells();
    		 String[] title=new String[colNum];
    		 for(int i=firstColNum;i<LastColNum;i++) {
    			 title[i]=firstRow.getCell(i).getStringCellValue();
    		 }
    		 Map<Integer,Map<String,Object>> content = new HashMap<Integer,Map<String,Object>>();
    		 int firstRowIndex = sheet.getFirstRowNum()+1;
			 int lastRowIndex = sheet.getLastRowNum();
			 for(int i=firstRowIndex;i<=lastRowIndex;i++) {
				 Row row= sheet.getRow(i);
				 if(row !=null) {
					 int firstCellIndex = row.getFirstCellNum();
                     int lastCellIndex = row.getLastCellNum();
                     Map<String,Object> cellValue = new HashMap<String,Object>();
                     for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {
                    	 Object obj = getCellFormatValue(row.getCell(cIndex));
                    	 cellValue.put(title[cIndex],obj);
                     }
                     content.put(i,cellValue);
				 }
			 }
    	     return content;
    	 }
    	 } catch(Exception e) {
			 return null;
		 }
		return null;
     }
     /**
 	 * 
 	 * 根据Cell类型设置数据
 	 * 
 	 * @param cell
 	 * @return
 	 * @author hwk
 	 */
 	private Object getCellFormatValue(Cell cell) {
 		Object cellvalue = "";
 		if(cell==null) {
 			return null;
 		}
 		if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC) {
 			//如果是date
 			if(DateUtil.isCellDateFormatted(cell)) {
 				SimpleDateFormat df =new SimpleDateFormat("yyyy-mm-dd");
 				cellvalue = df.format(DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
 			}
 			//如果是纯数字
 			else {
 				cellvalue = cell.getNumericCellValue();
 			}
 		}
 		else if(cell.getCellType()==Cell.CELL_TYPE_STRING) {
 			cellvalue = cell.getStringCellValue();
 		}
 		else if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN) {
 			cellvalue = cell.getBooleanCellValue()+"";
 		}
 		else if(cell.getCellType()==Cell.CELL_TYPE_FORMULA) {
 			cellvalue = cell.getCellFormula()+"";
 		}
 		else if(cell.getCellType()==Cell.CELL_TYPE_BLANK) {
 			cellvalue = "";
 		}
 		else if(cell.getCellType()==Cell.CELL_TYPE_ERROR) {
 			cellvalue = "errorCell";
 		}	
 		else {
 			cellvalue = "unknowCell";
 		}
 		return cellvalue;
 	}

}
