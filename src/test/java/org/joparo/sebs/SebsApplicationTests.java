package org.joparo.sebs;

import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest
class SebsApplicationTests {

    @Autowired
    Repository repository;

    @Test
    void contextLoads() {
    }

}
