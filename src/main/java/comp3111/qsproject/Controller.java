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

import java.util.*;
import java.util.stream.Collectors;

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
    public ComboBox<String> FieldSelect2;

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
    public BarChart<Double, String> t21OverallBarChart;
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
    @FXML
    public BarChart<Double, String> t22OverallBarChart;

    public XYChart.Series<Double, String> barChartData;
    public XYChart.Series<Double, String> barChartData2;
    public XYChart.Series<Double, String> barChartData3;
    public XYChart.Series<Double, String> barChartData4;
    public XYChart.Series<Double, String> barChartData5;
    public XYChart.Series<Double, String> barChartData21;
    public XYChart.Series<Double, String> barChartData22;
    public XYChart.Series<Double, String> barChartData23;
    public XYChart.Series<Double, String> barChartData24;
    public XYChart.Series<Double, String> barChartData25;


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
        FieldSelect2.setItems(FXCollections.observableArrayList("Rank", "Score", "Faculty Count", "International Student", "Student Faculty Ratio"));
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

        //Clear Data
        if (barChartData != null){
            barChartData.getData().clear();
        }
        if (barChartData2 !=null){
            barChartData2.getData().clear();
        }
        if (barChartData3 !=null){
            barChartData3.getData().clear();
        }
        if (barChartData4 !=null){
            barChartData4.getData().clear();
        }
        if (barChartData5 !=null){
            barChartData5.getData().clear();
        }

        //Clear Charts
        t21OverallBarChart.getData().clear();
        t21OverallBarChart.getXAxis().setLabel ("");
        t21LineChart.getData().clear();
    }

    @FXML
    private void T21_onClickCompare() {
        //Set error text as empty
        error1.setText("");
        t21OverallBarChart.getXAxis().setLabel ("");

        String university1 = t2University1ChoiceBox.getValue();
        String university2 = t2University2ChoiceBox.getValue();

        boolean yearCondition = false;
        List <String> SelectedYears = new ArrayList<>();
        CheckBox[] checkboxes = {
                t22017CheckBox,
                t22018CheckBox,
                t22019CheckBox,
                t22020CheckBox,
                t22021CheckBox,
                t22022CheckBox
        };

        for (CheckBox checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                String year = checkbox.getText();
                SelectedYears.add(year);
                yearCondition = true;
            }
        }

        List <QSItem> universityList1 = QSList.list.stream().filter (qsItem -> qsItem.getName().equals(university1) && SelectedYears.contains(qsItem.year)).collect(Collectors.toList());
        List <QSItem> universityList2 = QSList.list.stream().filter (qsItem -> qsItem.getName().equals(university2) && SelectedYears.contains(qsItem.year)).collect(Collectors.toList());

        if (university1 == null) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Alert!");
            if (university2 == null) {
                if (yearCondition == false) {
                    alert.setContentText("Please Select University 1, University 2, and Year");
                    Optional<ButtonType> result = alert.showAndWait();
                    error1.setText("Please Select University 1, University 2, and Year");
                }
                else {
                    alert.setContentText("Please Select University 1 and University 2");
                    Optional<ButtonType> result = alert.showAndWait();
                    error1.setText("Please Select University 1 and University 2");
                }
            }
            else if (yearCondition == false) {
                alert.setContentText("Please Select University 1 and Year");
                Optional<ButtonType> result = alert.showAndWait();
                error1.setText("Please Select University 1 and Year");
            }
            else {
                alert.setContentText("Please Select University 1");
                Optional<ButtonType> result = alert.showAndWait();
                error1.setText("Please Select University 1");
            }
        }
        else if (university2 == null) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Alert!");
            if (yearCondition == false) {
                alert.setContentText("Please Select University 2 and Year");
                Optional<ButtonType> result = alert.showAndWait();
                error1.setText("Please Select University 2 and Year");
            } else {
                alert.setContentText("Please Select University 2");
                Optional<ButtonType> result = alert.showAndWait();
                error1.setText("Please Select University 2");
            }
        }
        else if (yearCondition == false) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Alert!");
            alert.setContentText("Please Select Year");
            Optional<ButtonType> result = alert.showAndWait();
            error1.setText("Please Select Year");
        }
        else if (universityList1.isEmpty() || universityList2.isEmpty()){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Alert!");
            alert.setContentText("Please Select Another Year or University");
            Optional<ButtonType> result = alert.showAndWait();
            error1.setText("Please Select Another Year or University");
        }
        else{
            FieldSelect.setValue("Score"); //Default Display will be Score

            //Clear Charts
            t21OverallBarChart.getData().clear();
            t21LineChart.getData().clear();
            t21OverallBarChart.getXAxis().setLabel ("Avg. Score");
            //Create Analyzer
            T21Analysis analyzer = new T21Analysis (university1, university2, SelectedYears);
            barChartData = analyzer.getBarChartData("rank");
            barChartData2 = analyzer.getBarChartData("score");
            barChartData3 = analyzer.getBarChartData("studentFacultyRatio");
            barChartData4 = analyzer.getBarChartData("internationalStudents");
            barChartData5 = analyzer.getBarChartData("facultyCount");

            //Set Default overall to Score Graph
            t21OverallBarChart.getData().addAll(barChartData2);

            //Set Line Chart
            List<XYChart.Series<String, Double>> lineChartData = analyzer.getLineChartData("score");
            lineChartData.sort(Comparator.comparing(series -> series.getData().get(0).getXValue().toString()));
            t21LineChart.getData().addAll(lineChartData);
        }
    }
    @FXML
    private void HandleCombo (ActionEvent event){
        String choice = FieldSelect.getValue();
        if (choice != null){
            t21OverallBarChart.getData().clear();
            if (choice.equals("Score")){
                if (barChartData2 !=null){
                    t21OverallBarChart.getData().add(barChartData2);
                }
                t21OverallBarChart.getXAxis().setLabel ("Avg. Score");
            }
            else if (choice.equals("Faculty Count")){
                if (barChartData5!=null){
                    t21OverallBarChart.getData().add(barChartData5);
                }
                t21OverallBarChart.getXAxis().setLabel ("Avg. Faculty Count");
            }
            else if (choice.equals("Rank")){
                if (barChartData!=null){
                    t21OverallBarChart.getData().add(barChartData);
                }
                t21OverallBarChart.getXAxis().setLabel ("Avg. Rank");
            }
            else if (choice.equals("International Student")){
                if (barChartData4!=null){
                    t21OverallBarChart.getData().add(barChartData4);
                }
                t21OverallBarChart.getXAxis().setLabel ("Avg. International Students");
            }
            else if (choice.equals("Student Faculty Ratio")){
                if (barChartData3!=null){
                    t21OverallBarChart.getData().add(barChartData3);
                }
                t21OverallBarChart.getXAxis().setLabel ("Avg. Student Faculty Ratio");
            }
        }
    }


    @FXML
    private void T22_onClickClear() {
        //Clear Countries/regions
        t2CountryRegion1ChoiceBox.setValue(null);
        t2CountryRegion2ChoiceBox.setValue(null);
        FieldSelect2.setValue(null);

        //Clear Years
        t22017CheckBox2.setSelected(false);
        t22018CheckBox2.setSelected(false);
        t22019CheckBox2.setSelected(false);
        t22020CheckBox2.setSelected(false);
        t22021CheckBox2.setSelected(false);
        t22022CheckBox2.setSelected(false);

        //Clear Error Message
        error2.setText("");

        //Clear Data
        if (barChartData21 != null){
            barChartData21.getData().clear();
        }
        if (barChartData22 !=null){
            barChartData22.getData().clear();
        }
        if (barChartData23 !=null){
            barChartData23.getData().clear();
        }
        if (barChartData24 !=null){
            barChartData24.getData().clear();
        }
        if (barChartData25 !=null){
            barChartData25.getData().clear();
        }

        //Clear Charts
        t22OverallBarChart.getData().clear();
        t22OverallBarChart.getXAxis().setLabel ("");
        t22LineChart.getData().clear();
        /*
            Your Code Here.
            Reset the Page Task 2.2. (including the choice boxes, check boxes and charts)
         */
    }

    @FXML
    private void T22_onClickCompare() {
        error2.setText("");
        t22OverallBarChart.getXAxis().setLabel ("");

        String countryregion1 = t2CountryRegion1ChoiceBox.getValue();
        String countryregion2 = t2CountryRegion2ChoiceBox.getValue();

        boolean yearCondition_22 = false;
        List <String> SelectedYears22 = new ArrayList<>();

        CheckBox[] checkboxes = {
                t22017CheckBox2,
                t22018CheckBox2,
                t22019CheckBox2,
                t22020CheckBox2,
                t22021CheckBox2,
                t22022CheckBox2
        };

        for (CheckBox checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                String year = checkbox.getText();
                SelectedYears22.add(year);
                yearCondition_22 = true;
            }
        }

        List<QSItem> countryList1 = QSList.list.stream()
                .filter(qsItem -> (qsItem.getCountry().equals(countryregion1) || qsItem.getRegion().equals(countryregion1)) && SelectedYears22.contains(qsItem.getYear()))
                .collect(Collectors.toList());
        List<QSItem> countryList2 = QSList.list.stream()
                .filter(qsItem -> (qsItem.getCountry().equals(countryregion2) || qsItem.getRegion().equals(countryregion2)) && SelectedYears22.contains(qsItem.getYear()))
                .collect(Collectors.toList());

        if (countryregion1.equals ("All")){
            countryList1 = QSList.list.stream().filter (qsItem -> (SelectedYears22.contains(qsItem.getYear()))).collect(Collectors.toList());
        }

        if (countryregion2.equals("All")){
            countryList2 = QSList.list.stream().filter(qsItem -> (SelectedYears22.contains(qsItem.getYear()))).collect(Collectors.toList());
        }

        if (countryregion1 == null) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Alert!");
            if (countryregion2 == null) {
                if (yearCondition_22 == false) {
                    alert.setContentText("Please Select Country/Region 1, Country/Region 2, and Year");
                    Optional<ButtonType> result = alert.showAndWait();
                    error2.setText("Please Select Country/Region 1, Country/Region 2, and Year");
                }
                else {
                    alert.setContentText("Please Select Country/Region 1 and Country/Region 2");
                    Optional<ButtonType> result = alert.showAndWait();
                    error2.setText("Please Select Country/Region 1 and Country/Region 2");
                }
            }
            else {
                if (yearCondition_22 == false) {
                    alert.setContentText("Please Select Country/Region 1 and Year");
                    Optional<ButtonType> result = alert.showAndWait();
                    error2.setText("Please Select Country/Region 1 and Year");
                }
                else {
                    alert.setContentText("Please Select Country/Region 1");
                    Optional<ButtonType> result = alert.showAndWait();
                    error2.setText("Please Select Country/Region 1");
                }
            }
        }
        else if (countryregion2 == null) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Alert!");
            if (yearCondition_22 == false) {
                alert.setContentText("Please Select Country/Region 2 and Year");
                Optional<ButtonType> result = alert.showAndWait();
                error2.setText("Please Select Country/Region 2 and Year");
            }
            else {
                alert.setContentText("Please Select Country/Region 2");
                Optional<ButtonType> result = alert.showAndWait();
                error2.setText("Please Select Country/Region 2");
            }
        }
        else if (yearCondition_22 == false) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Alert!");
            alert.setContentText("Please Select Year");
            Optional<ButtonType> result = alert.showAndWait();
            error2.setText("Please Select Year");
        }
        else if (countryList1.isEmpty() || countryList2.isEmpty()){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Alert!");
            alert.setContentText("Please Select Another Year or Country/Region");
            Optional<ButtonType> result = alert.showAndWait();
            error2.setText("Please Select Another Year or Country/Region");
        }
        else{
            FieldSelect2.setValue("Score"); //Default Display will be Score

            //Clear Charts
            t22OverallBarChart.getData().clear();
            t22LineChart.getData().clear();
            t22OverallBarChart.getXAxis().setLabel ("Avg. Score");
            //Create Analyzer
            T22Analysis analyzer2 = new T22Analysis (countryregion1, countryregion2, SelectedYears22);
            barChartData21 = analyzer2.getBarChartData("rank");
            barChartData22 = analyzer2.getBarChartData("score");
            barChartData23 = analyzer2.getBarChartData("studentFacultyRatio");
            barChartData24 = analyzer2.getBarChartData("internationalStudents");
            barChartData25 = analyzer2.getBarChartData("facultyCount");

            //Set Default overall to Score Graph
            t22OverallBarChart.getData().addAll(barChartData22);

            //Set Line Chart
            List<XYChart.Series<String, Double>> lineChartData = analyzer2.getLineChartData("score");
            lineChartData.sort(Comparator.comparing(series -> series.getData().get(0).getXValue().toString()));
            t22LineChart.getData().addAll(lineChartData);
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
    private void HandleCombo2 (ActionEvent event){
        String choice = FieldSelect2.getValue();
        if (choice != null){
            t22OverallBarChart.getData().clear();
            if (choice.equals("Score")){
                if (barChartData22 !=null){
                    t22OverallBarChart.getData().add(barChartData22);
                }
                t22OverallBarChart.getXAxis().setLabel ("Avg. Score");
            }
            else if (choice.equals("Faculty Count")){
                if (barChartData25!=null){
                    t22OverallBarChart.getData().add(barChartData25);
                }
                t22OverallBarChart.getXAxis().setLabel ("Avg. Faculty Count");
            }
            else if (choice.equals("Rank")){
                if (barChartData21!=null){
                    t22OverallBarChart.getData().add(barChartData21);
                }
                t22OverallBarChart.getXAxis().setLabel ("Avg. Rank");
            }
            else if (choice.equals("International Student")){
                if (barChartData24!=null){
                    t22OverallBarChart.getData().add(barChartData24);
                }
                t22OverallBarChart.getXAxis().setLabel ("Avg. International Students");
            }
            else if (choice.equals("Student Faculty Ratio")){
                if (barChartData23!=null){
                    t22OverallBarChart.getData().add(barChartData23);
                }
                t22OverallBarChart.getXAxis().setLabel ("Avg. Student Faculty Ratio");
            }
        }
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