package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.NotFoundException;

import DTO.VideoDTO;
import model.User;
import repositories.UserRepository;

@Service
public class UserService {
	
	
	private final WebClient webClient;
	
	@Autowired
	private UserRepository ur;

	public Object getPreferiti(Long id) throws NotFoundException {
		Optional<User> u = ur.findById(id);
		if(u.isPresent()) {
			
			User user =  u.get();
//			for(Long idVideo : u.getPrefetiti()) {
				List<VideoDTO> res = webClient.get()
				.uri("http://localhost:8001/catalogo/listaPreferiti")
				.retrieve()
				.bodyToMono(List.class)
				.block();
				return res;
//			}
			
		}
		
		throw new NotFoundException();
	}
	
	

}
