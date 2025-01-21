package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            if (isItemNamed(item, "Aged Brie")) {
                updateAgedBrieQuality(item);
            }
            else if(isItemNamed(item, "Backstage passes to a TAFKAL80ETC concert")){
                updateBackstagePasses(item);
            }
            else if (isItemNamed(item, "Sulfuras, Hand of Ragnaros")) {
                updateSulfuras(item);
            }
            else if(isItemNamed(item, "Conjured Mana Cake")){
                updateConjuredItem(item);
            }
            else{
                updateGeneralItem(item);
            }
        }
    }

    private boolean isItemNamed(Item item, String name){
        return item.name.equals(name);
    }

    private void updateAgedBrieQuality(Item item){
        if(item.quality < 50){
            item.quality++;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }

    private void updateBackstagePasses(Item item){
        if(item.quality < 50){
            item.quality++;

            if (item.sellIn <= 10 && item.quality < 50) {
                item.quality++;
            }
            if (item.sellIn <= 5 && item.quality < 50) {
                item.quality++;
            }

        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateSulfuras(Item item) {

    }

    private void updateConjuredItem(Item item) {
        if (item.quality > 0) {
            item.quality -= 2;
            if (item.sellIn <= 0 && item.quality > 0) {
                item.quality -= 2;
            }
            if (item.quality < 0) {
                item.quality = 0;
            }
        }
        item.sellIn--;
    }

    private void updateGeneralItem(Item item) {
        if (item.quality > 0) {
            item.quality--;
            if (item.sellIn <= 0 && item.quality > 0) {
                item.quality--;
            }
        }
        item.sellIn--;
    }




}
