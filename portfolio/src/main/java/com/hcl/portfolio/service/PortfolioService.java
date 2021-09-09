package com.hcl.portfolio.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.hcl.portfolio.dto.PortfolioResponseDto;
import com.hcl.portfolio.exception.PortfolioNotFoundException;
import com.hcl.portfolio.model.Portfolio;

@Service
public interface PortfolioService {
	
//	public Portfolio savePortfolio(@Valid PortfolioRequestDto portfolioRequestDto);
//
//	public Portfolio getPortfolioById(int portfolioId) throws PortfolioNotFoundException;

//	public PortfolioResponseDto findById(int portfolioId) throws PortfolioNotFoundException;
//	
//	public static PortfolioResponseDto convertPortfolioToPortfolioResponseDto(Portfolio portfolio) {
//		PortfolioResponseDto portfolioResponseDto=new PortfolioResponseDto();
//		BeanUtils.copyProperties(portfolio,portfolioResponseDto);
//		return portfolioResponseDto;
//	}

	//public Portfolio getPortfolioById(int portfolioId)throws PortfolioNotFoundException;

	public Portfolio findById(int portfolioId) throws PortfolioNotFoundException;

	public PortfolioResponseDto findByName(String portfolioName) throws PortfolioNotFoundException;

	public static PortfolioResponseDto convertPortfolioToPortfolioResponseDto(Portfolio portfolio) {
		PortfolioResponseDto portfolioResponseDto=new PortfolioResponseDto();
		BeanUtils.copyProperties(portfolio,portfolioResponseDto);
		return portfolioResponseDto;
	}



}
