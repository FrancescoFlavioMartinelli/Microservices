package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import models.Video;
import repositories.VideoRepository;

@Service
public class VideoService {
	
	@Autowired
	private VideoRepository vr;
	
	public Page<Video> findAll(Pageable p) {
		return vr.findAll(p);
	}
	
	public List<Video> getList(List<Long> listId) {
		List<Video> res = new ArrayList<Video>)();
		for(Long i : listId) {
			Optional<Video> v = vr.findById(i);
			if(v.isPresent()) {				
				res.add(v.get());
			}
		}
		return res;
	}

}
