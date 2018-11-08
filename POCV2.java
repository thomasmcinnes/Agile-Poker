import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class POCV2 {
    public static void main(String[] args)throws Exception {
        int finish = 80;

        String weekCSV = "C:\\Agile Poker\\scores.csv";
        //location of file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(weekCSV));
        List<String> voterResults = new ArrayList<>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            voterResults.add(line);
        }
        bufferedReader.close();

        int groupScore = 0;

        for (String lineInFile : voterResults) {
            int[] numbers = Arrays.stream(lineInFile.split(",")).mapToInt(Integer::parseInt).toArray();
            groupScore = groupScore + numbers[numbers.length-1];

        }
        String firstNum = "1";
        System.out.print(groupScore);
//        {
//            firstNum = voterResults.get(0);
//            System.out.println(firstNum);
//        }
        String lastNum;
//        {
//            lastNum = voterResults.get(voterResults.size() - 1);
//            System.out.println(lastNum);
//        }
//        (finish);
    }
}



