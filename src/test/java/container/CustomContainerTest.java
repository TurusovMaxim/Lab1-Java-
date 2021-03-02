package container;

import interfaces.Actions;

import static org.junit.jupiter.api.Assertions.*;

class CustomContainerTest {

    Actions testContainer;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("\r\nsetUp");

        testContainer = new CustomContainer(5);

        for (int i = 0; i < 5; i++) {
            testContainer.setElement(i);
        }
    }

    @org.junit.jupiter.api.Test
    void getElement() throws Exception {
        System.out.println("getElement");

        assertEquals(1, testContainer.getElement(1));
    }

    @org.junit.jupiter.api.Test
    void setElement() throws Exception {
        System.out.println("setElement");

        testContainer.setElement(5);
        assertEquals(5, testContainer.getElement(5));
    }

    @org.junit.jupiter.api.Test
    void deleteElement() throws Exception {
        System.out.println("deleteElement");

        testContainer.deleteElement(0);
        assertEquals(0, testContainer.getElement(0)); //expected fail
    }
}