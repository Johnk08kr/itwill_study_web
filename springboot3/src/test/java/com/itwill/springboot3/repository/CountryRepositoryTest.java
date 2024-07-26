package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Country;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CountryRepositoryTest {
	
	@Autowired
	private CountryRepository countryRepo;
	
//	@Test
	public void testDependencyInjection() {
		
		assertThat(countryRepo).isNotNull();
		log.info("countryRepo={}", countryRepo);
	}
	
//	@Test
	public void testFindAll() {
		
		Long countryCount = countryRepo.count();
		assertThat(countryCount).isEqualTo(25L);
		
		List<Country> countryList = countryRepo.findAll();
		log.info("countryList[0]={}", countryList.get(0));
	}
	
	@Transactional
	@Test
	public void testFindById() {
		
		Country country = countryRepo.findById("JP").orElseThrow();
		assertThat(country.getId()).isEqualTo("JP");
		
		log.info("country[JP]={}", country);
		log.info("country[JP]={}", country.getRegion());
	}
}
