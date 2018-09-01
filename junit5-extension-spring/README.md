# JUnit in Spring Boot

## 스프링 부트가 아닌 경우에는?
- @ExtendWith 
- @ContextConfiguration

@ExtendWith 어노테이션으로 스프링 또는 모키토 라이브러리를 확장해서 사용할 수 있고, @ContextConfiguration 어노테이션으로 컨텍스트 설정을 할 수 있다.  

````java
@ExtendWith(SpringExtension.class)

@ContextConfiguration(classes = { MySpringApplication.class })
class SimpleSpringTest {
생략
````

#### 참고소스
[https://github.com/PacktPublishing/Mastering-Software-Testing-with-JUnit-5/blob/master/junit5-spring/src/test/java/io/github/bonigarcia/SimpleSpringTest.java](https://github.com/PacktPublishing/Mastering-Software-Testing-with-JUnit-5/blob/master/junit5-spring/src/test/java/io/github/bonigarcia/SimpleSpringTest.java)

## 스프링 부트 기본 테스트

#### JUnit 5.X 디펜던시 추가

스프링 부트 2.0에서는 기본으로 JUnit 4.2 를 디펜던시가 되어있다. 아래와 같이 디펜던시를 변경하자. 

````groovy
dependencies {  
   compile('org.springframework.boot:spring-boot-starter-web')  
   testCompile('org.springframework.boot:spring-boot-starter-test'){  
      exclude group: 'junit'  
  }  
   testCompile('org.junit.jupiter:junit-jupiter-api:5.2.0')  
   testRuntime('org.junit.jupiter:junit-jupiter-engine:5.2.0')  
}
````

#### @ExtendWith, @SpringBootTest 어노테이션
- @ExtendWith
- @SpringBootTest

@ExtendWith 어노테이션을 그대로 사용하고, @ContextConfiguration 대신에 @SpringBootTest 을 사용한다. @SpringBootTest 어노테이션은 애플리케이션컨텍스트를 실행한다. 

CoffeeCompont 라는 @Componet 로 선언되어 생성된 Bean 을 테스트 한다고 가정하면, 아래와 같이 테스트 할 수 있다. 

````java
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
````

#### 레퍼런스
[https://github.com/spring-projects/spring-framework/blob/master/spring-test/src/main/java/org/springframework/test/context/junit/jupiter/SpringExtension.java](https://github.com/spring-projects/spring-framework/blob/master/spring-test/src/main/java/org/springframework/test/context/junit/jupiter/SpringExtension.java)


## 스프링 부트 MVC 테스트

작성 중..




