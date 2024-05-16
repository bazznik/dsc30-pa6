import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BSTreeTest {

    @org.junit.jupiter.api.Test
    public void getRootTest() {
        BSTree<Integer> bst = new BSTree<>();
        bst.insert(10);
        assertNotNull(bst.getRoot());

        BSTree<Integer> bst1 = new BSTree<>();
        bst1.insert(10);
        bst1.insert(5);
        bst1.insert(15);
        assertEquals(10, bst1.getRoot().getKey().intValue());

        BSTree<Integer> bst2 = new BSTree<>();
        bst2.insert(3);
        bst2.insert(8);
        assertEquals(3, bst2.getRoot().getKey().intValue());
    }

    @org.junit.jupiter.api.Test
    public void getSizeTest() {
        BSTree<Integer> bst = new BSTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        assertEquals(3, bst.getSize());

        BSTree<Integer> bst1 = new BSTree<>();
        bst1.insert(34);
        assertEquals(1, bst1.getSize());

        BSTree<Integer> bst2 = new BSTree<>();
        assertEquals(0, bst2.getSize());
    }


    @org.junit.jupiter.api.Test
    public void insertTest() {
        BSTree<Integer> bst = new BSTree<>();
        bst.insert(10);
        bst.insert(5);
        assertEquals(2, bst.getSize());

        BSTree<Integer> bst1 = new BSTree<>();
        bst1.insert(10);
        bst1.insert(5);
        bst1.insert(9);
        bst1.insert(19);
        bst1.insert(3);
        assertEquals(5, bst1.getSize());

        BSTree<Integer> bst2 = new BSTree<>();
        bst2.insert(10);
        assertEquals(1, bst2.getSize());
    }

    @org.junit.jupiter.api.Test
    public void findKeyTest() {
        BSTree<Integer> bst = new BSTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        assertTrue(bst.findKey(3));

        BSTree<Integer> bst1 = new BSTree<>();
        bst1.insert(5);
        bst1.insert(6);
        bst1.insert(8);
        bst1.insert(3);
        bst1.insert(1);
        bst1.insert(9);
        assertTrue(bst1.findKey(9));

        BSTree<Integer> bst2 = new BSTree<>();
        bst2.insert(1);
        assertTrue(bst2.findKey(1));
    }

    @org.junit.jupiter.api.Test
    public void insertDataTest() {
        BSTree<Integer> bst = new BSTree<>();
        bst.insert(5);
        bst.insertData(5,1);
        assertEquals(1,bst.getSize());

        BSTree<Integer> bst1 = new BSTree<>();
        bst1.insert(5);
        bst1.insert(6);
        bst1.insert(8);
        bst1.insertData(8,4);
        bst1.insertData(5,3);
        bst1.insertData(6,2);
        assertEquals(3,bst1.getSize());

        BSTree<Integer> bst2 = new BSTree<>();
        bst2.insert(5);
        bst2.insert(2);
        bst2.insertData(5,7);
        bst2.insertData(2,5);
        assertEquals(2,bst2.getSize());
    }

    @org.junit.jupiter.api.Test
    public void findDataListTest() {

    }

    @org.junit.jupiter.api.Test
    public void findHeightTest() {
        BSTree<Integer> bst = new BSTree<>();
        assertEquals(-1, bst.findHeight());

        BSTree<Integer> bst1 = new BSTree<>();
        bst1 .insert(10);
        assertEquals(0, bst1 .findHeight());

        BSTree<Integer> bst2 = new BSTree<>();
        bst2.insert(6);
        bst2.insert(0);
        bst2.insert(3);
        assertEquals(2, bst2.findHeight());
    }

    @org.junit.jupiter.api.Test
    public void iteratorTest() {
        BSTree<Integer> bst = new BSTree<>();
        Iterator<Integer> iterator = bst.iterator();
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);

        BSTree<Integer> bst1 = new BSTree<>();
        bst1.insert(10);
        Iterator<Integer> iterator1 = bst1.iterator();
        assertTrue(iterator1.hasNext());
        assertEquals(10, iterator1.next());
        assertFalse(iterator1.hasNext());
        assertThrows(NoSuchElementException.class, iterator1::next);

        BSTree<Integer> bst2 = new BSTree<>();
        bst2.insert(10);
        bst2.insert(5);
        bst2.insert(15);
        bst2.insert(2);
        bst2.insert(7);
        bst2.insert(12);
        bst2.insert(20);
        Iterator<Integer> iterator2 = bst2.iterator();
        assertTrue(iterator2.hasNext());
        assertEquals(2, iterator2.next());
        assertTrue(iterator2.hasNext());

    }
    @org.junit.jupiter.api.Test
    public void hasNextTest() {
        BSTree<Integer> bst = new BSTree<>();
        bst.insert(10);
        Iterator<Integer> iterator = bst.iterator();
        assertTrue(iterator.hasNext());

        BSTree<Integer> bst1 = new BSTree<>();
        Iterator<Integer> iterator1 = bst1.iterator();
        assertFalse(iterator1.hasNext());

        BSTree<Integer> bst2 = new BSTree<>();
        bst2.insert(10);
        bst2.insert(5);
        Iterator<Integer> iterator2 = bst2.iterator();
        assertTrue(iterator2.hasNext());
    }
    @org.junit.jupiter.api.Test
    public void nextTest() {
        BSTree<Integer> bst = new BSTree<>();
        bst.insert(10);
        Iterator<Integer> iterator = bst.iterator();
        assertEquals(10, iterator.next());

        BSTree<Integer> bst1 = new BSTree<>();
        bst1.insert(10);
        bst1.insert(5);
        Iterator<Integer> iterator1 = bst1.iterator();
        assertEquals(5, iterator1.next());
        assertEquals(10, iterator1.next());

        BSTree<Integer> bst2 = new BSTree<>();
        bst2.insert(6);
        bst2.insert(2);
        bst2.insert(4);
        Iterator<Integer> iterator2 = bst2.iterator();
        assertEquals(2, iterator2.next());
        assertEquals(4, iterator2.next());
        assertEquals(6, iterator2.next());
    }



    @org.junit.jupiter.api.Test
    public void intersectionTest() {
    }

    @org.junit.jupiter.api.Test
    public void levelMaxTest() {
    }
}