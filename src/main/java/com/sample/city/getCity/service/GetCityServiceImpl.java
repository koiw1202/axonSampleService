package com.sample.city.getCity.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.city.getCity.command.ChangePopulationCommand;
import com.sample.city.getCity.command.CreateCityCommand;
import com.sample.city.getCity.mapper.GetCityMapper;
import com.sample.city.getCity.model.GetCityVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetCityServiceImpl implements GetCityService {

	@Autowired
	GetCityMapper getCityMapper ;
	
	private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;
    
	@Override
	public List<GetCityVO> getCityList(String cityName) {
		// TODO Auto-generated method stub
		return getCityMapper.getCityList(cityName);
	}

	@Override
	public void insertCity(GetCityVO getCityVO) {
		// TODO Auto-generated method stub
		int result = getCityMapper.insertCityList(getCityVO) ;

	}

	@Override
	public Object updateCityPopulation(GetCityVO getCityVO) {
		
		// TODO Auto-generated method stub
		ChangePopulationCommand changePopulationCommand = new ChangePopulationCommand(getCityVO);
        Object obj = commandGateway.sendAndWait( changePopulationCommand, 1000, TimeUnit.MILLISECONDS );
		
        return obj;
	}
}
