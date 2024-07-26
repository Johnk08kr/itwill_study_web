package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot3.domain.Region;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class RegionRepositoryTest {
	
	@Autowired
	private RegionRepository regionRepo;
	
//	@Test
	public void testDependencyInjection() {
		
		assertThat(regionRepo).isNotNull();
		log.info("regionRepo={}", regionRepo);
	}
	
	@Test
	public void testFindAll() {
		
		Long RegionCount = regionRepo.count();
		assertThat(RegionCount).isEqualTo(4);
		
		List<Region> regionList = regionRepo.findAll();
		log.info("regionList[2]={}", regionList.get(2));
	}
}
