package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.*;
import java.util.stream.Collectors;

public class T21Analysis {
    public ObservableList<QSItem> University1List = FXCollections.observableArrayList();
    public ObservableList<QSItem> University2List = FXCollections.observableArrayList();
    private String University1Name;
    private String University2Name;



    T21Analysis(String uni_1, String uni_2, List<String> years) {
        List <QSItem> university1 = QSList.list.stream().filter (qsItem -> qsItem.getName().equals(uni_1) && years.contains(qsItem.year)).collect(Collectors.toList());
        List <QSItem> university2 = QSList.list.stream().filter (qsItem -> qsItem.getName().equals(uni_2) && years.contains(qsItem.year)).collect(Collectors.toList());

        university1.sort(Comparator.comparing (QSItem::getYear));
        university2.sort(Comparator.comparing (QSItem::getYear));

        University1List = FXCollections.observableArrayList(university1);
        University2List = FXCollections.observableArrayList(university2);
        University1Name = uni_1;
        University2Name = uni_2;
    }

    public double calculate (ObservableList<QSItem> UniversityList , String searchName){
        double sum = 0.0;
        double length = 0.0;


        for (QSItem qsItem: UniversityList) {
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
        double displayAverage1 = calculate (University1List, searchName);
        double displayAverage2 = calculate (University2List, searchName);


        barData.getData().add(new XYChart.Data<>(displayAverage1, University1Name));
        barData.getData().add(new XYChart.Data<>(displayAverage2, University2Name));


        return barData;
    }

    List<XYChart.Series<String, Double>> getLineChartData(String searchName) {
        List<XYChart.Series<String, Double>> lineData = new ArrayList<>();
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        XYChart.Series<String, Double> series2 = new XYChart.Series<>();
        series1.setName(University1Name);
        series2.setName(University2Name);

        for (QSItem qsItem: University1List) {
            String year = qsItem.getYear();
            String scoreString = qsItem.getScore();

            if (scoreString == null){
                continue;
            }

            scoreString = scoreString.replaceAll(",", "");
            scoreString = scoreString.replaceAll("\"", "");
            scoreString = scoreString.replaceAll("\\.", "");


            double score;
            try {
                score = Double.parseDouble(scoreString);
            } catch (NumberFormatException e) {
                score = 0.0; // Default value for invalid scores
            }

            series1.getData().add(new XYChart.Data<>(year, score));
        }

        for (QSItem qsItem2: University2List) {
            String year = qsItem2.getYear();
            String scoreString = qsItem2.getScore();

            if (scoreString == null){
                continue;
            }
            scoreString = scoreString.replaceAll(",", "");
            scoreString = scoreString.replaceAll("\"", "");
            scoreString = scoreString.replaceAll("\\.", "");


            double score;
            try {
                score = Double.parseDouble(scoreString);
            } catch (NumberFormatException e) {
                score = 0.0; // Default value for invalid scores
            }

            series2.getData().add(new XYChart.Data<>(year, score));
        }

        lineData.add(series1);
        lineData.add(series2);

        return lineData;
    }
}
