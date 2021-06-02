package kodlama.io.hrms.dataAccess.abstracts;

import java.awt.Image;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobPosition;
import kodlama.io.hrms.entities.dtos.JobPositionWithAdvertisementDto;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	
	
	JobPosition getPositionName(String positionName);

	JobPosition findByPositonName(String positionName);
	
	JobPosition findById(int id);
	
	Optional<Image> getJobPositionWithAdvertisementDetails();
	

}


