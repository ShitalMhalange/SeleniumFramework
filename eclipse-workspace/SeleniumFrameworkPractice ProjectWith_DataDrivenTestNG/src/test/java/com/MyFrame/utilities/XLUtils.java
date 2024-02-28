package com.MyFrame.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 
{
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet wsh;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlFiles,String xlsheet) throws IOException
	{
		fis=new FileInputStream(xlFiles);
		wb=new XSSFWorkbook(fis);
		wsh=wb.getSheet(xlsheet);
		int rcount=wsh.getLastRowNum();
		wb.close();
		fis.close();
		
		return rcount;
	}
	public static int getcellCount(String xlFiles,String xlsheet,int rownum) throws IOException
	{
		fis=new FileInputStream(xlFiles);
		wb=new XSSFWorkbook(fis);
		wsh=wb.getSheet(xlsheet);
		row=wsh.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;
	}
	public static String getcellData(String xlFiles,String xlsheet,int rownum,int colnum) throws IOException
	{
		fis=new FileInputStream(xlFiles);
		wb=new XSSFWorkbook(fis);
		wsh=wb.getSheet(xlsheet);
		row=wsh.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try
		{
			DataFormatter formatter=new DataFormatter();
			String cellData=formatter.formatCellValue(cell);
			return cellData;
			
		}
		catch (Exception e)
		{
			data="";
		}
		wb.close();
		fis.close();
		return data;
	}
	public static void setcellData(String xlFiles,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fis=new FileInputStream(xlFiles);
		wb=new XSSFWorkbook(fis);
		wsh=wb.getSheet(xlsheet);
		row=wsh.getRow(rownum);
		cell=row.getCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xlFiles);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	
}
