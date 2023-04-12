package user.service;

import java.util.List;

import user.bean.UserDTO;

public interface UserService {

	public void write(UserDTO userDTO);

	public List<UserDTO> getUserList();

	public String isExistID(String id);

	public UserDTO getUser(String id);

}
