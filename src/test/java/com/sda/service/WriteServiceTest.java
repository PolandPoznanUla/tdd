package com.sda.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriteServiceTest {

    private WriteService writeService;

    @Before
    public void init() {
        writeService = new WriteService();
    }

    @Test
    public void shouldReturnMessageWithGivenName() {
        String givenName = "Ula";
        String actualValue = writeService.action(givenName);
        String expectedValue = "Hello, " + givenName;

        Assert.assertEquals("Messages are not the same", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageWithNameAsNull() {
        String givenValue = null;
        String actualValue = writeService.action(givenValue);
        String expectedValue = "Hello, my friend";

        Assert.assertEquals("Messages are not the same", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageWithEmptyName() {
        String givenValue = "";
        String actualValue = writeService.action(givenValue);
        String expectedValue = "Hello, my friend";

        Assert.assertEquals("Messages are not the same", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnShoutMessageWithGivenCapitalLetters() {
        String givenValue = "ANNA";
        String actualValue = writeService.action(givenValue);
        String expectedValue = "HELLO, ANNA!";

        Assert.assertEquals("Message not correct for capital letters", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageFilledWithSpaces() {
        String givenValue = "    ";
        String expectedValue = "Hello, my friend";
        String actualValue = writeService.action(givenValue);

        Assert.assertEquals("Message is not correct", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageForGivenMultipleNames() {
        String givenValue = "John, Martin, Ella";
        String expectedValue = "Hello, John, Martin and Ella";
        String actualValue = writeService.action(givenValue);

        Assert.assertEquals("Message not correct for multiple names", expectedValue, actualValue);
    }
}
