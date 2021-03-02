import interfaces.Actions;
import container.CustomContainer;

import java.util.Scanner;


/**
 * Класс контейнер, позволяющий хранить произвольное количество целых чисел.
 * @author TurusovMaxim
 */

public class Program {


    /**
     * Outputs array data
     *
     * @param storageSize - a size of an array.
     *
     * @param customContainer - an object of type Action,
     *                        that implements the interface
     *                        with the main methods.
     *
     * @exception Exception - checks valid conditions.
     */

    private static void outputStorage(int storageSize, Actions customContainer) throws Exception {
        System.out.print("The array: [ ");

        for (int i = 0; i < storageSize; i++) {
            System.out.print(" " + customContainer.getElement(i) + ", ");
        }

        System.out.println("]");
    }


    public static void main(String[] args) throws Exception {

        //container initialization
        System.out.println("Enter a storage size:");

        Scanner scanner = new Scanner(System.in);

        int storageSize = scanner.nextInt();

        Actions customContainer = new CustomContainer(storageSize);


        //adding an item to an array
        System.out.println("Fine. Now You need to fill the array with numbers:");

        for (int i = 0; i < storageSize; i++) {
            customContainer.setElement(scanner.nextInt());
        }

        outputStorage(storageSize, customContainer);


        //removing an item from an array
        System.out.println("Enter an index to remove an item:");

        int item = scanner.nextInt();

        customContainer.deleteElement(item);

        storageSize--;

        outputStorage(storageSize, customContainer);
    }
}