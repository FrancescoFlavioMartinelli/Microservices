package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.NotFoundException;

import DTO.VideoDTO;
import services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@GetMapping("/{id}/preferiti")
	public ResponseEntity<List<VideoDTO>> getPreferiti(@PathVariable Long id) {
		try {
			return new ResponseEntity.ok(us.getPreferiti(id));
		} catch(NotFoundException e) {
			return new ResponseEntity.notFound();
		}
	}

}
