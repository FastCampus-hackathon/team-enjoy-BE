package com.saramin.saraminback.domain.scrap.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScrapExperienceResponseDto {

	@JsonProperty("new_experience")
	private List<ScrapAddDto> newExperience;
	private List<ScrapAddDto> experience;
	@JsonProperty("both_experience")
	private List<ScrapAddDto> bothExperience;
	@JsonProperty("any_experience")
	private List<ScrapAddDto> anyExperience;

}
