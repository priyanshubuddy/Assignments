package com.hcl.PlaylistApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.PlaylistApi.Entity.PlayList;

public interface PlayListRepo extends JpaRepository<PlayList,Long> {

}
