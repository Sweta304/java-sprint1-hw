import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReportReader {

    private ArrayList<HashMap<Integer,Integer>> yearReport = new ArrayList<>();

    ArrayList<HashMap<Integer,Integer>> readYearReports(int year) {

        HashMap<Integer,Integer> expensesList = new HashMap<>();
        HashMap<Integer,Integer> incomesList = new HashMap<>();

        String[] yearReportsList; //list of all strings in report
        FileReader readFile = new FileReader();

        yearReportsList = readFile.readFileContentsOrNull("resources/y." + year + ".csv");
        if (yearReportsList != null) { //if report for this month exists
            for (int j = 1; j < yearReportsList.length; j++) {
                String[] separateValues = yearReportsList[j].split(",");
                if (Boolean.valueOf(separateValues[2])){
                    expensesList.put(Integer.valueOf(separateValues[0]), Integer.valueOf(separateValues[1]));
                } else {
                    incomesList.put(Integer.valueOf(separateValues[0]), Integer.valueOf(separateValues[1]));
                }

            }
            yearReport.add(incomesList);
            yearReport.add(expensesList);
        }
        System.out.println("Годовой отчет считан");
        return yearReport;
    }

}
