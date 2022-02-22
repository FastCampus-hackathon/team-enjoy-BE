package com.saramin.saraminback.domain.scrap.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScrapCompareListDto {
	@JsonProperty("id")
	private List<String> id;
}
