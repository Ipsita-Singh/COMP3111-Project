package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T3Analysis {
    public ObservableList<RecommendItem> RecommendList = FXCollections.observableArrayList();

    T3Analysis (String top_input, String bottom_input, String type, String region) {
        /*
            Your Code Here.
            Collect the QSItem which fit the score range, type and region into the RecommendItem.
            Sort the RecommendList by bestRank.
            Hint: QSList.list is a static property and you can use "update" function in RecommendItem.
         */
        // Iterate over the QSList
        int bottom = Integer.parseInt(bottom_input);
        int top = Integer.parseInt(top_input);
        for (QSItem item : QSList.list) {
            // Convert the item's score to an integer
            int itemScore = Integer.parseInt(item.getRank());

            // Check if the item fits the score range, type, and region
            if (itemScore >= bottom && itemScore <= top && item.type.equals(type) && item.region.equals(region)) {
                // If a RecommendItem for this QSItem already exists in the RecommendList, update it
                boolean found = false;
                for (RecommendItem recommendItem : RecommendList) {
                    if (recommendItem.name.equals(item.name)) {
                        recommendItem.update(item);
                        found = true;
                        break;
                    }
                }

                // If a RecommendItem for this QSItem does not exist in the RecommendList, create a new one
                if (!found) {
                    RecommendList.add(new RecommendItem(item));
                }
            }
        }

        // Sort the RecommendList by bestRank
        RecommendList.sort((item1, item2) -> Integer.compare(Integer.parseInt(item1.bestRank), Integer.parseInt(item2.bestRank)));

    }

    ObservableList<RecommendItem> getRecommendData() {
        // Show the most valuable university
        return RecommendList;
    }
}
