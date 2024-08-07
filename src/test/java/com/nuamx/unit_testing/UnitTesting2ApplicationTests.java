package com.nuamx.unit_testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UnitTesting2ApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testAdd2() {
        int result = restTemplate.getForObject("/calculator/add?a=1&b=2", Integer.class);
        assertEquals(3, result);
        result = restTemplate.getForObject("/calculator/add?a=3&b=2", Integer.class);
        assertEquals(5, result);
    }

    @Test
    void testSubtract2() {
        int result = restTemplate.getForObject("/calculator/subtract?a=1&b=2", Integer.class);
        assertEquals(-1, result);
        result = restTemplate.getForObject("/calculator/subtract?a=3&b=2", Integer.class);
        assertEquals(1, result);
    }

    @Test
    void testMultiply2() {
        int result = restTemplate.getForObject("/calculator/multiply?a=1&b=2", Integer.class);
        assertEquals(2, result);
        result = restTemplate.getForObject("/calculator/multiply?a=3&b=2", Integer.class);
        assertEquals(6, result);
    }

    @Test
    void testDivide2() {
        Double result = restTemplate.getForObject("/calculator/divide?a=1&b=2", Double.class);
        assertEquals(0.5, result);
        result = restTemplate.getForObject("/calculator/divide?a=2&b=2", Double.class);
        assertEquals(1, result);
    }

}
