package edu.cofc.Tests;

import edu.cofc.Administration.Admin;
import edu.cofc.TextfileInterface.TextInterface;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class TextInterfaceTest {
    private TextInterface textInterface;

    @Before
    public void setUp() {
    	textInterface = TextInterface.getInstance();
    	}


    	//CAN'T TEST METHODS THAT WRITE TO FILES -- THOSE NEED A VISUAL TEST OF THE FILES
    @Test
    //Tests the login method for voters
    public void testVoterRegistered() throws FileNotFoundException {
        Boolean results = textInterface.voterRegistered("agaga", 1);
        assertEquals(true, results);
        results = textInterface.voterRegistered("faketyFake", 1);
        assertEquals(false, results);
        results = textInterface.voterRegistered("faketyFake", 2);
        assertEquals(false, results);
        results = textInterface.voterRegistered("faketyFake", 3);
        assertEquals(false, results);
         results = textInterface.voterRegistered("86612", 2);
        assertEquals(true, results);
         results = textInterface.voterRegistered("social", 3);
        assertEquals(true, results);
    }

    @Test
    //Tests the login method for admins
    public void testAdminLoginValid() {
        Admin admin = new Admin("bubbles","misae");
        boolean results = textInterface.adminLoginValid(admin);
        assertEquals(true, results);
        admin = new Admin ("x", "y");
        results = textInterface.adminLoginValid(admin);
        assertEquals(false, results);
    }

    @Test
    //tests the official tally method
    //NOT FINISHED
    public void testGetOfficialTally(){
        int results = textInterface.getOfficialTally();
    }

    @Test
    //tests the unofficial tally method
    //NOT FINISHED
    public void testGetUnofficialTally() {
        int results = textInterface.getUnofficialTally();
    }

    @Test
    //tests the recount method
    //NOT FINISHED
    public void testGetRecount() {
        int results = textInterface.getRecount();
    }
}
