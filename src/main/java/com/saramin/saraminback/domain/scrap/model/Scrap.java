package com.saramin.saraminback.domain.scrap.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "scrap")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Scrap {

	private String expirationTimestamp;
	private CloseType closeType;
	private String postingTimestamp;
	private int active;
	private Company company;
	private String modificationTimestamp;
	private Position position;
	@Id
	private String id;
	private String keyword;
	private Salary salary;
	private String url;
	private String openingTimestamp;

}
