package list;

import org.junit.Test;
import treeAVL.TreeAVL;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class AVLtest {
    @Test
    public void justBuilding() {
        TreeAVL<Integer,String> tree = new TreeAVL<>();

        tree.insert(700,"Moisha");
        tree.insert(100,"Gosha");
        tree.insert(500,"Sasha");
        tree.insert(120,"Jack");
        tree.insert(350,"Robert");
        tree.insert(590,"Mark");
        tree.insert(1200,"Tomas");
        tree.insert(550,"Rojers");

        assertEquals("Mark",tree.get(590));
        assertEquals("Gosha",tree.get(100));
        assertEquals("Moisha",tree.get(700));
    }

    @Test
    public void buildRemoveFindTest() {
        TreeAVL<Integer,String> tree = new TreeAVL<>();

        tree.insert(700,"Moisha");
        tree.insert(100,"Gosha");
        tree.insert(500,"Sasha");
        tree.insert(120,"Jack");
        tree.insert(350,"Robert");
        tree.insert(590,"Mark");
        tree.insert(1200,"Tomas");
        tree.insert(550,"Rojers");

        assertEquals("Mark",tree.get(590));
        assertEquals("Gosha",tree.get(100));
        assertEquals("Moisha",tree.get(700));
        tree.remove(700);
        tree.remove(550);
        assertEquals("Mark",tree.get(590));
        assertNull(tree.get(700));
        assertNull(tree.get(550));
    }
}
