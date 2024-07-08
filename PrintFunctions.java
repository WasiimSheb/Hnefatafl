import java.lang.reflect.Array;
import java.util.*;
import java.util.Hashtable;

public class PrintFunctions{

    static void printWhiteStats(ConcretePiece [] whitePS,ConcretePiece [] deadWhitePS){
        for (int i=0;i<13;i++){
            if(deadWhitePS[i]!=null){
                whitePS[i]=deadWhitePS[i];
            }
        }

        Arrays.sort(whitePS,new Comparators());

        for (int i=0;i<13;i++){
            if(whitePS[i].getHistory().size()>1) {
                if (whitePS[i].getType().equals("♔")) {
                    System.out.println("K" + 7 + ": " + whitePS[i].getHistory());
                } else if (whitePS[i].getId() > 6) {
                    System.out.println("D" + (whitePS[i].getId() + 1) + ": " + whitePS[i].getHistory());
                } else {
                    System.out.println("D" + whitePS[i].getId() + ": " + whitePS[i].getHistory());
                }
            }
        }
    }

    public static void printBlackStats( ConcretePiece [] blackPS,ConcretePiece [] deadBlackPS){
        for (int i=0;i<24;i++){
            if(deadBlackPS[i]!=null){
                blackPS[i]=deadBlackPS[i];
            }
        }

        Arrays.sort(blackPS,new Comparators());

        for (int i=0;i<24;i++){
            if(blackPS[i].getHistory().size()>1) {
                System.out.println("A" +(blackPS[i].getId()+1)+ ": " + blackPS[i].getHistory());
            }
        }
    }

    public static void printKills(ConcretePiece [] whitePS,ConcretePiece [] blackPS,ConcretePiece [] deadWhitePS,ConcretePiece[] deadBlackPS){
        ConcretePiece [] arr=new ConcretePiece[37];

        for (int i=0;i<13;i++){
            if(whitePS[i]==null)
                arr[i]=deadWhitePS[i];
            else
                arr[i]=whitePS[i];
        }

        for (int i=13,j=0;i<37;i++,j++){
            if(blackPS[j]==null)
                arr[i]=deadBlackPS[j];
            else
                arr[i]=blackPS[j];
        }

        Arrays.sort(arr,new KillsComparator());

        for(int i=36;i>=0;i--){
            if(arr[i].getNumOfKills()==0)
                return;
            if(arr[i].getOwner().isPlayerOne()){
                if (arr[i].getId() < 6)
                    System.out.println("D" + arr[i].getId() + ": " + arr[i].getNumOfKills() + " kills");
                else
                    System.out.println("D" + (arr[i].getId() + 1) + ": " + arr[i].getNumOfKills() + " kills");
            }else {
                System.out.println("A"+(arr[i].getId()+1)+": "+arr[i].getNumOfKills()+" kills");
            }
        }
    }

    public static void printSquares(ConcretePiece [] whitePS,ConcretePiece [] blackPS,ConcretePiece [] deadWhitePS,ConcretePiece[] deadBlackPS){
        ConcretePiece [] arr=new ConcretePiece[37];

        for (int i=0;i<13;i++){
            if(whitePS[i]==null)
                arr[i]=deadWhitePS[i];
            else
                arr[i]=whitePS[i];
        }

        for (int i=13,j=0;i<37;i++,j++){
            if(blackPS[j]==null)
                arr[i]=deadBlackPS[j];
            else
                arr[i]=blackPS[j];
        }


        Arrays.sort(arr,new SquaresComparator());

        for(int i=36;i>=0;i--){
            if(arr[i].getNumOfSquaresTraveled()==0)
                return;
            if(arr[i].getOwner().isPlayerOne()){
                if(arr[i].getType().equals("♔"))
                    System.out.println("K7: " + arr[i].getNumOfSquaresTraveled() + " squares");
                else if (arr[i].getId() < 6)
                    System.out.println("D" + arr[i].getId() + ": " + arr[i].getNumOfSquaresTraveled() + " squares");
                else
                    System.out.println("D" + (arr[i].getId() + 1) + ": " + arr[i].getNumOfSquaresTraveled() + " squares");
            }else {
                System.out.println("A"+(arr[i].getId()+1)+": "+arr[i].getNumOfSquaresTraveled()+" squares");
            }
        }

    }

    public static void printPostions(Hashtable<Position,ArrayList<ConcretePiece>> postionsCount){

        // Step 2: Convert Hashtable to List<Map.Entry>
        List<Map.Entry<Position, ArrayList<ConcretePiece>>> list = new ArrayList<>(postionsCount.entrySet());

        // Step 3: Sort the list based on the size of ArrayList values
        Collections.sort(list, Comparator
                .comparing((Map.Entry<Position, ArrayList<ConcretePiece>> entry) -> entry.getValue().size(), Comparator.reverseOrder())
                .thenComparing(entry -> entry.getKey().getRow())
                .thenComparing(entry -> entry.getKey().getCol()));

        // Step 4: Optional - Convert the sorted list back to a LinkedHashMap
        LinkedHashMap<Position, ArrayList<ConcretePiece>> sortedHashtable = new LinkedHashMap<>();
        for (Map.Entry<Position, ArrayList<ConcretePiece>> entry : list) {
            sortedHashtable.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted Hashtable
        for (Map.Entry<Position, ArrayList<ConcretePiece>> entry : sortedHashtable.entrySet()) {
            if(entry.getValue().size()<=1)
                return;

            System.out.println(entry.getKey() + "" + entry.getValue().size()+" pieces");
        }

    }

}










