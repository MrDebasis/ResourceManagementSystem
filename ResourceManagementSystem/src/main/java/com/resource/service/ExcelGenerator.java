package com.resource.service;

import java.io.ByteArrayInputStream; import java.io.ByteArrayOutputStream;
import java.io.IOException; import java.util.List;
import org.apache.poi.ss.usermodel.Cell; import
org.apache.poi.ss.usermodel.CellStyle; import
org.apache.poi.ss.usermodel.CreationHelper; import
org.apache.poi.ss.usermodel.Font; import
org.apache.poi.ss.usermodel.IndexedColors; import
org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook; import
org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.resource.model.Resources;

public class ExcelGenerator { 
	public static ByteArrayInputStream resourcessToExcel(List<Resources> resources) throws IOException {

		String[] COLUMNs = {"country", "globalGroupID", "employeeId","emailId","password", "name","localGrade", 
				"leaveApplied", "status","grade","type", "officeCity"}; 

		try( Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();){
			CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("Resources");

			Font headerFont = workbook.createFont(); 
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < COLUMNs.length; col++) { Cell cell =
					headerRow.createCell(col); cell.setCellValue(COLUMNs[col]);
					cell.setCellStyle(headerCellStyle);
			}

			CellStyle ageCellStyle = workbook.createCellStyle();
			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

			int rowIdx = 1; for (Resources res : resources)
			{ Row row =sheet.createRow(rowIdx++);

			row.createCell(0).setCellValue(res.getCountry());
			row.createCell(1).setCellValue(res.getGlobalGroupID());
			row.createCell(2).setCellValue(res.getEmployeeId());
			row.createCell(3).setCellValue(res.getEmailId());
			row.createCell(4).setCellValue(res.getPassword());
			row.createCell(5).setCellValue(res.getName());
			row.createCell(6).setCellValue(res.getLocalGrade());
			row.createCell(7).setCellValue(res.getLeaveApplied());
			row.createCell(8).setCellValue(res.getStatus());
			row.createCell(9).setCellValue(res.getGrade());
			row.createCell(10).setCellValue(res.getType());
			row.createCell(11).setCellValue(res.getOfficeCity());

			Cell ageCell = row.createCell(14); ageCell.setCellValue(res.getEmployeeId());
			ageCell.setCellStyle(ageCellStyle);
			}

			workbook.write(out); 
			return new ByteArrayInputStream(out.toByteArray()); } 
	}
}
