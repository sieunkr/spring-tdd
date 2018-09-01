package spring.tdd.application;

import org.springframework.stereotype.Service;

@Service
public class CoffeeUseCase {
    public String getCoffeeMessage(){
        return "커피를주문한다.";
    }
}
