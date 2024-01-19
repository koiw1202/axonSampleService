package com.sample.city.getCity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetCityVO {
	
	public GetCityVO(int id2) {
		// TODO Auto-generated constructor stub
	}
	
	private String name ;
    private int id ;
    private String countryCode ;
    private String district ;
    private int population ;
    
}
