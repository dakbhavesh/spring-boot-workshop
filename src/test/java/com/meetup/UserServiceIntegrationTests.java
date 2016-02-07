package com.meetup;

import com.meetup.domain.User;
import com.meetup.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.ZonedDateTime;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest
public class UserServiceIntegrationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testSaveUser(){
        User user = prepareUser();
        user = userService.save(user);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void testGetAllUsers(){
        List<User> users = (List)userService.getAll();
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
    }

    private User prepareUser(){
        User user = new User();
        user.setFirstName("Bhavesh");
        user.setLastName("Shah");
        user.setUsername("dakbhavesh");
        return user;
    }
}
