package com.saramin.saraminback.domain.search.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {

	@NotBlank
	private String keyword;

	private int start;
}
