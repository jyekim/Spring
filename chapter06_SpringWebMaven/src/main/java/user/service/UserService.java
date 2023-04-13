package user.service;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserService {

	public void write(UserDTO userDTO);

	public Map<String, Object> getUserList(String pg);

	public String isExistID(String id);

	public UserDTO getUser(String id);

	public void delete(String id);

	public void update(UserDTO userDTO);

}
