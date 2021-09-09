package com.hcl.portfolio.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.portfolio.dto.PortfolioResponseDto;
import com.hcl.portfolio.exception.PortfolioNotFoundException;
import com.hcl.portfolio.model.Portfolio;
import com.hcl.portfolio.service.PortfolioService;



@RestController
public class PortfolioController {
	
	@Autowired
	PortfolioService portfolioService;

	@GetMapping("/portfolio/{portfolioId}")
	public ResponseEntity<Portfolio> findById(@PathVariable  int portfolioId) throws PortfolioNotFoundException {
		//portfolioService.getPortfolioById(portfolioId);
		return new ResponseEntity<Portfolio>(portfolioService.findById(portfolioId), HttpStatus.ACCEPTED);

	}
//	 @GetMapping("/portfolios/{portfolioId}")
//	 public ResponseEntity<PortfolioResponseDto> findById(@PathVariable int portfolioId) throws PortfolioNotFoundException {
//		return new ResponseEntity<PortfolioResponseDto>(portfolioService.findById(portfolioId), HttpStatus.OK);
//		 
//	 }
	 
	 @GetMapping("/portfolios/{portfolioName}")
	 public ResponseEntity<PortfolioResponseDto> findByName(@PathVariable String portfolioName) throws PortfolioNotFoundException{
		 return new ResponseEntity<PortfolioResponseDto>(portfolioService.findByName(portfolioName), HttpStatus.OK); 
	 }
	/*
	 * private SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	 * 
	 * @Scheduled(cron = "0/5 * * ? * *") public void task() {
	 * System.out.println("Scheduler (cron expression) task with duration : " +
	 * sdf.format(new Date())); }
	 */

}

