package kodlama.io.hrms.core.utilities.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

public class CloudinaryService {
	
	Cloudinary cloudinary;
	
    private Map<String, String> valuesMap = new HashMap<>();
	
	public CloudinaryService() {
		
		
		
		valuesMap.put("cloud_name","dcajl19dv" );
		
		valuesMap.put("api_key", "936233725779375" );
		
		valuesMap.put("api_secret","**********************" );
		
		cloudinary = new Cloudinary(valuesMap);
	}
	
	public Map upload (MultipartFile multipartFile) throws IOException {
		
		File file = convert(multipartFile);
		
		Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		
		file.delete();
		
		return result;
	}
	
	public Map delete (int id) throws IOException {
		
		Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
		
		return result;
	}
	
	
	private File convert(MultipartFile multipartFile) throws IOException {
		
		File file = new File(multipartFile.getOriginalFilename());
		
		FileOutputStream stream = new FileOutputStream(file);
		
		stream.write(multipartFile.getBytes());
		
		stream.close();
		
		return file;
	}

}
