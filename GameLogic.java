import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class GameLogic implements PlayableLogic{

    //playerTurn is 0 if it's the second player turn
    protected static int playerTurn;
    private final int BOARD_SIZE=11;
    private Player whitePlayer, blackPlayer;
    protected static ConcretePiece [] whitePS,deadWhitePS;
    protected static  ConcretePiece [] blackPS,deadBlackPS;

    private Stack<ConcretePiece> moves;

    protected static Hashtable<Position, ArrayList<ConcretePiece>> postionsCount;

    public GameLogic(){
        whitePlayer =new ConcretePlayer(true);
        blackPlayer =new ConcretePlayer(false);
        whitePS=new ConcretePiece[13];
        blackPS=new ConcretePiece[24];
        newGame();
    }

    public void newGame(){
        playerTurn =0;
        moves=new Stack<>();
        postionsCount=new Hashtable<>();

        deadWhitePS=new ConcretePiece[13];
        deadBlackPS=new ConcretePiece[24];


        whitePS[0]=new King(5,5);
        Position p=new Position(5,5);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[0]);

        whitePS[1]=new Pawn(3,5, whitePlayer,1);
        p=new Position(3,5);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[1]);

        whitePS[2]=new Pawn(4,4, whitePlayer,2);
        p=new Position(4,4);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[2]);

        whitePS[3]=new Pawn(4,5, whitePlayer,3);
        p=new Position(4,5);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[3]);

        whitePS[4]=new Pawn(4,6, whitePlayer,4);
        p=new Position(4,6);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[4]);

        whitePS[5]=new Pawn(5,3, whitePlayer,5);
        p=new Position(5,3);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[5]);

        whitePS[6]=new Pawn(5,4, whitePlayer,6);
        p=new Position(5,4);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[6]);

        whitePS[7]=new Pawn(5,6, whitePlayer,7);
        p=new Position(5,6);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[7]);

        whitePS[8]=new Pawn(5,7, whitePlayer,8);
        p=new Position(5,7);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[8]);

        whitePS[9]=new Pawn(6,4, whitePlayer,9);
        p=new Position(6,4);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[9]);

        whitePS[10]=new Pawn(6,5, whitePlayer,10);
        p=new Position(6,5);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[10]);

        whitePS[11]=new Pawn(6,6, whitePlayer,11);
        p=new Position(6,6);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[11]);

        whitePS[12]=new Pawn(7,5, whitePlayer,12);
        p=new Position(7,5);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(whitePS[12]);

        blackPS[0]=new Pawn(0,3, blackPlayer,0);
        p=new Position(0,3);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[0]);

        blackPS[1]=new Pawn(0,4, blackPlayer,1);
        p=new Position(0,4);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[1]);

        blackPS[2]=new Pawn(0,5, blackPlayer,2);
        p=new Position(0,5);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[2]);

        blackPS[3]=new Pawn(0,6, blackPlayer,3);
        p=new Position(0,6);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[3]);

        blackPS[4]=new Pawn(0,7, blackPlayer,4);
        p=new Position(0,7);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[4]);

        blackPS[5]=new Pawn(1,5, blackPlayer,5);
        p=new Position(1,5);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[5]);

        blackPS[6]=new Pawn(3,0, blackPlayer,6);
        p=new Position(3,0);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[6]);

        blackPS[7]=new Pawn(3,10, blackPlayer,7);
        p=new Position(3,10);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[7]);

        blackPS[8]=new Pawn(4,0, blackPlayer,8);
        p=new Position(4,0);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[8]);

        blackPS[9]=new Pawn(4,10, blackPlayer,9);
        p=new Position(4,10);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[9]);

        blackPS[10]=new Pawn(5,0, blackPlayer,10);
        p=new Position(5,0);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[10]);

        blackPS[11]=new Pawn(5,1, blackPlayer,11);
        p=new Position(5,1);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[11]);

        blackPS[12]=new Pawn(5,9, blackPlayer,12);
        p=new Position(5,9);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[12]);

        blackPS[13]=new Pawn(5,10, blackPlayer,13);
        p=new Position(5,10);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[13]);

        blackPS[14]=new Pawn(6,0, blackPlayer,14);
        p=new Position(6,0);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[14]);

        blackPS[15]=new Pawn(6,10, blackPlayer,15);
        p=new Position(6,10);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[15]);

        blackPS[16]=new Pawn(7,0, blackPlayer,16);
        p=new Position(7,0);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[16]);

        blackPS[17]=new Pawn(7,10, blackPlayer,17);
        p=new Position(7,10);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[17]);

        blackPS[18]=new Pawn(9,5, blackPlayer,18);
        p=new Position(9,5);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[18]);

        blackPS[19]=new Pawn(10,3, blackPlayer,19);
        p=new Position(10,3);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[19]);

        blackPS[20]=new Pawn(10,4, blackPlayer,20);
        p=new Position(10,4);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[20]);

        blackPS[21]=new Pawn(10,5, blackPlayer,21);
        p=new Position(10,5);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[21]);

        blackPS[22]=new Pawn(10,6, blackPlayer,22);
        p=new Position(10,6);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[22]);

        blackPS[23]=new Pawn(10,7, blackPlayer,23);
        p=new Position(10,7);
        postionsCount.put(p,new ArrayList<>());
        postionsCount.get(p).add(blackPS[23]);
    }

    @Override
    public boolean move(Position a, Position b) {
        if(getPieceAtPosition(a)==null || getPieceAtPosition(b)!=null||!isInBounds(b))
            return false;

        ConcretePiece p=(ConcretePiece)getPieceAtPosition(a);

        //checking whose turn it is.
        if ((p.getOwner().isPlayerOne()&&playerTurn==0)||(!p.getOwner().isPlayerOne()&&playerTurn==1)){
            return false;
        }

        if(isCorner(b)&&!p.getType().equals("♔"))
            return false;

        if(a.getCol()==b.getCol()){
            if(isRowAccessible(a,b)){
                checkPositionsCount(p,b);
                if(p.getType().equals("♙")||p.getType().equals("♟")){
                    ConcretePiece LastPawn=new Pawn(p);
                    moves.push(LastPawn);
                }else {
                    ConcretePiece LastKing=new King(p);
                    moves.push(LastKing);
                }
                p.calculateSquares(b);
                p.getPosition().setRow(b.getRow());
                initiateMove(p);
                return true;
            }
        } else if(a.getRow()==b.getRow()){
            if(isColAccessible(a,b)){
                checkPositionsCount(p,b);
                if(p.getType().equals("♙")||p.getType().equals("♟")){
                    ConcretePiece LastPawn=new Pawn(p);
                    moves.push(LastPawn);
                }else {
                    ConcretePiece LastKing=new King(p);
                    moves.push(LastKing);
                }
                p.calculateSquares(b);
                p.getPosition().setCol(b.getCol());
                initiateMove(p);
                return true;
            }
        }
        return false;
    }

    public void checkPositionsCount(ConcretePiece piece, Position b){
        ArrayList<ConcretePiece> arrayList=postionsCount.get(b);
        if(arrayList==null){
            arrayList =new ArrayList<>();
            postionsCount.put(new Position(b.getRow(),b.getCol()),arrayList);
        }
        if(arrayList.contains(piece)){
            return;
        }
        arrayList.add(piece);
    }

    public void initiateMove(ConcretePiece p){
        Position CopyP= new Position(p.getPosition());
        p.getHistory().add(CopyP);
        attacking(p);
        playerTurn = (playerTurn + 1) % 2;
        isGameFinished();
    }

    public void attacking(ConcretePiece p){
        if(p.getType().equals("♔"))
            return;

        ConcretePiece [][] pieces={whitePS,blackPS};
        ConcretePiece [][] deadPieces={deadWhitePS,deadBlackPS};

        int row=p.getPosition().getRow();
        int col=p.getPosition().getCol();

        Piece up=getPieceAtPosition(new Position(row,col-1));
        Piece down=getPieceAtPosition(new Position(row ,col+1));
        Piece left=getPieceAtPosition((new Position(row-1,col)));
        Piece right=getPieceAtPosition((new Position(row+1,col)));

        if(up!=null&&p.getOwner().isPlayerOne()!=up.getOwner().isPlayerOne()&&!up.getType().equals("♔")){
            if (col - 2 < 0) {
              kill(pieces,deadPieces,up,p);
            }else {
                Position upUpPosition = new Position(row, col - 2);
                Piece upUp = getPieceAtPosition(upUpPosition);
                if (isCorner(upUpPosition)) {
                    kill(pieces,deadPieces,up,p);
                }else if (upUp != null && p.getOwner().isPlayerOne() == upUp.getOwner().isPlayerOne()&&!upUp.getType().equals("♔")) {
                    kill(pieces,deadPieces,up,p);
                }
            }
        }

        if(down!=null&&p.getOwner().isPlayerOne()!=down.getOwner().isPlayerOne()&&!down.getType().equals("♔")){
            if (col + 2 > 10) {
               kill(pieces,deadPieces,down,p);
            }else {
                Position downDownPosition = new Position(row, col + 2);
                Piece downDown = getPieceAtPosition(downDownPosition);
                if (isCorner(downDownPosition)) {
                    kill(pieces,deadPieces,down,p);

                }else if (downDown != null && p.getOwner().isPlayerOne() == downDown.getOwner().isPlayerOne()&&!downDown.getType().equals("♔")){
                    kill(pieces,deadPieces,down,p);
                }
            }
        }

        if(left!=null&&p.getOwner().isPlayerOne()!=left.getOwner().isPlayerOne()&&!left.getType().equals("♔")) {
            if (row - 2 < 0) {
                kill(pieces,deadPieces,left,p);
            } else {
                Position leftLeftPosition = new Position(row - 2, col);
                Piece leftLeft = getPieceAtPosition(leftLeftPosition);
                if (isCorner(leftLeftPosition)) {
                    kill(pieces,deadPieces,left,p);
                } else if (leftLeft != null && p.getOwner().isPlayerOne() == leftLeft.getOwner().isPlayerOne()&&!leftLeft.getType().equals("♔")) {
                   kill(pieces,deadPieces,left,p);
                }
            }
        }

        if(right!=null&&p.getOwner().isPlayerOne()!=right.getOwner().isPlayerOne()&&!right.getType().equals("♔")){
            if (row + 2 > 10) {
                kill(pieces,deadPieces,right,p);
            }else {
                Position rightRightPosition = new Position(row + 2, col);
                Piece rightRight = getPieceAtPosition(rightRightPosition);
                if (isCorner(rightRightPosition)) {
                    kill(pieces,deadPieces,right,p);
                }
                else if (rightRight != null && p.getOwner().isPlayerOne() == rightRight.getOwner().isPlayerOne()&&!rightRight.getType().equals("♔")) {
                    kill(pieces,deadPieces,right,p);
                }
            }
        }
    }

    public void kill(ConcretePiece [][] pieces,ConcretePiece [][] deadPieces,Piece pieceKilled,Piece killer){
        ((ConcretePiece)killer).addKill();
        moves.push((ConcretePiece) pieceKilled);
        deadPieces[playerTurn][((ConcretePiece) pieceKilled).getId()] = (ConcretePiece) pieceKilled;
        pieces[playerTurn][((ConcretePiece) pieceKilled).getId()] = null;
    }

    @Override
    public Piece getPieceAtPosition(Position position) {
        for (int i = 0; i < 13; i++) {
            if(whitePS[i]!=null) {
                if (whitePS[i].getPosition().equals(position)) {
                    return whitePS[i];
                }
            }
        }
        for (int i = 0; i < 24; i++) {
            if(blackPS[i]!=null) {
                if (blackPS[i].getPosition().equals(position)) {
                    return blackPS[i];
                }
            }
        }
        return null;
    }

    @Override
    public Player getFirstPlayer() {
        return whitePlayer;
    }

    @Override
    public Player getSecondPlayer() {
        return blackPlayer;
    }

    @Override
    public boolean isGameFinished() {
        for(int i=0;i<24;i++){
            if(blackPS[i]!=null)
                break;
            if(i==23) {
               weHaveAWinner();
            }
        }

        int row=whitePS[0].getPosition().getRow();
        int col=whitePS[0].getPosition().getCol();
        Position position=new Position(row,col);

        if (isCorner(position)){
            weHaveAWinner();
            return true;
        }

        Piece p1=getPieceAtPosition(new Position(row+1,col));
        Piece p2=getPieceAtPosition(new Position(row -1,col));
        Piece p3=getPieceAtPosition((new Position(row,col+1)));
        Piece p4=getPieceAtPosition((new Position(row,col-1)));

        //all the ifs bellow checks if the king is surrounded
        if(p1!=null && p2!=null && p3!=null && p4!=null){
            if(!p1.getOwner().isPlayerOne() && !p2.getOwner().isPlayerOne() && !p3.getOwner().isPlayerOne() && !p4.getOwner().isPlayerOne()){
                weHaveAWinner();
                return true;
            }
        }

        if(p1!=null&&p2!=null&&p3!=null&& !isInBounds(new Position(row,col-1))){
            if(!p1.getOwner().isPlayerOne() && !p2.getOwner().isPlayerOne() && !p3.getOwner().isPlayerOne()){
                weHaveAWinner();
                return true;
            }
        }

        if(p1!=null && p2!=null && !isInBounds(new Position(row,col+1)) && p4!=null){
            if(!p1.getOwner().isPlayerOne() && !p2.getOwner().isPlayerOne() && !p4.getOwner().isPlayerOne()){
                weHaveAWinner();
                return true;
            }
        }

        if(p1!=null && !isInBounds(new Position(row -1,col)) && p3!=null && p4!=null){
            if(!p1.getOwner().isPlayerOne()  && !p3.getOwner().isPlayerOne() && !p4.getOwner().isPlayerOne()){
                weHaveAWinner();
                return true;
            }
        }

        if(!isInBounds(new Position(row+1,col)) && p2!=null && p3!=null && p4!=null){
            if(!p2.getOwner().isPlayerOne() && !p3.getOwner().isPlayerOne() && !p4.getOwner().isPlayerOne()){
                weHaveAWinner();
                return true;
            }
        }
        return false;
    }

    private boolean isCorner(Position p) {
        int row=p.getRow();
        int col=p.getCol();

        if((row==0&&col==0)||(row==0&&col==10)||(row==10&& col==0)||(row==10 && col==10)){
            return true;
        }
        return false;
    }

    public void weHaveAWinner(){
        if(playerTurn==0){
            ((ConcretePlayer)getFirstPlayer()).AddWin();
            PrintFunctions.printWhiteStats(whitePS,deadWhitePS);
            PrintFunctions.printBlackStats(blackPS,deadBlackPS);
        } else {
            ((ConcretePlayer)getSecondPlayer()).AddWin();
            PrintFunctions.printBlackStats(blackPS,deadBlackPS);
            PrintFunctions.printWhiteStats(whitePS,deadWhitePS);
        }
        System.out.println("***************************************************************************");
        PrintFunctions.printKills(whitePS,blackPS,deadWhitePS,deadBlackPS);
        System.out.println("***************************************************************************");
        PrintFunctions.printSquares(whitePS,blackPS,deadWhitePS,deadBlackPS);
        System.out.println("***************************************************************************");
        PrintFunctions.printPostions(postionsCount);
        System.out.println("***************************************************************************");
        reset();
    }

    public boolean isInBounds(Position position){
        if(position.getRow()>10||position.getRow()<0)
            return false;
        if(position.getCol()>10||position.getCol()<0)
            return false;

        return true;
    }

    @Override
    public boolean isSecondPlayerTurn() {
        return playerTurn==0;
    }

    @Override
    public void reset() {
        newGame();
    }

    @Override
    public void undoLastMove() {
        if(moves.isEmpty())
            return;

        ConcretePiece piece=moves.pop();

        if(piece.getType().equals("♔")){
            whitePS[0]=piece;
            playerTurn=(playerTurn+1)%2;
            return;
        }

        int pieceId=piece.getId();

        if(piece.getOwner().isPlayerOne()){
            //if killed restore the kill
            if(whitePS[pieceId]==null){
                while (piece.getOwner().isPlayerOne()&&whitePS[pieceId]==null) {
                    whitePS[pieceId] = piece;
                    deadWhitePS[pieceId]=null;
                    piece = moves.pop();
                    pieceId = piece.getId();
                }
                blackPS[pieceId]=piece;
            }else {
                ConcretePiece temp=whitePS[pieceId];
                ArrayList<ConcretePiece> arr=postionsCount.get(temp.getPosition());
                arr.remove(temp);
                whitePS[pieceId] = piece;
            }
        }else {
            if(blackPS[pieceId]==null){
                while(blackPS[pieceId]==null&&!piece.getOwner().isPlayerOne()) {
                    blackPS[pieceId] = piece;
                    deadBlackPS[pieceId]=null;
                    piece = moves.pop();
                    pieceId = piece.getId();
                }
                whitePS[pieceId]=piece;
            }else {
                ConcretePiece temp=blackPS[pieceId];
                ArrayList<ConcretePiece> arr=postionsCount.get(temp.getPosition());
                arr.remove(temp);
                blackPS[pieceId] = piece;
            }
        }
         playerTurn=(playerTurn+1)%2;
    }

    @Override
    public int getBoardSize() {
        return BOARD_SIZE;
    }

    public boolean isColAccessible(Position a,Position b){
        if(a.getCol()>b.getCol()){
            for (int i=1;i<a.getCol()-b.getCol();i++){
                if(getPieceAtPosition(new Position(b.getRow(),b.getCol()+i))!=null){
                    return false;
                }
            }
        }else {
            for (int i=1;i<b.getCol()-a.getCol();i++){
                if(getPieceAtPosition(new Position(b.getRow(),b.getCol()-i))!=null){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isRowAccessible(Position a,Position b){
        if(a.getRow()>b.getRow()){
            for (int i=1;i<a.getRow()-b.getRow();i++){
                if(getPieceAtPosition(new Position(a.getRow()-i,b.getCol()))!=null){
                    return false;
                }
            }
        }else {
            for (int i=1;i<b.getRow()-a.getRow();i++){
                if(getPieceAtPosition(new Position(b.getRow()-i,b.getCol()))!=null){
                    return false;
                }
            }
        }
        return true;
    }
}