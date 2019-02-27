package com.douzone.fileupload.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileuploadService {
	public String restore(MultipartFile multipartFile) {
		String url = "";
		if(multipartFile.isEmpty() ) {
			return url;
		}//비어있는지 확인
		
		String originalFileName = multipartFile.getOriginalFilename();
		String extName = originalFileName.substring(originalFileName.lastIndexOf(',')+1);//뒤에서 부터 찾아야 확장자 +1?
		String saveFileName = generateSaveFileName(extName);
		long fileSize = multipartFile.getSize();
		
		System.out.println("################" + originalFileName);
		System.out.println("################" + extName);
		System.out.println("################" + saveFileName);
		System.out.println("################" + fileSize);
		
		return url;
	}
	private String generateSaveFileName(String extName) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += ("."+extName);
		
		return fileName;
	}
}
