package com.hcl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Trader;

@Repository
public interface TraderRepository extends JpaRepository<Trader, Long>{

	Optional<Trader> findByEmail(String email);

}
