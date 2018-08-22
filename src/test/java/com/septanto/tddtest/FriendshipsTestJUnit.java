package com.septanto.tddtest;

import com.septanto.tdd.Friendships;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.assertj.core.api.Assertions.assertThat;


public class FriendshipsTestJUnit {
    Friendships friendships;

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

    @Test // hamcrest stye
    public void joeHas5Friends() {
        assertThat(friendships.getFriendList("Joe"), hasSize(5));
    }

    @Test // hamcrest stye
    public void joeIsFriendWithEveryone() {
        assertThat(
                friendships.getFriendList("Joe"),
                containsInAnyOrder("Audrey", "Peter", "Michael", "Britney", "Paul")
        );
    }

    @Test // assertJ style of test 2 and 3
    public void testTwoAndThree() {
        assertThat(friendships.getFriendList("Joe"))
        .hasSize(5)
        .containsOnly("Audrey", "Peter", "Michael", "Britney", "Paul");
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
