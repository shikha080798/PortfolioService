package com.hcl.management.service;

import java.util.List;

import javax.validation.Valid;

import com.hcl.management.dto.PortfolioRequestDto;
import com.hcl.management.exception.PortfolioNotFoundException;
import com.hcl.management.model.Portfolio;


public interface IPortfolioService {

	List<Portfolio> getportfolioDetails(Long accountNo) throws PortfolioNotFoundException ;
}
