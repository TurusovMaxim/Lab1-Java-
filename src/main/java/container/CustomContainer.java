package container;

import interfaces.Actions;


/**
 * The class that describes the basic actions on an array.
 */
public class CustomContainer implements Actions {

    private int[] storage;
    private int storageSize; //may be final
    private int numberOfObjects = 0;


    public CustomContainer(int storageSize) {
        this.storageSize = storageSize;

        storage = new int[storageSize];
    }


    /**
     * Here we are, we check if the array is empty
     * and verify whether an index is out of the bounds.
     *
     * @param index - an element index.
     *
     * @exception Exception - checks valid conditions.
     */

    private void admissibleConditions(int index) throws Exception {
        if (storage == null)
        {
            throw new Exception("The array is empty!");
        }

        if (index < 0)
        {
            throw new Exception("The index can not be negative!");
        }

        if(index >= storage.length) {
            throw new Exception("The index is not within the bounds of the storage!");
        }
    }


    /**
     * Gets an element by its index.
     *
     * @param index - an element index.
     *
     * @exception Exception - checks valid conditions.
     */

    public int getElement(int index) throws Exception {

        admissibleConditions(index);

        return storage[index];
    }


    /**
     * Checks if we go out of the array.
     * If we do, we increase the size of the array.
     * Else we make a mark on the number of elements
     * and add an item to the array.
     *
     * @param item - a future element of the array.
     */

    public void setElement (int item) {
        if (numberOfObjects == storageSize) {
            storage = addition(item);
        } else {
            numberOfObjects = numberOfObjects + 1;

            storage[numberOfObjects - 1] = item;
        }
    }


    /**
     * Increase the size of the array.
     *
     * @param item - a future element of the array.
     */

    private int[] addition(int item) {
        int[] newStorage = new int[storageSize + 1];

        for (int i = 0; i < storageSize; i++) {
            newStorage[i] = storage[i];
        }

        newStorage[storageSize] = item;

        return newStorage;
    }


    /**
     * removing an element from the array.
     *
     * @param index - an index of an item to remove.
     */

    public void deleteElement(int index) throws Exception {

        admissibleConditions(index);

        int[] newStorage = new int[storage.length - 1];

        for (int i = 0, j = 0; i < storage.length; i++) {
            if (i != index) {
                newStorage[j++] = storage[i];
            }
        }

        storage = newStorage;
    }

}

