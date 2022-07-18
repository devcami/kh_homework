package com.kh.spring.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.demo.model.dto.Dev;
import com.kh.spring.demo.model.exception.DevNotFoundException;
import com.kh.spring.demo.model.service.DemoService;

import lombok.extern.slf4j.Slf4j;

/**
 * RestAPI
 * - Representational State Transfer 
 * - 요청 성격별로 전송방식을 결정해서 사용하는 서비스
 * - c POST
 * - r GET
 * - u PUT / PATCH
 * - d DELETE 
 * 
 * - url작성 시 명사형 계층구조를 갖도록 작성해야함
 *
 */
@Controller
@Slf4j
@RequestMapping("/dev")
public class DevRestAPIController {
	
	@Autowired
	DemoService demoService;
	
	/**
	 * ResponseEntity<T>
	 *  - T : body에 작성할 java type 
	 *  - ? = Object 모든 타입을 의미
	 *  
	 */
	@GetMapping
	public ResponseEntity<?> dev(){
		List<Dev> list = null;
		try {
			list = demoService.selectDevList();
			log.debug("list = {}", list);
			
		} catch (Exception e) {
			log.error("Dev 목록 조회 오류", e);
			Map<String, Object> map = new HashMap<>();
			map.put("msg", "Dev 목록 조회 오류");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<?> dev(@PathVariable int no){
		Dev dev = null;
		try {
			log.debug("no = {}", no);
			dev = demoService.selectDev(no);
			log.debug("dev = {}", dev);
			
			if(dev == null) {
				throw new DevNotFoundException(String.valueOf(no));
			}
			
		}
		catch (DevNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		catch (Exception e) {
			log.error("Dev 한명 조회 오류", e);
			Map<String, Object> map = new HashMap<>();
			map.put("msg", "Dev 한명 조회 오류");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
		return ResponseEntity.ok(dev);
	}
	
	/**
	 * @PathVariable 에 .이 포함된 경우 정규표현식으로 작성
	 */
	@GetMapping("/email/{email:.+}")
	public ResponseEntity<?> dev(@PathVariable String email){
		Dev dev = null;
		try {
			log.debug("email = {}", email);
//			dev = demoService.selectDevByEmail(email);
			List<Dev> list = demoService.selectDevList();
			for(Dev _dev : list) {
				if(email.equals(_dev.getEmail())){
					dev = _dev;
					break;
				}
			}
			log.debug("dev = {}", dev);
			
			if(dev == null) {
				throw new DevNotFoundException(String.valueOf(email));
			}
			
		}
		catch (DevNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		catch (Exception e) {
			log.error("Dev 한명 이메일 조회 오류", e);
			Map<String, Object> map = new HashMap<>();
			map.put("msg", "Dev 한명 이메일 조회 오류");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE).body(dev);
		
	}
	
	@GetMapping("/lang/{lang}")
	public ResponseEntity<?> devlang(@PathVariable String lang){
		List<Dev> devs = new ArrayList<>();
		try {
			List<Dev> list = demoService.selectDevList();
			for(Dev dev : list) {
				for(String l : dev.getLang()) {
					if(l.equals(lang)) {
						devs.add(dev);
						break;
					}
				}
			}
		} 
		catch (DevNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		catch (Exception e) {
			log.error("Dev 목록 언어 조회 오류", e);
			Map<String, Object> map = new HashMap<>();
			map.put("msg", "Dev 목록 언어 조회 오류");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE,	MediaType.APPLICATION_JSON_UTF8_VALUE).body(devs);
	}
	
}
