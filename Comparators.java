import java.util.ArrayList;
import java.util.Comparator;

public class Comparators implements Comparator<ConcretePiece> {
    @Override
    public int compare(ConcretePiece piece1, ConcretePiece piece2) {
        int p1History=piece1.getHistory().size();
        int p2History=piece2.getHistory().size();

        if(p1History==p2History){
            return Integer.compare(piece1.getId(),piece2.getId());
        }

        return Integer.compare(p1History,p2History);
    }
}

 class KillsComparator implements Comparator<ConcretePiece>{

    @Override
    public int compare(ConcretePiece piece1, ConcretePiece piece2) {
        int p1Kills=piece1.getNumOfKills();
        int p2Kills=piece2.getNumOfKills();

        if(p1Kills==p2Kills){
            int id1=piece1.getId();
            int id2=piece2.getId();
            if(id2==id1){
                if(GameLogic.playerTurn==0){
                    if(piece1.getOwner()== piece2.getOwner())
                        return 0;
                    if(piece1.getOwner().isPlayerOne()){
                        //return piece 1
                        return 1;
                    }
                    //return piece 2
                    return -1;
                }else {
                    if(piece1.getOwner()== piece2.getOwner())
                        return 0;
                    if(piece1.getOwner().isPlayerOne()){
                        //return piece 2
                        return -1;
                    }
                    //return piece 1
                    return 1;
                }
            }
            return Integer.compare(id1,id2);
        }
        return Integer.compare(p1Kills,p2Kills);
    }
}


class SquaresComparator implements Comparator<ConcretePiece> {

    @Override
    public int compare(ConcretePiece piece1, ConcretePiece piece2) {
        int p1Squares = piece1.getNumOfSquaresTraveled();
        int p2Squares = piece2.getNumOfSquaresTraveled();

        if (p1Squares == p2Squares) {
            int id1 = piece1.getId();
            int id2 = piece2.getId();

            if (piece1.getOwner() == piece2.getOwner()&&id1==id2)
                return 0;

            if(piece1.getOwner().isPlayerOne()){
                if(id1>6){
                    id1++;
                }
            }

            if(piece2.getOwner().isPlayerOne()){
                if(id2>6)
                    id2++;
            }

            if (id2 == id1) {
                if (GameLogic.playerTurn == 0) {
                    if (piece1.getOwner().isPlayerOne()) {
                        //return piece 1
                        return 1;
                    }
                    //return piece 2
                    return -1;
                }

                if (piece1.getOwner().isPlayerOne()) {
                    //return piece 2
                    return -1;
                }
                //return piece 1
                return 1;

            }

            return Integer.compare(id2, id1);
        }
        return Integer.compare(p1Squares,p2Squares);
    }
}

class PostionsComparator implements Comparator<ArrayList<ConcretePiece>> {

    @Override
    public int compare(ArrayList<ConcretePiece> arr1, ArrayList<ConcretePiece> arr2) {
        if(arr1.size()==arr2.size()) {

        }
        return Integer.compare(arr1.size(),arr2.size());
    }
}


