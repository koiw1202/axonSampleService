package com.sample.util;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class ResponseEntityUtil {
	
	public ResponseEntity<List<?>> responseEntityReturn(List<?> list) {
		if(list != null && list.size() > 0) {
			return ResponseEntity.ok()
				       .headers(new HttpHeaders())
				       .body(list) ;
		} else {
			return ResponseEntity.notFound()
						.headers(new HttpHeaders())
				        .build()  ;
		}
	}
}