package com.saramin.saraminback.domain.search.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.saramin.saraminback.domain.search.dto.SearchRequestDto;

@Service
public class SearchService {
	@Value("${saramin.api.access-key}")
	private String accessKey;

	public String searchKeyword(SearchRequestDto dto) {

		try {
			String text = URLEncoder.encode(dto.getKeyword(), StandardCharsets.UTF_8);
			String apiURL =
				"https://oapi.saramin.co.kr/job-search?access-key=" + accessKey + "&keyword=" + text + "&start="
					+ dto.getStart() + "&job_cd=2";

			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");

			int responseCode = con.getResponseCode();
			BufferedReader br;

			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			return response.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
