package com.smartchoice.controller;

import org.hibernate.Transaction;
import org.hibernate.Query;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.smartchoice.dao.Dao;
import com.smartchoice.model.UploadFile;
import com.smartchoice.model.UploadFile;

import oracle.jdbc.pool.OracleDataSource;

@RestController
@RequestMapping(value="/product")

public class ProductUploadListController {
	@Autowired
	//DriverManagerDataSource datasource;
	OracleDataSource dsource;

	@Autowired
	SessionFactory sf;

	 byte[] data;
     Long l;
	
	@Autowired
	private Dao fileUploadDao;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String showUploadForm() {
		return "Heloo..its image_upload";
	
	}
	
	  @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	    public String handleFileUpload(HttpServletRequest request,
	            @RequestParam(value="file",required=false) CommonsMultipartFile[] fileUpload) throws Exception {
	         
		  System.out.println("####################");
	        if (fileUpload != null && fileUpload.length > 0) {
	            for (CommonsMultipartFile aFile : fileUpload){
	                 
	                System.out.println("Saving file: " + aFile.getOriginalFilename());
	                
	                UploadFile uploadFile = new UploadFile();
	                uploadFile.setFileName(aFile.getOriginalFilename());
	                uploadFile.setData(aFile.getBytes());
	                fileUploadDao.save(uploadFile);                
	            }
	        }
	 
	        return "Success";
	    }	
	  @RequestMapping("/remove")
		public String remove(@PathVariable("documentId") long documentId) {
			
		  fileUploadDao.remove(documentId);
			
			return "Success";
		
	

	  }
	  
	  @RequestMapping(value="/download/")
      public ModelAndView download1(@ModelAttribute("file")UploadFile f)
      {
    	  UploadFile u=fileUploadDao.getfile(f);
    	  System.out.println("*******");
    	  return new ModelAndView("edit","file",u);
      }
	  
	  
	  @RequestMapping(value="/load")
	    public String getAllFileUpload(Model mo) 
	    {
	    	System.out.println("in controller-----------------");
	  	   System.out.println("---displayalldata---");
	  	 
	  	 List<UploadFile> stu =fileUploadDao.getAllFileUpload();
	  		   System.out.println("list-------------"+stu);
	         //System.out.println(stu.getFileName()+"--file name");
	  		   mo.addAttribute("fileupload", stu);
	  		   return "display";
	 	 
	 		  }
	  
	  
	  @RequestMapping(value="/download/upd")
      public ResponseEntity<ByteArrayResource> download(UploadFile ul) throws IOException {
    	  
    	  System.out.println("hiiii");
        List<UploadFile> stu =fileUploadDao.getAllFileUpload();
 		   for(UploadFile f:stu) 
 		   {
 			  data =f.getData(); 
 			  
 		   }
 		 ByteArrayResource resource = new ByteArrayResource(data);
 		 System.out.println("---image---");
 	      return ResponseEntity.ok()
 	            .header(HttpHeaders.CONTENT_DISPOSITION,
 	                  "attachment;filename=" + ul.getFileName().toString())
 	            .contentType(MediaType.IMAGE_JPEG).contentLength(data.length)
 	            .body(resource);
 	   }

}
