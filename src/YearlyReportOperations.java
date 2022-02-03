import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReportOperations {

    ConvertMonthNumsIntoNames month = new ConvertMonthNumsIntoNames();

    public double averageYearExpenses(ArrayList<HashMap<Integer, Integer>> yearReport) {
        int commonYearExpenses = 0;
        double averageYearExpenses = 0;
        for (int b : yearReport.get(1).keySet()) {
            commonYearExpenses = commonYearExpenses + yearReport.get(1).get(b);
        }
        averageYearExpenses = commonYearExpenses / yearReport.get(1).size();
        return averageYearExpenses;
    }

    public double averageYearIncome(ArrayList<HashMap<Integer, Integer>> yearReport) {
        int commonYearIncome = 0;
        double averageYearIncome = 0;
        for (int b : yearReport.get(0).keySet()) {
            commonYearIncome = commonYearIncome + yearReport.get(0).get(b);
        }
        averageYearIncome = commonYearIncome / yearReport.get(0).size();
        return averageYearIncome;
    }

    public int incomeByMonth(int monthNum, ArrayList<HashMap<Integer, Integer>> yearReport) {
        int incomeByMonth = 0;
        incomeByMonth = yearReport.get(0).get(monthNum);
        return incomeByMonth;
    }

    public int expenseByMonth(int monthNum, ArrayList<HashMap<Integer, Integer>> yearReport) {
        int expenseByMonth = 0;
        expenseByMonth = yearReport.get(1).get(monthNum);
        return expenseByMonth;
    }

    public int profitByMonth(int monthNum, ArrayList<HashMap<Integer, Integer>> yearReport) {
        int profitByMonth = 0;
        profitByMonth = yearReport.get(0).get(monthNum) - yearReport.get(1).get(monthNum);
        return profitByMonth;
    }

    public int monthQty(ArrayList<HashMap<Integer, Integer>> yearReport) {
        int monthQty = yearReport.get(1).size();
        return monthQty;
    }

    public void printYearReport(int year, ArrayList<HashMap<Integer, Integer>> yearReport) {
        System.out.println(year + ":\nПрибыль помесячно:");

        for (int i = 1; i <= yearReport.get(0).size(); i++) {
            System.out.println(month.monthName(i) + " - " + profitByMonth(i, yearReport));
        }
        System.out.println("Средний расход за все месяцы:");
        System.out.println(averageYearExpenses(yearReport));
        System.out.println("Средний доход за все месяцы:");
        System.out.println(averageYearIncome(yearReport));
        System.out.println("--------------");
    }
}
