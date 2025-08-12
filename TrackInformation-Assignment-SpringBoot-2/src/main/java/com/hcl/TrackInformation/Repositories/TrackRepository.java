package com.hcl.TrackInformation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.TrackInformation.Entity.Track;

public interface TrackRepository extends JpaRepository<Track, Long> {

}
