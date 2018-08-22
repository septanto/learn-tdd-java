package com.septanto.tddtest;

import com.septanto.tdd.FriendsCollection;
import com.septanto.tdd.Friendships;
import com.septanto.tdd.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class FriendshipsTest {

    @InjectMocks
    Friendships friendships;

    @Mock
    FriendsCollection friends;

    @BeforeClass
    public static void beforeClass() {
        // This method will be executed once on initialization time
    }

    @Before
    public void before() {
        friendships = new Friendships();
        friendships.makeFriends("Joe", "Audrey");
        friendships.makeFriends("Joe", "Peter");
        friendships.makeFriends("Joe", "Michael");
        friendships.makeFriends("Joe", "Britney");
        friendships.makeFriends("Joe", "Paul");
    }

    @Test
    public void alexDoesNotHaveFriends() {
        Assert.assertTrue("Alex does not have friends", friendships.getFriendList("Alex").isEmpty());
    }

    @Test
    public void joeHas5Friends() {
        List<String> expected = Arrays.asList("Audrey", "Peter", "Michael", "Britney", "Paul");
        Person joe = spy(new Person("Joe"));

        doReturn(joe).when(friends).findByName("Joe");
        doReturn(expected).when(joe).getFriends();

        assertThat(friendships.getFriendList("Joe"))
                .hasSize(5)
                .containsOnly("Audrey", "Peter", "Michael", "Britney", "Paul");
    }

    @Test // hamcrest stye
    public void joeIsFriendWithEveryone() {
        assertThat(
                friendships.getFriendList("Joe"),
                containsInAnyOrder("Audrey", "Peter", "Michael", "Britney", "Paul")
        );
    }

    @AfterClass
    public static void afterClass() {
        // this method will be executed once when all test are executed
    }

    @After
    public void after() {
        // This method will be executed once after each test execution
    }
}
