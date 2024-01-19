package com.sample.city.getCity.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.sample.city.getCity.model.GetCityVO;

public class CreateCityCommand {

	@TargetAggregateIdentifier
	private GetCityVO getCityVO ;
	
	public CreateCityCommand(GetCityVO getCityVO) {
        
		if (getCityVO.getName().equals("")) {
            throw new IllegalArgumentException("CityName is Empty.");
        }
		
        this.getCityVO = getCityVO ;
    }
	
}
