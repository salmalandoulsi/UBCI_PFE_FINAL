package ubci.app.business;

import java.util.List;

import javax.ejb.Local;

import ubci.app.persistence.Parametre;
import ubci.app.persistence.TypeP;

@Local
public interface ParametreLocal {

	void createParameter(Parametre app);

	void saveOrUpdateParameter(Parametre app);

	Parametre findParameterById(int id);

	void removeParameter(Parametre app);

	List<Parametre> findAllParameter();

	List<Parametre> findSpecificType(int id);
	 List<Parametre> findSpecificType(TypeP type ) ;
	
	// type 
	void createTypeP(TypeP app);

	void saveOrUpdateTypeP(TypeP app);

	TypeP findTypePById(int id);

	void removeTypeP(TypeP app);

	List<TypeP> findAllTypeP();

	
}
