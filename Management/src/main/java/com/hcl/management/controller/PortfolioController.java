package com.hcl.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.management.dto.PortfolioRequestDto;
import com.hcl.management.dto.PortfolioResponseDto;
import com.hcl.management.exception.PortfolioNotFoundException;
import com.hcl.management.feignclient.PortfolioConnect;
import com.hcl.management.model.Portfolio;
import com.hcl.management.service.IPortfolioService;

@RestController
public class PortfolioController {
	@Autowired
	PortfolioConnect portfolioConnect;
	

	
	@GetMapping("/portfolio/{portfolioId}")
	public ResponseEntity<Portfolio> getPortfolioById(@PathVariable  int portfolioId) throws PortfolioNotFoundException{
		return portfolioConnect.findById(portfolioId);
	}
	

	 @GetMapping("/portfolios/{portfolioName}")
	 public ResponseEntity<PortfolioResponseDto> findByName(@PathVariable String portfolioName) throws PortfolioNotFoundException{
		 return portfolioConnect.findByName(portfolioName);
	 }
	 
	
}
