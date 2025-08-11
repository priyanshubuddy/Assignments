package com.hcl.PlaylistApi.Service;

import com.hcl.PlaylistApi.Entity.PlayList;
import com.hcl.PlaylistApi.Repository.PlayListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListService {

	@Autowired
	public PlayListRepo playListRepo;

	public PlayList createPlaylist(PlayList playList) {
		return playListRepo.save(playList);
	}

	public PlayList getPlaylist(Long id) {
		return playListRepo.findById(id).get();
	}

	public List<PlayList> getAllPlaylists() {
		return playListRepo.findAll();
	}

	public void deletePlayList(long id) {
		playListRepo.deleteById(id);
	}

	public PlayList updatePlaylist(PlayList playlist) {
		return playListRepo.save(playlist); // assuming you use Spring Data JPA
	}

}
