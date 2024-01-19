package com.sample.city.getCity.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetCityEvent {
	private String name ;
    private int cityId ;
    private String countryCode ;
    private String district ;
    private int population ;
}
