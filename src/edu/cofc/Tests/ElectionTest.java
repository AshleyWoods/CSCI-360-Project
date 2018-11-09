package edu.cofc.Tests;

import edu.cofc.Application.Election;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ElectionTest {
    private Election electionDef;
    private Election electionCus;
    private List<String> candidatesCus;
    private List<String> candidatesDef;
    private List<String> results;

    @Before
    public void setUp() {
        results = new ArrayList<>();
        candidatesCus = new ArrayList<>();
        candidatesDef = new ArrayList<>();
        candidatesCus.add("Candidate 1");
        candidatesCus.add("Candidate 2");
        candidatesDef.add("Buggs Bunny");
        candidatesDef.add("Road Runner");
        candidatesDef.add("Daffy Duck");
        candidatesDef.add("Wiley E. Cyote");
        candidatesDef.add("Peter Parker");
        candidatesDef.add("Batman");
        candidatesDef.add("Spider Man");
        candidatesDef.add("Bruce Wayne");
        electionDef = new Election();
        electionCus = new Election(candidatesCus, "Title");
    }

    @Test
    //Tests the constructor to make sure that the methods that use the getters get the right values
    public void testConstructor(){
        assertEquals(candidatesDef, electionDef.getCandidates());
        assertEquals(candidatesCus, electionCus.getCandidates());
        assertEquals("Title", electionCus.getTitle());
        assertEquals("House Representative Election, Senate Representative Election", electionDef.getTitle());
        assertEquals(results, electionCus.getResults());
        assertEquals(results, electionCus.getResults());
    }

}
