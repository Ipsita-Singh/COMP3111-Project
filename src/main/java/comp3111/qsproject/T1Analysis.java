package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.util.*;
import java.util.stream.Collectors;

public class T1Analysis {
    public ObservableList<QSItem> tableList = FXCollections.observableArrayList();
    T1Analysis (String year) {
        /*
            Your Code Here.
            Collect the QSItem with corresponding years into tableList.
            Use static properties in QSList here.
            Hint: QSList.list is a static property.
         */
        List <QSItem> tList = QSList.list.stream().filter(qsItem -> qsItem.getYear().equals(year)).collect(Collectors.toList());
        tableList = FXCollections.observableArrayList(tList);
    }

    ObservableList<QSItem> getTableList() {
        return tableList;
    }

    ObservableList<PieChart.Data> getPieChartData(String searchName) {
        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList();
        /*
            Your Code Here.
            Return the Pie Chart Data.
            Pie Chart shows the SUM of the score.
            For example, when the user chooses "size", which means the searchName will be "size"
            And Return an ObservableList with PieChart.Data
            [
                key: "L", value: the Sum score of the Large size universities,
                key: "M", value: the Sum score of the Middle size universities,
                key: "S", value: the Sum score of the Small size universities,
            ]
         */
        Map<String, Double> scoreMap = new HashMap<>();

        // Iterate over the tableList
        for (QSItem item : tableList) {
            // Get the attribute value based on searchName
            String attributeValue = item.getProperty(searchName);
            // Get the score of the item
            // Add the score to the corresponding attribute value in the map
            if (!item.getScore().isEmpty()) {
                Double score = Double.valueOf(item.getScore());
                scoreMap.put(attributeValue, (Double)scoreMap.getOrDefault(attributeValue, 0.0) + score);
            }
        }

        // Convert the map to PieChart.Data and add to pieChartData
        for (Map.Entry<String, Double> entry : scoreMap.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey() + ": " + Math.round(entry.getValue()), Math.round(entry.getValue())));
        }

        // Sort the list based on the pie chart data values
        Collections.sort(pieChartData, (o1, o2) -> Double.compare(o2.getPieValue(), o1.getPieValue()));

        if (pieChartData.size() > 10){
            int otherScore = 0;
            for (int i = 9; i < pieChartData.size(); i++){
                otherScore += pieChartData.get(i).getPieValue();
            }

            pieChartData.remove(9, pieChartData.size());

            pieChartData.add(new PieChart.Data("Others: " + otherScore, otherScore));

        }

        System.out.println(pieChartData);
        return pieChartData;
    }

    XYChart.Series<String, Double> getBarChartData(String searchName) {
        XYChart.Series<String, Double> barData= new XYChart.Series<>();
        /*
            Your Code Here.
            Return the Bar Chart Data.
            Bar Chart shows the Avg. of the score.
            For example, when the user chooses "size", which means the searchName will be "size"
            And Return an XYChart.Series with XYChart.Data
            [
                key: "L", value: the Average score of the Large size universities,
                key: "M", value: the Average score of the Middle size universities,
                key: "S", value: the Average score of the Small size universities,
            ]
         */
        Map<String, Double> scoreMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        // Iterate over the tableList
        for (QSItem item : tableList) {
            // Get the attribute value based on searchName
            String attributeValue = item.getProperty(searchName);
            // Get the score of the item
            // Add the score to the corresponding attribute value in the map
            if (!item.getScore().isEmpty()) {
                countMap.put(attributeValue, countMap.getOrDefault(attributeValue, 0) + 1);

                Double score = Double.valueOf(item.getScore());
                scoreMap.put(attributeValue, ((Double)scoreMap.getOrDefault(attributeValue, 0.0) * (countMap.get(attributeValue)-1) + score)/countMap.get(attributeValue));
            }
        }

        // Convert the map to PieChart.Data and add to pieChartData
        for (Map.Entry<String, Double> entry : scoreMap.entrySet()) {
            barData.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        // Sort the list based on the bar chart data values
        Collections.sort(barData.getData(), (o1, o2) -> Double.compare(o2.getYValue().doubleValue(), o1.getYValue().doubleValue()));


        if (barData.getData().size() > 10){
            double otherScore = 0;
            int count = 0;
            for (int i = 9; i < barData.getData().size(); i++){
                int tempcount = countMap.get(barData.getData().get(i).getXValue());
                otherScore = ((otherScore * count + barData.getData().get(i).getYValue() * tempcount) / (tempcount + count));
            }

            barData.getData().remove(9, barData.getData().size());

            barData.getData().add(new XYChart.Data<>("Others", ( (double)otherScore)));

        }

        return barData;
    }


}
