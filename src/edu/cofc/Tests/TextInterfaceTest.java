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
        Boolean results = textInterface.voterRegistered("misae", "evans", "e","agaga", 1);
        assertEquals(true, results);
        results = textInterface.voterRegistered("faketyFake", "fake", "fake", "fake",  1);
        assertEquals(false, results);
        results = textInterface.voterRegistered("faketyFake","fake", "fake", "fake",  2);
        assertEquals(false, results);
        results = textInterface.voterRegistered("faketyFake", "fake", "fake", "fake", 3);
        assertEquals(false, results);
         results = textInterface.voterRegistered("test", "test", "t", "75063", 2);
        assertEquals(true, results);
         results = textInterface.voterRegistered("test", "test", "t", "test", 3);
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
        int[] results = textInterface.getOfficialTally();
        //READ ME -- This value is obtained though a visual inspection of the FILE and by counting votes on your own.
        // If the file is changed then THIS TEST WILL NOT WORK
        //Order : BuggsBunny, RoadRunner, DaffyDuck,WileyCyote, PeterParker, BatMan, SpiderMan, BruceWayne
        int[] expected = {4,0,2,0,1,0,2,3};
        assertEquals(expected[0], results[0]);
        assertEquals(expected[1], results[1]);
        assertEquals(expected[2], results[2]);
        assertEquals(expected[3], results[3]);
        assertEquals(expected[4], results[4]);
        assertEquals(expected[5], results[5]);
        assertEquals(expected[6], results[6]);
        assertEquals(expected[7], results[7]);
    }

    @Test
    //tests the unofficial tally method
    //NOT FINISHED
    public void testGetUnofficialTally() {
        int[] results = textInterface.getUnofficialTally();
        //READ ME -- This value is obtained though a visual inspection of the FILE and by counting votes on your own.
        // If the file is changed then THIS TEST WILL NOT WORK
        //Order : BuggsBunny, RoadRunner, DaffyDuck,WileyCyote, PeterParker, BatMan, SpiderMan, BruceWayne
        int[] expected = {4,0,2,0,1,0,2,3};
        assertEquals(expected[0], results[0]);
        assertEquals(expected[1], results[1]);
        assertEquals(expected[2], results[2]);
        assertEquals(expected[3], results[3]);
        assertEquals(expected[4], results[4]);
        assertEquals(expected[5], results[5]);
        assertEquals(expected[6], results[6]);
        assertEquals(expected[7], results[7]);
    }

    @Test
    //tests the recount method
    //NOT FINISHED -- Recount is broken so we can't really test it until it's fixed
    public void testGetRecount() {
        //boolean results = textInterface.getRecount();
        //READ ME -- This value is obtained though a visual inspection of the FILE and by counting votes on your own.
        // If the file is changed then THIS TEST WILL NOT WORK
        //boolean expected = ;
    }
}
