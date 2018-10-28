package edu.cofc.Ballots;

import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.TextfileInterface.TextInterface;
import edu.cofc.Vote.Vote;

import java.util.ArrayList;
import java.util.List;

public class Ballot {
    private List<Vote> votes;
    private List candidates;
    private List voteNumber;

    public Ballot() {
        this.votes = new ArrayList<Vote>();
        this.voteNumber = new ArrayList();
        this.candidates = Main.getCurrentElection().getCandidates();
        for (int i = 0; i<8; i++) {
            this.voteNumber.add(0);
        }

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
