package com.gildedrose;

public class DefaultItemUpdaterFactory implements ItemUpdaterFactory{
    @Override
    public ItemUpdater getUpdater(Item item) {
        if (item.name.equals("Aged Brie")) {
            return new AgedBrieUpdater();
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePassUpdater();
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new SulfurasUpdater();
        } else if (item.name.startsWith("Conjured")) {
            return new ConjuredItemUpdater();
        } else {
            return new GeneralItemUpdater();
        }
    }
}
