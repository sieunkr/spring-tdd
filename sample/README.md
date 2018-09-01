# JUnit 5 

## JUnit5 기본 개요

일체형 아키텍처로 구성된 JUnit4를 개선하기 위해 등장한 JUnit5 는 자바 8+ 의 모던 프로그래밍으로 개발이 되었고, 3개의 큰 컴포넌트로 구성된다. JUnit5 의 기본 개념에 대해서 알아본다. 해당 문서는 공식 JUnit5 레퍼런스를 참고하였다. 자세한 내용은 아래 링크를 통해서 확인하길 바란다. 

[https://junit.org/junit5/docs/current/user-guide/#overview-what-is-junit-5](https://junit.org/junit5/docs/current/user-guide/#overview-what-is-junit-5)

#### JUnit5 구성 컴포넌트
JUnit5 는 3개의 컴포넌트로 구성되는데 아래와 같다.

- JUnit Vintae
- JUnit Jupiter
- JUnit Platform

**JUnit Jupiter**   :  새로운 프로그래밍 모델을 위한 테스트 엔진을 제공한다.  
**JUnit Vintae**  : 기존 버전(JUnit3, JUnit4)을 위한 테스트 엔진을 제공한다.  
**JUnit Platform** : 테스트 엔진 인터페이스를 정의한다. (?)

캡쳐화면


#### JUnit5 with Maven
````xml
<build>
   <plugins>
      <plugin>
         <artifactId>maven-surefire-plugin</artifactId>
         <version>${maven-surefire-plugin.version}</version>
         <dependencies>
             <dependency>
                <groupId>org.junit.platform</groupId>
                <artifactId>junit-platform-surefire-provider</artifactId>
                <version>${junit.platform.version}</version>
            </dependency>
            <dependency>
               <groupId>org.junit.jupiter</groupId>
               <artifactId>junit-jupiter-engine</artifactId>
               <version>${junit.jupiter.version}</version>
            </dependency>
         </dependencies>
      </plugin>
   </plugins>
 </build>
````

#### JUnit5 with Gradle

````groovy
testCompile('org.junit.jupiter:junit-jupiter-api:5.2.0')  
testRuntime('org.junit.jupiter:junit-jupiter-engine:5.2.0')
````

참고로 스프링 부트 2.0.X 버전에서는 기본적으로 Junit4.12 버전이 디펜던시로 추가된다. 충돌을 방지하기 위해서 4.12 버전을 exclude 해야 한다. 

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

#### JUnit5 샘플 프로젝트

[https://github.com/junit-team/junit5-samples/tree/r5.2.0/junit5-jupiter-starter-gradle](https://github.com/junit-team/junit5-samples/tree/r5.2.0/junit5-jupiter-starter-gradle)
[https://github.com/junit-team/junit5-samples/tree/r5.2.0/junit5-jupiter-starter-maven](https://github.com/junit-team/junit5-samples/tree/r5.2.0/junit5-jupiter-starter-maven)

> JUnit5 는 ... 

## JUnit5 기본 테스트

#### 라이프사이클
JUnit5 는 JUnit4 와 동일한 라이프사이클을 사용한다. 어노테이션 이름이 변경되었다.

|JUnit5|설명|JUnit4|
|--|--|--|
|@BeforeAll| |@BeforeClass|
|@BeforeEach|??|@Before|
|@Test||@Test|
|@AfterEach|??|@After|
|@AfterAll| |@AfterClass|

````java
import org.junit.jupiter.api.*;  
  
import static org.junit.jupiter.api.Assertions.assertNotEquals;  
import static org.junit.jupiter.api.Assertions.assertTrue;  
import static org.junit.jupiter.api.Assumptions.assumeTrue;  
  
@DisplayName("라이프사이클 설명을 위한 클래스")  
public class LifeCycle {  
  
    @BeforeAll  
  static void initializeBeforeAll() {  
        System.out.println("initializeBeforeAll...");  
  }  
  
    @BeforeEach  
  void initializeBeforeEach() {  
        System.out.println("initializeBeforeEach...");  
  }  
  
    @Test  
 @DisplayName("@Test를 사용하는 첫번째 테스트")  
    void firstTest() {  
        System.out.println("첫번째 테스트...");  
  assertTrue(true);  
  }  
  
    @Test  
 @DisplayName("@Test를 사용하는 두번째 테스트")  
    void secondTest() {  
        assumeTrue(true);  
  System.out.println("두번째 테스트...");  
  assertNotEquals(1, 2, "");  
  }  
  
    @Test  
 @Disabled @DisplayName("@Disabled를 사용하는 스킵 테스트")  
    void disabledTest() {  
        System.out.println("disabled...");  
  }  
  
    @AfterEach  
  void afterEach() {  
        System.out.println("afterEach...");  
  }  
  
    @AfterAll  
  static void afterAll() {  
        System.out.println("afterAll...");  
  }  
}
````


더 자세한 정보는 공식 레퍼런스를 참고하자.
[https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations](https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations)

#### Assertions

|Assertion|설명|
|--|--|
|fail| |
|assertTrue| |
|assertFalse| |
|assertNull| |
|assertNotNull| |
|assertEquals| |
|assertArrayEquals| |
|assertNotEquals| |
|assertSame| |
|assertNotSame| |
|assertAll| |

샘플 소스는 아래 링크를 참고하였다.
[https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Assertions.html](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Assertions.html)

#### Assertions 샘플 테스트

````java
Person person = new Person("sieun", 1981);


@Test  
void standardAssertions(){  
	assertEquals(7,7);  
	assertNotEquals(3,7);  
	assertTrue(3 < 7);  
	assertEquals("sieun",person.getName());  
	assertTrue(1985 > person.getBorn());  
}
````


````java
@Test  
void groupedAssertions() {  
    assertAll("person",  
		() -> assertEquals("sieun", person.getName()),  
		() -> assertEquals("1981", person.getBorn().toString())  
    );  
}
````


````java
@Test
void dependentAssertions() {

    assertAll("properties",
            () -> {
                String name = person.getName();
                assertNotNull(name);
                assertAll("name",
                        () -> assertTrue(name.startsWith("s")),
                        () -> assertTrue(name.endsWith("n"))
                );
            },
            () -> {
                Person.Gender gender = person.getGender();
                assertNull(gender);
            },
            () -> {
                Person.Gender gender = irene.getGender();
                assertNotNull(gender);
                assertAll("아이린",
                        () -> assertEquals("irene", irene.getName()),
                        () -> assertEquals(Person.Gender.F, irene.getGender())
                );
            }
    );
}
````

