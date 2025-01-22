package com.gildedrose;

class GildedRose {
    Item[] items;
    private final ItemUpdaterFactory factory;

    public GildedRose(Item[] items, ItemUpdaterFactory factory) {
        this.items = items;
        this.factory = factory;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = factory.getUpdater(item);
            updater.update(item);
        }
    }


}
