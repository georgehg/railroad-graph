package org.ghgs.chalenges;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class InputHelperTest {

    @Test
    public void returnGraphFromCommandLine() {
        final String opt = "-g";
        final String graphInput = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        String[] args = {opt, graphInput};

        String readGraph = InputHelper.getInputGraph(args);

        assertEquals(graphInput, readGraph);
    }

    @Test
    public void returnGraphFromUserInput() {
        final String userGraphInput = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        System.setIn(new ByteArrayInputStream(userGraphInput.getBytes()));

        String readGraph = InputHelper.getInputGraph(new String[]{});

        assertEquals(userGraphInput, readGraph);
    }

    @Test(expected = Exception.class)
    public void returnGraphFromCommandLine_throwsException() {
        final String opt = "-g";
        String[] args = {opt};

        InputHelper.getInputGraph(args);
    }

}