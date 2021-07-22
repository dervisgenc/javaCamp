package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.entities.concretes.User;
import kodlamaio.hrms.core.utilities.randomCodeGenerator.RandomCodeGenerator;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService{
	private ActivationCodeDao activationCodeDao;
	

	
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
		
	}

	

	
	@Override
	public void createCode(ActivationCode activationCode , User user) {
		
			RandomCodeGenerator randomCodeGenerator = new RandomCodeGenerator();
			
			activationCode.setUserId(user.getId());
			
			activationCode.setCode(randomCodeGenerator.createRandomCode());
			
			this.activationCodeDao.save(activationCode);
		
	}

	/*@Override
	public Result verifyCode(String code,ActivationCode activationCode) {
		if(activationCodeDao.findByCode(code) == null){
            return new ErrorResult("Kod hatalı");
        }
		
		activationCode.setVerified(true);
		return new SuccessResult("Kullanıcı aktif edildi");        
		
	}*/	
	@Override
	public Result verifyCode(String code, int id ) {
		
		if (this.activationCodeDao.findByUserId(id).isVerified() == true) {
			return new ErrorResult("E-posta zaten doğrulanmış.");
		}else if (this.activationCodeDao.getByUserId(id).getCode().equals(code) && this.activationCodeDao.findByUserId(id).isVerified() == false) {
			this.activationCodeDao.activateUser(id);
		 return new SuccessResult("E-posta doğrulandı.");
		}
		
		return new ErrorResult("Doğrulama geçersiz");
		
	}




	@Override
	public DataResult<ActivationCode> getByUserId(int id) {
		
		return new SuccessDataResult<ActivationCode>(this.activationCodeDao.getByUserId(id));
	}
	
	

}
