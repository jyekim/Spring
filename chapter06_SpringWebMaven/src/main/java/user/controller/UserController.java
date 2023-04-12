package user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
		
		@Autowired
		private UserService userService; 
		
	
		@GetMapping(value="writeForm")
		public String writeForm() {
			return "user/writeForm"; 
		}
		
		
		@PostMapping(value="write")
		@ResponseBody
		public void write(@ModelAttribute UserDTO userDTO) {
			userService.write(userDTO);
			 
		}
		
		
		
		@GetMapping(value="list")
		public String list() {
			// DB를 거치지 않고 바로 화면에 틀만 띄움
			return "user/list";
		}
		
		@PostMapping(value="getUserList")
		@ResponseBody 
		public List<UserDTO> getUserList() {
			return userService.getUserList();
		}
		
		
		@PostMapping(value="isExistId")
		@ResponseBody
		public String isExistId(@RequestParam String id) {
		
			return userService.isExistID(id);
		}
		
		
		@GetMapping(value="updateForm")
		public String UpdateForm() {
			return "user/updateForm";
		}
		
		@PostMapping(value="getUser")
		@ResponseBody
		public UserDTO getUser(@RequestParam String id) {
			return userService.getUser(id);
		}
}

//"angel"로 쓰면 단순문자열이 아니라 파일명으로 인식 => /WEB-INF/angel.jsp