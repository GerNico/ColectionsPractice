package list;

import org.junit.Test;
import selfmadeHash.Basked;
import selfmadeHash.MyHashTable;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class testHashTable {

    @Test
    public void testOfList(){
        Basked<String,Integer> basked=new Basked<>();
        basked.insert("Moisha",700);
        basked.insert("Gosha",100);
        basked.insert("Sasha",500);
        assertEquals(basked.getByKey("Sasha"),new Integer(500));
        basked.remove("Sasha");
        assertNull(basked.getByKey("Sasha"));
    }

    @Test
    public void simplesMapTest(){
        MyHashTable<String,Integer> map= new MyHashTable<>();
        map.put("Moisha",700);
        map.put("Gosha",100);
        map.put("Sasha",500);
        map.put("Jack",1500);
        map.put("Bob",2500);
        map.put("Mark",900);
        map.put("Tom",1200);
        map.put("Cap Rojers",5500);
        assertEquals(map.take("Bob"),new Integer(2500));
        map.delete("Bob");
        assertNull(map.take("Bob"));
    }

    @Test
    public void mapTestRefiling(){
        MyHashTable<String,Integer> map= new MyHashTable<>();
        map.wherePut("Moisha",700);
        map.wherePut("Gosha",100);
        map.wherePut("Sasha",500);
        map.wherePut("Jack",1500);
        map.wherePut("Robert",2500);
        map.wherePut("Mark",900);
        map.wherePut("Tomas",1200);
        map.wherePut("Rojers",5500);
        map.wherePut("Moisha2",2700);
        map.wherePut("Gosha2",2100);
        map.wherePut("Sasha2",2500);
        map.wherePut("Jack2",21500);
        map.wherePut("Robert2",22500);
        map.wherePut("Mark2",2900);
        map.wherePut("Tom2",21200);
        map.wherePut("Rojers2",25500);
        map.wherePut("Said",7500);
        map.wherePut("Radjesh",9500);
        assertEquals(map.take("Said"),new Integer(7500));
        map.delete("Said");
        assertNull(map.take("Said"));
    }



}
