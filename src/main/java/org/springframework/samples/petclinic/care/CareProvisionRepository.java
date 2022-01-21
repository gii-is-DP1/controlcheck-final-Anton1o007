package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CareProvisionRepository extends CrudRepository<CareProvision,Integer>{
    @Query("SELECT c FROM CareProvision c")
    List<CareProvision> findAll();        
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);
    @Query("SELECT c FROM Care c")
	List<Care> findAllCares();
    //@Query("SELECT c FROM Care c WHERE ?1 IN c.compatiblePetTypes")
    List<Care> findCompatibleCares(String petTypeName);
    @Query("SELECT c FROM Care c WHERE c.name=?1")
    Care findCareByName(String name);
    //@Query("SELECT c FROM CareProvision c WHERE c.visit.")
    List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
}
