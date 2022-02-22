package com.saramin.saraminback.domain.scrap.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saramin.saraminback.domain.scrap.dto.ScrapAddDto;
import com.saramin.saraminback.domain.scrap.dto.ScrapExperienceResponseDto;
import com.saramin.saraminback.domain.scrap.model.Scrap;

@Component
public class ScrapMapper {

	public Scrap toScrap(ScrapAddDto scrapAddDto){
		return Scrap.builder()
			.url(scrapAddDto.getUrl())
			.active(scrapAddDto.getActive())
			.company(scrapAddDto.getCompany())
			.position(scrapAddDto.getPosition())
			.keyword(scrapAddDto.getKeyword())
			.salary(scrapAddDto.getSalary())
			.id(scrapAddDto.getId())
			.postingTimestamp(scrapAddDto.getPostingTimestamp())
			.modificationTimestamp(scrapAddDto.getModificationTimestamp())
			.expirationTimestamp(scrapAddDto.getExpirationTimestamp())
			.closeType(scrapAddDto.getCloseType())
			.openingTimestamp(scrapAddDto.getOpeningTimestamp())
			.build();
	}

	public ScrapAddDto toScrapAddDto(Scrap scrap){
		return ScrapAddDto.builder()
			.url(scrap.getUrl())
			.active(scrap.getActive())
			.company(scrap.getCompany())
			.position(scrap.getPosition())
			.keyword(scrap.getKeyword())
			.salary(scrap.getSalary())
			.id(scrap.getId())
			.postingTimestamp(scrap.getPostingTimestamp())
			.modificationTimestamp(scrap.getModificationTimestamp())
			.expirationTimestamp(scrap.getExpirationTimestamp())
			.closeType(scrap.getCloseType())
			.openingTimestamp(scrap.getOpeningTimestamp())
			.build();
	}

	public ScrapExperienceResponseDto toDtoList(
		List<ScrapAddDto> newExperienceDto,
		List<ScrapAddDto> experienceDto,
		List<ScrapAddDto> bothExperienceDto,
		List<ScrapAddDto> anyExperienceDto
	) {
		return ScrapExperienceResponseDto.builder()
			.newExperience(newExperienceDto)
			.experience(experienceDto)
			.bothExperience(bothExperienceDto)
			.anyExperience(anyExperienceDto)
			.build();
	}
}
