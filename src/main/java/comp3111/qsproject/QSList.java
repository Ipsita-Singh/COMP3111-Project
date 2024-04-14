package comp3111.qsproject;

import com.csvreader.CsvReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This file is a container of collected QS data
 */

public class QSList {
    public static ObservableList<QSItem> list = FXCollections.observableArrayList();
    public static ObservableList<String> university = FXCollections.observableArrayList();
    public static ObservableList<String> type = FXCollections.observableArrayList();
    public static ObservableList<String> region = FXCollections.observableArrayList();
    public static ObservableList<String> country = FXCollections.observableArrayList();

    public static void initialize() {
        try {

            list = CSVToList("qs.csv");


            collectUniversityTypeRegionCountry();


        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
            Your Code Here.
            1. Load the csv into list.
            2. Collect the set of university, type, region and country.
         */
    }

    private static ObservableList<QSItem> CSVToList(String filePath) throws IOException {
        ObservableList<QSItem> dataList = FXCollections.observableArrayList();;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String [] parsed = new String[15];;
                int j = 0;
                for (int i = 0; i < data.length; i++){
                    if (data[i].contains("\"") == true) {
                        parsed[j++] = data[i] + "," + data[i + 1];
                        i = i+1;
                    }
                    else{
                        parsed[j++] = data [i];
                    }
                }
                parsed [0] = parsed [0].replace ("\"", "").trim();
                QSItem item = new QSItem(parsed);
                dataList.add(item);
            }
        }

        return dataList;
    }

    private static void collectUniversityTypeRegionCountry() {


        for (QSItem item : list) {
            university.add(item.getName());
            type.add(item.getType());
            region.add(item.getRegion());
            country.add(item.getCountry());
        }



    }
}
