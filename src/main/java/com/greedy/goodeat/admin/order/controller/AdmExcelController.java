package com.greedy.goodeat.admin.order.controller;


import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
public class AdmExcelController {
	
	 	@PostMapping("/excel/download")
	    public void excelDownload(@RequestParam String fileName, HttpServletResponse response, Model model) throws Exception{
	 		
	 		try (XSSFWorkbook objWorkBook = new XSSFWorkbook()) {
	 			XSSFSheet objSheet = null;
	 			XSSFRow objRow = null;
	 			XSSFCell objCell = null;
				
				//제목폰트
	 			XSSFFont font = objWorkBook.createFont();
				font.setFontHeightInPoints((short)9);
				font.setFontName("맑은고딕");
				
				//제목스타일에 폰트적용, 정렬
				XSSFCellStyle styleHd = objWorkBook.createCellStyle();
				styleHd.setFont(font);
				
				objSheet = objWorkBook.createSheet("첫번째 시트");
			
			       
			    
				
				// 1행
				objRow = objSheet.createRow(0);
				objRow.setHeight((short) 0x150);
				
				objCell = objRow.createCell(0);
				objCell.setCellValue("번호");
				objCell.setCellStyle(styleHd);
				
				objCell = objRow.createCell(1);
				objCell.setCellValue("이름");
				objCell.setCellStyle(styleHd);
				
				//2행 
				objRow = objSheet.createRow(0);
				objRow.setHeight((short) 0x150);
				
				objCell = objRow.createCell(0);
				objCell.setCellValue("1");
				objCell.setCellStyle(styleHd);
				
				objCell = objRow.createCell(1);
				objCell.setCellValue("홍길동");
				objCell.setCellStyle(styleHd);
				
				response.setContentType("Application/Msexcel");
				response.setHeader("Content-Disposition", "ATTachment; Filename="+URLEncoder.encode("주문내역","UTF-8")+".xlsx");
				
				OutputStream fileOut = response.getOutputStream();
				objWorkBook.write(fileOut);
				fileOut.close();
			}
	 		response.getOutputStream().flush();
	 		response.getOutputStream().close();
	 		
	 	}
	      
	
	

}


