package com.hcl.portfolio.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hcl.portfolio.dto.PortfolioResponseDto;
import com.hcl.portfolio.exception.PortfolioNotFoundException;
import com.hcl.portfolio.model.Portfolio;
import com.hcl.portfolio.repository.PortfolioRepository;


@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	PortfolioRepository portfolioRepository;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	@Scheduled(cron = "0/5 * * ? * *")
	public void updatePrice() {
		List<Portfolio> portfolioList = portfolioRepository.findAll();
		portfolioList.forEach(portfolio -> {
			portfolio.setTotalPrice(Math.random() * 1000);
			portfolioRepository.flush();
		});
	}
	/*
	 * private SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	 * 
	 * @Scheduled(cron = "0/5 * * ? * *") public void task() {
	 * System.out.println("Scheduler (cron expression) task with duration : " +
	 * sdf.format(new Date())); }
	 */

	@Override
	public Portfolio findById(int portfolioId) throws PortfolioNotFoundException {
		Optional<Portfolio> portfolio = portfolioRepository.findById(portfolioId);
		if (portfolio.isPresent()) {
			return portfolio.get();
		}
		return null;
	}

	
	@Override
	public PortfolioResponseDto findByName(String portfolioName) throws PortfolioNotFoundException {
		Portfolio portfolio = portfolioRepository.findPortfolioByName(portfolioName);
		if (portfolio == null) {
			throw new PortfolioNotFoundException("No portfolios with this name");
		}
		return PortfolioService.convertPortfolioToPortfolioResponseDto(portfolio);
	}

	}
