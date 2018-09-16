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

        //Case 0.1 - Bucket is empty: This one shouldn't happen since every bucket is initialized
        // with at least 1 "empty" item, but let's have it just in case.
        if (numItemsInIndex == 0) {
            System.out.println("THE ITEM DID NOT EXIST TO BEGIN WITH");
            return;
        }

        if (numItemsInIndex == 1) {
          //Case 0.2 - Bucket is empty: This bucket only has one item in it, and it's the default
          // empty item
           Item firstItem = hashTable[index];
           if (firstItem.name.equals("empty") && firstItem.favDrink.equals("empty")) {
               System.out.println(name + "was not found in the list" );
               return;
           }
           //Case 1 - Only one item in the bucket, and that item is the one to be removed
           else if (firstItem.name.equals(name)) {
             firstItem.name = "empty";
             firstItem.favDrink = "empty";
             firstItem.nextItem = null;
             System.out.println("CASE 1");
             return;
           }
        }


        //Case 2: Item to delete is the first in the bucket, there are other items though
        Item firstItem = hashTable[index];
        if (firstItem.name.equals(name)) {
          hashTable[index] = hashTable[index].nextItem;
          firstItem.name = "empty";
          firstItem.favDrink = "empty";
          firstItem.nextItem = null;

          System.out.println("CASE 2: " + name + " found as first item in Bucket! Deleted.");
          return;
        }

        //Case 3: Bucket has items but first item is not a match

        Item previousItem = firstItem;
        Item thisItem = previousItem.nextItem;

        //Case 3.1 Item is somewhere in the middle of list
        while(thisItem != null) {
          if (thisItem.name.equals(name)) {
            previousItem.nextItem = thisItem.nextItem;

            thisItem.name = "empty";
            thisItem.favDrink = "empty";
            thisItem.nextItem = null;
            System.out.println("Case 3.1 " + name + " found somewhere in list. Deleted");
            return;
          }
          previousItem = thisItem;
          thisItem = thisItem.nextItem;
        }
        System.out.println("Item not found");
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
