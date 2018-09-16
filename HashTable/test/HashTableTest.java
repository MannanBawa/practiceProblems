import org.junit.Test;
import org.junit.Assert;

public class HashTableTest {



    @Test
    public void testPrintTable() {
        HashTable thisTable = new HashTable();
        thisTable.addItem("Adam", "Buice");
        thisTable.addItem("Mannan", "Puice");
        thisTable.addItem("AnthonyG", "Wuice");
        thisTable.addItem("MichaelV", "Fuice");
        thisTable.printTable();
    }

    @Test
    public void testPrintItemsInIndex() {
        HashTable thisTable = new HashTable();
        thisTable.addItem("Adam", "Buice");
        thisTable.addItem("Mannan", "Puice");
        thisTable.addItem("AnthonyG", "Wuice");
        thisTable.addItem("MichaelV", "Fuice");
        thisTable.printItemsInIndex(1);
    }

    @Test
    public void testPrintItemsInEmptyIndex() {
        HashTable thisTable = new HashTable();
        thisTable.printItemsInIndex(0);
    }

    @Test
    public void testFindDrink() {
        HashTable thisTable = new HashTable();
        thisTable.addItem("Adam", "Buice");
        thisTable.addItem("Mannan", "Puice");
        thisTable.addItem("AnthonyG", "Wuice");
        thisTable.addItem("MichaelV", "Fuice");
        String result = thisTable.findDrink("Mannan");
        System.out.println(result);
    }

    @Test
    public void testFindDrinkNotInHash() {
        HashTable thisTable = new HashTable();
        thisTable.addItem("Adam", "Buice");
        thisTable.addItem("Mannan", "Puice");
        thisTable.addItem("AnthonyG", "Wuice");
        thisTable.addItem("MichaelV", "Fuice");
        String result = thisTable.findDrink("James");
        System.out.println(result);
    }

    @Test
    public void testRemove0Items() {
        HashTable thisTable = new HashTable();
        thisTable.removeItem("Mannan");
    }

    @Test
    public void testRemoveCase0p1() {
        HashTable thisTable = new HashTable();
        thisTable.addItem("Adam", "Buice");
        thisTable.removeItem("Mannan");
    }

    @Test
    public void testRemoveCase1() {
        HashTable thisTable = new HashTable();
        thisTable.addItem("Adam", "Buice");
        thisTable.removeItem("Adam");
    }

    @Test
    public void testRemoveCase2() {
        HashTable thisTable = new HashTable();
        thisTable.addItem("Adam", "Buice");
        thisTable.addItem("Mannan", "Puice");
        thisTable.removeItem("Adam");
        thisTable.printTable();
    }

    @Test
    public void testRemoveCase3p1() {
        HashTable thisTable = new HashTable();
        thisTable.addItem("Adam", "Buice");
        thisTable.addItem("Mannan", "Puice");
        thisTable.removeItem("Mannan");
        thisTable.printTable();
    }


}
