package com.saramin.saraminback.domain.scrap.controller;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import com.saramin.saraminback.TestSupport;
import com.saramin.saraminback.domain.search.service.SearchService;

class ScrapControllerTest extends TestSupport {
	@Autowired
	SearchService searchService;

	@Test
	@Transactional
	void addScrap() throws Exception {
		mockMvc.perform(
				post("/apis/scrap/add")
					.contentType(MediaType.APPLICATION_JSON)
					.content(readJson("json/search/add.json"))

			).andExpect(status().isOk())
			.andDo(
				restDocs.document(
					requestFields(
						fieldWithPath("[0].url").description("채용공고 표준 URL. 공채속보의 경우, 리디렉션이 있을 수 있습니다."),
						fieldWithPath("[0].active").description("공고 진행 여부 1: 진행중, 0: 마감"),
						fieldWithPath("[0].company").description("공고 회사"),
						fieldWithPath("[0].company.detail").description("공고 회사 상세 정보"),
						fieldWithPath("[0].company.detail.href").description("기업정보 페이지 (공개되어 있는 경우)"),
						fieldWithPath("[0].company.detail.name").description("공고 회사 이름"),
						fieldWithPath("[0].position").description("채용 포지션"),
						fieldWithPath("[0].position.title").description("공고 제목"),
						fieldWithPath("[0].position.industry").description("업종"),
						fieldWithPath("[0].position.industry.code").description("업종 코드\n"),
						fieldWithPath("[0].position.industry.name").description("업종명\n"),
						fieldWithPath("[0].position.location").description("지역\n"),
						fieldWithPath("[0].position.location.code").description("지역 코드\n"),
						fieldWithPath("[0].position.location.name").description("지역명"),
						fieldWithPath("[0].position.job-type").description("근무형태"),
						fieldWithPath("[0].position.job-type.code").description("근무형태 코드\n"),
						fieldWithPath("[0].position.job-type.name").description("근무형태 값\n"),
						fieldWithPath("[0].position.job-mid-code").description("상위 직무\n"),
						fieldWithPath("[0].position.job-mid-code.code").description("상위 직무 코드\n"),
						fieldWithPath("[0].position.job-mid-code.name").description("상위 직무명\n"),
						fieldWithPath("[0].position.job-code").description("직무"),
						fieldWithPath("[0].position.job-code.code").description("직종 코드\n"),
						fieldWithPath("[0].position.job-code.name").description("직무명\n"),
						fieldWithPath("[0].position.experience-level").description("경력\n"),
						fieldWithPath("[0].position.experience-level.code").description("경력 코드\n"
							+ "1 : 신입\n"
							+ "2 : 경력\n"
							+ "3 : 신입/경력\n"
							+ "0 : 경력무관"),
						fieldWithPath("[0].position.experience-level.min").description("경력 최소 값\n"),
						fieldWithPath("[0].position.experience-level.max").description("경력 최대 값\n"),
						fieldWithPath("[0].position.experience-level.name").description("경력 값\n"),
						fieldWithPath("[0].position.required-education-level").description("학력"),
						fieldWithPath("[0].position.required-education-level.code").description("학력 코드\n"),
						fieldWithPath("[0].position.required-education-level.name").description("학력 값\n"),
						fieldWithPath("[0].keyword").description("키워드\n"),
						fieldWithPath("[0].salary").description("연봉"),
						fieldWithPath("[0].salary.code").description("연봉 코드\n"),
						fieldWithPath("[0].salary.name").description("연봉 값\n"),
						fieldWithPath("[0].id").description("공고 번호\n"),
						fieldWithPath("[0].posting-timestamp").description("게시일의 Unix timestamp\n"),
						fieldWithPath("[0].modification-timestamp").description("수정일 Unix timestamp\n"),
						fieldWithPath("[0].opening-timestamp").description("접수 시작일의 Unix timestamp\n"),
						fieldWithPath("[0].expiration-timestamp").description("마감일의 Unix timestamp\n"),
						fieldWithPath("[0].close-type").description("마감일 형식"),
						fieldWithPath("[0].close-type.code").description("마감일 코드\n"
							+ "1 : 접수 마감일\n"
							+ "2 : 채용시\n"
							+ "3 : 상시\n"
							+ "4 : 수시"),
						fieldWithPath("[0].close-type.name").description("마감일 값\n"))
					));
	}

