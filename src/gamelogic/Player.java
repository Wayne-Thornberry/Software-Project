package gamelogic;

public class Player {

    private String sName;
    private int iScore;
    private int iSeconds;
    private int iLives;
    private int iFailed;
    private int iCompleted;

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getiScore() {
        return iScore;
    }

    public void setiScore(int iScore) {
        this.iScore = iScore;
    }

    public int getiSeconds() {
        return iSeconds;
    }

    public void setiSeconds(int iSeconds) {
        this.iSeconds = iSeconds;
    }

    public int getiLives() {
        return iLives;
    }

    public void setiLives(int iLives) {
        this.iLives = iLives;
    }

    public int getiFailed() {
        return iFailed;
    }

    public void setiFailed(int iFailed) {
        this.iFailed = iFailed;
    }

    public int getiCompleted() {
        return iCompleted;
    }

    public void setiCompleted(int iCompleted) {
        this.iCompleted = iCompleted;
    }
}
