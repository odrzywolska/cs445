package edu.iit.cs445.vin.data;

import edu.iit.cs445.vin.model.MonthlySelectionType;
import edu.iit.cs445.vin.model.Wine;

public class AllWhite extends MonthlySelection {

	public AllWhite() {
		super.mst = MonthlySelectionType.AW;
	}
	
	@Override
	void addWine(Wine w) {
		// Make sure only white wines are added

	}

}
