package edu.cofc.Tests;

import edu.cofc.Application.Election;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ElectionTest {
    private Election electionDef;
    private Election electionCus;
    private List<String> candidates;

    @Before
    public void setUp() {
        candidates.add("Candidate 1");
        candidates.add("Candidate 2");
        electionDef = new Election();
        electionCus = new Election(candidates, "Title");
    }
}
