package economics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public class Market {
	public final ImmutableMap<String, Good> GOODS;
	private Map<Good, LinkedList<Transaction>> market;
	
	public Market(ImmutableMap<String, Good> goods) {
		GOODS = goods;
		market = new HashMap<Good, LinkedList<Transaction>>();
		refreshOffers();
	}
	
	private void refreshOffers() {
		ImmutableSet<String> keys = GOODS.keySet();
		for (Iterator<String> i = keys.iterator(); i.hasNext();) {
			Good forSale = GOODS.get(i.next());
			market.put(forSale, new LinkedList<Transaction>());
		}
	}
	
	public List<Transaction> getOffers(Good needed) {
		return market.get(needed);
	}

	public void addAdvertisement(Transaction transaction) {
		market.get(transaction.getOffer().getQuantity()).add(transaction);
	}
}
