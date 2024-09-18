package com.luandeoliveira.ccb_api.model;

import com.luandeoliveira.ccb_api.controllers.HymnFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HymnTest {
    @Test
    void testHashCode(){
        Hymn hymn1 = HymnFactory.createHymn();
        Hymn hymn2 = HymnFactory.createHymn();
        assertEquals(hymn1.hashCode(), hymn2.hashCode());
    }
    @Test
    void testEquals(){
        Hymn hymn1 = HymnFactory.createHymn();
        Hymn hymn2 = HymnFactory.createHymn();
        assertEquals(hymn1, hymn2);
        assertEquals(hymn1, hymn1);

        hymn2 = null;
        assertNotEquals(hymn1, hymn2);
    }

    @Test
    void testToString(){
        Hymn hymn1 = HymnFactory.createHymn();
        assertNotNull(hymn1.toString());
    }
}