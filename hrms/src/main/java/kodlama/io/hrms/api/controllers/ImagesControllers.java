package kodlama.io.hrms.api.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.core.utilities.services.CloudinaryService;
import kodlama.io.hrms.entities.concretes.Image;

@RestController
@RequestMapping("/api/cloudinary")

public class ImagesControllers {
	
	CloudinaryService cloudinaryService;
	
	ImageService imageService;
	
	
	@Autowired
	public ImagesControllers(CloudinaryService cloudinaryService, ImageService imageService) {
		
		super();
		this.cloudinaryService = cloudinaryService;
		this.imageService = imageService;
	}
	
	
	@GetMapping("getall")
	
	public ResponseEntity<List<Image>> getAll(){
		
		List<Image> list  = this.imageService.getAll().getData();
		
		return new ResponseEntity(list,HttpStatus.OK);
		
		}
	
	@PostMapping("/upload")
	
	public ResponseEntity<?> upload (@RequestParam MultipartFile multipartFile) throws IOException {
		
		BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
		
		if(bufferedImage == null) {
			
			return new ResponseEntity("Resim yüklemesi başarısız.", HttpStatus.BAD_REQUEST);
		
		
		
	}
		
		
		Map result = cloudinaryService.upload(multipartFile);
		
		Image image = new Image();
		
		this.imageService.add(image);
		
		
		return new ResponseEntity("Image saved.", HttpStatus.OK);
	
	

}
	
	
	
	@DeleteMapping("/delete/{id}")
	
	public ResponseEntity<?> delete (@PathVariable("id") int id) throws IOException{
		
	
		if (!this.imageService.isAvailable(id)) {
			
			return new ResponseEntity("Böyle bir resim bulunamadı",HttpStatus.NOT_FOUND);
		}
		
		Image image = this.imageService.getById(id).getData().get(id);
		
		Map result = cloudinaryService.delete(image.getId());
		
		this.imageService.delete(id);
		
		return new ResponseEntity("Resim başarıyla silindi.", HttpStatus.OK);
	

}




}


















