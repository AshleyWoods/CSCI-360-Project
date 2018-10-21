package edu.cofc.Vote;

public class Voter {

    private String firstName;
    private String lastName;
    private String middleInitial;
    private int SSN;

    public Voter (String lastName, String firstName, String middleInitial, int SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.SSN = SSN;
    }

    public int getSSN() {
        return this.SSN;
    }


}
