package com.hcl.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.TraderReq;
import com.hcl.entity.Trader;
import com.hcl.repository.TraderRepository;

@Service
public class TraderService {

	@Autowired
	private TraderRepository traderRepository;

	public boolean validateExistance(Trader traderReq) {
		return traderRepository.findByEmail(traderReq.getEmail()).isPresent();
	}

	public Trader registerTrader(Trader trader) {
		return traderRepository.save(trader);
	}

	public List<Trader> getAllTrader() {
//		return traderRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		return traderRepository.findAll();
	}

	public Trader getTraderByEmail(String email) {
		Optional<Trader> traderOpt = traderRepository.findByEmail(email);
		return traderOpt.orElse(null);
	}

	public Trader updateTrader(TraderReq traderReq) {
		Trader trader = this.getTraderByEmail(traderReq.getEmail());
		trader.setName(traderReq.getName());
		trader.setUpdatedAt(new Date());
		return traderRepository.save(trader);
	}

	public Trader addMoneyToTrader(String email, double amount) {
		Trader trader = getTraderByEmail(email);

		if (trader == null) {
			return null;
		}

		trader.setBalance(trader.getBalance() + amount);
		trader.setUpdatedAt(new Date());

		return traderRepository.save(trader);
	}

}
