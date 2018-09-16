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



}
