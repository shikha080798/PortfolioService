package com.hcl.management.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.management.dto.PortfolioRequestDto;
import com.hcl.management.exception.PortfolioNotFoundException;
import com.hcl.management.model.Account;
import com.hcl.management.model.Portfolio;
import com.hcl.management.repository.PortfolioRepository;
import com.hcl.management.service.IPortfolioService;

@Service
public class PortfolioServiceImpl implements IPortfolioService {

	@Autowired
	PortfolioRepository portfolioRepository;

	@Override
	public List<Portfolio> getportfolioDetails(Long accountNo) throws PortfolioNotFoundException {
		// TODO Auto-generated method stub
		List<Portfolio> portfolio = portfolioRepository.getportfolioDetails(accountNo);
		return portfolio;
	}

}
