public class ConcretePlayer implements Player{
    protected boolean isPlayerOne;

    protected int wins;

    public ConcretePlayer(boolean isPlayerOne){
        this.isPlayerOne=isPlayerOne;
        wins=0;
    }

    @Override
    public boolean isPlayerOne() {
        return isPlayerOne;
    }

    @Override
    public int getWins() {
        return wins;
    }

    public void AddWin(){this.wins++;}
}
