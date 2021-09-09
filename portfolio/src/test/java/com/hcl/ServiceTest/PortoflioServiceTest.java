package com.hcl.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hcl.portfolio.dto.PortfolioResponseDto;
import com.hcl.portfolio.exception.PortfolioNotFoundException;
import com.hcl.portfolio.model.Portfolio;
import com.hcl.portfolio.repository.PortfolioRepository;
import com.hcl.portfolio.service.PortfolioServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PortoflioServiceTest {

	@Mock
	PortfolioRepository portfolioRepository;
	@InjectMocks
	PortfolioServiceImpl portfolioServiceimpl;
	// static Optional<Portfolio> options;
	static Portfolio portfolio;
	static PortfolioResponseDto portfoliodto;

	@BeforeAll
	public static void setup() {

		portfolio = new Portfolio();
		portfolio.setName("HCL");
		portfolio.setPortfolioId(1);
		portfolio.setTotalPrice(120.00);
		portfoliodto = new PortfolioResponseDto();
		portfoliodto.setName("HCL");
		portfoliodto.setQuantity(1);
		portfoliodto.setTotalPrice(120.00);
	}

@Test
@DisplayName("Portfolio By Id : Positive Scenerio")
public void PortfolioById1() throws PortfolioNotFoundException{
//context
doReturn(Optional.of(portfolio)).when(portfolioRepository).findById(1);
//event
Portfolio result = portfolioServiceimpl.findById(1);
//outcome
assertEquals(result,portfolioRepository.findById(1).get());
}

@Test
@DisplayName("Portfolio By Id : Negative Scenerio")
public void PortfolioById2() throws PortfolioNotFoundException{
//context
doReturn(Optional.of(portfolio)).when(portfolioRepository).findById(1);
//outcome
assertThrows(PortfolioNotFoundException.class,()-> portfolioServiceimpl.findById(1));
}

@Test
@DisplayName("Portfolio By Username : Positive Scenerio")
public void PortfolioByUsername1() throws PortfolioNotFoundException{
//context
when(portfolioRepository.findPortfolioByName("HCL")).thenReturn(portfolio);
//event
PortfolioResponseDto result = portfolioServiceimpl.findByName("HCL");
//outcome
assertEquals(result.getName(),portfolioRepository.findPortfolioByName("HCL").getName());
assertEquals(result.getTotalPrice(),portfolioRepository.findPortfolioByName("HCL").getTotalPrice());
assertEquals(result.getQuantity(),portfolioRepository.findPortfolioByName("HCL").getQuantity());

}

@Test
@DisplayName("Portfolio By Username : Negative Scenerio")
public void PortfolioByUsername2() throws PortfolioNotFoundException{
//context
when(portfolioRepository.findPortfolioByName("HCL)")).thenReturn(portfolio);
//outcome
assertThrows(PortfolioNotFoundException.class,()-> portfolioServiceimpl.findByName("HCL"));

}
}