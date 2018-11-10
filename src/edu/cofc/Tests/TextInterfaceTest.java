package edu.cofc.Tests;

import edu.cofc.TextfileInterface.TextInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextInterfaceTest {
    private TextInterface textInterface;

    @Before
    public void setUp() {textInterface = TextInterface.getInstance();}
}
