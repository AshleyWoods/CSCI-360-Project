package edu.cofc.Vote;

public class Vote {

    private Voter voter;
    private String candidate;

    public Vote(Voter v, String can) {
        voter = v;
        candidate = can;
    }

    public Voter getVoter() {
        return voter;
    }
    public String getCandidate(){
        return candidate;
    }
}
