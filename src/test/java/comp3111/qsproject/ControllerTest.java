package comp3111.qsproject;

import javafx.fxml.FXMLLoader;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;




import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    @BeforeAll
    public static void startJavaFXRuntime() {
        Platform.startup( () -> {});
    }

    @Test
    public void testInitialize() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        // Add more assertions to validate other elements in the Controller class
        assertEquals("2017",controller.t1YearChoiceBox.getValue());
    }

    @Test
    public void testReset() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t2University1ChoiceBox.setValue("Cornell University");
        controller.t2University2ChoiceBox.setValue("Cornell University");
        controller.t22017CheckBox.setSelected(true);

        controller.T21_onClickCompare();
        controller.T21_onClickClear();

        // Add more assertions to validate other elements in the Controller class
        assertEquals(false,controller.t22017CheckBox.isSelected());
    }

    @Test
    public void testT1() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t1PieChartChoiceBox.setValue("country");
        controller.T1_onClickSearch();

        assertEquals("country & score",controller.t1PieChartLabel.getText());

        // Add more assertions to validate other elements in the Controller class

    }
    @Test
    public void testReset2() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t2CountryRegion2ChoiceBox.setValue("North America");
        controller.t2CountryRegion1ChoiceBox.setValue("All");
        controller.t22017CheckBox2.setSelected(true);

        controller.T22_onClickCompare();
        controller.T22_onClickClear();

        // Add more assertions to validate other elements in the Controller class
        assertEquals(false,controller.t22017CheckBox2.isSelected());
    }

    @Test
    public void HandleCombo() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t2CountryRegion2ChoiceBox.setValue("North America");
        controller.t2CountryRegion1ChoiceBox.setValue("All");
        controller.t22017CheckBox2.setSelected(true);


        controller.T22_onClickCompare();
        controller.FieldSelect2.setValue("Faculty Count");
        controller.HandleCombo2();


        // Add more assertions to validate other elements in the Controller class
        assertEquals("Avg. Faculty Count",controller.t22OverallBarChart.getXAxis().getLabel());
    }

    @Test
    public void HandleCombo2() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t2CountryRegion2ChoiceBox.setValue("North America");
        controller.t2CountryRegion1ChoiceBox.setValue("All");
        controller.t22017CheckBox2.setSelected(true);


        controller.T22_onClickCompare();
        controller.FieldSelect2.setValue("Rank");
        controller.HandleCombo2();


        // Add more assertions to validate other elements in the Controller class
        assertEquals("Avg. Rank",controller.t22OverallBarChart.getXAxis().getLabel());
    }
    @Test
    public void HandleCombo3() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t2CountryRegion2ChoiceBox.setValue("North America");
        controller.t2CountryRegion1ChoiceBox.setValue("All");
        controller.t22017CheckBox2.setSelected(true);


        controller.T22_onClickCompare();
        controller.FieldSelect2.setValue("International Student");
        controller.HandleCombo2();



        // Add more assertions to validate other elements in the Controller class
        assertEquals("Avg. International Students",controller.t22OverallBarChart.getXAxis().getLabel());
    }

    @Test
    public void HandleCombo4() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t2CountryRegion2ChoiceBox.setValue("North America");
        controller.t2CountryRegion1ChoiceBox.setValue("All");
        controller.t22017CheckBox2.setSelected(true);


        controller.T22_onClickCompare();
        controller.FieldSelect2.setValue("Score");
        controller.HandleCombo2();


        // Add more assertions to validate other elements in the Controller class
        assertEquals("Avg. Score",controller.t22OverallBarChart.getXAxis().getLabel());
    }

    @Test
    public void HandleCombo5() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t2CountryRegion2ChoiceBox.setValue("North America");
        controller.t2CountryRegion1ChoiceBox.setValue("All");
        controller.t22017CheckBox2.setSelected(true);


        controller.T22_onClickCompare();
        controller.FieldSelect2.setValue("Student Faculty Ratio");
        controller.HandleCombo2();


        // Add more assertions to validate other elements in the Controller class
        assertEquals("Avg. Student Faculty Ratio",controller.t22OverallBarChart.getXAxis().getLabel());
    }

    @Test
    public void HandleCombo21() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t2University1ChoiceBox.setValue("Cornell University");
        controller.t2University2ChoiceBox.setValue("Cornell University");
        controller.t22017CheckBox.setSelected(true);


        controller.T21_onClickCompare();
        controller.FieldSelect.setValue("Faculty Count");
        controller.HandleCombo();


        // Add more assertions to validate other elements in the Controller class
        assertEquals("Avg. Faculty Count",controller.t21OverallBarChart.getXAxis().getLabel());
    }

    @Test
    public void HandleCombo22() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t2University1ChoiceBox.setValue("Cornell University");
        controller.t2University2ChoiceBox.setValue("Cornell University");
        controller.t22017CheckBox.setSelected(true);


        controller.T21_onClickCompare();
        controller.FieldSelect.setValue("Rank");
        controller.HandleCombo();


        // Add more assertions to validate other elements in the Controller class
        assertEquals("Avg. Rank",controller.t21OverallBarChart.getXAxis().getLabel());
    }
    @Test
    public void HandleCombo23() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t2University1ChoiceBox.setValue("Cornell University");
        controller.t2University2ChoiceBox.setValue("Cornell University");
        controller.t22017CheckBox.setSelected(true);


        controller.T21_onClickCompare();
        controller.FieldSelect.setValue("International Student");
        controller.HandleCombo();


        // Add more assertions to validate other elements in the Controller class
        assertEquals("Avg. International Students",controller.t21OverallBarChart.getXAxis().getLabel());
    }

    @Test
    public void HandleCombo24() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t2University1ChoiceBox.setValue("Cornell University");
        controller.t2University2ChoiceBox.setValue("Cornell University");
        controller.t22017CheckBox.setSelected(true);


        controller.T21_onClickCompare();
        controller.FieldSelect.setValue("Score");
        controller.HandleCombo();

        // Add more assertions to validate other elements in the Controller class
        assertEquals("Avg. Score",controller.t21OverallBarChart.getXAxis().getLabel());
    }

    @Test
    public void HandleCombo25() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ui.fxml"));
        fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        // Verify that the choice boxes are initialized correctly
        controller.initialize();

        controller.t2University1ChoiceBox.setValue("Cornell University");
        controller.t2University2ChoiceBox.setValue("Cornell University");
        controller.t22017CheckBox.setSelected(true);


        controller.T21_onClickCompare();
        controller.FieldSelect.setValue("Student Faculty Ratio");
        controller.HandleCombo();

        // Add more assertions to validate other elements in the Controller class
        assertEquals("Avg. Student Faculty Ratio",controller.t21OverallBarChart.getXAxis().getLabel());
    }
}

