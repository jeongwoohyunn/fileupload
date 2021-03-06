package com.douzone.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.fileupload.service.FileuploadService;


@Controller
public class FileuploadController {
	
	@Autowired
	FileuploadService fileuploadService;
	
	@RequestMapping("/form")
	public String form() {
		return "form";//views까지 servlet에서 잡아줘서
		//http://localhost:8080/fileupload/form
	}
	
	//form - upload - result
	@RequestMapping("/upload")
	public String upload(
		@RequestParam(value = "email", required = true, defaultValue = "")String email,
		@RequestParam(value= "upload-file" ) MultipartFile multipartFile,
		Model model) {	
		
		//여러개 넘기려면 배열로 넘기면된다.MultipartFile[] multipartFile
		//result.jsp에서 지정해준 url을 뿌려줌
		System.out.println("email:"+email);	
		String url = fileuploadService.restore(multipartFile);
		
		model.addAttribute("url",url);
		//파라미터로 email 받아옴  
		return "result";
	}
}
