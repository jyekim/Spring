package user.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;
import user.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController2 {
	@Autowired
	private UserService userService; 

	// 파일 업로드
	@GetMapping(value="uploadForm")
	public String uploadForm() {
		return "user/uploadForm";
	}
	
	
	// 파일 업로드
		@GetMapping(value="uploadForm_AJax")
		public String uploadForm_AJax() {
			return "user/uploadForm_AJax";
		}
		
		
		
		// 파일 업로드
		@GetMapping(value="uploadForm_AJax_list")
		public String uploadForm_AJax_list() {
			//화면에 띄움
			return "user/uploadForm_AJax_list";
		}
		
		@PostMapping(value="getUploadForm_AJax_list")
		@ResponseBody
		public List<UserImageDTO> getUploadForm_AJax_list(){
			return userService.getUploadForm_AJax_list();
		}
	
	
	//이미지 등록하기 업로드 쓸때는 반드시 MultipartFile img 이거 써야함
	/*@PostMapping(value="upload", produces = "text/html; charset=UTF-8")
	@ResponseBody //브라우저에 바로 뿌리도록 jsp파일 안 찾음
	public String upload(@RequestParam MultipartFile img, 
						@ModelAttribute UserImageDTO userImageDTO,
						HttpSession session) {
		
		//실제 폴더랑 가상폴더랑 위치가 다름
		//가상폴더
		//String filePath_lier = "C:/Users/bitcamp/git/Spring/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage";
		
		
		//파일 업로드는 반드시 실제 폴더에 해야 위치할 수 있다. 그래야 모두가 볼 수 있음 가상 폴더는 나만 볼 수 있는 것 
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println("실제 폴더 = " + filePath);
		
		String fileName = img.getOriginalFilename();
		System.out.println("파일명 = " + fileName);
		
		
		
		File file= new File(filePath, fileName); //파일 생성
		//File file_lier= new File(filePath_lier, fileName); //파일 생성
		
		try {  
			//FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file_lier)); //파일 복사
			img.transferTo(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		userImageDTO.setImage1(fileName);
		
		//UserService -> UserDAO  -->userMapper.xml 
		
		
		return "<img src= '../storage/" + fileName + "' width='300' height='300' />"; 
	
	}
	*/
	
	/*-------------name"img"가 2개 이상일 때  */
	 /* @PostMapping(value="upload", produces = "text/html; charset=UTF-8")
	@ResponseBody //브라우저에 바로 뿌리도록 jsp파일 안 찾음
	public String upload(@RequestParam MultipartFile[] img, 
						@ModelAttribute UserImageDTO userImageDTO,
						HttpSession session) {
		
		
		//파일 업로드는 반드시 실제 폴더에 해야 위치할 수 있다. 그래야 모두가 볼 수 있음 가상 폴더는 나만 볼 수 있는 것 
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println("실제 폴더 = " + filePath);
		
		String fileName;
		File file;
		
		if(img[0] != null) {
			fileName = img[0].getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				img[0].transferTo(file);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(img[1] != null) {
			fileName = img[1].getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				img[1].transferTo(file);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return "이미지 등록 완료"; 
	
	}
	*/
	
	
	
	//==============한번에 여러개 파일을 선택 ============
	@PostMapping(value="upload", produces = "text/html; charset=UTF-8")
	@ResponseBody                      //multipartfile이 여러개가 되어야 한다는 뜻
	public String upload(@RequestParam("img[]") List<MultipartFile> list, 
						@ModelAttribute UserImageDTO userImageDTO,
						HttpSession session) {
		
		
		//파일 업로드는 반드시 실제 폴더에 해야 위치할 수 있다. 그래야 모두가 볼 수 있음 가상 폴더는 나만 볼 수 있는 것 
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println("실제 폴더 = " + filePath);
		
		String fileName;
		File file;
		
		Map<String, String> map = new HashMap<>();
		
		
		List<String> fileNameList = new ArrayList<String>();
		for(MultipartFile img: list) {
			fileName = img.getOriginalFilename();
			file = new File(filePath, fileName);
	
			try {
				img.transferTo(file);

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			fileNameList.add(fileName);
			
		
			
		}//for
		
		userService.upload(userImageDTO, fileNameList);
		
		return "이미지 등록 완료";
		 
	}
	
}
