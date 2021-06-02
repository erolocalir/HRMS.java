package kodlama.io.hrms.dataAccess.abstracts;

import java.awt.Image;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao extends JpaRepository<Image, Integer>  {
	
	Optional<Image> findById();

}

