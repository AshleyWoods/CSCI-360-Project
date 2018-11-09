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
                "hopePhone", "workPhone", "DlNUM", 2222222);
    }
}
