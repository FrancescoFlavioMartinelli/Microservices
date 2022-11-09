package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Video;
import services.VideoService;

@RestController
@RequestMapping("/catalogo")
public class VideoController {
	
	@Autowired
	private VideoService vs;
	
	@GetMapping("/all")
	public ResponseEntity<Video> getAll(Pageable p) {
		return new ResponseEntity.ok(vs.findAll(p));
	}
	
	@PostMapping("/listaPreferiti")
	public ResponseEntity<List<Video>> getFromLista(@RequestBody List<Long> listId) {
		return new ResponseEntity.ok(vs.getList(listId));
	}

}