 //       int i=0,j=0;
//        while(i<12&&j<24){
//            if(whitePS[i].getNumOfKills()>blackPS[j].getNumOfKills()){
//                if (whitePS[i].getId() < 6)
//                    System.out.println("D" + whitePS[i].getId() + ": " + whitePS[i].getNumOfKills() + " kills");
//                else
//                    System.out.println("D" + (whitePS[i].getId() + 1) + ": " + whitePS[i].getNumOfKills() + " kills");
//                i++;
//            }else if(whitePS[i].getNumOfKills()<blackPS[j].getNumOfKills()){
//                System.out.println("A"+(blackPS[j].getId()+1)+": "+blackPS[j].getNumOfKills()+" kills");
//                j++;
//            }else if(GameLogic.playerTurn==0){
//                if(whitePS[i].getNumOfKills()!=0) {
//                    if (whitePS[i].getId() < 6)
//                        System.out.println("D" + whitePS[i].getId() + ": " + whitePS[i].getNumOfKills() + " kills");
//                    else
//                        System.out.println("D" + (whitePS[i].getId() + 1) + ": " + whitePS[i].getNumOfKills() + " kills");
//                }
//                i++;
//            }else {
//                if(blackPS[i].getNumOfKills()!=0) {
//                    System.out.println("A" + (blackPS[j].getNumOfKills() + 1) + ": " + whitePS[i].getNumOfKills() + " kills");
//                }
//                j++;
//            }
//        }
//
//        while(i<12){
//            if(whitePS[i].getNumOfKills()!=0) {
//                if (whitePS[i].getId() < 6)
//                    System.out.println("D" + whitePS[i].getId() + ": " + whitePS[i].getNumOfKills() + " kills");
//                else
//                    System.out.println("D" + (whitePS[i].getId() + 1) + ": " + whitePS[i].getNumOfKills() + " kills");
//            }
//            i++;
//        }
//        while(j<24){
//            if(blackPS[i].getNumOfKills()!=0) {
//                System.out.println("A" + (blackPS[j].getNumOfKills() + 1) + ": " + whitePS[i].getNumOfKills() + " kills");
//            }
//            j++;
//        }







//SQUARESS
// int i=0,j=0;
//
//        while(i<12&&j<24){
//            if(whitePS[i].getNumOfSquaresTraveled()>blackPS[j].getNumOfSquaresTraveled()){
//                if(whitePS[i].getType().equals("♔")){
//                    System.out.println("k7: " + whitePS[i].getNumOfSquaresTraveled() + " squares");
//                }else if(whitePS[i].getId()<6){
//                    System.out.println("D" + whitePS[i].getId() + ": " + whitePS[i].getNumOfSquaresTraveled() + " squares");
//                }else
//                    System.out.println("D" + (whitePS[i].getId() + 1) + ": " + whitePS[i].getNumOfSquaresTraveled() + " squares");
//                i++;
//            }else if(whitePS[i].getNumOfSquaresTraveled()<blackPS[j].getNumOfSquaresTraveled()) {
//                System.out.println("A" + (blackPS[j].getId()  + 1) + ": " + blackPS[j].getNumOfSquaresTraveled() + " squares");
//                j++;
//            }else if(whitePS[i].getNumOfSquaresTraveled()!=0){
//                if(whitePS[i].getId()>6&&(whitePS[i].getId()+1)<blackPS[j].getId()){
//                    System.out.println("D" + (whitePS[i].getId() + 1) + ": " + whitePS[i].getNumOfSquaresTraveled() + " squares");
//                    i++;
//                } else if(whitePS[i].getId()<6&&whitePS[i].getId()<blackPS[j].getId()){
//                    System.out.println("D" + whitePS[i].getId()+ ": " + whitePS[i].getNumOfSquaresTraveled() + " squares");
//                    i++;
//                }else if(whitePS[i].getId()>blackPS[j].getId()){
//                    System.out.println("A" + (blackPS[j].getId() + 1) + ": " + blackPS[j].getNumOfSquaresTraveled() + " squares");
//                    j++;
//                }else if(GameLogic.playerTurn==0){
//                    if (whitePS[i].getId() < 6)
//                        System.out.println("D" + whitePS[i].getId() + ": " + whitePS[i].getNumOfSquaresTraveled() + " squares");
//                    else
//                        System.out.println("D" + (whitePS[i].getId() + 1) + ": " + whitePS[i].getNumOfSquaresTraveled() + " squares");
//                    i++;
//                }else {
//                    if(blackPS[j].getNumOfSquaresTraveled()!=0) {
//                        System.out.println("A" + (blackPS[j].getId() + 1) + ": " + blackPS[j].getNumOfSquaresTraveled() + " squares");
//                    }
//                    j++;
//                }
//            }else {
//                break;
//            }
//
//        }
//
//
//        while(i<12){
//            if(whitePS[i].getNumOfSquaresTraveled()!=0) {
//                if (whitePS[i].getId() < 6)
//                    System.out.println("D" + whitePS[i].getId() + ": " + whitePS[i].getNumOfSquaresTraveled() + " squares");
//                else
//                    System.out.println("D" + (whitePS[i].getId() + 1) + ": " + whitePS[i].getNumOfSquaresTraveled() + " squares");
//            }
//            i++;
//        }
//        while(j<24){
//            if(blackPS[i].getNumOfSquaresTraveled()!=0) {
//                System.out.println("A" + (blackPS[j].getId() + 1) + ": " + blackPS[j].getNumOfSquaresTraveled() + " squares");
//            }
//            j++;
//        }