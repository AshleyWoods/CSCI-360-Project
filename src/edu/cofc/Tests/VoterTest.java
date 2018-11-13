package edu.cofc.Tests;

import edu.cofc.Vote.Voter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VoterTest {
    private Voter voterFull;
    private Voter voterAbrev;


    @Before
    public void setUp() {
        voterAbrev = new Voter("firstName", "lastName", "MiddleI", "18889372", 3);
        voterFull = new Voter("firstName","lastName", "MiddleI", "suffix", "sex",
                "race", "ssn", "residentialStreet", "residentialCity", "residentialState", "residentialZip", "residentialApt",
                "inCityLimits", "mailStreet", "cityMailing", "stateMailing", "zipMailing", "birthDAY", "birthdayMonth", "birthdayYear",
                "homePhone", "workPhone", "DLNUM", 2222222);
    }
    @Test
    //make sure that constructor works  
    public void testConstructor() {
    	assertEquals("firstName", voterFull.getFirstName());
    	assertEquals("lastName", voterFull.getLastName());
    	assertEquals("MiddleI", voterFull.getMiddleInitial());
    	assertEquals("suffix", voterFull.getSuffix());
    	assertEquals("sex", voterFull.getSex());
    	assertEquals("race", voterFull.getRace());
    	assertEquals("ssn", voterFull.getSSN());
    	assertEquals("residentialStreet", voterFull.getStreetResidential());
    	assertEquals("residentialCity", voterFull.getCityResidential());
    	assertEquals("residentialState", voterFull.getStateResidental());
    	assertEquals("residentialZip", voterFull.getZipResidential());
    	assertEquals("residentialApt", voterFull.getAptResidential());
    	assertEquals("inCityLimits", voterFull.getCityLimits());
    	assertEquals("mailStreet", voterFull.getStreetMailing());
    	assertEquals("cityMailing", voterFull.getCityMailing());
    	assertEquals("stateMailing", voterFull.getStateMailing());
    	assertEquals("zipMailing", voterFull.getZipMailing());
    	assertEquals("birthDAY", voterFull.getBirthdayDate());
    	assertEquals("birthdayMonth", voterFull.getBirthdayMonth());
    	assertEquals("birthdayYear", voterFull.getBirthdayYear());
    	assertEquals("homePhone", voterFull.getHomePhone());
    	assertEquals("workPhone", voterFull.getWorkPhone());
    	assertEquals("DLNUM", voterFull.getDLNumber());
    	assertEquals(2222222,voterFull.getvoterID());
    }
    //make sure that print voterInfo works 
    
    
}
