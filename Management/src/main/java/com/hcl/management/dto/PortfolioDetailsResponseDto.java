package com.hcl.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioDetailsResponseDto {
	
	private PurchaseResponseDto purchaseResponseDto;
	
	private double currentPrice;

	public PurchaseResponseDto getPurchaseResponseDto() {
		return purchaseResponseDto;
	}

	public void setPurchaseResponseDto(PurchaseResponseDto purchaseResponseDto) {
		this.purchaseResponseDto = purchaseResponseDto;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

}
