package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.*;
import java.util.stream.Collectors;

public class T22Analysis {
    public ObservableList<QSItem> CountryRegion1List = FXCollections.observableArrayList();
    public ObservableList<QSItem> CountryRegion2List = FXCollections.observableArrayList();
    private String CountryRegion1Name;
    private String CountryRegion2Name;

    T22Analysis(String country_region_1, String country_region_2, List<String> years) {
        List<QSItem> country1 = QSList.list.stream()
                .filter(qsItem -> (qsItem.getCountry().equals(country_region_1) || qsItem.getRegion().equals(country_region_1)) && years.contains(qsItem.getYear()))
                .collect(Collectors.toList());
        List<QSItem> country2 = QSList.list.stream()
                .filter(qsItem -> (qsItem.getCountry().equals(country_region_2) || qsItem.getRegion().equals(country_region_2)) && years.contains(qsItem.getYear()))
                .collect(Collectors.toList());


        if (country_region_1.equals ("All")){
            country1 = QSList.list.stream().filter (qsItem -> (years.contains(qsItem.getYear()))).collect(Collectors.toList());
        }

        if (country_region_2.equals("All")){
            country2 = QSList.list.stream().filter(qsItem -> (years.contains(qsItem.getYear()))).collect(Collectors.toList());
        }

        country1.sort(Comparator.comparing (QSItem::getYear));
        country2.sort(Comparator.comparing (QSItem::getYear));

        CountryRegion1List = FXCollections.observableArrayList(country1);
        CountryRegion2List = FXCollections.observableArrayList(country2);
        CountryRegion1Name = country_region_1;
        CountryRegion2Name = country_region_2;

    }

    public double calculate (ObservableList<QSItem> CountryList , String searchName){
        double sum = 0.0;
        double length = 0.0;


        for (QSItem qsItem: CountryList) {
            String scoreString = "";
            if (searchName.equals("Score")) {
                scoreString = qsItem.getScore();
            }
            else if (searchName.equals("Rank")) {
                scoreString = qsItem.getRank();
            }
            else if (searchName.equals("International Students")){
                scoreString = qsItem.getInternationalStudents();
            }
            else if (searchName.equals("Student Faculty Ratio")){
                scoreString = qsItem.getStudentFacultyRatio();
            }
            else if (searchName.equals("Faculty Count")){
                scoreString = qsItem.getFacultyCount();
            }

            if (scoreString == null){
                continue;
            }
            scoreString = scoreString.replaceAll(",", "");
            scoreString = scoreString.replaceAll("\"", "");
            scoreString = scoreString.replaceAll("\\.", "");


            double summation;
            try {
                summation = Double.parseDouble(scoreString);

            } catch (NumberFormatException e) {
                summation = 0.0;
            }

            sum += summation;

            length++;
        }
        if (length == 0.0){
            return sum;
        }

        return sum / length;
    }
    XYChart.Series<Double, String> getBarChartData(String searchName) {
        XYChart.Series<Double, String> barData= new XYChart.Series<>();
        double countryAverage1 = calculate (CountryRegion1List, searchName);
        double countryAverage2 = calculate (CountryRegion2List, searchName);

        barData.getData().add(new XYChart.Data<>(countryAverage1, CountryRegion1Name));
        barData.getData().add(new XYChart.Data<>(countryAverage2, CountryRegion2Name));

        return barData;
    }

    List<XYChart.Series<String, Double>> getLineChartData(String searchName) {
        List<XYChart.Series<String, Double>> lineData = new ArrayList<>();
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        XYChart.Series<String, Double> series2 = new XYChart.Series<>();
        series1.setName(CountryRegion1Name);
        series2.setName(CountryRegion2Name);

        List <String> yearsSelected = new ArrayList<>();

        for (QSItem qsItem: CountryRegion1List){
            yearsSelected.add(qsItem.getYear());
        }

        Set<String> uniqueYears = new HashSet<>(yearsSelected);
        yearsSelected.clear();
        yearsSelected.addAll(uniqueYears);
        Collections.sort(yearsSelected);

        ObservableList<QSItem> country1Values = FXCollections.observableArrayList();
        for (String year: yearsSelected){
            List <QSItem> filtered = CountryRegion1List.stream().filter(qsItem -> (qsItem.getYear().contains(year))).collect(Collectors.toList());
            country1Values.clear();
            country1Values.addAll(filtered);
            double countryAverage1 = calculate (country1Values,"Score");
            series1.getData().add(new XYChart.Data<>(year, countryAverage1));
        }

        List <String> yearsSelected2 = new ArrayList<>();

        for (QSItem qsItem: CountryRegion2List){
            yearsSelected2.add(qsItem.getYear());
        }

        Set<String> uniqueYears2 = new HashSet<>(yearsSelected2);
        yearsSelected2.clear();
        yearsSelected2.addAll(uniqueYears2);
        Collections.sort(yearsSelected2);

        ObservableList<QSItem> country2Values = FXCollections.observableArrayList();
        for (String year: yearsSelected2){
            List <QSItem> filtered = CountryRegion2List.stream().filter(qsItem -> (qsItem.getYear().contains(year))).collect(Collectors.toList());
            country2Values.clear();
            country2Values.addAll(filtered);
            double countryAverage2 = calculate (country2Values,"Score");

            series2.getData().add(new XYChart.Data<>(year, countryAverage2));
        }

        lineData.add(series1);
        lineData.add(series2);

        return lineData;
    }
}
