import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReportsOperations {

    ConvertMonthNumsIntoNames month = new ConvertMonthNumsIntoNames();

    int commonExpensesByMonth(int monthNumber, HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports) {
        int commonExpenses = 0;
        HashMap<String, ArrayList<String>> monthReport = monthlyReports.get(monthNumber);
        ArrayList<String> itemsValues;

        for (String i : monthReport.keySet()) {
            itemsValues = monthReport.get(i);
            if (itemsValues.get(0).equals("TRUE")) {
                commonExpenses = commonExpenses + (Integer.valueOf(itemsValues.get(1)) * Integer.valueOf(itemsValues.get(2)));
            }
        }
        return commonExpenses;
    }

    int commonIncomesByMonth(int monthNumber, HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports) {
        int commonIncomes = 0;
        HashMap<String, ArrayList<String>> monthReport = monthlyReports.get(monthNumber);
        ArrayList<String> itemsValues;

        for (String i : monthReport.keySet()) {
            itemsValues = monthReport.get(i);
            if (itemsValues.get(0).equals("FALSE")) {
                commonIncomes = commonIncomes + (Integer.valueOf(itemsValues.get(1)) * Integer.valueOf(itemsValues.get(2)));
            }
        }
        return commonIncomes;
    }

    void theMostProfitableItem(int monthNumber, HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports) {
        int maxProfit = 0;
        String theMostProfitableItem = null;
        HashMap<String, ArrayList<String>> monthReport = monthlyReports.get(monthNumber);
        ArrayList<String> itemsValues;

        for (String i : monthReport.keySet()) {
            itemsValues = monthReport.get(i);
            if (itemsValues.get(0).equals("FALSE")) {
                int itemProfit = Integer.valueOf(itemsValues.get(1)) * Integer.valueOf(itemsValues.get(2));
                if (itemProfit > maxProfit) {
                    maxProfit = itemProfit;
                    theMostProfitableItem = i;
                }
            }
        }
        System.out.println("самый прибыльный товар: " + theMostProfitableItem + " - " + maxProfit);
    }

    void theMostExpenseItem(int monthNumber, HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports) {
        int maxExpense = 0;
        String theMostExpenseItem = null;
        HashMap<String, ArrayList<String>> monthReport = monthlyReports.get(monthNumber);
        ArrayList<String> itemsValues;

        for (String i : monthReport.keySet()) {
            itemsValues = monthReport.get(i);
            if (itemsValues.get(0).equals("TRUE")) {
                int itemProfit = Integer.valueOf(itemsValues.get(1)) * Integer.valueOf(itemsValues.get(2));
                if (itemProfit > maxExpense) {
                    maxExpense = itemProfit;
                    theMostExpenseItem = i;
                }
            }
        }
        System.out.println("самая большая трата: " + theMostExpenseItem + " - " + maxExpense);
    }

    void printMonthReport(HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports) {
        for (int i = 1; i <= monthlyReports.size(); i++) {
            System.out.println(month.monthName(i) + ":");
            theMostProfitableItem(i, monthlyReports);
            theMostExpenseItem(i, monthlyReports);
            System.out.println("--------------");
        }

    }

}
