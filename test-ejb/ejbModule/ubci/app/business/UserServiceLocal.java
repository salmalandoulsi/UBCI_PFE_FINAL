package ubci.app.business;

import java.util.List;

import javax.ejb.Local;

import ubci.app.persistence.Project;
import ubci.app.persistence.User;


@Local
public interface UserServiceLocal {
	void createUser(User u);
	void saveOrUpdateUser(User u);
	User findUserById(int id);
	void removeUser(User u);
	List<User> findAllUser();

}
