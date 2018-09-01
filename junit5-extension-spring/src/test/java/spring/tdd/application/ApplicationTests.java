package spring.tdd.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	public CoffeeComponent coffeeComponent;

	@Test
	@DisplayName("첫번째 테스트")
	public void test(){
		assertEquals("커피를주문한다.", coffeeComponent.getCoffeeMessage());
	}
}
