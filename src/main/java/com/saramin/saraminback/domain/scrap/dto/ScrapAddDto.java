package com.saramin.saraminback.domain.scrap.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.saramin.saraminback.domain.scrap.model.CloseType;
import com.saramin.saraminback.domain.scrap.model.Company;
import com.saramin.saraminback.domain.scrap.model.Position;
import com.saramin.saraminback.domain.scrap.model.Salary;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScrapAddDto implements Serializable {
	private String url;
	private int active;
	private Company company;
	private Position position;
	private String keyword;
	private Salary salary;

	private String id;
	@JsonProperty("posting-timestamp")
	private String postingTimestamp;
	@JsonProperty("modification-timestamp")
	private String modificationTimestamp;
	@JsonProperty("expiration-timestamp")
	private String expirationTimestamp;
	@JsonProperty("close-type")
	private CloseType closeType;
	@JsonProperty("opening-timestamp")
	private String openingTimestamp;
}
