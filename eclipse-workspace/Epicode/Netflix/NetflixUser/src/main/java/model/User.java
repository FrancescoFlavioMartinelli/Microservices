package model;

import java.util.List;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	private Long id;
	
	private String nome;
	private String username;
	private String password;
	
	private List<Long> preferiti;
	
	

}
