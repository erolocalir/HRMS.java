package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Candidates;
import kodlama.io.hrms.entities.concretes.Users;

public interface CandidatesDao extends JpaRepository<Candidates, Integer>{

	Candidates findByNationalityId(String id);

	void saveAll(Users verifications);
	
}

