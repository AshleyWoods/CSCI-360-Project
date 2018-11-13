package edu.cofc.Tests;


import edu.cofc.Application.Election;

import edu.cofc.Ballots.Ballot;
import edu.cofc.Vote.Vote;
import edu.cofc.Vote.Voter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BallotTest {
    private Election election;
    private Ballot ballot;
    private Vote vote;
    private Voter voter;

    //C
    @Before
    public void setUp() {
        election = new Election();
        ballot = new Ballot(election);
        voter = new Voter("firstName", "lastName", "MiddleI", "18889372", 3);
        vote = new Vote(voter, "Candidate");
    }

    @Test
    //Tests the add vote method of ballots to make sure that the votes are added to the list properly
    public void testAddVote(){
        ballot.addVote(vote);
        List<Vote> votes = new ArrayList<Vote>();
        votes.add(vote);
        assertEquals(votes, ballot.getVotes());
    }

    //@Test
    //Tests the SubmitBallot method to make sure that the method runs correctly
    //How to run/test?? <- Can't run test, a print cannot be tested by this but by a visual test of the file
    //public void testSubmitBallot(){ }
}
