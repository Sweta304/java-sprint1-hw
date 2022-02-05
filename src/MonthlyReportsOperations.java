import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReportsOperations {

    private ConvertMonthNumsIntoNames month = new ConvertMonthNumsIntoNames();

    private int commonCashFlow(String isExpense, int monthNumber, HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports){
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

    public int commonExpensesByMonth(int monthNumber, HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports) {
        int commonExpenses = commonCashFlow("TRUE",monthNumber,monthlyReports);
        return commonExpenses;
    }

    public int commonIncomesByMonth(int monthNumber, HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports) {
        int commonIncomes = commonCashFlow("FALSE",monthNumber,monthlyReports);
        return commonIncomes;
    }

    private String findItem(String isExpense, int monthNumber, HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports) {
        String foundItem;
        int maxProfit = 0;
        String theMostProfitableItem = null;
        HashMap<String, ArrayList<String>> monthReport = monthlyReports.get(monthNumber);
        ArrayList<String> itemsValues;

        for (String i : monthReport.keySet()) {
            itemsValues = monthReport.get(i);
            if (itemsValues.get(0).equals(isExpense)) {
                int itemProfit = Integer.valueOf(itemsValues.get(1)) * Integer.valueOf(itemsValues.get(2));
                if (itemProfit > maxProfit) {
                    maxProfit = itemProfit;
                    theMostProfitableItem = i;
                }
            }
        }
        foundItem = theMostProfitableItem + " - " + maxProfit;
        return foundItem;
    }

    public void theMostProfitableItem(int monthNumber, HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports) {
        String foundItem = findItem("FALSE",monthNumber,monthlyReports);
        System.out.println("самый прибыльный товар: " + foundItem);
    }

    public void theMostExpenseItem(int monthNumber, HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports) {
        String foundItem = findItem("TRUE",monthNumber,monthlyReports);
        System.out.println("самая большая трата: " + foundItem);
    }

    public void printMonthReport(HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports) {
        for (int i = 1; i <= monthlyReports.size(); i++) {
            System.out.println(month.monthName(i) + ":");
            theMostProfitableItem(i, monthlyReports);
            theMostExpenseItem(i, monthlyReports);
            System.out.println("--------------");
        }

    }

}
