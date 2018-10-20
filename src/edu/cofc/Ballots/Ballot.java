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
            voteNumber.add(0);
        }
        candidates.add("Buggs Bunny");
        candidates.add("Road Runner");
        candidates.add("Daffy Duck");
        candidates.add("Wiley E. Cyote");
        candidates.add("Peter Parker");
        candidates.add("Batman");
        candidates.add("Spider Man");
        candidates.add("Bruce Wayne");
    }

    private void addVote(Vote vote) {
        votes.add(vote);
    }

    private void submitBallot() {
        for (int i = 0; i<votes.size(); i++){
            int index = candidates.indexOf(votes.get(i).getCandidate());
            voteNumber.set(index, 1);
        }
        Main.getInterface().saveVote(votes.get(0).getVoter(),candidates,voteNumber);
    }
}
