package models;

import lombok.Data;

@Entity
@Data
public class Video {
	
	@Id
	private Long id;
	
	private String title;
	private Long durata;
	

}
