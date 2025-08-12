package com.hcl.TrackInformation.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.TrackInformation.Entity.Track;

public interface TrackService {
		
	Track CreateMusicTrack(Track track);
	
	List<Track> getAllTracks();

	void deleteTrack(Long trackId);
	
	List<Track> getSortedTracks();



}
