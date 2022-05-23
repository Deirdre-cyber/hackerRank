import java.util.ArrayList;
import java.util.List;

public class hourGlass {

    public static void main(String[] args) {
        ArrayList<List<Integer>> grid = new ArrayList<>();
        ArrayList<Integer> rowOne = new ArrayList<>();
        rowOne.add(-1);
        rowOne.add(-1);
        rowOne.add(0);
        rowOne.add(-9);
        rowOne.add(-2);
        rowOne.add(-2);
        grid.add(rowOne);

        ArrayList<Integer> rowTwo = new ArrayList<>();
        rowTwo.add(-2);
        rowTwo.add(-1);
        rowTwo.add(-6);
        rowTwo.add(-8);
        rowTwo.add(-2);
        rowTwo.add(-5);
        grid.add(rowTwo);

        ArrayList<Integer> rowThree = new ArrayList<>();
        rowThree.add(-1);
        rowThree.add(-1);
        rowThree.add(-1);
        rowThree.add(-2);
        rowThree.add(-3);
        rowThree.add(-4);
        grid.add(rowThree);

        ArrayList<Integer> rowFour = new ArrayList<>();
        rowFour.add(-1);
        rowFour.add(-9);
        rowFour.add(-2);
        rowFour.add(-4);
        rowFour.add(-4);
        rowFour.add(-5);
        grid.add(rowFour);

        ArrayList<Integer> rowFive = new ArrayList<>();
        rowFive.add(-7);
        rowFive.add(-3);
        rowFive.add(-3);
        rowFive.add(-2);
        rowFive.add(-9);
        rowFive.add(-9);
        grid.add(rowFive);

        ArrayList<Integer> rowSix = new ArrayList<>();
        rowSix.add(-1);
        rowSix.add(-3);
        rowSix.add(-1);
        rowSix.add(-2);
        rowSix.add(-4);
        rowSix.add(-5);
        grid.add(rowSix);

        System.out.println(hourglassSum(grid));
    }

    public static int hourglassSum(List<List<Integer>> arr) {

        int largestHourglass = Integer.MIN_VALUE;

        for(int i = 0; i < arr.size()-2; i++){

            for(int j = 0; j < arr.get(i).size()-2; j++){

                int currentHourGlass = (arr.get(i).get(j) + arr.get(i).get(j + 1)
                        + arr.get(i).get(j + 2)) +
                        (arr.get(i + 1).get(j + 1)) +
                        (arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1)
                                + arr.get(i + 2).get(j + 2));

                System.out.println("Current row " + i + " Column " + j + ": " + currentHourGlass);
                if(currentHourGlass > largestHourglass){
                    largestHourglass = currentHourGlass;
                }
            }
        }

        return largestHourglass;
    }

}
