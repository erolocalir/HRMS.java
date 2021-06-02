package kodlama.io.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionWithAdvertisementDto {
	
	private int id;
	
	private String positionName;
	
	private int openPositions;
	
	private String description;
	
	

}

