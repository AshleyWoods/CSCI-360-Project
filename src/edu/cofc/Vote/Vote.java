package edu.cofc.Vote;

public class Vote {
//Stores the vote information for high cohesion and becomes the information expert for this data
    private Voter voter;
    private String candidate;

    //Constructor, Creator
    public Vote(Voter v, String can) {
        this.voter = v;
        this.candidate = can;
    }

    public Voter getVoter() {
        return this.voter;
    }

    public String getCandidate(){
        return this.candidate;
    }

}
