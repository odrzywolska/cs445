package edu.iit.cs445.vin.data;

import edu.iit.cs445.vin.model.MonthlySelection;
import java.util.Collection;

public class MonthlySelectionData {

    public static Collection<MonthlySelection> getMonthlySelections() {
        return DataLoader.data.monthlySelections;
    }

    public static void load(){
        DataLoader.load();
    }

    public static void save() {
        DataLoader.save();
    }
}
