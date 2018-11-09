package edu.cofc.Ballots;

import edu.cofc.Application.Election;
import edu.cofc.Application.VotingSystem.Main;
import edu.cofc.TextfileInterface.TextInterface;
import edu.cofc.Vote.Vote;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Ballot {
    //Accumulates the voting and voter information and passes it to the text database
    private List<Vote> votes;
    private List candidates;
    private List voteNumber;
    private Election currentElection;

    public Ballot(Election elec) {
        this.votes = new ArrayList<Vote>();
        this.voteNumber = new ArrayList();
        this.candidates = elec.getCandidates();
        for (int i = 0; i<8; i++) {
            this.voteNumber.add(0);
        }

    }

    public void addVote(Vote vote) {
        this.votes.add(vote);
    }

    public void submitBallot() throws FileNotFoundException {
        for (int i = 0; i<this.votes.size(); i++){
            int index = this.candidates.indexOf(this.votes.get(i).getCandidate());
            this.voteNumber.set(index, 1);
        }
        Main.getInterface().saveVote(this.votes.get(0).getVoter(),this.candidates,this.voteNumber);
    }

    public List<Vote> getVotes() {return this.votes;}
}
