package com.saramin.saraminback.domain.scrap.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.saramin.saraminback.domain.scrap.dto.ScrapAddDto;
import com.saramin.saraminback.domain.scrap.dto.ScrapCompareListDto;
import com.saramin.saraminback.domain.scrap.mapper.ScrapMapper;
import com.saramin.saraminback.domain.scrap.repository.ScrapMongoDBRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScrapService {
	private final ScrapMapper scrapMapper;
	private final ScrapMongoDBRepository scrapMongoDBRepository;

	public void addScrap(List<ScrapAddDto> scrapAddDto) {
		System.out.println(scrapAddDto);
		for (ScrapAddDto scraps : scrapAddDto) {
			scrapMongoDBRepository.save(scrapMapper.toScrap(scraps));
		}
	}

	public List<ScrapAddDto> getScrap() {
		return scrapMongoDBRepository.findAll().stream().map(scraps -> scrapMapper.toScrapAddDto(scraps)).collect(
			Collectors.toList());
	}

	public List<ScrapAddDto> getScrapCompare(ScrapCompareListDto scrapCompareListDto) {
		return scrapMongoDBRepository.findByIdIn(scrapCompareListDto.getId())
			.stream()
			.map(scraps -> scrapMapper.toScrapAddDto(scraps))
			.collect(
				Collectors.toList());
	}

}
