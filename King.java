import java.util.ArrayList;

public class King extends ConcretePiece{

    public King(int row,int col){
        position=new Position(col,row);
        owner=new ConcretePlayer(true);
        history=new ArrayList<>();
        history.add(new Position(position));
        numOfKills=-1;
        numOfSquaresTraveled=0;
    }

    public King(ConcretePiece p) {
        position=new Position(p.getPosition().getRow(),p.getPosition().getCol());
        owner=new ConcretePlayer(true);
        history=new ArrayList<>();
        history.addAll(p.getHistory());
        numOfSquaresTraveled=p.getNumOfSquaresTraveled();
    }

    @Override
    public String getType() {
        return "♔";
    }
}
