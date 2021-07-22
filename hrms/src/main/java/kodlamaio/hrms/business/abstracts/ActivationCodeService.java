package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.entities.concretes.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {
	void createCode(ActivationCode code ,User user);
	
	Result verifyCode(String code,int id);
    
	DataResult<ActivationCode> getByUserId(int id);


}
