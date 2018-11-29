package edu.cofc.Application;

import java.util.ArrayList;
import java.util.List;

public class Election {
//Stores election information for high cohesion
    private List<String> candidates;
    public List<String> results;
    private String title;

    public Election() {
        this.results = new ArrayList<>();
        this.candidates = new ArrayList<String>();
        this.candidates.add("Buggs Bunny");
        this.candidates.add("Road Runner");
        this.candidates.add("Daffy Duck");
        this.candidates.add("Wiley E. Cyote");
        this.candidates.add("Peter Parker");
        this.candidates.add("Batman");
        this.candidates.add("Spider Man");
        this.candidates.add("Bruce Wayne");
        this.title = "House Representative Election, Senate Representative Election";

    }

    //Constructor -- Creator
    public Election(List<String> can, String Title) {
        this.results = new ArrayList<>();
        this.candidates = can;
        this.title = Title;
    }

    public List<String> getResults() {
        return this.results;
    }

    public List<String> getCandidates() {
        return this.candidates;
    }

    public String getTitle() {
        return this.title;
    }

    public void setResults(List<String> res) {
        this.results = res;
    }

    public void setCandidates(List<String> can) {
       this.candidates = can;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

}
