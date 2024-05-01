package comp3111.qsproject;

import javafx.scene.chart.PieChart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class T1AnalysisTest {

        /*
    @Test
    void DataTabletest() {
        QSList.initialize();
        String year = "2018";


        T1Analysis tester = new T1Analysis(year);
        //List <QSItem> expectedTable = new
        //Assertions.assertEquals(tester.getTableList(),

    }
    */


    @Test
    void PieChartDatatest() {
        QSList.initialize();
        String year = "2019";

        T1Analysis tester = new T1Analysis(year);
        ObservableList<PieChart.Data> ExpectedpieChartData= FXCollections.observableArrayList();

        /*
        2019 size data:
        XL: 5979
        L: 9651
        M: 2972
        S: 887
         */
        ExpectedpieChartData.add(new PieChart.Data("L: 9651", 9651));
        ExpectedpieChartData.add(new PieChart.Data("XL: 5979", 5979));
        ExpectedpieChartData.add(new PieChart.Data("M: 2972", 2972));
        ExpectedpieChartData.add(new PieChart.Data("S: 887", 887));
        assertEquals(ExpectedpieChartData,tester.getPieChartData("size"));
    }

}