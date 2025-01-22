package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    /*
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items, new DefaultItemUpdaterFactory());
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

     */

    @Test
    void testAgedBrieIncreasesQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items, new DefaultItemUpdaterFactory());

        app.updateQuality();

        assertEquals(1, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void testBackstagePassIncreasesQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20) };
        GildedRose app = new GildedRose(items, new DefaultItemUpdaterFactory());

        app.updateQuality();

        assertEquals(21, app.items[0].quality); // Increase by 1
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void testBackstagePassQualityDropsToZeroAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items, new DefaultItemUpdaterFactory());

        app.updateQuality();

        assertEquals(0, app.items[0].quality); // Quality drops to 0
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void testSulfurasNeverChanges() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items, new DefaultItemUpdaterFactory());

        app.updateQuality();

        assertEquals(80, app.items[0].quality); // Quality stays constant
        assertEquals(0, app.items[0].sellIn);   // SellIn stays constant
    }

    @Test
    void testConjuredItemsDegradeTwiceAsFast() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items, new DefaultItemUpdaterFactory());

        app.updateQuality();

        assertEquals(4, app.items[0].quality); // Decrease by 2
        assertEquals(2, app.items[0].sellIn);  // SellIn decreases by 1
    }

    @Test
    void testGeneralItemsDegradeNormally() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items, new DefaultItemUpdaterFactory());

        app.updateQuality();

        assertEquals(19, app.items[0].quality); // Decrease by 1
        assertEquals(9, app.items[0].sellIn);   // SellIn decreases by 1
    }

    @Test
    void testGeneralItemsDegradeTwiceAsFastAfterSellIn() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 20) };
        GildedRose app = new GildedRose(items, new DefaultItemUpdaterFactory());

        app.updateQuality();

        assertEquals(18, app.items[0].quality); // Decrease by 2
        assertEquals(-1, app.items[0].sellIn);  // SellIn decreases by 1
    }

}
