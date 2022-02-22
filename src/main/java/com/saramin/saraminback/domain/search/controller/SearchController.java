package com.saramin.saraminback.domain.search.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saramin.saraminback.domain.search.dto.SearchRequestDto;
import com.saramin.saraminback.domain.search.service.SearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/apis")
@RequiredArgsConstructor
public class SearchController {

	private final SearchService searchService;

	@PostMapping("/search")
	public ResponseEntity<?> search(@RequestBody SearchRequestDto dto) throws ParseException {
		String jsonStr = searchService.searchKeyword(dto);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonStr);
		JSONObject jsonObj = (JSONObject)obj;
		return ResponseEntity.ok(jsonObj);
	}
}
