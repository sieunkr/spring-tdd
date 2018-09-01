package spring.tdd.sample;

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
    @Disabled
    @DisplayName("@Disabled를 사용하는 스킵 테스트")
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
