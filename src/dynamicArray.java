import java.util.ArrayList;
import java.util.List;

public class dynamicArray {
    public static void main(String[] args) {
        int n = 2;
        ArrayList<ArrayList<String>> queriesAsString = new ArrayList<>();

        //account for numbers greater than one digit in length!
        ArrayList<String> rowOne = new ArrayList<>();
        rowOne.add("2 5");
        queriesAsString.add(rowOne);

        ArrayList<String> rowTwo = new ArrayList<>();
        rowTwo.add("1 0 5");
        queriesAsString.add(rowTwo);

        ArrayList<String> rowThree = new ArrayList<>();
        rowThree.add("1 1 7");
        queriesAsString.add(rowThree);

        ArrayList<String> rowFour = new ArrayList<>();
        rowFour.add("1 0 3");
        queriesAsString.add(rowFour);

        ArrayList<String> rowFive = new ArrayList<>();
        rowFive.add("2 1 0");
        queriesAsString.add(rowFive);

        ArrayList<String> rowSix = new ArrayList<>();
        rowSix.add("2 1 1");
        queriesAsString.add(rowSix);

        //parse string array
        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
        ArrayList<ArrayList<Integer>> numList = new ArrayList<>();

        for (int i = 0; i < queriesAsString.size(); i++){

            ArrayList<Integer> row = new ArrayList<>();

            for(int j = 0; j < queriesAsString.get(i).size(); j++){

                int firstNum = Integer.parseInt(queriesAsString.get(i).get(j).substring(0, 1));
                row.add(firstNum);

                int secondNum = Integer.parseInt(queriesAsString.get(i).get(j).substring(2, 3));
                row.add(secondNum);

                if(i != 0){
                    int thirdNum = Integer.parseInt(queriesAsString.get(i).get(j).substring(4));
                    row.add(thirdNum);
                }

                numList.add(row);
            }
        }
        //System.out.println(numList);
        System.out.println(dynamicArray(n, numList));
    }

    public static ArrayList<Integer> dynamicArray(int n, ArrayList<ArrayList<Integer>> queries) {

        ArrayList<Integer> answers = new ArrayList<>();

        int lastAnswer = 0;
        int numQueries = queries.size();

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        //Add empty arrays x n
        for(int i = 0; i < n; i++){
            arr.add(new ArrayList<Integer>());
        }

        //do queries on arrays
        for(int j = 1; j < numQueries; j++){

            int x = queries.get(j).get(1);
            int y = queries.get(j).get(2);

            if(queries.get(j).get(0) == 1){
                int idx = ((x ^ lastAnswer) % n);
                arr.get(idx).add(y);
            }
            else {
                if(arr.size() != 0){
                    int idx = ((x ^ lastAnswer) % n);
                    lastAnswer = arr.get(idx).get(y % (arr.get(idx).size()));
                    answers.add(lastAnswer);
                }
            }
        }

        return answers;
    }
}


