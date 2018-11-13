package edu.cofc.Tests;

import edu.cofc.Vote.Vote;

import edu.cofc.Vote.Voter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VoteTest {
    private Voter voter;
    private Vote vote;

    @Before
    public void setUp() {
        voter = new Voter("firstName", "lastName", "MiddleI", "18889372", 3);
        vote = new Vote(voter, "Candidate");
    }

    @Test
    public void testConstructor(){
        assertEquals(voter, vote.getVoter());
        assertEquals("Candidate", vote.getCandidate());
    }
}
