package com.sample.city.getCity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.city.getCity.model.GetCityVO;
import com.sample.city.getCity.service.GetCityService;
import com.sample.util.CCConst;
import com.sample.util.ResponseEntityUtil;

import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = CCConst.BASE_URI + "/getCity/v1")
public class GetCityController {
	
	@Autowired
	private GetCityService getCityService;
	
	@ApiOperation(value = "도시 목록", notes = "<big>도시 전체 목록</big>을 반환한다.")
	@GetMapping(value = "/getCityList", headers = { "Content-type=application/json" })
	public @ResponseBody ResponseEntity<List<?>> getCityList(
			@RequestParam(value = "cityName", required = false) String cityName) {
		
		List<GetCityVO> list = getCityService.getCityList(cityName) ;
		return new ResponseEntityUtil().responseEntityReturn(list) ;
	}
	
	@ApiOperation(value = "도시 등록", notes = "도시를 등록한다.")
	@PostMapping(value = "/insertCity", headers = { "Content-type=application/json" })
	public @ResponseBody ResponseEntity<List<?>> insertCity(GetCityVO getCityVO) {
		
		getCityService.insertCity(getCityVO) ;
		
		return new ResponseEntityUtil().responseEntityReturn(null) ;
		
	}
	
	@ApiOperation(value = "도시의 인구수 변경", notes = "도시의 인구수 변경")
	@PatchMapping (value = "/updateCityPopulation", headers = { "Content-type=application/json" })
	public @ResponseBody ResponseEntity<List<?>> updateCityPopulation(GetCityVO getCityVO) {
		
		getCityService.updateCityPopulation(getCityVO) ;
		
		return new ResponseEntityUtil().responseEntityReturn(null) ;
		
	}
	
}
