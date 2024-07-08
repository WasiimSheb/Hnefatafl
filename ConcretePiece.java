import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public abstract class ConcretePiece implements Piece {
    protected int id;
    protected Position position;
    protected Player owner;
    protected ArrayList<Position> history;

    protected int numOfKills;

    protected int numOfSquaresTraveled;

    public ArrayList<Position> getHistory() {
        return history;
    }
    @Override
    public Player getOwner() {
        return owner;
    }
    public Position getPosition(){
        return position;
    }
    @Override
    public abstract String getType();
    public int getId() {return id;}

    public int getNumOfKills(){return numOfKills;}

    public void addKill(){numOfKills++;}
    public int getNumOfSquaresTraveled(){return numOfSquaresTraveled;}

    public void calculateSquares(Position p){
        if(p.getCol()==position.getCol()){
            numOfSquaresTraveled=Math.abs((p.getRow())- (position.getRow()))+numOfSquaresTraveled;
        }else {
            numOfSquaresTraveled=Math.abs((p.getCol())- (position.getCol()))+numOfSquaresTraveled;
        }
    }
}