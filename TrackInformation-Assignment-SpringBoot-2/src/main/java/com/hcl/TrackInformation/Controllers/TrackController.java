package com.hcl.TrackInformation.Controllers;

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

import com.hcl.TrackInformation.Entity.Track;
import com.hcl.TrackInformation.Services.TrackService;

@RestController
@RequestMapping("/music/platform/v1/tracks")
public class TrackController {
	
	@Autowired
	private TrackService trackService;
	
	@PostMapping()
	public ResponseEntity<Track> CreateTrack(@RequestBody Track trackReq) {
		Track response = trackService.CreateMusicTrack(trackReq);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping()
	public ResponseEntity<List<Track>> GetAllTracks() {
		List<Track> response = trackService.getAllTracks();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/{trackId}")
	public ResponseEntity<?> DeleteTrack(@PathVariable Long trackId) {
		trackService.deleteTrack(trackId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/Sorted")
	public ResponseEntity<List<Track>> GetSortedTracks() {
		List<Track> tracks = trackService.getSortedTracks();
		return ResponseEntity.status(HttpStatus.OK).body(tracks);	
	}
	
}

