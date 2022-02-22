package com.saramin.saraminback.domain.scrap.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScrapEducationResponseDto {

	@JsonProperty("any")
	private List<ScrapAddDto> any;
	@JsonProperty("highschool")
	private List<ScrapAddDto> highschool;
	@JsonProperty("univ")
	private List<ScrapAddDto> univ;
	@JsonProperty("univ-4year")
	private List<ScrapAddDto> univ4year;

}
