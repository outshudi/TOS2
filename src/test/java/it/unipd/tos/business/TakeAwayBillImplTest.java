package it.unipd.tos.business;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unipd.tos.business.TakeAwayBillImpl;
import it.unipd.tos.business.itemType;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import java.util.List;
import java.util.ArrayList;

public class TakeAwayBillImplTest {

	TakeAwayBill bill= new TakeAwayBillImpl();
	
	@Test
	public void evaluateBillTest() throws TakeAwayBillException{
		List<MenuItem> list= new ArrayList<MenuItem>();
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		double expected= 10.5;
		double actual= bill.getOrderPrice(list);
		assertEquals(expected, actual,0.0);
	}
	
	@Test
	public void billValueUnderTenTest() throws TakeAwayBillException{
		List<MenuItem> list= new ArrayList<MenuItem>();
		list.add(new MenuItem(itemType.Panini,"vegetariano",1.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",1.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",1.5));
		double expected= 5.0;
		double actual= bill.getOrderPrice(list);
		assertEquals(expected, actual,0.0);
	}
	
	@Test
	public void billValueOverFiftyTest() throws TakeAwayBillException{
		List<MenuItem> list= new ArrayList<MenuItem>();
		list.add(new MenuItem(itemType.Panini,"vegetariano",54.0));
		double expected= 48.6;
		double actual= bill.getOrderPrice(list);
		assertEquals(expected, actual,0.0);
	}
	
	@Test
	public void overFiveDisountTest() throws TakeAwayBillException{
		List<MenuItem> list= new ArrayList<MenuItem>();
		list.add(new MenuItem(itemType.Panini,"vegetariano",2.0));
		list.add(new MenuItem(itemType.Panini,"vegetariano",1.0));
		list.add(new MenuItem(itemType.Panini,"vegetariano",1.0));
		list.add(new MenuItem(itemType.Panini,"vegetariano",1.0));
		list.add(new MenuItem(itemType.Panini,"vegetariano",6.0));
		list.add(new MenuItem(itemType.Panini,"primavera",1.0));
		list.add(new MenuItem(itemType.Bevande,"acqua",1.0));
		list.add(new MenuItem(itemType.Fritti,"olive_ascolane",6.0));
		double expected= 18.5;
		double actual= bill.getOrderPrice(list);
		assertEquals(expected, actual,0.0);
	}
	
/*	@Test
	public void emptyOrderTest() throws TakeAwayBillException {
		TakeAwayBill bill= new TakeAwayBillImpl();
		List<MenuItem> list= new ArrayList<MenuItem>();
		double sum= bill.getOrderPrice(list);
		double expected= 0.0;
		assertEquals(expected, sum, 0.0);
	}*/
	
	@Test
	public void billOutOfBoundTest()  throws TakeAwayBillException{
		List<MenuItem> list= new ArrayList<MenuItem>();
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",2.0));
		list.add(new MenuItem(itemType.Panini,"primavera",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",2.0));
		list.add(new MenuItem(itemType.Panini,"primavera",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",2.0));
		list.add(new MenuItem(itemType.Panini,"primavera",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",2.0));
		list.add(new MenuItem(itemType.Panini,"primavera",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",2.0));
		list.add(new MenuItem(itemType.Panini,"primavera",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",2.0));
		list.add(new MenuItem(itemType.Panini,"primavera",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",2.0));
		list.add(new MenuItem(itemType.Panini,"primavera",3.5));
		double sum= bill.getOrderPrice(list);
		double expected= 0.0;
		assertEquals(expected, sum, 0.0);
	}
	
	@Test
	public void lessFivePaniniDiscountTest() throws TakeAwayBillException{
		List<MenuItem> list= new ArrayList<MenuItem>();
		list.add(new MenuItem(itemType.Bevande,"acqua",3.5));
		list.add(new MenuItem(itemType.Bevande,"thé",3.5));
		list.add(new MenuItem(itemType.Panini,"vegetariano",3.5));
		list.add(new MenuItem(itemType.Bevande,"acqua",3.5));
		list.add(new MenuItem(itemType.Fritti,"olive_ascolane",3.5));
		list.add(new MenuItem(itemType.Panini,"primavera",3.5));
		assertEquals(21.0,bill.getOrderPrice(list),0.0);
		
	}
	
	
	@Test
	public void TakeAwayBillExceptionTest() {
		List<MenuItem> list= new ArrayList<MenuItem>();
		boolean t= false;
		try {
			double sum = bill.getOrderPrice(list);
		} catch(Exception e) {
			t= true;
		}
		assertTrue(t);
	}

}
