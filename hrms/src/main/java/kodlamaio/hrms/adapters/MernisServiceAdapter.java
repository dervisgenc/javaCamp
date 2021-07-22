package kodlamaio.hrms.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PersonCheckService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements PersonCheckService{

	@Override
	public boolean checkRealPerson(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return true;
	}

	/*@Override
	public boolean checkRealPerson(JobSeeker jobSeeker) {
		KPSPublicSoapProxy client= new KPSPublicSoapProxy();
		boolean result =false;
		try {
			result=client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalId()), 
					jobSeeker.getFirstName().toUpperCase(new Locale("tr")), 
					jobSeeker.getLastName().toUpperCase(new Locale("tr")),
					jobSeeker.getBirthYear()
					);
		} catch (NumberFormatException | RemoteException e) {
			e.printStackTrace();
		}
		return result;
	} */	
	

}
