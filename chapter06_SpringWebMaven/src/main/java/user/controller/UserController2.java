package user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="user")
public class UserController2 {

	// 파일 업로드
	@GetMapping(value="uploadForm")
	public String uploadForm() {
		return "user/uploadForm";
	}
	
	//이미지 등록하기 업로드 쓸때는 반드시 MultipartFile img 이거 써야함
	@PostMapping(value="upload")
	@ResponseBody //브라우저에 바로 뿌리도록 jsp파일 안 찾음
	public String upload(@RequestParam MultipartFile img, HttpSession session) {
		
		//실제 폴더랑 가상폴더랑 위치가 다름
		//가상폴더
		String filePath_lier = "C:/Users/bitcamp/git/Spring/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage";
		
		
		//파일 업로드는 반드시 실제 폴더에 해야 위치할 수 있다. 그래야 모두가 볼 수 있음 가상 폴더는 나만 볼 수 있는 것 
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println("실제 폴더 = " + filePath);
		
		String fileName = img.getOriginalFilename();
		
		File file= new File(filePath, fileName); //파일 생성
		File file_lier= new File(filePath_lier, fileName); //파일 생성
		
		try {
			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file_lier));
			img.transferTo(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "<img src= '../storage/" + fileName + "' width='300' height='300' />"; 
	
	}
		 
}
