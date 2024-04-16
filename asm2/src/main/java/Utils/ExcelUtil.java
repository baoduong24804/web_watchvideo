/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import Entity.History;
import Entity.User;
import Entity.Video;
import Main.test;
import Storage.VideoLike;

import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 *
 * @author Ha Thanh Liem
 */
public class ExcelUtil {

    public static Workbook printUser(List<User> list) throws FileNotFoundException, IOException {
    	
    	

    	HSSFWorkbook workbook = new HSSFWorkbook();
    	HSSFSheet sheet = workbook.createSheet("List User");
    	
//      KhoaHoc kh = (KhoaHoc) cbKhoaHoc.getSelectedItem()
       // List<Object[]> list = dao.getNguoiHoc();

        int rownum = 0;
        Cell cell = null;
        Row row = null;
        // 
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        //MaNH
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Id");
        cell.setCellStyle(style);

        //Họ Tên
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Email");
        cell.setCellStyle(style);

        //Điểm 
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Username");
        cell.setCellStyle(style);

        //Xếp loại
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("PassWord");
        cell.setCellStyle(style);
        
      
        cell = row.createCell(4, CellType.BOOLEAN);
        cell.setCellValue("Role");
        cell.setCellStyle(style);
        
        
        cell = row.createCell(5, CellType.BOOLEAN);
        cell.setCellValue("Online");
        cell.setCellStyle(style);

        //DATA 
        for (int i = 0; i < list.size(); i++) {
            rownum++;
            row = sheet.createRow(rownum);

            //ID Student
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue((Integer) list.get(i).getUserId());

            //FULL NAME
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue((String) list.get(i).getEmail());

            //POINT
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue((String) list.get(i).getUsername());

            //CLASSIFICATION
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue((String) list.get(i).getPassword());
            
            cell = row.createCell(4, CellType.BOOLEAN);
            cell.setCellValue((Boolean) list.get(i).getRole());
            
            cell = row.createCell(5, CellType.BOOLEAN);
            cell.setCellValue((Boolean) list.get(i).getOnline());

        }
    	
        return workbook;

    }
    
public static Workbook printVideo(List<Video> list) throws FileNotFoundException, IOException {
    	
    	

    	HSSFWorkbook workbook = new HSSFWorkbook();
    	HSSFSheet sheet = workbook.createSheet("List Video");
    	
//      KhoaHoc kh = (KhoaHoc) cbKhoaHoc.getSelectedItem()
       // List<Object[]> list = dao.getNguoiHoc();

        int rownum = 0;
        Cell cell = null;
        Row row = null;
        // 
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        //MaNH
        cell = row.createCell(0, CellType.NUMERIC);
        cell.setCellValue("Id");
        cell.setCellStyle(style);

        //Họ Tên
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Title");
        cell.setCellStyle(style);

        //Điểm 
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("URL");
        cell.setCellStyle(style);

        //Xếp loại
        cell = row.createCell(3, CellType.NUMERIC);
        cell.setCellValue("Share");
        cell.setCellStyle(style);
        
      
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Description");
        cell.setCellStyle(style);
        
        

        //DATA 
        for (int i = 0; i < list.size(); i++) {
            rownum++;
            row = sheet.createRow(rownum);

            //ID Student
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue((Integer) list.get(i).getVideoId());

            //FULL NAME
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue((String) list.get(i).getTitle());

            //POINT
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue((String) list.get(i).getUrl());

            //CLASSIFICATION
            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue((Integer) list.get(i).getShare());
            
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue((String) list.get(i).getDescription());
            
          

        }
    	
        return workbook;

    }

public static Workbook printSatistical(List<VideoLike> list) throws FileNotFoundException, IOException {
	
	

	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("List Video");
	
//  KhoaHoc kh = (KhoaHoc) cbKhoaHoc.getSelectedItem()
   // List<Object[]> list = dao.getNguoiHoc();

    int rownum = 0;
    Cell cell = null;
    Row row = null;
    // 
    HSSFCellStyle style = createStyleForTitle(workbook);

    row = sheet.createRow(rownum);

    //MaNH
    cell = row.createCell(0, CellType.NUMERIC);
    cell.setCellValue("Id");
    cell.setCellStyle(style);

    //Họ Tên
    cell = row.createCell(1, CellType.STRING);
    cell.setCellValue("Title");
    cell.setCellStyle(style);

    //Điểm 
    cell = row.createCell(2, CellType.STRING);
    cell.setCellValue("URL");
    cell.setCellStyle(style);

    //Xếp loại
    cell = row.createCell(3, CellType.NUMERIC);
    cell.setCellValue("Share");
    cell.setCellStyle(style);
    
  
    cell = row.createCell(4, CellType.NUMERIC);
    cell.setCellValue("Like");
    cell.setCellStyle(style);
    
    

    //DATA 
    for (int i = 0; i < list.size(); i++) {
        rownum++;
        row = sheet.createRow(rownum);

        //ID Student
        cell = row.createCell(0, CellType.NUMERIC);
        cell.setCellValue((Integer) list.get(i).getVideoId());

        //FULL NAME
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue((String) list.get(i).getTitle());

        //POINT
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue((String) list.get(i).getUrl());

        //CLASSIFICATION
        cell = row.createCell(3, CellType.NUMERIC);
        cell.setCellValue((Integer) list.get(i).getShare());
        
        cell = row.createCell(4, CellType.NUMERIC);
        cell.setCellValue((Integer) list.get(i).getTotalLike());
        
      

    }
	
    return workbook;

}

    public static void chooseDirectoryToSave(Workbook workbook,String type) {
    	File directory = null;
        //int x = choose.showSaveDialog(null);
		ClassLoader classLoader = ExcelUtil.class.getClassLoader();
		URL resource = classLoader.getResource("Main");
		if (resource != null) {
			
			try {
				directory = new File(resource.toURI());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        
            try {
                String file = directory.getAbsolutePath().toString()+"\\";
                System.out.println(file);
                Date date = new Date();
                String d = date.toString().replace(" ", "_").replace(":", "_");
                System.out.println(d);
                FileOutputStream outFile = new FileOutputStream(file+d+type+".xlsx");
                workbook.write(outFile);
                workbook.close();
                outFile.close();
                System.out.println("Done Excel");
            } catch (Exception ex) {
               System.out.println(ex.getMessage());
            }
        }
    

    
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    
}
