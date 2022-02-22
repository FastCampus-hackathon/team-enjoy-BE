package com.saramin.saraminback.domain.scrap.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saramin.saraminback.domain.scrap.dto.ScrapAddDto;
import com.saramin.saraminback.domain.scrap.dto.ScrapCompareListDto;
import com.saramin.saraminback.domain.scrap.service.ScrapService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apis/scrap")
public class ScrapController {

	private final ScrapService scrapService;

	@PostMapping("/add")
	public ResponseEntity addScrap(@RequestBody List<ScrapAddDto> scrapAddDto) {
		System.out.println(scrapAddDto);

		scrapService.addScrap(scrapAddDto);

		return ResponseEntity.ok("저장됨");
	}

	@GetMapping("/deploy")
	public ResponseEntity getScrap() {

		List<ScrapAddDto> scraps = scrapService.getScrap();

		return ResponseEntity.ok(scraps);
	}

	@PostMapping("/compare")
	public ResponseEntity getScrapCompare(@RequestBody ScrapCompareListDto scrapCompareListDto) {

		List<ScrapAddDto> scraps = scrapService.getScrapCompare(scrapCompareListDto);

		return ResponseEntity.ok(scraps);
	}

}
