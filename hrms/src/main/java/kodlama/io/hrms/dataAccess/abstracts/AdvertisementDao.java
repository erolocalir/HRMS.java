package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Advertisement;

public interface AdvertisementDao extends JpaRepository<Advertisement,Integer> {
	
	List<Advertisement> findByIsActiveTrue();
	
	List<Advertisement> findByIsActiveTrueOrderByPublicationDate();
	
	List<Advertisement> findByIsActiveTrueAndEmployer_userid(int userid);
	
	Advertisement findByIdAndEmployer_Userid(int id, int userid);

}

