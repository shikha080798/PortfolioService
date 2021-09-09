package com.hcl.management.feignclient;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.management.dto.PortfolioResponseDto;
import com.hcl.management.exception.PortfolioNotFoundException;
import com.hcl.management.model.Portfolio;




@FeignClient(name="portfolioservice", url="http://localhost:8091/")
public interface PortfolioConnect {
	
	@GetMapping("/portfolio/{portfolioId}")
	public ResponseEntity<Portfolio> findById(@PathVariable  int portfolioId) throws PortfolioNotFoundException;
	

	 @GetMapping("/portfolios/{portfolioName}")
	 public ResponseEntity<PortfolioResponseDto> findByName(@PathVariable String portfolioName) throws PortfolioNotFoundException;
	
}
	
