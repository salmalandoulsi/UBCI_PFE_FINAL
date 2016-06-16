package ubci.app.business;

import java.util.List;

import javax.ejb.Remote;

import ubci.app.persistence.Parametre;

@Remote
public interface ParametreRemote {
	void createParameter(Parametre app) ;

	 void saveOrUpdateParameter(Parametre app) ;

	 Parametre findParameterById(int id) ;

	 void removeParameter(Parametre app) ;

	 List<Parametre> findAllParameter() ;
}
