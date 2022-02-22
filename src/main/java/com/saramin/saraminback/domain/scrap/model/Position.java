package com.saramin.saraminback.domain.scrap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Position{
	@JsonProperty("job-type")
	private JobType jobType;
	@JsonProperty("required-education-level")
	private RequiredEducationLevel requiredEducationLevel;
	@JsonProperty("job-code")
	private JobCode jobCode;
	private Industry industry;
	private Location location;
	@JsonProperty("job-mid-code")
	private JobMidCode jobMidCode;
	private String title;
	@JsonProperty("experience-level")
	private ExperienceLevel experienceLevel;

	public JobType getJobType(){
		return jobType;
	}

	public RequiredEducationLevel getRequiredEducationLevel(){
		return requiredEducationLevel;
	}

	public JobCode getJobCode(){
		return jobCode;
	}

	public Industry getIndustry(){
		return industry;
	}

	public Location getLocation(){
		return location;
	}

	public JobMidCode getJobMidCode(){
		return jobMidCode;
	}

	public String getTitle(){
		return title;
	}

	public ExperienceLevel getExperienceLevel(){
		return experienceLevel;
	}
}