	@Test
	void getScrap() throws Exception {
		mockMvc.perform(
				get("/apis/scrap/deploy")
					.contentType(MediaType.APPLICATION_JSON)
			).andExpect(status().isOk())
			.andDo(restDocs.document(
				responseFields(
					fieldWithPath("[0].url").description("채용공고 표준 URL. 공채속보의 경우, 리디렉션이 있을 수 있습니다."),
					fieldWithPath("[0].active").description("공고 진행 여부 1: 진행중, 0: 마감"),
					fieldWithPath("[0].company").description("공고 회사"),
					fieldWithPath("[0].company.detail").description("공고 회사 상세 정보"),
					fieldWithPath("[0].company.detail.href").description("기업정보 페이지 (공개되어 있는 경우)"),
					fieldWithPath("[0].company.detail.name").description("공고 회사 이름"),
					fieldWithPath("[0].position").description("채용 포지션"),
					fieldWithPath("[0].position.title").description("공고 제목"),
					fieldWithPath("[0].position.industry").description("업종"),
					fieldWithPath("[0].position.industry.code").description("업종 코드\n"),
					fieldWithPath("[0].position.industry.name").description("업종명\n"),
					fieldWithPath("[0].position.location").description("지역\n"),
					fieldWithPath("[0].position.location.code").description("지역 코드\n"),
					fieldWithPath("[0].position.location.name").description("지역명"),
					fieldWithPath("[0].position.job-type").description("근무형태"),
					fieldWithPath("[0].position.job-type.code").description("근무형태 코드\n"),
					fieldWithPath("[0].position.job-type.name").description("근무형태 값\n"),
					fieldWithPath("[0].position.job-mid-code").description("상위 직무\n"),
					fieldWithPath("[0].position.job-mid-code.code").description("상위 직무 코드\n"),
					fieldWithPath("[0].position.job-mid-code.name").description("상위 직무명\n"),
					fieldWithPath("[0].position.job-code").description("직무"),
					fieldWithPath("[0].position.job-code.code").description("직종 코드\n"),
					fieldWithPath("[0].position.job-code.name").description("직무명\n"),
					fieldWithPath("[0].position.experience-level").description("경력\n"),
					fieldWithPath("[0].position.experience-level.code").description("경력 코드\n"
						+ "1 : 신입\n"
						+ "2 : 경력\n"
						+ "3 : 신입/경력\n"
						+ "0 : 경력무관"),
					fieldWithPath("[0].position.experience-level.min").description("경력 최소 값\n"),
					fieldWithPath("[0].position.experience-level.max").description("경력 최대 값\n"),
					fieldWithPath("[0].position.experience-level.name").description("경력 값\n"),
					fieldWithPath("[0].position.required-education-level").description("학력"),
					fieldWithPath("[0].position.required-education-level.code").description("학력 코드\n"),
					fieldWithPath("[0].position.required-education-level.name").description("학력 값\n"),
					fieldWithPath("[0].keyword").description("키워드\n"),
					fieldWithPath("[0].salary").description("연봉"),
					fieldWithPath("[0].salary.code").description("연봉 코드\n"),
					fieldWithPath("[0].salary.name").description("연봉 값\n"),
					fieldWithPath("[0].id").description("공고 번호\n"),
					fieldWithPath("[0].posting-timestamp").description("게시일의 Unix timestamp\n"),
					fieldWithPath("[0].modification-timestamp").description("수정일 Unix timestamp\n"),
					fieldWithPath("[0].opening-timestamp").description("접수 시작일의 Unix timestamp\n"),
					fieldWithPath("[0].expiration-timestamp").description("마감일의 Unix timestamp\n"),
					fieldWithPath("[0].close-type").description("마감일 형식"),
					fieldWithPath("[0].close-type.code").description("마감일 코드\n"
						+ "1 : 접수 마감일\n"
						+ "2 : 채용시\n"
						+ "3 : 상시\n"
						+ "4 : 수시"),
					fieldWithPath("[0].close-type.name").description("마감일 값\n"))
			));
	}


	@Test
	void getScrapCompare() throws Exception {
		mockMvc.perform(
				post("/apis/scrap/compare")
					.contentType(MediaType.APPLICATION_JSON)
					.content(readJson("json/search/compare.json"))
			).andExpect(status().isOk())
			.andDo(restDocs.document(
				responseFields(
					fieldWithPath("[0].url").description("채용공고 표준 URL. 공채속보의 경우, 리디렉션이 있을 수 있습니다."),
					fieldWithPath("[0].active").description("공고 진행 여부 1: 진행중, 0: 마감"),
					fieldWithPath("[0].company").description("공고 회사"),
					fieldWithPath("[0].company.detail").description("공고 회사 상세 정보"),
					fieldWithPath("[0].company.detail.href").description("기업정보 페이지 (공개되어 있는 경우)"),
					fieldWithPath("[0].company.detail.name").description("공고 회사 이름"),
					fieldWithPath("[0].position").description("채용 포지션"),
					fieldWithPath("[0].position.title").description("공고 제목"),
					fieldWithPath("[0].position.industry").description("업종"),
					fieldWithPath("[0].position.industry.code").description("업종 코드\n"),
					fieldWithPath("[0].position.industry.name").description("업종명\n"),
					fieldWithPath("[0].position.location").description("지역\n"),
					fieldWithPath("[0].position.location.code").description("지역 코드\n"),
					fieldWithPath("[0].position.location.name").description("지역명"),
					fieldWithPath("[0].position.job-type").description("근무형태"),
					fieldWithPath("[0].position.job-type.code").description("근무형태 코드\n"),
					fieldWithPath("[0].position.job-type.name").description("근무형태 값\n"),
					fieldWithPath("[0].position.job-mid-code").description("상위 직무\n"),
					fieldWithPath("[0].position.job-mid-code.code").description("상위 직무 코드\n"),
					fieldWithPath("[0].position.job-mid-code.name").description("상위 직무명\n"),
					fieldWithPath("[0].position.job-code").description("직무"),
					fieldWithPath("[0].position.job-code.code").description("직종 코드\n"),
					fieldWithPath("[0].position.job-code.name").description("직무명\n"),
					fieldWithPath("[0].position.experience-level").description("경력\n"),
					fieldWithPath("[0].position.experience-level.code").description("경력 코드\n"
						+ "1 : 신입\n"
						+ "2 : 경력\n"
						+ "3 : 신입/경력\n"
						+ "0 : 경력무관"),
					fieldWithPath("[0].position.experience-level.min").description("경력 최소 값\n"),
					fieldWithPath("[0].position.experience-level.max").description("경력 최대 값\n"),
					fieldWithPath("[0].position.experience-level.name").description("경력 값\n"),
					fieldWithPath("[0].position.required-education-level").description("학력"),
					fieldWithPath("[0].position.required-education-level.code").description("학력 코드\n"),
					fieldWithPath("[0].position.required-education-level.name").description("학력 값\n"),
					fieldWithPath("[0].keyword").description("키워드\n"),
					fieldWithPath("[0].salary").description("연봉"),
					fieldWithPath("[0].salary.code").description("연봉 코드\n"),
					fieldWithPath("[0].salary.name").description("연봉 값\n"),
					fieldWithPath("[0].id").description("공고 번호\n"),
					fieldWithPath("[0].posting-timestamp").description("게시일의 Unix timestamp\n"),
					fieldWithPath("[0].modification-timestamp").description("수정일 Unix timestamp\n"),
					fieldWithPath("[0].opening-timestamp").description("접수 시작일의 Unix timestamp\n"),
					fieldWithPath("[0].expiration-timestamp").description("마감일의 Unix timestamp\n"),
					fieldWithPath("[0].close-type").description("마감일 형식"),
					fieldWithPath("[0].close-type.code").description("마감일 코드\n"
						+ "1 : 접수 마감일\n"
						+ "2 : 채용시\n"
						+ "3 : 상시\n"
						+ "4 : 수시"),
					fieldWithPath("[0].close-type.name").description("마감일 값\n"))
			));
	}

