package com.sample.city.getCity.service;
        
import java.util.List;

import com.sample.city.getCity.model.GetCityVO;

public interface GetCityService {

	List<GetCityVO> getCityList(String cityName);
	
	void insertCity(GetCityVO getCityVO) ;
	
	Object updateCityPopulation(GetCityVO getCityVO) ;
}
