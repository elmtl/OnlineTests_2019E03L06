package com.acquisio.basic.java.question05;

import static org.junit.Assert.*;

import org.junit.Test;

public class RefactoringTest {

	@Test
	public void testName() {
		Item[] items = new Item[] { new Item("foo", 0, 0), new Item("Aged Brie", 1000, 1),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 3),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80) };

		Item[] itemsTestWithPreviousMethod = new Item[] { new Item("foo", 0, 0), new Item("Aged Brie", 1000, 1),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 3),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80) };

		Refactoring app = new Refactoring(items);
		
		// To be sure the result after refactoring matches the ones generated by existing method
		Refactoring appObsolete = new Refactoring(itemsTestWithPreviousMethod);
		for (int i = 0; i < 10; i++) {
			appObsolete.updateQualityObsolete();
			app.updateQuality();

			for (int itemIndex = 0; itemIndex < 4; itemIndex++) {
				System.out.println("before : " + appObsolete.items[itemIndex].toString());
				System.out.println("after refactoring : " + app.items[itemIndex].toString());
				System.out.println("--------------------------------------");
				assertEquals(appObsolete.items[itemIndex].toString(), app.items[itemIndex].toString());
			}

		}		
	}

}
