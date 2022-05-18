package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	Workbook wb ;
	
	public  ExcelUtilities(String excelpath) throws Throwable{
		FileInputStream fi = new FileInputStream(excelpath);
		wb= WorkbookFactory.create(fi);
	
}
	public int rowcount(String sheetname )
	{
	return wb.getSheet(sheetname).getLastRowNum();	
	}
	public int cellcount(String sheetname)
	{
		return wb.getSheet(sheetname).getRow(0).getLastCellNum();
		
	}
	public String getcelldata(String sheetname , int row, int colum)
	{
		String Data="";
		if (wb.getSheet(sheetname).getRow(row).getCell(colum).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int aa =(int)wb.getSheet(sheetname).getRow(row).getCell(colum).getNumericCellValue();
			Data = String.valueOf(aa);
		}
		else{
			Data= wb.getSheet(sheetname).getRow(row).getCell(colum).getStringCellValue();
			}
		return Data;
	}
	public void setcelldata(String sheetname, int row,int colum,String status,String outputpath) throws Throwable
	{
		Sheet ws = wb.getSheet(sheetname);
		Row rr = wb.getSheet(sheetname).getRow(row);
		Cell cc =wb.getSheet(sheetname).getRow(row).getCell(colum);
		cc.setCellValue(status);
		if (status.equalsIgnoreCase("pass")) {
			CellStyle style= wb.createCellStyle();
			Font font= wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			font.setBoldweight(font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rr.getCell(colum).setCellStyle(style);
		}
		else if (status.equalsIgnoreCase("fail")) {
			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			font.setBold(true);
			font.setColor(IndexedColors.RED.getIndex());
			font.setBoldweight(font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rr.getCell(colum).setCellStyle(style);
		}
		else if (status.equalsIgnoreCase("Blocked")) {
			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			font.setBold(true);
			font.setBoldweight(font.BOLDWEIGHT_BOLD);
			font.setColor(IndexedColors.BLACK.getIndex());
			style.setFont(font);
			rr.getCell(colum).setCellStyle(style);
			
		}
		FileOutputStream fo = new FileOutputStream(outputpath);
		wb.write(fo);
		//fo.close();
		wb.close();
		
	}
	
	

}
