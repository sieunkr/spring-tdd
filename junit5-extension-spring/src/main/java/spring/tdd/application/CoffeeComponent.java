package spring.tdd.application;

import org.springframework.stereotype.Component;

@Component
public class CoffeeComponent {

    private final CoffeeUseCase coffeeUseCase;

    public CoffeeComponent(CoffeeUseCase coffeeUseCase) {
        this.coffeeUseCase = coffeeUseCase;
    }

    public String getCoffeeMessage(){
        return coffeeUseCase.getCoffeeMessage();
    }
}
