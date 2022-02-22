package com.saramin.saraminback.domain.search.controller;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.saramin.saraminback.TestSupport;
import com.saramin.saraminback.domain.search.service.SearchService;

class SearchControllerTest extends TestSupport {

	@Autowired
	SearchService searchService;

	@Test
	void search() throws Exception {
		mockMvc.perform(
			post("/apis/search")
				.contentType(MediaType.APPLICATION_JSON)
				.content(readJson("json/search/search.json"))
		)
			.andExpect(status().isOk())
			.andDo(
				restDocs.document(
					requestFields(
						fieldWithPath("keyword").description("검색 키워드"),
						fieldWithPath("start").description("검색 결과 페이지 (0부터 시작)")
					),
					responseFields(
						fieldWithPath("jobs").description("공고"),
						fieldWithPath("jobs.count").description("job 엘리먼트 개수"),
						fieldWithPath("jobs.start").description("검색 결과의 페이지 번호 (0부터 시작)"),
						fieldWithPath("jobs.total").description("총 검색 결과 수"),
						fieldWithPath("jobs.job").description("채용공고 엘리먼트"),
						fieldWithPath("jobs.job[0].url").description("채용공고 표준 URL. 공채속보의 경우, 리디렉션이 있을 수 있습니다."),
						fieldWithPath("jobs.job[0].active").description("공고 진행 여부 1: 진행중, 0: 마감"),
						fieldWithPath("jobs.job[0].company").description("공고 회사"),
						fieldWithPath("jobs.job[0].company.detail").description("공고 회사 상세 정보"),
						fieldWithPath("jobs.job[0].company.detail.href").description("기업정보 페이지 (공개되어 있는 경우)"),
						fieldWithPath("jobs.job[0].company.detail.name").description("공고 회사 이름"),
						fieldWithPath("jobs.job[0].position").description("채용 포지션"),
						fieldWithPath("jobs.job[0].position.title").description("공고 제목"),
						fieldWithPath("jobs.job[0].position.industry").description("업종"),
						fieldWithPath("jobs.job[0].position.industry.code").description("업종 코드\n"),
						fieldWithPath("jobs.job[0].position.industry.name").description("업종명\n"),
						fieldWithPath("jobs.job[0].position.location").description("지역\n"),
						fieldWithPath("jobs.job[0].position.location.code").description("지역 코드\n"),
						fieldWithPath("jobs.job[0].position.location.name").description("지역명"),
						fieldWithPath("jobs.job[0].position.job-type").description("근무형태"),
						fieldWithPath("jobs.job[0].position.job-type.code").description("근무형태 코드\n"),
						fieldWithPath("jobs.job[0].position.job-type.name").description("근무형태 값\n"),
						fieldWithPath("jobs.job[0].position.job-mid-code").description("상위 직무\n"),
						fieldWithPath("jobs.job[0].position.job-mid-code.code").description("상위 직무 코드\n"),
						fieldWithPath("jobs.job[0].position.job-mid-code.name").description("상위 직무명\n"),
						fieldWithPath("jobs.job[0].position.job-code").description("직무"),
						fieldWithPath("jobs.job[0].position.job-code.code").description("직종 코드\n"),
						fieldWithPath("jobs.job[0].position.job-code.name").description("직무명\n"),
						fieldWithPath("jobs.job[0].position.experience-level").description("경력\n"),
						fieldWithPath("jobs.job[0].position.experience-level.code").description("경력 코드\n"
							+ "1 : 신입\n"
							+ "2 : 경력\n"
							+ "3 : 신입/경력\n"
							+ "0 : 경력무관"),
						fieldWithPath("jobs.job[0].position.experience-level.min").description("경력 최소 값\n"),
						fieldWithPath("jobs.job[0].position.experience-level.max").description("경력 최대 값\n"),
						fieldWithPath("jobs.job[0].position.experience-level.name").description("경력 값\n"),
						fieldWithPath("jobs.job[0].position.required-education-level").description("학력"),
						fieldWithPath("jobs.job[0].position.required-education-level.code").description("학력 코드\n"),
						fieldWithPath("jobs.job[0].position.required-education-level.name").description("학력 값\n"),
						fieldWithPath("jobs.job[0].keyword").description("키워드\n"),
						fieldWithPath("jobs.job[0].salary").description("연봉"),
						fieldWithPath("jobs.job[0].salary.code").description("연봉 코드\n"),
						fieldWithPath("jobs.job[0].salary.name").description("연봉 값\n"),
						fieldWithPath("jobs.job[0].id").description("공고 번호\n"),
						fieldWithPath("jobs.job[0].posting-timestamp").description("게시일의 Unix timestamp\n"),
						fieldWithPath("jobs.job[0].modification-timestamp").description("수정일 Unix timestamp\n"),
						fieldWithPath("jobs.job[0].opening-timestamp").description("접수 시작일의 Unix timestamp\n"),
						fieldWithPath("jobs.job[0].expiration-timestamp").description("마감일의 Unix timestamp\n"),
						fieldWithPath("jobs.job[0].close-type").description("마감일 형식"),
						fieldWithPath("jobs.job[0].close-type.code").description("마감일 코드\n"
							+ "1 : 접수 마감일\n"
							+ "2 : 채용시\n"
							+ "3 : 상시\n"
							+ "4 : 수시"),
						fieldWithPath("jobs.job[0].close-type.name").description("마감일 값\n")
					)
				)
			)
		;
	}
}