package edu.cofc.Tests;

import edu.cofc.Application.Election;
import edu.cofc.Ballots.Ballot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BallotTest {
    private Election election;
    private Ballot ballot;

    @Before
    public void setUp() {
        election = new Election();
        ballot = new Ballot(election);
    }
}
