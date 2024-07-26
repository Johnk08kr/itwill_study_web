package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Location;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class LocationRepositoryTest {

	@Autowired
	private LocationRepository locRepo;
	
//	@Test
	public void testDependencyInjection() {
		assertThat(locRepo).isNotNull();
		log.info("locRepo={}", locRepo);
	}
	
//	@Test
	public void testFindAll() {
		Long locCount = locRepo.count();
		assertThat(locCount).isEqualTo(23L);
		
		List<Location> locList = locRepo.findAll();
		log.info("locList[0]={}", locList.get(0));
	}
	
	@Transactional
	@Test
	public void testFindById() {
		Location loc = locRepo.findById(1600).orElseThrow();
		assertThat(loc.getId()).isEqualTo(1600);
		
		log.info("loc[1600]={}", loc);
		log.info("loc[1600].country={}", loc.getCountry());
	}
}
