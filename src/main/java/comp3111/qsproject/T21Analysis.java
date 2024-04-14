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

    static List <String> SortUniversity (List <String> years1) {
        //combine the two strings
        List <String> combined = new ArrayList<>(years1);
        Collections.sort (combined);
        return combined;
        //return a sorted string
    }
    T21Analysis(String uni_1, String uni_2, List<String> years) {
        List <QSItem> university1 = QSList.list.stream().filter (qsItem -> qsItem.getName().equals(uni_1) && years.contains(qsItem.year)).collect(Collectors.toList());
        List <QSItem> university2 = QSList.list.stream().filter (qsItem -> qsItem.getName().equals(uni_2) && years.contains(qsItem.year)).collect(Collectors.toList());

        university1.sort(Comparator.comparing (QSItem::getYear));
        university2.sort(Comparator.comparing (QSItem::getYear));
        /*
            Your Code Here.
            Collect the QSItem with corresponding years and university into two university lists.
            Sort university lists by the years.
            Hint: QSList.list is a static property.
         */
    }

    XYChart.Series<Double, String> getBarChartData(String searchName) {
        XYChart.Series<Double, String> barData= new XYChart.Series<>();


        // Adding rank data for University 1
        //barData.getData().add(new XYChart.Data<>(1.0, "University 1"));


        // Adding rank data for University 2
        //barData.getData().add(new XYChart.Data<>(2.0, "University 2"));

        /*
            Your Code Here.
            Return the Bar Chart Data.
            Bar Chart shows the Avg. of the selected property.
            For example, when the user chooses "score", which means the searchName will be "score"
            And Return an XYChart.Series with XYChart.Data
            [
              Average score of university2, "University 2"
              Average score of university1, "University 1"
            ]

            There are some "dirty data" in csv.
            For example, the string "3,143" or "3.143" can not transfer to Integer or Double directly.
            Careful process these data.
         */
        return barData;
    }

    List<XYChart.Series<String, Double>> getLineChartData(String searchName) {
        List<XYChart.Series<String, Double>> lineData = new ArrayList<>();
        /*
            Your Code Here.
            Fill the lineData1 and lineData2.
            Line Chart shows two lines. Each line shows the number of searchName each year.
            In our cases, the searchName will be "score"
            And Return an XYChart.Series with XYChart.Data
            [
              Series[Data<year,score>],
            ]

            There are some "dirty data" in csv.
            For example, the string "3,143" or "3.143" can not transfer to Integer or Double directly.
            Careful process these data.
         */
        return lineData;
    }
}
