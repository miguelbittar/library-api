package dev.miguelbittar.library_api.infra.beans;

import dev.miguelbittar.library_api.core.gateway.BookGateway;
import dev.miguelbittar.library_api.core.usecases.CreateBookUseCase;
import dev.miguelbittar.library_api.core.usecases.CreateBookUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateBookUseCase createBookUseCase(BookGateway bookGateway){
        return new CreateBookUseCaseImpl(bookGateway);
    }
}
