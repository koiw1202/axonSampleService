package com.sample.city.getCity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sample.city.getCity.model.GetCityVO;

@Mapper
@Repository("GetCityMapper")
public interface GetCityMapper {
	
	List<GetCityVO> getCityList(String cityName);
	
	int insertCityList(GetCityVO getCityVO) ;
	
	
	int updateCityPopulation(GetCityVO getCityVO) ;
	
}