	@Test
	void getExperience() throws Exception {
		mockMvc.perform(
			get("/apis/scrap/experience")
				.contentType(MediaType.APPLICATION_JSON)
		)
			.andExpect(status().isOk())
			.andDo(
				restDocs.document(
					responseFields(
						fieldWithPath("experience").description("경력"),
						fieldWithPath("new_experience").description("신입"),
						fieldWithPath("both_experience").description("신입 / 경력"),
						fieldWithPath("any_experience").description("경력 무관"),
						fieldWithPath("experience[0].url").description("채용공고 표준 URL. 공채속보의 경우, 리디렉션이 있을 수 있습니다."),
						fieldWithPath("experience[0].active").description("공고 진행 여부 1: 진행중, 0: 마감"),
						fieldWithPath("experience[0].company").description("공고 회사"),
						fieldWithPath("experience[0].company.detail").description("공고 회사 상세 정보"),
						fieldWithPath("experience[0].company.detail.href").description("기업정보 페이지 (공개되어 있는 경우)"),
						fieldWithPath("experience[0].company.detail.name").description("공고 회사 이름"),
						fieldWithPath("experience[0].position").description("채용 포지션"),
						fieldWithPath("experience[0].position.title").description("공고 제목"),
						fieldWithPath("experience[0].position.industry").description("업종"),
						fieldWithPath("experience[0].position.industry.code").description("업종 코드\n"),
						fieldWithPath("experience[0].position.industry.name").description("업종명\n"),
						fieldWithPath("experience[0].position.location").description("지역\n"),
						fieldWithPath("experience[0].position.location.code").description("지역 코드\n"),
						fieldWithPath("experience[0].position.location.name").description("지역명"),
						fieldWithPath("experience[0].position.job-type").description("근무형태"),
						fieldWithPath("experience[0].position.job-type.code").description("근무형태 코드\n"),
						fieldWithPath("experience[0].position.job-type.name").description("근무형태 값\n"),
						fieldWithPath("experience[0].position.job-mid-code").description("상위 직무\n"),
						fieldWithPath("experience[0].position.job-mid-code.code").description("상위 직무 코드\n"),
						fieldWithPath("experience[0].position.job-mid-code.name").description("상위 직무명\n"),
						fieldWithPath("experience[0].position.job-code").description("직무"),
						fieldWithPath("experience[0].position.job-code.code").description("직종 코드\n"),
						fieldWithPath("experience[0].position.job-code.name").description("직무명\n"),
						fieldWithPath("experience[0].position.experience-level").description("경력\n"),
						fieldWithPath("experience[0].position.experience-level.code").description("경력 코드\n"
							+ "1 : 신입\n"
							+ "2 : 경력\n"
							+ "3 : 신입/경력\n"
							+ "0 : 경력무관"),
						fieldWithPath("experience[0].position.experience-level.min").description("경력 최소 값\n"),
						fieldWithPath("experience[0].position.experience-level.max").description("경력 최대 값\n"),
						fieldWithPath("experience[0].position.experience-level.name").description("경력 값\n"),
						fieldWithPath("experience[0].position.required-education-level").description("학력"),
						fieldWithPath("experience[0].position.required-education-level.code").description("학력 코드\n"),
						fieldWithPath("experience[0].position.required-education-level.name").description("학력 값\n"),
						fieldWithPath("experience[0].keyword").description("키워드\n"),
						fieldWithPath("experience[0].salary").description("연봉"),
						fieldWithPath("experience[0].salary.code").description("연봉 코드\n"),
						fieldWithPath("experience[0].salary.name").description("연봉 값\n"),
						fieldWithPath("experience[0].id").description("공고 번호\n"),
						fieldWithPath("experience[0].posting-timestamp").description("게시일의 Unix timestamp\n"),
						fieldWithPath("experience[0].modification-timestamp").description("수정일 Unix timestamp\n"),
						fieldWithPath("experience[0].opening-timestamp").description("접수 시작일의 Unix timestamp\n"),
						fieldWithPath("experience[0].expiration-timestamp").description("마감일의 Unix timestamp\n"),
						fieldWithPath("experience[0].close-type").description("마감일 형식"),
						fieldWithPath("experience[0].close-type.code").description("마감일 코드\n"
							+ "1 : 접수 마감일\n"
							+ "2 : 채용시\n"
							+ "3 : 상시\n"
							+ "4 : 수시"),
						fieldWithPath("experience[0].close-type.name").description("마감일 값\n"),

						fieldWithPath("new_experience[0].url").description("채용공고 표준 URL. 공채속보의 경우, 리디렉션이 있을 수 있습니다."),
						fieldWithPath("new_experience[0].active").description("공고 진행 여부 1: 진행중, 0: 마감"),
						fieldWithPath("new_experience[0].company").description("공고 회사"),
						fieldWithPath("new_experience[0].company.detail").description("공고 회사 상세 정보"),
						fieldWithPath("new_experience[0].company.detail.href").description("기업정보 페이지 (공개되어 있는 경우)"),
						fieldWithPath("new_experience[0].company.detail.name").description("공고 회사 이름"),
						fieldWithPath("new_experience[0].position").description("채용 포지션"),
						fieldWithPath("new_experience[0].position.title").description("공고 제목"),
						fieldWithPath("new_experience[0].position.industry").description("업종"),
						fieldWithPath("new_experience[0].position.industry.code").description("업종 코드\n"),
						fieldWithPath("new_experience[0].position.industry.name").description("업종명\n"),
						fieldWithPath("new_experience[0].position.location").description("지역\n"),
						fieldWithPath("new_experience[0].position.location.code").description("지역 코드\n"),
						fieldWithPath("new_experience[0].position.location.name").description("지역명"),
						fieldWithPath("new_experience[0].position.job-type").description("근무형태"),
						fieldWithPath("new_experience[0].position.job-type.code").description("근무형태 코드\n"),
						fieldWithPath("new_experience[0].position.job-type.name").description("근무형태 값\n"),
						fieldWithPath("new_experience[0].position.job-mid-code").description("상위 직무\n"),
						fieldWithPath("new_experience[0].position.job-mid-code.code").description("상위 직무 코드\n"),
						fieldWithPath("new_experience[0].position.job-mid-code.name").description("상위 직무명\n"),
						fieldWithPath("new_experience[0].position.job-code").description("직무"),
						fieldWithPath("new_experience[0].position.job-code.code").description("직종 코드\n"),
						fieldWithPath("new_experience[0].position.job-code.name").description("직무명\n"),
						fieldWithPath("new_experience[0].position.experience-level").description("경력\n"),
						fieldWithPath("new_experience[0].position.experience-level.code").description("경력 코드\n"
							+ "1 : 신입\n"
							+ "2 : 경력\n"
							+ "3 : 신입/경력\n"
							+ "0 : 경력무관"),
						fieldWithPath("new_experience[0].position.experience-level.min").description("경력 최소 값\n"),
						fieldWithPath("new_experience[0].position.experience-level.max").description("경력 최대 값\n"),
						fieldWithPath("new_experience[0].position.experience-level.name").description("경력 값\n"),
						fieldWithPath("new_experience[0].position.required-education-level").description("학력"),
						fieldWithPath("new_experience[0].position.required-education-level.code").description(
							"학력 코드\n"),
						fieldWithPath("new_experience[0].position.required-education-level.name").description("학력 값\n"),
						fieldWithPath("new_experience[0].keyword").description("키워드\n"),
						fieldWithPath("new_experience[0].salary").description("연봉"),
						fieldWithPath("new_experience[0].salary.code").description("연봉 코드\n"),
						fieldWithPath("new_experience[0].salary.name").description("연봉 값\n"),
						fieldWithPath("new_experience[0].id").description("공고 번호\n"),
						fieldWithPath("new_experience[0].posting-timestamp").description("게시일의 Unix timestamp\n"),
						fieldWithPath("new_experience[0].modification-timestamp").description("수정일 Unix timestamp\n"),
						fieldWithPath("new_experience[0].opening-timestamp").description("접수 시작일의 Unix timestamp\n"),
						fieldWithPath("new_experience[0].expiration-timestamp").description("마감일의 Unix timestamp\n"),
						fieldWithPath("new_experience[0].close-type").description("마감일 형식"),
						fieldWithPath("new_experience[0].close-type.code").description("마감일 코드\n"
							+ "1 : 접수 마감일\n"
							+ "2 : 채용시\n"
							+ "3 : 상시\n"
							+ "4 : 수시"),
						fieldWithPath("new_experience[0].close-type.name").description("마감일 값\n"),

						fieldWithPath("both_experience[0].url").description("채용공고 표준 URL. 공채속보의 경우, 리디렉션이 있을 수 있습니다."),
						fieldWithPath("both_experience[0].active").description("공고 진행 여부 1: 진행중, 0: 마감"),
						fieldWithPath("both_experience[0].company").description("공고 회사"),
						fieldWithPath("both_experience[0].company.detail").description("공고 회사 상세 정보"),
						fieldWithPath("both_experience[0].company.detail.href").description("기업정보 페이지 (공개되어 있는 경우)"),
						fieldWithPath("both_experience[0].company.detail.name").description("공고 회사 이름"),
						fieldWithPath("both_experience[0].position").description("채용 포지션"),
						fieldWithPath("both_experience[0].position.title").description("공고 제목"),
						fieldWithPath("both_experience[0].position.industry").description("업종"),
						fieldWithPath("both_experience[0].position.industry.code").description("업종 코드\n"),
						fieldWithPath("both_experience[0].position.industry.name").description("업종명\n"),
						fieldWithPath("both_experience[0].position.location").description("지역\n"),
						fieldWithPath("both_experience[0].position.location.code").description("지역 코드\n"),
						fieldWithPath("both_experience[0].position.location.name").description("지역명"),
						fieldWithPath("both_experience[0].position.job-type").description("근무형태"),
						fieldWithPath("both_experience[0].position.job-type.code").description("근무형태 코드\n"),
						fieldWithPath("both_experience[0].position.job-type.name").description("근무형태 값\n"),
						fieldWithPath("both_experience[0].position.job-mid-code").description("상위 직무\n"),
						fieldWithPath("both_experience[0].position.job-mid-code.code").description("상위 직무 코드\n"),
						fieldWithPath("both_experience[0].position.job-mid-code.name").description("상위 직무명\n"),
						fieldWithPath("both_experience[0].position.job-code").description("직무"),
						fieldWithPath("both_experience[0].position.job-code.code").description("직종 코드\n"),
						fieldWithPath("both_experience[0].position.job-code.name").description("직무명\n"),
						fieldWithPath("both_experience[0].position.experience-level").description("경력\n"),
						fieldWithPath("both_experience[0].position.experience-level.code").description("경력 코드\n"
							+ "1 : 신입\n"
							+ "2 : 경력\n"
							+ "3 : 신입/경력\n"
							+ "0 : 경력무관"),
						fieldWithPath("both_experience[0].position.experience-level.min").description("경력 최소 값\n"),
						fieldWithPath("both_experience[0].position.experience-level.max").description("경력 최대 값\n"),
						fieldWithPath("both_experience[0].position.experience-level.name").description("경력 값\n"),
						fieldWithPath("both_experience[0].position.required-education-level").description("학력"),
						fieldWithPath("both_experience[0].position.required-education-level.code").description("학력 코드\n"),
						fieldWithPath("both_experience[0].position.required-education-level.name").description("학력 값\n"),
						fieldWithPath("both_experience[0].keyword").description("키워드\n"),
						fieldWithPath("both_experience[0].salary").description("연봉"),
						fieldWithPath("both_experience[0].salary.code").description("연봉 코드\n"),
						fieldWithPath("both_experience[0].salary.name").description("연봉 값\n"),
						fieldWithPath("both_experience[0].id").description("공고 번호\n"),
						fieldWithPath("both_experience[0].posting-timestamp").description("게시일의 Unix timestamp\n"),
						fieldWithPath("both_experience[0].modification-timestamp").description("수정일 Unix timestamp\n"),
						fieldWithPath("both_experience[0].opening-timestamp").description("접수 시작일의 Unix timestamp\n"),
						fieldWithPath("both_experience[0].expiration-timestamp").description("마감일의 Unix timestamp\n"),
						fieldWithPath("both_experience[0].close-type").description("마감일 형식"),
						fieldWithPath("both_experience[0].close-type.code").description("마감일 코드\n"
							+ "1 : 접수 마감일\n"
							+ "2 : 채용시\n"
							+ "3 : 상시\n"
							+ "4 : 수시"),
						fieldWithPath("both_experience[0].close-type.name").description("마감일 값\n"),

						fieldWithPath("any_experience[0].url").description("채용공고 표준 URL. 공채속보의 경우, 리디렉션이 있을 수 있습니다."),
						fieldWithPath("any_experience[0].active").description("공고 진행 여부 1: 진행중, 0: 마감"),
						fieldWithPath("any_experience[0].company").description("공고 회사"),
						fieldWithPath("any_experience[0].company.detail").description("공고 회사 상세 정보"),
						fieldWithPath("any_experience[0].company.detail.href").description("기업정보 페이지 (공개되어 있는 경우)"),
						fieldWithPath("any_experience[0].company.detail.name").description("공고 회사 이름"),
						fieldWithPath("any_experience[0].position").description("채용 포지션"),
						fieldWithPath("any_experience[0].position.title").description("공고 제목"),
						fieldWithPath("any_experience[0].position.industry").description("업종"),
						fieldWithPath("any_experience[0].position.industry.code").description("업종 코드\n"),
						fieldWithPath("any_experience[0].position.industry.name").description("업종명\n"),
						fieldWithPath("any_experience[0].position.location").description("지역\n"),
						fieldWithPath("any_experience[0].position.location.code").description("지역 코드\n"),
						fieldWithPath("any_experience[0].position.location.name").description("지역명"),
						fieldWithPath("any_experience[0].position.job-type").description("근무형태"),
						fieldWithPath("any_experience[0].position.job-type.code").description("근무형태 코드\n"),
						fieldWithPath("any_experience[0].position.job-type.name").description("근무형태 값\n"),
						fieldWithPath("any_experience[0].position.job-mid-code").description("상위 직무\n"),
						fieldWithPath("any_experience[0].position.job-mid-code.code").description("상위 직무 코드\n"),
						fieldWithPath("any_experience[0].position.job-mid-code.name").description("상위 직무명\n"),
						fieldWithPath("any_experience[0].position.job-code").description("직무"),
						fieldWithPath("any_experience[0].position.job-code.code").description("직종 코드\n"),
						fieldWithPath("any_experience[0].position.job-code.name").description("직무명\n"),
						fieldWithPath("any_experience[0].position.experience-level").description("경력\n"),
						fieldWithPath("any_experience[0].position.experience-level.code").description("경력 코드\n"
							+ "1 : 신입\n"
							+ "2 : 경력\n"
							+ "3 : 신입/경력\n"
							+ "0 : 경력무관"),
						fieldWithPath("any_experience[0].position.experience-level.min").description("경력 최소 값\n"),
						fieldWithPath("any_experience[0].position.experience-level.max").description("경력 최대 값\n"),
						fieldWithPath("any_experience[0].position.experience-level.name").description("경력 값\n"),
						fieldWithPath("any_experience[0].position.required-education-level").description("학력"),
						fieldWithPath("any_experience[0].position.required-education-level.code").description(
							"학력 코드\n"),
						fieldWithPath("any_experience[0].position.required-education-level.name").description("학력 값\n"),
						fieldWithPath("any_experience[0].keyword").description("키워드\n"),
						fieldWithPath("any_experience[0].salary").description("연봉"),
						fieldWithPath("any_experience[0].salary.code").description("연봉 코드\n"),
						fieldWithPath("any_experience[0].salary.name").description("연봉 값\n"),
						fieldWithPath("any_experience[0].id").description("공고 번호\n"),
						fieldWithPath("any_experience[0].posting-timestamp").description("게시일의 Unix timestamp\n"),
						fieldWithPath("any_experience[0].modification-timestamp").description("수정일 Unix timestamp\n"),
						fieldWithPath("any_experience[0].opening-timestamp").description("접수 시작일의 Unix timestamp\n"),
						fieldWithPath("any_experience[0].expiration-timestamp").description("마감일의 Unix timestamp\n"),
						fieldWithPath("any_experience[0].close-type").description("마감일 형식"),
						fieldWithPath("any_experience[0].close-type.code").description("마감일 코드\n"
							+ "1 : 접수 마감일\n"
							+ "2 : 채용시\n"
							+ "3 : 상시\n"
							+ "4 : 수시"),
						fieldWithPath("any_experience[0].close-type.name").description("마감일 값\n")
					)

				)
			)
		;
	}

