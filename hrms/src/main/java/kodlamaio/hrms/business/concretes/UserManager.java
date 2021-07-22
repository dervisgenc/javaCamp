package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.core.entities.concretes.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
@Service
public class UserManager implements UserService {
	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Kullanıcılar Listelendi");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email));
	}
	
	@Override
	public Result add(User user) {
		if(userDao.findByEmail(user.getEmail())!=null){
			return new ErrorResult("Bu email ile kullanıcı mevcut");
		}
		this.userDao.save(user);
		return new SuccessResult("Sisteme kayıt olundu");
	}

	
	

	

}
