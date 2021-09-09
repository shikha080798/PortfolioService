
package com.hcl.management.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.management.dto.PortfolioDetailsResponseDto;
import com.hcl.management.dto.PortfolioResponseDto;
import com.hcl.management.dto.PurchaseRequestDto;
import com.hcl.management.dto.PurchaseResponseDto;
import com.hcl.management.exception.ManagementException;
import com.hcl.management.exception.PortfolioNotFoundException;
import com.hcl.management.feignclient.PortfolioConnect;
import com.hcl.management.model.Account;
import com.hcl.management.model.Portfolio;
import com.hcl.management.model.Purchase;
import com.hcl.management.repository.AccountRepository;
import com.hcl.management.repository.PurchaseRepository;
import com.hcl.management.service.IAccountService;
import com.hcl.management.service.IPurchaseService;
import com.hcl.management.util.DateTimeUtil;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service

@Slf4j
public class PurchaseServiceImpl implements IPurchaseService {
	private static final Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);

	@Autowired
	PortfolioConnect portfolioConnect;

	@Autowired
	IAccountService iAccountService;

	@Autowired
	PurchaseRepository purchaseRepository;
	@Autowired
	AccountRepository accountRepository;

	@Override
	
		public String purchase(PurchaseRequestDto purchaseRequestDto)
				throws ManagementException, PortfolioNotFoundException {
			Account account = accountRepository.getById(purchaseRequestDto.getAccountId());
			if (account == null) {
				logger.warn("No such account exists");
				throw new ManagementException("Account Id doesn't exists");
			}
			ResponseEntity<Portfolio> portfolio = portfolioConnect.findById(purchaseRequestDto.getPortfolioId());
			Purchase purchase = new Purchase();
			purchase.setName("abc");
			purchase.setQuantity(purchaseRequestDto.getQuantity());
			purchase.setPrice(200);
			purchase.setDateTime(DateTimeUtil.dateTime());
			purchase.setAccount(account);
			logger.info("saving the data in the database");
			purchaseRepository.save(purchase);
			logger.info("data saved successfully");
			return "Purchased Successfully";
		
}

//	@Override
//	public List<PurchaseResponseDto> getById(int id) {
//		Purchase purchase = new Purchase();
//		purchase.purchaseRepository.findPurchaseById(id);
//		if(purchase==null) { 
//			throw new ManagementException("Id doesn't exists"); 
//		}
//		List <PurchaseResponseDto> dto = new ArrayList<PurchaseResponseDto>();
//		dto.
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
public PortfolioDetailsResponseDto getById(int id) throws ManagementException, PortfolioNotFoundException {
	Purchase purchase = purchaseRepository.findPurchaseById(id);
	if (purchase == null) {
		throw new ManagementException("Id doesn't exists");
	}
	PortfolioDetailsResponseDto portfolioDetailsResponseDto = new PortfolioDetailsResponseDto();
	portfolioDetailsResponseDto.setPurchaseResponseDto(IPurchaseService.convertPurchaseToPurchaseResponseDto(purchase));
	portfolioDetailsResponseDto
			.setCurrentPrice(portfolioConnect.findByName(purchase.getName()).getBody().getTotalPrice());
	return portfolioDetailsResponseDto;

}
	
	@Override
	public List<PurchaseResponseDto> getByAccountId(int accountId) throws ManagementException{
		List<Purchase> purchaseList=purchaseRepository.findPurchaseByAccountAccountId(accountId);
		if(purchaseList.isEmpty()) {
			throw new ManagementException("No purchases for this account");
		}
		return IPurchaseService.convertPurchaseListToPurchaseResponseDtoList(purchaseList);
		
	}
	

}
