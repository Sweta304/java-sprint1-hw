import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int year = 0;

        HashMap<Integer, HashMap<String, ArrayList<String>>> monthlyReports = new HashMap<>();
        ArrayList<HashMap<Integer, Integer>> yearReport = new ArrayList<>();
        boolean isMonthReportsCalled = false;
        boolean isYearReportCalled = false;

        YearlyReportReader yearlyReportReader = new YearlyReportReader();
        MonthlyReportReader monthlyReportReader = new MonthlyReportReader();
        MonthlyReportsOperations monthlyReportsOperations = new MonthlyReportsOperations();
        YearlyReportOperations yearlyReportOperations = new YearlyReportOperations();


        while (true) {
            printMenu();
            int command;
            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите числовое значение");
                break;
            }
            if (command == 1) {
                monthlyReports = monthlyReportReader.readMonthlyReports();
                isMonthReportsCalled = true;
            } else if (command == 2) {
                System.out.println("введите год для считывания отчета");
                year = scanner.nextInt();
                yearReport = yearlyReportReader.readYearReports(year);
                isYearReportCalled = true;
            } else if (command == 3) {
                if (isMonthReportsCalled & isYearReportCalled) {
                    ReportsMatching reportsMatching = new ReportsMatching(year, monthlyReports, yearReport);
                    reportsMatching.reportsMatching(yearlyReportOperations.monthQty(yearReport));
                } else {
                    System.out.println("Сначала считайте все месячные и годовой отчеты");
                    break;
                }
            } else if (command == 4) {
                if (isMonthReportsCalled) {
                    monthlyReportsOperations.printMonthReport(monthlyReports);
                } else {
                    System.out.println("Сначала считайте все месячные отчеты");
                    break;
                }
            } else if (command == 5) {
                if (isYearReportCalled) {
                    yearlyReportOperations.printYearReport(year, yearReport);
                } else {
                    System.out.println("Сначала считайте годовой отчет");
                    break;
                }
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }

    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Считать все месячные отчёты\n" +
                "2 - Считать годовой отчёт\n" +
                "3 - Сверить отчёты\n" +
                "4 - Вывести информацию о всех месячных отчётах\n" +
                "5 - Вывести информацию о годовом отчёте\n" +
                "0 - Завершить программу");
    }

}

