package com.hcl.PlaylistApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.PlaylistApi.Entity.PlayList;
import com.hcl.PlaylistApi.Service.PlayListService;

@RestController
@RequestMapping("/v1/playlists")

public class PlayListController {

	@Autowired
	private PlayListService playListService;

	
	//Create Playlist
	
	@PostMapping()
	public ResponseEntity<PlayList> createPlayList(@RequestBody PlayList playlist) {

		PlayList playList = new PlayList();
		playList.setName(playlist.getName());
		playList.setTracks(playlist.getTracks());
		playListService.createPlaylist(playList);
		
		return new ResponseEntity<>(playList, HttpStatus.CREATED);
	}
	
	// Get playlist by id

	@GetMapping("/{playListId}")
	public ResponseEntity<PlayList> getPlayList(@PathVariable Long playListId) {

		return ResponseEntity.ok(playListService.getPlaylist(playListId));
	}

	// Get all playlists
	
	@GetMapping()
	public ResponseEntity<List<PlayList>> getAll() {
		return ResponseEntity.ok(playListService.getAllPlaylists());
	}
	
	// Delete playlist
	
	@DeleteMapping("/{playListId}")
	public ResponseEntity<Void> deletePlayList(@PathVariable Long playListId) {
		playListService.deletePlayList(playListId);
		return ResponseEntity.status(204).body(null);

	}

}
