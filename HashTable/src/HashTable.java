public class HashTable {

    private static final int tableSize = 10;

    Item[] hashTable = new Item[tableSize];

    public HashTable() {

        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = new Item();
            hashTable[i].name = "empty";
            hashTable[i].favDrink = "empty";
            hashTable[i].nextItem = null;
        }
    }

    public int hash(String key) {

        int hash = 0;
        int index;
        int keyLength = key.length();

        for (int i = 0; i < keyLength; i++) {
            int charAsInt = (int)key.charAt(i);
            hash += charAsInt;
        }
        //System.out.println("Hash: " + hash);
        index = hash % tableSize;
        //System.out.println(index);
        return index;
    }

    public void addItem(String name, String favDrink) {

        int index = hash(name);
        //System.out.println("Name: " + name + "Index: "+ index);

        if (hashTable[index].name.equals("empty")) {
            hashTable[index].name = name;
            hashTable[index].favDrink = favDrink;
        }
        else {
            Item firstItem = hashTable[index];
            Item newItem = new Item();
            newItem.name = name;
            newItem.favDrink = favDrink;
            newItem.nextItem = null;

            while (firstItem.nextItem != null) {
                firstItem = firstItem.nextItem;
            }
            firstItem.nextItem = newItem;
        }

    }

    public void removeItem(String name) {

        int index = hash(name);
        int numItemsInIndex = numItemsInIndex(index);

        if (numItemsInIndex == 0 ) {
            System.out.println("THE ITEM DID NOT EXIST TO BEGIN WITH");
            return;
        }

        if (numItemsInIndex == 1) {
           Item thisItem = hashTable[index];
           if (thisItem.name.equals(name)) {
               thisItem.name = "empty";
               thisItem.favDrink = "empty";
               thisItem.nextItem = null;
               return;
           } else {
               System.out.println("THE ITEM DID NOT EXIST TO BEGIN WITH");
           }
        }

        Item previousItem = hashTable[index];
        Item thisItem = previousItem.nextItem;
        boolean itemFound = false;

        if (previousItem.name.equals(name)) {
            itemFound = true;
            previousItem = thisItem;
            thisItem.name = "empty";
            thisItem.favDrink = "empty";
            thisItem.nextItem = null;

        }

        while(thisItem.nextItem != null) {

            if (thisItem.name.equals(name)) {
                itemFound = true;

                previousItem.nextItem = thisItem.nextItem;

                thisItem.name = "empty";
                thisItem.favDrink = "empty";
                thisItem.nextItem = null;
            }

            previousItem = thisItem;
            thisItem = thisItem.nextItem;
        }

        if (thisItem.name.equals(name)) {
            itemFound = true;
            previousItem.nextItem = null;
            thisItem.name = "empty";
            thisItem.favDrink = "empty";
            thisItem.nextItem = null;
        }
    }

    public int numItemsInIndex(int index) {

        Item thisItem = hashTable[index];
        int count = 0;

        if (thisItem.name == "empty") {
            return count;
        } else {
            count++;
            while (thisItem.nextItem != null) {
                count++;
                thisItem = thisItem.nextItem;
            }
            return count;
        }
    }

    public void printTable() {
        int number;
        for (int i = 0; i < tableSize; i++) {
            number = numItemsInIndex(i);
            Item thisItem = hashTable[i];
            System.out.println("---------------------------------------");
            System.out.println("Index: " + i);
            System.out.println("Name: " + thisItem.name);
            System.out.println("FavDrink: " + thisItem.favDrink);
            System.out.println("Number of items in this bucket: " + number);
            System.out.println("---------------------------------------");
        }


    }

    public void printItemsInIndex(int index) {

        Item thisBucket = hashTable[index];

        if (thisBucket.name.equals("empty")) {
            System.out.println("Index: " + index + " is empty.");
        }
        else {
            System.out.println("Index: " + index + " contains: ");

            while(thisBucket.nextItem != null) {
                System.out.println("---------------------------------------");
                System.out.println("Name: " + thisBucket.name);
                System.out.println("FavDrink: " + thisBucket.favDrink);
                System.out.println("---------------------------------------");
                thisBucket = thisBucket.nextItem;
            }
            System.out.println("---------------------------------------");
            System.out.println("Name: " + thisBucket.name);
            System.out.println("FavDrink: " + thisBucket.favDrink);
            System.out.println("---------------------------------------");
        }
    }

    public String findDrink(String name) {

        int index = hash(name);
        boolean foundName = false;

        String favDrink = new String();

        Item thisItem = hashTable[index];

        while(thisItem != null) {
            if (thisItem.name.equals(name)) {
                foundName = true;
                favDrink = thisItem.favDrink;
            }
            thisItem = thisItem.nextItem;
        }

        if (foundName) {
            //System.out.println(name + "'s favorite drink is " + favDrink);
            return favDrink;
        } else {
            //System.out.println("This person does not exist in the Hashtable");
            return "PERSON NOT FOUND";
        }
    }
}
