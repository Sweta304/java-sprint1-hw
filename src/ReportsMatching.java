/*
- Подсчитывать две суммы: общие доходы и общие расходы по каждому из месяцев.
- Сверять полученные суммы с суммой доходов и расходов в отчёте по году.
Если обнаружена ошибка, программа должна выводить месяц, в котором обнаружено несоответствие.
Если ошибок не обнаружено, должна выводиться только информация об успешном завершении операции.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class ReportsMatching {

    int year;
    private HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports = new HashMap<>();
    private ArrayList<HashMap<Integer,Integer>> yearReport = new ArrayList<>();

    ReportsMatching (int year, HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports, ArrayList<HashMap<Integer,Integer>> yearReport){
        this.year=year;
        this.monthlyReports=monthlyReports;
        this.yearReport=yearReport;
    }

    private MonthlyReportsOperations monthlyReportOperations = new MonthlyReportsOperations();
    private YearlyReportOperations yearlyReportOperations = new YearlyReportOperations();
    private ConvertMonthNumsIntoNames months = new ConvertMonthNumsIntoNames();

    void reportsMatching (int monthQty){
        for(int i=1;i<=monthQty;i++){
            int expenseFromMonthReport = monthlyReportOperations.commonExpensesByMonth(i,monthlyReports);
            int incomeFromMonthReport = monthlyReportOperations.commonIncomesByMonth(i,monthlyReports);
            int expenseFromYearReport = yearlyReportOperations.expenseByMonth(i,yearReport);
            int incomeFromYearReport = yearlyReportOperations.incomeByMonth(i,yearReport);


            if ((expenseFromMonthReport!=expenseFromYearReport) || (incomeFromMonthReport!=incomeFromYearReport)){
                System.out.println("Несоответствие в месяце - "+months.monthName(i));
            }
        }
        System.out.println("Сверка выполнена успешно");
    }

}
