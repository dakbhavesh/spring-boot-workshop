package com.meetup;

import com.meetup.web.resource.UserResource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest
@ComponentScan(basePackages = {"com.meetup"})
public class UserResourceIntegrationTests {

    private MockMvc api;

    @Autowired
    private UserResource userResource;

    @Before
    public void setUp(){
        api = MockMvcBuilders.standaloneSetup(userResource).build();
    }

    @Test
    @Ignore("Run Test from IDE")
    public void testSaveUser() throws Exception{
        String userJson = "{\n" +
                "\"firstName\": \"Foo\",\n" +
                "\"lastName\": \"Bar\",\n" +
                "\"username\": \"foo.bar\"\n" +
                "}";
        api.perform(MockMvcRequestBuilders.post("/users").
                contentType(MediaType.APPLICATION_JSON).
                content(userJson).
                accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Ignore("Run Test from IDE")
    public void testFindOne() throws Exception{
        api.perform(MockMvcRequestBuilders.get("/users/31").
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

}
