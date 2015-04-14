package edu.iit.cs445.vin.data;

import edu.iit.cs445.vin.model.MonthlySelectionType;
import edu.iit.cs445.vin.model.Wine;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class MonthlySelection {
	protected MonthlySelectionType mst;
	private YearMonth ym;
	private List<Wine> ms = new ArrayList<Wine>();
	
	abstract void addWine(Wine w);
	
	public boolean isMatch(String kw) {
		Iterator<Wine> it = this.ms.iterator();
		while (it.hasNext()) {
			Wine w = it.next();
			if (w.isMatch(kw)) return true;
		}
		return false;
	}
	
	public MonthlySelection() {
		this.ym = YearMonth.now().plusMonths(1);	// next month's selection
	}
	
	public MonthlySelection(String ym) {	// Must be in the yyyy-mm format
		this.ym = YearMonth.parse(ym);
	}
}
