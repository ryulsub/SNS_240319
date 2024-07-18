package com.sns.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {
	
	public static final String FILE_UPLOAD_PATH = "D:\\신률섭\\6_spring_project\\sns\\sns_workspace\\images/";
	
	// input:MultipartFile, userLoginId
	// output:String(이미지경로)
	public String uploadFile(MultipartFile file, String loginId) {
		
		String directoryName = loginId + "_" + System.currentTimeMillis();
		
		String filePath = FILE_UPLOAD_PATH + directoryName + "/";
		
		File directory = new File(filePath);
		if ( directory.mkdir() == false) {
			return null;
		}
		
		try {
			byte[] bytes = file.getBytes();
			//★★★★★★★ 한글명으로 된 이미지는 업로드 불가하므로 나중에 영문자로 바꾸기
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return null; // 이미지 업로드 실패시 경로 null
		}
		
		return "/images/" + directoryName + "/" + file.getOriginalFilename();
	}

}
