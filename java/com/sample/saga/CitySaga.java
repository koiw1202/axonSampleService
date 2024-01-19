package com.sample.saga;

import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.CommandResultMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.city.getCity.command.CancelPopulationCommand;
import com.sample.city.getCity.command.ChangePopulationCommand;
import com.sample.city.getCity.model.GetCityVO;

import lombok.extern.slf4j.Slf4j;

@Saga
@Slf4j
public class CitySaga {

	@Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    public void changePopulation(GetCityVO getCityVO) {
        log.info("[StartSaga] changePopulation saga");

        commandGateway.send(new ChangePopulationCommand( getCityVO ), new CommandCallback<ChangePopulationCommand, Object>() {
			@Override
			public void onResult(CommandMessage<? extends ChangePopulationCommand> commandMessage,
					CommandResultMessage<? extends Object> commandResultMessage) {
				
				// TODO Auto-generated method stub
				if(commandResultMessage.isExceptional()) {

					// transaction
					log.info("[cancel population") ;
					commandGateway.send(new CancelPopulationCommand(getCityVO.getId()));
                }
			}
        });
    }
}
