package com.knownhub.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author eagel
 * @since 0.0.1
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = KnownHubService.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KnownHubServiceTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testIndex() {

    }
}
