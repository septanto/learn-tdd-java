package com.septanto.tddtest;

import com.septanto.tdd.Friendships;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.Arrays;
import java.util.List;

public class FriendshipsTestNG {

    Friendships friendships;

    public static void beforeClass() {
        // this method will be executed once on initialization time
    }

    @BeforeMethod
    public void before() {
        friendships = new Friendships();
        friendships.makeFriends("Joe", "Audrey");
        friendships.makeFriends("Joe", "Peter");
        friendships.makeFriends("Joe", "Michael");
        friendships.makeFriends("Joe", "Britney");
        friendships.makeFriends("Joe", "Paul");
    }

    public void alexDoesNotHaveFriends() {
        Assert.assertTrue(friendships.getFriendList("Alex").isEmpty(), "Alex does not have friends");
    }

    public void joeHas5Friends() {
        Assert.assertEquals(friendships.getFriendList("Joe").size(), 5, "Joe has 5 friends");
    }

    public void joeIsFriendWithEveryone() {
        List<String> friendsOfJoe = Arrays.asList("Audrey", "Peter", "Michael", "Britney", "Paul");
        Assert.assertTrue(friendships.getFriendList("Joe").containsAll(friendsOfJoe));
    }

}
