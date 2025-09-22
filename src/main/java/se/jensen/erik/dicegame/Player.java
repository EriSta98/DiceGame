package se.jensen.erik.dicegame;



public class Player {




    private String firstName;
    private String lastName;

    private int score = 0;



    //  ** GETS **

    // Används inte?
    public String getFirstName() {
        return firstName;
    }
    // Används inte?
    public String getLastName() {
        return lastName;
    }

    public int getScore() {
        return score;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }






    // ** SETS **  med undantag/exceptions
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        this.lastName= lastName;
    }


    // Används inte?
    public void setScore(int score) {
        this.score = score;
    }


    // Uppdaterar score efter tärningskast
    public void addToScore(int score){
        this.score += score;
    }




}
