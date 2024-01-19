package com.sample.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.sample.city.getCity.command.ChangePopulationCommand;
import com.sample.city.getCity.model.GetCityVO;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class CityAggregate {
	
	@AggregateIdentifier
    private String cityId;
	private int population;
	
	@CommandHandler
    public void cancelCity(ChangePopulationCommand command) {
        apply(new GetCityVO(command.getId()));
    }
	
	@EventSourcingHandler
    public void changeCityPopulation(GetCityVO getCityVO) {
        this.population = getCityVO.getPopulation();
    }
	
}
