package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.AddMoneyRequest;
import com.hcl.dto.TraderReq;
import com.hcl.entity.Trader;
import com.hcl.service.TraderService;

@RestController
@RequestMapping("/trading/traders")
public class TraderController {

	@Autowired
	private TraderService traderService;

	@PostMapping("/register")
	public ResponseEntity<Trader> registerTrader(@RequestBody Trader traderReq) {

		boolean existing = traderService.validateExistance(traderReq);

		if (existing) {
			return ResponseEntity.status(400).body(null);
		}

		Trader trader = traderService.registerTrader(traderReq);
		return ResponseEntity.status(HttpStatus.CREATED).body(trader);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Trader>> getAllTrader() {

		List<Trader> traders = traderService.getAllTrader();

		return ResponseEntity.ok(traders);
	}

	@PutMapping()
	public ResponseEntity<Trader> updateTrader(@RequestBody TraderReq traderReq) {

		Trader trader = traderService.getTraderByEmail(traderReq.getEmail());

		if (trader == null) {
			return ResponseEntity.status(404).body(null);
		}

		Trader updatedTrader = traderService.updateTrader(traderReq);

		return ResponseEntity.ok(updatedTrader);
	}

	@PutMapping("/add")
	public ResponseEntity<Trader> addMoney(@RequestBody AddMoneyRequest request) {
		Trader updatedTrader = traderService.addMoneyToTrader(request.getEmail(), request.getAmount());

		if (updatedTrader == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.ok(updatedTrader);
	}

	@GetMapping()
	public ResponseEntity<Trader> getTraderByEmail(@RequestParam String email) {
		Trader trader = traderService.getTraderByEmail(email);
		if (trader == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(trader);
	}

}
