package com.sample.city.getCity.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.sample.city.getCity.event.GetCityEvent;
import com.sample.city.getCity.model.GetCityVO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ChangePopulationCommand {

	public ChangePopulationCommand(GetCityVO getCityVO) {
		// TODO Auto-generated constructor stub
		this.event = getCityVO ; 
	}

	private GetCityVO event ;
	private String name ;
    private int id ;
    private String countryCode ;
    private String district ;
    
    @TargetAggregateIdentifier
    private int population ;
	
}
