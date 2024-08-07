package com.nuamx.unit_testing;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UnitTestingApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Test Add")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    void testAdd() {
        String path = "/calculator/add?a=1&b=2";
        Allure.step(String.format("Paso 1 suma: [%s]", path), (step) -> {
            step.parameter("a", 1);
            step.parameter("b", 2);
            int result = restTemplate.getForObject("/calculator/add?a=1&b=2", Integer.class);
            assertEquals(3, result);
            step.parameter("result", result);
        });

        path = "/calculator/add?a=3&b=2";
        Allure.step(String.format("Paso 2 suma: [%s]", path), (step) -> {
            step.parameter("a", 3);
            step.parameter("b", 2);
            int result = restTemplate.getForObject("/calculator/add?a=3&b=2", Integer.class);
            assertEquals(5, result);
            step.parameter("result", result);
        });

    }

    @Test
    @DisplayName("Test Subtract")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-456")
    @TmsLink("TMS-789")
    void testSubtract() {
        int result = restTemplate.getForObject("/calculator/subtract?a=1&b=2", Integer.class);
        assertEquals(-1, result);
        result = restTemplate.getForObject("/calculator/subtract?a=3&b=2", Integer.class);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Test Multiply")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-789")
    @TmsLink("TMS-098")
    void testMultiply() {
        int result = restTemplate.getForObject("/calculator/multiply?a=1&b=2", Integer.class);
        assertEquals(2, result);
        result = restTemplate.getForObject("/calculator/multiply?a=3&b=2", Integer.class);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("Test Divide")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-098")
    @TmsLink("TMS-765")
    void testDivide() {
        Double result = restTemplate.getForObject("/calculator/divide?a=1&b=2", Double.class);
        assertEquals(0.5, result);
        result = restTemplate.getForObject("/calculator/divide?a=2&b=2", Double.class);
        assertEquals(1, result);
    }

}
