package edu.cofc.Ballots;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.DataBase.DatabaseInterface;
import edu.cofc.Vote.Vote;

import java.util.List;

public class Ballot {
    private List<Vote> votes;
    private List candidates;
    private List voteNumber;

    public Ballot() {
        for (int i = 0; i<8; i++) {
            this.voteNumber.add(0);
        }
        this.candidates.add("Buggs Bunny");
        this.candidates.add("Road Runner");
        this.candidates.add("Daffy Duck");
        this.candidates.add("Wiley E. Cyote");
        this.candidates.add("Peter Parker");
        this.candidates.add("Batman");
        this.candidates.add("Spider Man");
        this.candidates.add("Bruce Wayne");
    }

    public void addVote(Vote vote) {
        this.votes.add(vote);
    }

    public void submitBallot() {
        for (int i = 0; i<this.votes.size(); i++){
            int index = this.candidates.indexOf(this.votes.get(i).getCandidate());
            this.voteNumber.set(index, 1);
        }
        Main.getInterface().saveVote(this.votes.get(0).getVoter(),this.candidates,this.voteNumber);
    }
}