	@Test
	void getEducationLevel() throws Exception {
		mockMvc.perform(
			get("/apis/scrap/education")
				.contentType(MediaType.APPLICATION_JSON)
		)
			.andExpect(status().isOk())
			.andDo(
				restDocs.document(
					responseFields(
						fieldWithPath("any").description("경력무관"),
						fieldWithPath("highschool").description("고등학교"),
						fieldWithPath("univ").description("대학졸업(2,3년)이상"),
						fieldWithPath("univ-4year").description("대학교졸업(4년)이상"),

						fieldWithPath("any[0].url").description("채용공고 표준 URL. 공채속보의 경우, 리디렉션이 있을 수 있습니다."),
						fieldWithPath("any[0].active").description("공고 진행 여부 1: 진행중, 0: 마감"),
						fieldWithPath("any[0].company").description("공고 회사"),
						fieldWithPath("any[0].company.detail").description("공고 회사 상세 정보"),
						fieldWithPath("any[0].company.detail.href").description("기업정보 페이지 (공개되어 있는 경우)"),
						fieldWithPath("any[0].company.detail.name").description("공고 회사 이름"),
						fieldWithPath("any[0].position").description("채용 포지션"),
						fieldWithPath("any[0].position.title").description("공고 제목"),
						fieldWithPath("any[0].position.industry").description("업종"),
						fieldWithPath("any[0].position.industry.code").description("업종 코드\n"),
						fieldWithPath("any[0].position.industry.name").description("업종명\n"),
						fieldWithPath("any[0].position.location").description("지역\n"),
						fieldWithPath("any[0].position.location.code").description("지역 코드\n"),
						fieldWithPath("any[0].position.location.name").description("지역명"),
						fieldWithPath("any[0].position.job-type").description("근무형태"),
						fieldWithPath("any[0].position.job-type.code").description("근무형태 코드\n"),
						fieldWithPath("any[0].position.job-type.name").description("근무형태 값\n"),
						fieldWithPath("any[0].position.job-mid-code").description("상위 직무\n"),
						fieldWithPath("any[0].position.job-mid-code.code").description("상위 직무 코드\n"),
						fieldWithPath("any[0].position.job-mid-code.name").description("상위 직무명\n"),
						fieldWithPath("any[0].position.job-code").description("직무"),
						fieldWithPath("any[0].position.job-code.code").description("직종 코드\n"),
						fieldWithPath("any[0].position.job-code.name").description("직무명\n"),
						fieldWithPath("any[0].position.experience-level").description("경력\n"),
						fieldWithPath("any[0].position.experience-level.code").description("경력 코드\n"
							+ "1 : 신입\n"
							+ "2 : 경력\n"
							+ "3 : 신입/경력\n"
							+ "0 : 경력무관"),
						fieldWithPath("any[0].position.experience-level.min").description("경력 최소 값\n"),
						fieldWithPath("any[0].position.experience-level.max").description("경력 최대 값\n"),
						fieldWithPath("any[0].position.experience-level.name").description("경력 값\n"),
						fieldWithPath("any[0].position.required-education-level").description("학력"),
						fieldWithPath("any[0].position.required-education-level.code").description("학력 코드\n"),
						fieldWithPath("any[0].position.required-education-level.name").description("학력 값\n"),
						fieldWithPath("any[0].keyword").description("키워드\n"),
						fieldWithPath("any[0].salary").description("연봉"),
						fieldWithPath("any[0].salary.code").description("연봉 코드\n"),
						fieldWithPath("any[0].salary.name").description("연봉 값\n"),
						fieldWithPath("any[0].id").description("공고 번호\n"),
						fieldWithPath("any[0].posting-timestamp").description("게시일의 Unix timestamp\n"),
						fieldWithPath("any[0].modification-timestamp").description("수정일 Unix timestamp\n"),
						fieldWithPath("any[0].opening-timestamp").description("접수 시작일의 Unix timestamp\n"),
						fieldWithPath("any[0].expiration-timestamp").description("마감일의 Unix timestamp\n"),
						fieldWithPath("any[0].close-type").description("마감일 형식"),
						fieldWithPath("any[0].close-type.code").description("마감일 코드\n"
							+ "1 : 접수 마감일\n"
							+ "2 : 채용시\n"
							+ "3 : 상시\n"
							+ "4 : 수시"),
						fieldWithPath("any[0].close-type.name").description("마감일 값\n"),

						fieldWithPath("highschool[0].url").description("채용공고 표준 URL. 공채속보의 경우, 리디렉션이 있을 수 있습니다."),
						fieldWithPath("highschool[0].active").description("공고 진행 여부 1: 진행중, 0: 마감"),
						fieldWithPath("highschool[0].company").description("공고 회사"),
						fieldWithPath("highschool[0].company.detail").description("공고 회사 상세 정보"),
						fieldWithPath("highschool[0].company.detail.href").description("기업정보 페이지 (공개되어 있는 경우)"),
						fieldWithPath("highschool[0].company.detail.name").description("공고 회사 이름"),
						fieldWithPath("highschool[0].position").description("채용 포지션"),
						fieldWithPath("highschool[0].position.title").description("공고 제목"),
						fieldWithPath("highschool[0].position.industry").description("업종"),
						fieldWithPath("highschool[0].position.industry.code").description("업종 코드\n"),
						fieldWithPath("highschool[0].position.industry.name").description("업종명\n"),
						fieldWithPath("highschool[0].position.location").description("지역\n"),
						fieldWithPath("highschool[0].position.location.code").description("지역 코드\n"),
						fieldWithPath("highschool[0].position.location.name").description("지역명"),
						fieldWithPath("highschool[0].position.job-type").description("근무형태"),
						fieldWithPath("highschool[0].position.job-type.code").description("근무형태 코드\n"),
						fieldWithPath("highschool[0].position.job-type.name").description("근무형태 값\n"),
						fieldWithPath("highschool[0].position.job-mid-code").description("상위 직무\n"),
						fieldWithPath("highschool[0].position.job-mid-code.code").description("상위 직무 코드\n"),
						fieldWithPath("highschool[0].position.job-mid-code.name").description("상위 직무명\n"),
						fieldWithPath("highschool[0].position.job-code").description("직무"),
						fieldWithPath("highschool[0].position.job-code.code").description("직종 코드\n"),
						fieldWithPath("highschool[0].position.job-code.name").description("직무명\n"),
						fieldWithPath("highschool[0].position.experience-level").description("경력\n"),
						fieldWithPath("highschool[0].position.experience-level.code").description("경력 코드\n"
							+ "1 : 신입\n"
							+ "2 : 경력\n"
							+ "3 : 신입/경력\n"
							+ "0 : 경력무관"),
						fieldWithPath("highschool[0].position.experience-level.min").description("경력 최소 값\n"),
						fieldWithPath("highschool[0].position.experience-level.max").description("경력 최대 값\n"),
						fieldWithPath("highschool[0].position.experience-level.name").description("경력 값\n"),
						fieldWithPath("highschool[0].position.required-education-level").description("학력"),
						fieldWithPath("highschool[0].position.required-education-level.code").description("학력 코드\n"),
						fieldWithPath("highschool[0].position.required-education-level.name").description("학력 값\n"),
						fieldWithPath("highschool[0].keyword").description("키워드\n"),
						fieldWithPath("highschool[0].salary").description("연봉"),
						fieldWithPath("highschool[0].salary.code").description("연봉 코드\n"),
						fieldWithPath("highschool[0].salary.name").description("연봉 값\n"),
						fieldWithPath("highschool[0].id").description("공고 번호\n"),
						fieldWithPath("highschool[0].posting-timestamp").description("게시일의 Unix timestamp\n"),
						fieldWithPath("highschool[0].modification-timestamp").description("수정일 Unix timestamp\n"),
						fieldWithPath("highschool[0].opening-timestamp").description("접수 시작일의 Unix timestamp\n"),
						fieldWithPath("highschool[0].expiration-timestamp").description("마감일의 Unix timestamp\n"),
						fieldWithPath("highschool[0].close-type").description("마감일 형식"),
						fieldWithPath("highschool[0].close-type.code").description("마감일 코드\n"
							+ "1 : 접수 마감일\n"
							+ "2 : 채용시\n"
							+ "3 : 상시\n"
							+ "4 : 수시"),
						fieldWithPath("highschool[0].close-type.name").description("마감일 값\n"),

						fieldWithPath("univ[0].url").description("채용공고 표준 URL. 공채속보의 경우, 리디렉션이 있을 수 있습니다."),
						fieldWithPath("univ[0].active").description("공고 진행 여부 1: 진행중, 0: 마감"),
						fieldWithPath("univ[0].company").description("공고 회사"),
						fieldWithPath("univ[0].company.detail").description("공고 회사 상세 정보"),
						fieldWithPath("univ[0].company.detail.href").description("기업정보 페이지 (공개되어 있는 경우)"),
						fieldWithPath("univ[0].company.detail.name").description("공고 회사 이름"),
						fieldWithPath("univ[0].position").description("채용 포지션"),
						fieldWithPath("univ[0].position.title").description("공고 제목"),
						fieldWithPath("univ[0].position.industry").description("업종"),
						fieldWithPath("univ[0].position.industry.code").description("업종 코드\n"),
						fieldWithPath("univ[0].position.industry.name").description("업종명\n"),
						fieldWithPath("univ[0].position.location").description("지역\n"),
						fieldWithPath("univ[0].position.location.code").description("지역 코드\n"),
						fieldWithPath("univ[0].position.location.name").description("지역명"),
						fieldWithPath("univ[0].position.job-type").description("근무형태"),
						fieldWithPath("univ[0].position.job-type.code").description("근무형태 코드\n"),
						fieldWithPath("univ[0].position.job-type.name").description("근무형태 값\n"),
						fieldWithPath("univ[0].position.job-mid-code").description("상위 직무\n"),
						fieldWithPath("univ[0].position.job-mid-code.code").description("상위 직무 코드\n"),
						fieldWithPath("univ[0].position.job-mid-code.name").description("상위 직무명\n"),
						fieldWithPath("univ[0].position.job-code").description("직무"),
						fieldWithPath("univ[0].position.job-code.code").description("직종 코드\n"),
						fieldWithPath("univ[0].position.job-code.name").description("직무명\n"),
						fieldWithPath("univ[0].position.experience-level").description("경력\n"),
						fieldWithPath("univ[0].position.experience-level.code").description("경력 코드\n"
							+ "1 : 신입\n"
							+ "2 : 경력\n"
							+ "3 : 신입/경력\n"
							+ "0 : 경력무관"),
						fieldWithPath("univ[0].position.experience-level.min").description("경력 최소 값\n"),
						fieldWithPath("univ[0].position.experience-level.max").description("경력 최대 값\n"),
						fieldWithPath("univ[0].position.experience-level.name").description("경력 값\n"),
						fieldWithPath("univ[0].position.required-education-level").description("학력"),
						fieldWithPath("univ[0].position.required-education-level.code").description("학력 코드\n"),
						fieldWithPath("univ[0].position.required-education-level.name").description("학력 값\n"),
						fieldWithPath("univ[0].keyword").description("키워드\n"),
						fieldWithPath("univ[0].salary").description("연봉"),
						fieldWithPath("univ[0].salary.code").description("연봉 코드\n"),
						fieldWithPath("univ[0].salary.name").description("연봉 값\n"),
						fieldWithPath("univ[0].id").description("공고 번호\n"),
						fieldWithPath("univ[0].posting-timestamp").description("게시일의 Unix timestamp\n"),
						fieldWithPath("univ[0].modification-timestamp").description("수정일 Unix timestamp\n"),
						fieldWithPath("univ[0].opening-timestamp").description("접수 시작일의 Unix timestamp\n"),
						fieldWithPath("univ[0].expiration-timestamp").description("마감일의 Unix timestamp\n"),
						fieldWithPath("univ[0].close-type").description("마감일 형식"),
						fieldWithPath("univ[0].close-type.code").description("마감일 코드\n"
							+ "1 : 접수 마감일\n"
							+ "2 : 채용시\n"
							+ "3 : 상시\n"
							+ "4 : 수시"),
						fieldWithPath("univ[0].close-type.name").description("마감일 값\n"),

						fieldWithPath("univ-4year[0].url").description("채용공고 표준 URL. 공채속보의 경우, 리디렉션이 있을 수 있습니다."),
						fieldWithPath("univ-4year[0].active").description("공고 진행 여부 1: 진행중, 0: 마감"),
						fieldWithPath("univ-4year[0].company").description("공고 회사"),
						fieldWithPath("univ-4year[0].company.detail").description("공고 회사 상세 정보"),
						fieldWithPath("univ-4year[0].company.detail.href").description("기업정보 페이지 (공개되어 있는 경우)"),
						fieldWithPath("univ-4year[0].company.detail.name").description("공고 회사 이름"),
						fieldWithPath("univ-4year[0].position").description("채용 포지션"),
						fieldWithPath("univ-4year[0].position.title").description("공고 제목"),
						fieldWithPath("univ-4year[0].position.industry").description("업종"),
						fieldWithPath("univ-4year[0].position.industry.code").description("업종 코드\n"),
						fieldWithPath("univ-4year[0].position.industry.name").description("업종명\n"),
						fieldWithPath("univ-4year[0].position.location").description("지역\n"),
						fieldWithPath("univ-4year[0].position.location.code").description("지역 코드\n"),
						fieldWithPath("univ-4year[0].position.location.name").description("지역명"),
						fieldWithPath("univ-4year[0].position.job-type").description("근무형태"),
						fieldWithPath("univ-4year[0].position.job-type.code").description("근무형태 코드\n"),
						fieldWithPath("univ-4year[0].position.job-type.name").description("근무형태 값\n"),
						fieldWithPath("univ-4year[0].position.job-mid-code").description("상위 직무\n"),
						fieldWithPath("univ-4year[0].position.job-mid-code.code").description("상위 직무 코드\n"),
						fieldWithPath("univ-4year[0].position.job-mid-code.name").description("상위 직무명\n"),
						fieldWithPath("univ-4year[0].position.job-code").description("직무"),
						fieldWithPath("univ-4year[0].position.job-code.code").description("직종 코드\n"),
						fieldWithPath("univ-4year[0].position.job-code.name").description("직무명\n"),
						fieldWithPath("univ-4year[0].position.experience-level").description("경력\n"),
						fieldWithPath("univ-4year[0].position.experience-level.code").description("경력 코드\n"
							+ "1 : 신입\n"
							+ "2 : 경력\n"
							+ "3 : 신입/경력\n"
							+ "0 : 경력무관"),
						fieldWithPath("univ-4year[0].position.experience-level.min").description("경력 최소 값\n"),
						fieldWithPath("univ-4year[0].position.experience-level.max").description("경력 최대 값\n"),
						fieldWithPath("univ-4year[0].position.experience-level.name").description("경력 값\n"),
						fieldWithPath("univ-4year[0].position.required-education-level").description("학력"),
						fieldWithPath("univ-4year[0].position.required-education-level.code").description("학력 코드\n"),
						fieldWithPath("univ-4year[0].position.required-education-level.name").description("학력 값\n"),
						fieldWithPath("univ-4year[0].keyword").description("키워드\n"),
						fieldWithPath("univ-4year[0].salary").description("연봉"),
						fieldWithPath("univ-4year[0].salary.code").description("연봉 코드\n"),
						fieldWithPath("univ-4year[0].salary.name").description("연봉 값\n"),
						fieldWithPath("univ-4year[0].id").description("공고 번호\n"),
						fieldWithPath("univ-4year[0].posting-timestamp").description("게시일의 Unix timestamp\n"),
						fieldWithPath("univ-4year[0].modification-timestamp").description("수정일 Unix timestamp\n"),
						fieldWithPath("univ-4year[0].opening-timestamp").description("접수 시작일의 Unix timestamp\n"),
						fieldWithPath("univ-4year[0].expiration-timestamp").description("마감일의 Unix timestamp\n"),
						fieldWithPath("univ-4year[0].close-type").description("마감일 형식"),
						fieldWithPath("univ-4year[0].close-type.code").description("마감일 코드\n"
							+ "1 : 접수 마감일\n"
							+ "2 : 채용시\n"
							+ "3 : 상시\n"
							+ "4 : 수시"),
						fieldWithPath("univ-4year[0].close-type.name").description("마감일 값\n")

					)
				)
			)
		;

	}
}