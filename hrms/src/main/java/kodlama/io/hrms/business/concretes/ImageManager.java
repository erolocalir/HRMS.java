package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ImageDao;
import kodlama.io.hrms.entities.concretes.Image;

public class ImageManager implements ImageService{
	
	
	ImageDao imageDao;
	
	
	
	@Autowired
	public ImageManager(ImageDao imageDao) {
		super();
		this.imageDao = imageDao;
	}






	@Override
	public DataResult<List<Image>> getAll() {
		
		return new SuccessDataResult<List<Image>>(this.imageDao.findById(),"Başarıyla listelendi");
	}

	
	
	
	
	
	@Override
	public Result add(Image image) {
		
		this.imageDao.save(image);
		return new SuccessResult("Başarıyla eklendi.");
		
	}

	
	
	
	@Override
	public Result delete(int id) {

		this.imageDao.deleteById(id);
		return new SuccessResult("Başarıyla silindi");
		
	}

	
	

	@Override
	public DataResult<List<Image>> getById(int id) {
		
		return new SuccessDataResult<List<Image>>(this.imageDao.findById(id),"Verilen id'ye sahip ürün başarıyla getirildi.");
		
		
		
	}

	
	@Override
	public boolean isAvailable(int id) {
		
		return this.imageDao.existsById(id);
		
		
	}

}
