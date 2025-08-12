package com.hcl.TrackInformation.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hcl.TrackInformation.Entity.Track;
import com.hcl.TrackInformation.Repositories.TrackRepository;
import com.hcl.TrackInformation.Services.TrackService;

@Service
public class TrackServiceImpl implements TrackService {
	
	@Autowired
	private TrackRepository trackRepository;

	@Override
	public Track CreateMusicTrack(Track track) {
		return trackRepository.save(track);
	}

	@Override
	public List<Track> getAllTracks() {
		return trackRepository.findAll();
	}

	@Override
	public void deleteTrack(Long trackId) {
		trackRepository.deleteById(trackId);
	}

	@Override
	public List<Track> getSortedTracks() {
		return trackRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
	}
	
}
