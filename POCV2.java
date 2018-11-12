import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class POCV2 {
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

            int[] numbers = Arrays.stream(lineInFile.split(",")).mapToInt(Integer::valueOf).toArray();
            //Array numbers is name. Estimates split when there a comma
            groupScore = groupScore + numbers[numbers.length-1];
            //Currently printing off the last result of each row and adding them up.
            rowResult = numbers[numbers.length-1];

            Map<Integer, Integer> valueCount = new HashMap<>();
            for(Integer number : numbers) {
                //looking at each numbers.
                valueCount.put(number, valueCount.getOrDefault(number, 0) + 1);
                // look at the values in the numbers. what are same and then what duplicates and add by one.
                // it does it for each row.
//                forMatch = (number * numbers);
            }
            for(Map.Entry<Integer, Integer> mapEntry : valueCount.entrySet()) {
                System.out.println(mapEntry.getKey() + "x" + mapEntry.getValue() + "=" + mapEntry.getKey() * mapEntry.getValue());
                // this is muliplying the estimate number by how many voted it. Could be valuable later on.
                System.out.println("The duplicate values are power of the amount people voted it" + Math.pow(mapEntry.getKey(),mapEntry.getValue()));
            }

            System.out.println("Duplicate values are: " + valueCount);
            //System.out.println(forMatch);
            //prints each rows duplicates.
        }


        System.out.println("this is all the estimate results added together : "+ groupScore);
        //the results added up
        System.out.println("This is the last number(group estimate) : " + rowResult);
        //print last estimate on a row
        //System.out.println(withoutDuplicates);

    }
}



