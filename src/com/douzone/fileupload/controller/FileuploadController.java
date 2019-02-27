package com.douzone.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileuploadController {
	
	@RequestMapping("/form")
	public String form() {
		return "form";//views까지 servlet에서 잡아줘서
		//http://localhost:8080/fileupload/form
	}
	
	//form - upload - result
	@RequestMapping("/upload")
	public String upload(
		@RequestParam(value = "email", required = true, defaultValue = "")String email,
		@RequestParam(value= "file1" ) MultipartFile file1,
		Model model) {	
		//result.jsp에서 지정해준 url1을 뿌려줌
		System.out.println("email:"+email);	
			
		//파라미터로 email 받아옴  
		return "result";
	}
}
