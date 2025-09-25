package se.jensen.erik.dicegame;



public class Player {




    private String firstName;
    private String lastName;

    private int score = 0;
    private int roundsWon = 0;



    //  ** GETS **


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getScore() {
        return score;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public int getRoundsWon() {
        return roundsWon;
    }




    // ** SETS **  med undantag/exceptions
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        this.lastName= lastName;
    }



    public void setScore(int score) {
        this.score = score;
    }


    // Uppdaterar score efter tärningskast
    public void addToScore(int score){
        this.score += score;
    }

    public void incrementRoundsWon(){
        this.roundsWon++;
    }
}
