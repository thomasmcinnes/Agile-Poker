import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class POCV2<groupScore, rowResult> {
    public static void main(String[] args)throws Exception {
        String weekCSV = "C:\\Agile Poker\\scores.csv";
        //location of file \\ are escape characters. So code can compile the code.
        BufferedReader bufferedReader = new BufferedReader(new FileReader(weekCSV));
        //reads the file(weekCSV)
        List<String> voterResults = new ArrayList<>();
        //voterResults into new Array

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            voterResults.add(line);
            // add a line to read if line is not null
        }
        bufferedReader.close();

        int groupScore = 0;
        int rowResult = 0;


        for (String lineInFile : voterResults) {
            // lineInFile is the row containing all the estimates
            //voterResults is the name for each row

            int[] numbers = Arrays.stream(lineInFile.split(",")).mapToInt(Integer::parseInt).toArray();
            //Array numbers is name. Estimates split when there a comma
            groupScore = groupScore + numbers[numbers.length-1];
            //Currently printing off the last result of each row and adding them up.
            rowResult = numbers[numbers.length-1];

        }
        String firstNum = "1";
        System.out.println("this is all the estimate results added together : "+ groupScore);
        //the results added up
        System.out.println(rowResult);
        //print last estimate on a row 


    }
}



