package edu.cofc.Vote;

public class Vote {

    private Voter voter;
    private String candidate;

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
