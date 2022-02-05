import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReportReader {

    private HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports = new HashMap<>();

    HashMap<Integer, HashMap<String, ArrayList<String>>> readMonthlyReports() {

        for (int i = 1; i <= 12; i++) {

            String[] monthlyReportsList; //list of all strings in report
            FileReader readFile = new FileReader();
            HashMap<String, ArrayList<String>> oneMonthReport = new HashMap<>();

            monthlyReportsList = readFile.readFileLinesOrNull("resources" + File.separatorChar + "m.20210" + i + ".csv"); //read all month reports
            if (monthlyReportsList != null) { //if report for this month exists
                for (int j = 1; j < monthlyReportsList.length; j++) {
                    ArrayList<String> itemValues = new ArrayList<>();
                    String[] separateValues = monthlyReportsList[j].split(",");
                    itemValues.add(separateValues[1]);
                    itemValues.add(separateValues[2]);
                    itemValues.add(separateValues[3]);
                    oneMonthReport.put(separateValues[0], itemValues);

                }
                monthlyReports.put(i, oneMonthReport);
            }
        }
        System.out.println("Все месячные отчеты считаны");
        return monthlyReports;
    }
}