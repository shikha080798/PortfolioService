package com.hcl.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hcl.management.model.Portfolio;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
	@Query("from Portfolio where (account_no=:accountNo)")
	List<Portfolio> getportfolioDetails(Long accountNo);

	//List<Portfolio> findByAccountNo(Long accountNo);
}
