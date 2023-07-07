package com.sample.app.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.app.demo.dto.requestDto;

@RestController
@RequestMapping("/app")
public class myController {
	
	
	@Value("${open.ai.key}")
	private String OPENAI_API_KEY;
	
	@GetMapping("/turboModelData")
	public ResponseEntity<String> getData() {
		
	String request = "{\"model\": \"gpt-3.5-turbo\",\"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}, {\"role\": \"user\", \"content\": \"Hello!\"}]}";

	HttpHeaders headers = new HttpHeaders();
	headers.set("Content-Type", "application/json");
	headers.set("Authorization", "Bearer "+ OPENAI_API_KEY);
	
	HttpEntity<String> entity = new HttpEntity<>(request, headers);
	
		
	final String url = "https://api.openai.com/v1/chat/completions";
		

	RestTemplate restTemplate = new RestTemplate();
	
    ResponseEntity<String> result = restTemplate.postForEntity(url, entity, String.class);

	return result;
		
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping(value="/completions", consumes = "application/json", produces ="application/json")
	public String getCompletionResponse(@RequestBody requestDto requestDto) throws JsonMappingException, JsonProcessingException {
	
		
	final String url = "https://api.openai.com/v1/completions";
	
	requestDto.setModel("text-davinci-003");
	requestDto.setMax_tokens(1000);
	
	HttpHeaders headers = new HttpHeaders();
	
	headers.set("Content-Type", "application/json");
	headers.set("Authorization", "Bearer " + OPENAI_API_KEY);
	
	ObjectMapper mapper = new ObjectMapper();
	String requestString=null;
	
	try {
		requestString = mapper.writeValueAsString(requestDto);
	}
	
	catch (JsonProcessingException e) {
		e.printStackTrace();
	}
	HttpEntity<String> entity = new HttpEntity<>(requestString, headers);
	
	RestTemplate restTemplate = new RestTemplate();
	
	ResponseEntity<String> result = restTemplate.postForEntity(url, entity, String.class);
	
	Map<String,List> map = mapper.readValue(result.getBody(), Map.class);
	
	List obj = map.get("choices");
	Map<String, String> responseValue= (Map<String, String>) obj.get(0);
	
	
	return responseValue.get("text");
	}
}
