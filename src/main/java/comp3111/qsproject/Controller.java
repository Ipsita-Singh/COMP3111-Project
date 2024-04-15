package comp3111.qsproject;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Controller {

    /* T1 Controller */
    public TableView<QSItem> t1DataTable;

    @FXML
    public ChoiceBox<String> t1YearChoiceBox;

    @FXML
    public BarChart<String, Double> t1BarChart;

    @FXML
    public TableColumn<QSItem, String> t1Rank;

    @FXML
    public TableColumn<QSItem, String> t1University;

    @FXML
    public TableColumn<QSItem, String> t1Score;

    @FXML
    public TableColumn<QSItem, String> t1Country;

    @FXML
    public TableColumn<QSItem, String> t1City;

    @FXML
    public TableColumn<QSItem, String> t1Type;

    @FXML
    public PieChart t1PieChart;

    @FXML
    public ChoiceBox<String> t1PieChartChoiceBox;

    @FXML
    public Label t1PieChartLabel;

    @FXML
    public ChoiceBox<String> t1BarChartChoiceBox;

    @FXML
    public Label t1BarChartLabel;

    @FXML
    public CategoryAxis t1BarChartTypeXaxis;

    /* T2 Controller */
    @FXML
    public ChoiceBox<String> t2University1ChoiceBox;
    @FXML
    public ChoiceBox<String> t2University2ChoiceBox;

    @FXML
    public Label error1;

    @FXML
    public Label error2;
    @FXML
    public ComboBox<String> FieldSelect;

    @FXML
    public ChoiceBox<String> t2CountryRegion1ChoiceBox;
    @FXML
    public ChoiceBox<String> t2CountryRegion2ChoiceBox;

    @FXML
    public CheckBox t22017CheckBox;
    @FXML
    public CheckBox t22018CheckBox;
    @FXML
    public CheckBox t22019CheckBox;
    @FXML
    public CheckBox t22020CheckBox;
    @FXML
    public CheckBox t22021CheckBox;
    @FXML
    public CheckBox t22022CheckBox;
    @FXML
    public CheckBox t22017CheckBox2;
    @FXML
    public CheckBox t22018CheckBox2;
    @FXML
    public CheckBox t22019CheckBox2;
    @FXML
    public CheckBox t22020CheckBox2;
    @FXML
    public CheckBox t22021CheckBox2;
    @FXML
    public CheckBox t22022CheckBox2;

    @FXML
    public BarChart<Double, String> t21RankBarChart;
    @FXML
    public BarChart<Double, String> t21ScoreBarChart;
    @FXML
    public BarChart<Double, String> t21FacultyBarChart;
    @FXML
    public BarChart<Double, String> t21InternationalBarChart;
    @FXML
    public BarChart<Double, String> t21SFRBarChart;
    @FXML
    public LineChart<String, Double> t21LineChart;

    @FXML
    public BarChart<Double, String> t22RankBarChart;
    @FXML
    public BarChart<Double, String> t22ScoreBarChart;
    @FXML
    public BarChart<Double, String> t22FacultyBarChart;
    @FXML
    public BarChart<Double, String> t22InternationalBarChart;
    @FXML
    public BarChart<Double, String> t22SFRBarChart;
    @FXML
    public LineChart<String, Double> t22LineChart;

    /* T3 Controller */

    @FXML
    public TextField t3TopRankTextField;
    @FXML
    public TextField t3BottomRankTextField;
    @FXML
    public ChoiceBox<String> t3TypeChoiceBox;
    @FXML
    public ChoiceBox<String> t3RegionChoiceBox;
    @FXML
    public TableView<RecommendItem> t3TableView;

    @FXML
    public TableColumn<RecommendItem, String> t3University;

    @FXML
    public TableColumn<RecommendItem, String> t3BestYear;

    @FXML
    public TableColumn<RecommendItem, String> t3BestRank;

    @FXML
    public TableColumn<RecommendItem, String> t3RecentYear;

    @FXML
    public TableColumn<RecommendItem, String> t3RecentRank;

    ObservableList<String> yearList = FXCollections.observableArrayList("2017", "2018", "2019", "2020", "2021", "2022");
    ObservableList<String> stringPropertyList = FXCollections.observableArrayList("country", "region", "size", "type", "researchOutput");

    @FXML
    private void initialize() {
        // Whole Program Information
        QSList.initialize();
        // T1
        t1YearChoiceBox.setItems(yearList);
        t1YearChoiceBox.setValue("2017");
        t1PieChartChoiceBox.setItems(stringPropertyList);
        t1PieChartChoiceBox.setValue("size");
        t1PieChartLabel.setText("");
        t1BarChartChoiceBox.setItems(stringPropertyList);
        t1BarChartChoiceBox.setValue("type");
        t1BarChartLabel.setText("");
        // T2
        /*
            Your Code Here.
            1. Initialize the Choice boxes of university.
            2. Initialize the Choice boxes of country/region.
            3. For choice boxes of country/region,
                you need to add a blank or "All" option representing selection of all the country/region.
         */
        //t2University1ChoiceBox.setItems(FXCollections.observableArrayList("Amherst", "United", "HKUST"));
        ObservableList<String> sortedUniversity = QSList.university;
        Collections.sort(sortedUniversity, Comparator.naturalOrder());
        t2University1ChoiceBox.setItems(sortedUniversity);
        t2University2ChoiceBox.setItems(sortedUniversity);

        ObservableList<String> sortedCountry = QSList.country;
        ObservableList<String> sortedRegion = QSList.region;
        Collections.sort(sortedCountry, Comparator.naturalOrder());
        Collections.sort(sortedRegion, Comparator.naturalOrder());

        ObservableList<String> combinedList = FXCollections.observableArrayList();
        combinedList.addAll(sortedCountry);
        combinedList.addAll(sortedRegion);
        combinedList.add("All");

        t2CountryRegion1ChoiceBox.setItems(combinedList);
        t2CountryRegion2ChoiceBox.setItems(combinedList);

        //xAxis.setText ("Avg. Rank");
        FieldSelect.setItems(FXCollections.observableArrayList("Rank", "Score", "Faculty Count", "International Student", "Student Faculty Ratio"));
        // T3
        /*
            Your Code Here.
            1. Initialize the Choice boxes of type.
            2. Initialize the Choice boxes of region.
            3. For choice boxes of region,
                you need to add a blank or "All" option representing selection of all the region.
         */
    }

    @FXML
    private void T1_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task1. (including the choice box, labels and charts)
         */
    }

    @FXML
    private void T1_onClickSearch() {
        /*
            Your Code Here.
            When click search on Task1:
                1. Fetch the year from the choice box.
                2. Clear previous data.
                3. Make an Analyser.
                4. Update the Table view, which shows Information about universities.
                5. Update the Pie Chart, which shows the sum score of selected property (t1PieChartChoiceBox).
                6. Update the Bar Chart, which shows the average score of selected property (t1BarChartChoiceBox).
            Please notice that we need listeners for monitoring the changes of choice box in pie chart and bar chart.
         */
    }

    @FXML
    private void T21_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task 2.1. (including the choice boxes, check boxes and charts)
         */
        //clear Universities and Combo Box
        t2University1ChoiceBox.setValue(null);
        t2University2ChoiceBox.setValue(null);
        FieldSelect.setValue(null);

        //Clear Years
        t22017CheckBox.setSelected(false);
        t22018CheckBox.setSelected(false);
        t22019CheckBox.setSelected(false);
        t22020CheckBox.setSelected(false);
        t22021CheckBox.setSelected(false);
        t22022CheckBox.setSelected(false);

        //Clear Error message
        error1.setText("");
        //xAxis.setText("Avg. Rank");

        //Clear Charts
        t21RankBarChart.getData().clear();
        t21InternationalBarChart.getData().clear();
        t21FacultyBarChart.getData().clear();
        t21ScoreBarChart.getData().clear();
        t21SFRBarChart.getData().clear();
        t21LineChart.getData().clear();

    }

    @FXML
    private void T21_onClickCompare() {
        //Set error text as empty
        error1.setText("");


        String university1 = t2University1ChoiceBox.getValue();
        String university2 = t2University2ChoiceBox.getValue();


        boolean yearCondition = false;
        List <String> SelectedYears = new ArrayList<>();
        if (t22017CheckBox.isSelected()){
            SelectedYears.add("2017");
            yearCondition = true;
        }
        if (t22018CheckBox.isSelected()){
            SelectedYears.add("2018");
            yearCondition = true;
        }
        if (t22019CheckBox.isSelected()){
            SelectedYears.add("2019");
            yearCondition = true;
        }
        if (t22020CheckBox.isSelected()){
            SelectedYears.add("2020");
            yearCondition = true;
        }
        if (t22021CheckBox.isSelected()){
            SelectedYears.add("2021");
            yearCondition = true;
        }
        if (t22022CheckBox.isSelected()){
            SelectedYears.add("2022");
            yearCondition = true;
        }


        if (university1 == null && university2 == null && yearCondition == false){
            error1.setText("Please Select University 1, University 2 and Year");
        }
        else if (university2 == null && university1 == null){
            error1.setText("Please Select University 1 and University 2");
        }
        else if (university2 == null && yearCondition == false){
            error1.setText("Please Select University2 and Year");
        }
        else if (university1 == null && yearCondition == false){
            error1.setText("Please Select University 1 and Year");
        }
        else if (university1 == null){
            error1.setText ("Please Select University 1");
        }
        else if (university2 == null){
            error1.setText("Please Select University 2");
        }
        else if (yearCondition == false){
            error1.setText ("Please Select Year");
        }
        else{
            t21RankBarChart.getData().clear();
            t21InternationalBarChart.getData().clear();
            t21FacultyBarChart.getData().clear();
            t21ScoreBarChart.getData().clear();
            t21SFRBarChart.getData().clear();
            t21LineChart.getData().clear();

            T21Analysis analyzer = new T21Analysis (university1, university2, SelectedYears);
            XYChart.Series<Double, String> barChartData = analyzer.getBarChartData("Rank");
            t21RankBarChart.getData().add(barChartData);

            XYChart.Series<Double, String> barChartData2 = analyzer.getBarChartData("Score");
            t21ScoreBarChart.getData().add(barChartData2);

            XYChart.Series<Double, String> barChartData3 = analyzer.getBarChartData("Student Faculty Ratio");
            t21SFRBarChart.getData().add(barChartData3);

            XYChart.Series<Double, String> barChartData4 = analyzer.getBarChartData("International Students");
            t21InternationalBarChart.getData().add(barChartData4);

            XYChart.Series<Double, String> barChartData5 = analyzer.getBarChartData("Faculty Count");
            t21FacultyBarChart.getData().add(barChartData5);

            List<XYChart.Series<String, Double>> lineChartData = analyzer.getLineChartData("Score");
            t21LineChart.getData().addAll(lineChartData);
        }

        //Analyzer
        /*
        if (university1 != null && university2 != null && yearCondition == true){
            T21Analysis analyzer = new T21Analysis (university1, university2, SelectedYears);
        }
        */
        /*
            Your Code Here.
            When click search on Task2.1:
                1. Fetch the two universities from the choice box.
                2. Fetch the selected years.
                3. Clear previous data.
                4. Make an Analyser.
                5. Update the Bar Charts, which shows the average of selected property.
                6. Update the line Chart, which shows two lines of score of each year.
         */
    }



    @FXML
    private void T22_onClickClear() {
        //Clear Countries/regions
        t2CountryRegion1ChoiceBox.setValue(null);
        t2CountryRegion2ChoiceBox.setValue(null);

        //Clear Years
        t22017CheckBox2.setSelected(false);
        t22018CheckBox2.setSelected(false);
        t22019CheckBox2.setSelected(false);
        t22020CheckBox2.setSelected(false);
        t22021CheckBox2.setSelected(false);
        t22022CheckBox2.setSelected(false);

        //Clear Error Message
        error2.setText("");

        //Clear Charts
        t22RankBarChart.getData().clear();
        t22InternationalBarChart.getData().clear();
        t22FacultyBarChart.getData().clear();
        t22ScoreBarChart.getData().clear();
        t22SFRBarChart.getData().clear();
        t22LineChart.getData().clear();
        /*
            Your Code Here.
            Reset the Page Task 2.2. (including the choice boxes, check boxes and charts)
         */
    }

    @FXML
    private void T22_onClickCompare() {
        error2.setText("");

        String countryregion1 = t2CountryRegion1ChoiceBox.getValue();
        String countryregion2 = t2CountryRegion2ChoiceBox.getValue();

        boolean yearCondition_22 = false;
        List <String> SelectedYears22 = new ArrayList<>();
        if (t22017CheckBox2.isSelected()){
            SelectedYears22.add("2017");
            yearCondition_22 = true;
        }
        if (t22018CheckBox2.isSelected()){
            SelectedYears22.add("2018");
            yearCondition_22 = true;
        }
        if (t22019CheckBox2.isSelected()){
            SelectedYears22.add("2019");
            yearCondition_22 = true;
        }
        if (t22020CheckBox2.isSelected()){
            SelectedYears22.add("2020");
            yearCondition_22 = true;
        }
        if (t22021CheckBox2.isSelected()){
            SelectedYears22.add("2021");
            yearCondition_22 = true;
        }
        if (t22022CheckBox2.isSelected()){
            SelectedYears22.add("2022");
            yearCondition_22 = true;
        }

        if (countryregion1 == null && countryregion2 == null && yearCondition_22 == false){
            error2.setText("Please Select Country/Region 1, Country/Region 2 and Year");
        }
        else if (countryregion1 == null && countryregion2 == null){
            error2.setText("Please Select Country/Region 1 and Country/Region 2");
        }
        else if (countryregion2 == null && yearCondition_22 == false){
            error2.setText("Please Select Country/Region 2 and Year");
        }
        else if (countryregion1 == null && yearCondition_22 == false){
            error2.setText("Please Select Country/Region 1 and Year");
        }
        else if (countryregion1 == null){
            error2.setText ("Please Select Country/Region 1");
        }
        else if (countryregion2 == null){
            error2.setText("Please Select Country/Region 2");
        }
        else if (yearCondition_22 == false){
            error2.setText ("Please Select Year");
        }
        else{
            t22RankBarChart.getData().clear();
            t22InternationalBarChart.getData().clear();
            t22FacultyBarChart.getData().clear();
            t22ScoreBarChart.getData().clear();
            t22SFRBarChart.getData().clear();
            t22LineChart.getData().clear();

            T22Analysis analyzer2 = new T22Analysis (countryregion1, countryregion2, SelectedYears22);
            XYChart.Series<Double, String> barChartData1 = analyzer2.getBarChartData("Rank");
            t22RankBarChart.getData().add(barChartData1);

            XYChart.Series<Double, String> barChartData2 = analyzer2.getBarChartData("Score");
            t22ScoreBarChart.getData().add(barChartData2);

            XYChart.Series<Double, String> barChartData3 = analyzer2.getBarChartData("Student Faculty Ratio");
            t22SFRBarChart.getData().add(barChartData3);

            XYChart.Series<Double, String> barChartData4 = analyzer2.getBarChartData("International Students");
            t22InternationalBarChart.getData().add(barChartData4);

            XYChart.Series<Double, String> barChartData5 = analyzer2.getBarChartData("Faculty Count");
            t22FacultyBarChart.getData().add(barChartData5);

            List<XYChart.Series<String, Double>> lineChartData1 = analyzer2.getLineChartData("Score");
            t22LineChart.getData().addAll(lineChartData1);
        }

        /*
            Your Code Here.
            When click search on Task2.2:
                1. Fetch the two country/region from the choice box.
                2. Fetch the selected years.
                3. Clear previous data.
                4. Make an Analyser.
                5. Update the Bar Charts, which shows the average of selected property.
                6. Update the line Chart, which shows two lines of score of each year.
         */
    }

    @FXML
    private void T3_onClickClear() {
        /*
            Your Code Here.
            Reset the Page Task 2.2. (including the text fields, choice boxes and the table view)
         */
    }

    @FXML
    private void T3_onClickRecommend() {
        /*
            Your Code Here.
            When click search on Task3:
                1. Fetch the top and bottom boundary requirement of score.
                2. Fetch the type and region requirements.
                3. Clear previous data.
                4. Make an Analyser.
                5. Update the Table View.
         */
    }

}