import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LRUCacheTest {


    @Test
    public void shouldTestLRU() {

        LRUCache<Integer,Integer> lruCache = new LRUCache<Integer, Integer>(4);


        lruCache.set(1,10);
        assertThat(lruCache.getHead().key, Is.<Object>is(new Integer(1)));

        lruCache.set(2,20);
        assertThat(lruCache.getHead().key, Is.<Object>is(new Integer(2)));

        lruCache.get(1);
        assertThat(lruCache.getHead().key, Is.<Object>is(new Integer(1)));

        lruCache.get(2);
        assertThat(lruCache.getHead().key, Is.<Object>is(new Integer(2)));
        assertThat(lruCache.get(2), is(new Integer(20)));

        lruCache.set(3,30);
        lruCache.set(4,40);
        lruCache.set(5,50);   // This one exceeds the capacity. - So at this point the LRU is (1,10). should be deleted

//        assertThat(lruCache.get(1),is(nullValue()));
//        assertThat(lruCache.get(1),is(10));
    }
}