package ubci.app.business;

import java.util.List;

import javax.ejb.Remote;

import ubci.app.persistence.User;



@Remote
public interface UserServiceRemote {
	void createUser(User u);
	void saveOrUpdateUser(User u);
	User findUserById(int id);
	void removeUser(User u);
	boolean findUserByLoginAndPass(String log,String pass);
	List<User> findAllUser();
}
