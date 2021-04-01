package com.esprit.tn.controllers;


import java.util.List;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.esprit.tn.entities.Contract;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class UserPDFExporter {
	   private List<Contract> contractlist;
	   
	 

	   public UserPDFExporter(List<Contract> con) {
		   this.contractlist =con;
	        }

	   private void writeTableHeader(PdfPTable table) {
	       PdfPCell cell = new PdfPCell();
	       cell.setBackgroundColor(Color.CYAN);
	       cell.setPadding(5);
	        
	       Font font = FontFactory.getFont(FontFactory.HELVETICA);
	       font.setColor(Color.WHITE);
	       
	       cell.setPhrase(new Phrase("Type", font));
	       table.addCell(cell);
	       
	       cell.setPhrase(new Phrase("Seller", font));
	       table.addCell(cell);
	       
	       
	       cell.setPhrase(new Phrase("Buyer", font));
	       table.addCell(cell);
	       
	       cell.setPhrase(new Phrase("Address", font));
	       table.addCell(cell);  
	       
	       cell.setPhrase(new Phrase("Sum", font));
	       table.addCell(cell);
	       
	       
	       cell.setPhrase(new Phrase("Date", font));
	       table.addCell(cell);
	       
	        
	   }
	    
	   private void writeTableData(PdfPTable table) {
	       for (Contract contract : contractlist) {
	           table.addCell(contract.getType().toString());
	           table.addCell(contract.getSeller());
	           table.addCell(contract.getBuyer());
	           table.addCell(contract.getAddress());
	           
	           table.addCell(String.valueOf(contract.getSum()));
	           table.addCell(contract.getDate().toString());
	       }
	   }
	    
	   public void export(HttpServletResponse response) throws DocumentException, IOException {
	       Document document = new Document(PageSize.A4);
	       PdfWriter.getInstance(document, response.getOutputStream());
	        
	       document.open();
	       Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	       font.setSize(18);
	       font.setColor(Color.BLUE);
	        
	       Paragraph p = new Paragraph("Contract", font);
	       p.setAlignment(Paragraph.ALIGN_CENTER);
	       document.add(p);
	       

	       PdfPTable table = new PdfPTable(6);
	       table.setWidthPercentage(100f);
	       table.setSpacingBefore(10);
	        
	       writeTableHeader(table);
	       writeTableData(table);
	       document.add(table);
	       document.close();
		
	        
	   }
	}
