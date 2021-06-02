package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Image;

public interface ImageService {
	
	
	DataResult<List<Image>> getAll();
	
	Result add(Image image);
	
	Result delete(int id);
	
	DataResult<List<Image>> getById(int id);

	boolean isAvailable(int id);
	
	

}


