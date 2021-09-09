package com.hcl.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.portfolio.controller.PortfolioController;
import com.hcl.portfolio.dto.PortfolioResponseDto;
import com.hcl.portfolio.exception.PortfolioNotFoundException;
import com.hcl.portfolio.model.Portfolio;
import com.hcl.portfolio.service.PortfolioService;

@ExtendWith(MockitoExtension.class)
public class PortfolioControllerTest {
	@Mock
	PortfolioService portfolioService;
	@InjectMocks
	PortfolioController portfolioController;
	static Portfolio portfolio;
	static PortfolioResponseDto portfolioResponseDto;

	@BeforeAll
	public static void setUp() {
		portfolio = new Portfolio();
		portfolio.setPortfolioId(1);
		portfolio.setName("Keerthi");
		portfolio.setQuantity(1);
		portfolio.setTotalPrice(3000);
	}

	@Test
	@DisplayName("Portfolio Function: Positive Scenario")
	public void portfolioTest() throws PortfolioNotFoundException {
		// context
		when(portfolioService.findById(1)).thenReturn(portfolio);
		// event
		Portfolio result = portfolioService.findById(1);
		// outcome
		assertEquals(portfolio, result);
		//assertEquals(HttpStatus.OK, result);
	}

	@Test
	@DisplayName("Portfolio Name Function: Positive Scenario")
	public void portfolioTest1() throws PortfolioNotFoundException {
		// context
		when(portfolioService.findByName("Keerthi")).thenReturn(portfolioResponseDto);
		// event
		PortfolioResponseDto result = portfolioService.findByName("Keerthi");
		// outcome
		assertEquals(portfolioResponseDto, result);
		//assertEquals(HttpStatus.OK, result);
	}

	@Test
	@DisplayName("Portfolio Function: Negative Scenario")
	public void portfolioTest2() throws PortfolioNotFoundException {
		// context
		when(portfolioService.findById(0)).thenThrow(PortfolioNotFoundException.class);
		// event
		// outcome
		assertThrows(PortfolioNotFoundException.class, () -> portfolioController.findById(0));
	}
}
