////////////////////////////////////////////////////////////////////
// [Olivier] [Utshudi] [1143556]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;
import java.util.ArrayList;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillImpl implements TakeAwayBill {
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        if (itemsOrdered.size() > 0) {
            if (itemsOrdered.size() < 30) { // test #4
                double sum = 0.0;
                for (int i = 0; i < itemsOrdered.size(); i = i + 1) {
                    MenuItem item = itemsOrdered.get(i);
                    // test #1
                    sum += item.getPrice();
                }
                // test #2
                double discountTest2 = overFiveDiscount(itemsOrdered);
                sum -= discountTest2;

                // test #3
                if (sum > 50.0) {
                    sum = (sum * 90.0) / 100.0;
                }
                // test #5
                if (sum < 10.0) {
                    sum += 0.5;
                }

                return sum;
            } else {
                return 0.0;
            }
        } else {
            throw new TakeAwayBillException("Empty list");
        }
    }

    public double overFiveDiscount(List<MenuItem> list) {
        double discount = 0.0;
        if (list.size() > 5) {
            int count = 0;
            List<MenuItem> subL = new ArrayList<MenuItem>();
            for (int i = 0; i < list.size(); i = i + 1) {
                MenuItem item = new MenuItem(list.get(i));
                if (item.getType().equals(itemType.Panini)) {
                    count += 1;
                    subL.add(item);
                }
            }
            if (count < 5) {
                return 0.0;
            } else {
                double lessExp = findLessExpensive(subL);
                discount = lessExp * 0.5;
            }
        }
        return discount;
    }

    public double findLessExpensive(List<MenuItem> list) {
        MenuItem item = list.get(0);
        for (int i = 1; i < list.size(); i = i + 1) {
            if (item.getPrice() > list.get(i).getPrice()) {
                item = list.get(i);
            }
        }
        return item.price;
    }
}
