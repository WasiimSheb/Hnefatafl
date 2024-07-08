import java.util.ArrayList;
import java.util.Stack;

public class Pawn extends ConcretePiece{


    public Pawn(int row,int col,Player player,int id){
        position=new Position(col,row);
        owner=player;
        this.id=id;
        history=new ArrayList<>();
        history.add(new Position(position));
        numOfKills=0;
        numOfSquaresTraveled=0;
    }

    public Pawn(ConcretePiece p){
        position=new Position(p.getPosition().getRow(),p.getPosition().getCol());
        history=new ArrayList<>();
        history.addAll(p.getHistory());
        owner=p.getOwner();
        this.id=p.getId();
        numOfKills=p.getNumOfKills();
        numOfSquaresTraveled=p.getNumOfSquaresTraveled();
    }



    @Override
    public String getType() {
        return this.owner.isPlayerOne() ?"♙":"♟" ;
    }
}
