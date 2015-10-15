package org.dreando.restfuldemo.controller;

import junit.framework.TestCase;
import org.dreando.restfuldemo.DemoRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Mateusz Koza on 15.10.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoRunner.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ApiControllerTest extends TestCase {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * A test that ensures that the api call without requested parameter cannot be performed.
     */
    @Test
    public void testGetCompanyWorkersMissesRequestParam() throws Exception {
        mockMvc.perform(get("/api/company/workers"))
                .andExpect(status().is(400));
    }

    /**
     * With provided expected parameter the test should return status OK
     */
    @Test
    public void testGetCompanyWorkersWithExpectedRequestParam() throws Exception {
        mockMvc.perform(get("/api/company/workers")
                .param("companyName", "Google"))
                .andExpect(status().is(200));
    }
}