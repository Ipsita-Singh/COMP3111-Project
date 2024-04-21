package comp3111.qsproject;

import javafx.beans.property.SimpleStringProperty;

public class RecommendItem {
    private SimpleStringProperty name;

    private SimpleStringProperty bestYear;

    private SimpleStringProperty bestRank;

    private SimpleStringProperty recentYear;

    private SimpleStringProperty recentRank;

    RecommendItem(QSItem item) {
        this.name = new SimpleStringProperty(item.name);
        this.bestYear = new SimpleStringProperty(item.year);
        this.bestRank = new SimpleStringProperty(item.rank);
        this.recentYear = new SimpleStringProperty(item.year);
        this.recentRank = new SimpleStringProperty(item.rank);
    }

    void update(QSItem item) {
        assert (item.name==(this.getName()));
        /*
            Your Code Here.
            This function update the information from other QSItem.
            1. Update the best rank and the corresponding year.
            2. Update the most recent year and the corresponding rank.
         */
        // Update the best rank and the corresponding year.
        if (Integer.parseInt(item.rank) < Integer.parseInt(this.getBestRank())) {
            this.setBestRank(item.rank);
            this.setBestYear(item.year);
        }
        // Update the most recent year and the corresponding rank.
        if (Integer.parseInt(item.year) > Integer.parseInt(this.getRecentYear())) {
            this.setRecentYear(item.year);
            this.setRecentRank(item.rank);
        }
    }

    public String getName() { return name.get(); }

    public String getBestYear() { return bestYear.get(); }

    public String getBestRank() { return bestRank.get(); }

    public String getRecentYear() { return recentYear.get(); }

    public String getRecentRank() { return recentRank.get(); }

    public void setName(String name) {this.name.set(name);}

    public void setBestYear(String BestYear) {this.bestYear.set(BestYear);}

    public void setBestRank(String BestRank) {this.bestRank.set(BestRank);}

    public void setRecentYear(String RecentYear) {this.recentYear.set(RecentYear);}

    public void setRecentRank(String RecentRank) {this.recentRank.set(RecentRank);}
}
