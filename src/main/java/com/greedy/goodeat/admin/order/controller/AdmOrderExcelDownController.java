package com.greedy.goodeat.admin.order.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.goodeat.admin.order.dto.JyOrderDTO;
import com.greedy.goodeat.admin.order.service.AdmOrderService;

@Controller
@RequestMapping("/admin")
public class AdmOrderExcelDownController {
	
	String paymentMethod = "";
	String paymentDate = "";
	
	private final AdmOrderService admOrderService;
		
		public AdmOrderExcelDownController(AdmOrderService admOrderService) {
			
			this.admOrderService = admOrderService;
			
		}
	
	@GetMapping("/excel/download")
	public void downloadCarInfo(HttpServletResponse response) throws IOException {
	  // 엑셀 파일 하나를 만듭니다
	  Workbook workbook = new SXSSFWorkbook();
	  // 엑셀 파일 내부에 Sheet 를 하나 생성합니다 (엑셀 파일 하나에는 여러 Sheet가 있을 수 있습니다)
	  Sheet sheet = workbook.createSheet();

	  // 엑셀 렌더링에 필요한 DTO를 가져옵니다
	  List<JyOrderDTO> orderExcel = admOrderService.getOrderInfo();

	  // 헤더를 생성합니다
	  int rowIndex = 0;
	  Row headerRow = sheet.createRow(rowIndex++);
	  Cell headerCell1 = headerRow.createCell(0);
	  headerCell1.setCellValue("주문번호");

	  Cell headerCell2 = headerRow.createCell(1);
	  headerCell2.setCellValue("주문상품");

	  Cell headerCell3 = headerRow.createCell(2);
	  headerCell3.setCellValue("주문일시");

	  Cell headerCell4 = headerRow.createCell(3);
	  headerCell4.setCellValue("주문상태");
	  
	  Cell headerCell5 = headerRow.createCell(4);
	  headerCell5.setCellValue("결제금액");
	  
	  Cell headerCell6 = headerRow.createCell(5);
	  headerCell6.setCellValue("결제수단");
	  
	  Cell headerCell7 = headerRow.createCell(6);
	  headerCell7.setCellValue("결제일");
	  
	  Cell headerCell8 = headerRow.createCell(7);
	  headerCell8.setCellValue("회원아이디");
	  
	  Cell headerCell9 = headerRow.createCell(8);
	  headerCell9.setCellValue("전화번호");
	  
	  Cell headerCell10 = headerRow.createCell(9);
	  headerCell10.setCellValue("수령인");
	  
	  Cell headerCell11 = headerRow.createCell(10);
	  headerCell11.setCellValue("배송주소");
	  
	  Cell headerCell12 = headerRow.createCell(11);
	  headerCell12.setCellValue("상세주소");
	  
	  Cell headerCell13 = headerRow.createCell(12);
	  headerCell13.setCellValue("우편번호");
	  
	  Cell headerCell14 = headerRow.createCell(13);
	  headerCell14.setCellValue("송장번호");
	  
	  Cell headerCell15 = headerRow.createCell(14);
	  headerCell15.setCellValue("택배사");
	
	  // 바디에 데이터를 넣어줍니다
	  for (JyOrderDTO dto : orderExcel) {
	    Row bodyRow = sheet.createRow(rowIndex++);

	    Cell bodyCell1 = bodyRow.createCell(0);
	    bodyCell1.setCellValue(dto.getOrderNo());

	    Cell bodyCell2 = bodyRow.createCell(1);
	    bodyCell2.setCellValue(dto.getProduct().getProductName());
	    
	    Cell bodyCell3 = bodyRow.createCell(2);
	    bodyCell3.setCellValue(dto.getOrderDate());
	    
	    Cell bodyCell4 = bodyRow.createCell(3);
	    bodyCell4.setCellValue(dto.getOrderStatus());

	    Cell bodyCell5 = bodyRow.createCell(4);
	    bodyCell5.setCellValue(dto.getAmountPay());

	    // 아직 미해결
	    Cell bodyCell6 = bodyRow.createCell(5);
	    dto.getPayment().forEach(payment -> {
    		 paymentMethod += payment.getPayMethod() + "\n";
 	    });
	    if(paymentMethod != null ) {
	    	bodyCell6.setCellValue(paymentMethod);
	    }else {
	    	bodyCell6.setCellValue("내용없음");
	    }
	  
	    // 아직 미해결
	    Cell bodyCell7 = bodyRow.createCell(6);
	    dto.getPayment().forEach(payment -> {
   		 paymentDate += payment.getPayDate() + "\n";
	    });
	    if(paymentDate != null ) {
	    	bodyCell7.setCellValue(paymentDate);
	    }else {
	    	bodyCell7.setCellValue("내용없음");
	    }
	  
	    Cell bodyCell8 = bodyRow.createCell(7);
	    bodyCell8.setCellValue(dto.getMember().getMemberId());
	    
	    Cell bodyCell9 = bodyRow.createCell(8);
	    bodyCell9.setCellValue(dto.getMember().getPhone());
	    
	    Cell bodyCell10 = bodyRow.createCell(9);
	    bodyCell10.setCellValue(dto.getDelivery().getRecipient());
	    
	    Cell bodyCell11 = bodyRow.createCell(10);
	    bodyCell11.setCellValue(dto.getDelivery().getDeliveryAddress());
	    
	    Cell bodyCell12 = bodyRow.createCell(11);
	    bodyCell12.setCellValue(dto.getDelivery().getDeliveryDetailAddress());
	    
	    Cell bodyCell13 = bodyRow.createCell(12);
	    bodyCell13.setCellValue(dto.getDelivery().getZipCode());
	    
	    Cell bodyCell14 = bodyRow.createCell(13);
	    if(dto.getDelivery().getInvoiceNo() != null ) {
	    	 bodyCell14.setCellValue(dto.getDelivery().getInvoiceNo());
	    }else {
	    	 bodyCell14.setCellValue("미입력");
	    }
	    
	    Cell bodyCell15 = bodyRow.createCell(14);
	    if(dto.getDelivery().getInvoiceNo() != null ) {
	    	bodyCell15.setCellValue(dto.getDelivery().getDeliveryCompany());
	    }else {
	    	 bodyCell15.setCellValue("미입력");
	    }
	    	 
	  }
	  
	  response.setContentType("Application/Msexcel");
	  response.setHeader("Content-Disposition", "ATTachment; Filename="+URLEncoder.encode("주문내역","UTF-8")+".xlsx");
	  
	  workbook.write(response.getOutputStream());
	  workbook.close();
	}

}
