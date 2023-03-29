package JavaStreamsDemoandUsageInSelenium;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

public class RecentlyPlayedStoreTest {

    @Test
    public void testAddSongToStore() {
    	RecentlyPlayedSongsStore store = new RecentlyPlayedSongsStore(3);
        store.addRecentlyPlayedSong("user1", "song1");
        store.addRecentlyPlayedSong("user1", "song2");
        store.addRecentlyPlayedSong("user2", "song3");
        List<String> expectedUser1Songs = Arrays.asList("song1", "song2");
        List<String> expectedUser2Songs = Arrays.asList("song3");
        assertEquals(store.getRecentlyPlayedSongs("user1"), expectedUser1Songs);
        assertEquals(store.getRecentlyPlayedSongs("user2"), expectedUser2Songs);
    }

    @Test
    public void testGetRecentlyPlayedSongsByUser() {
    	RecentlyPlayedSongsStore store = new RecentlyPlayedSongsStore(3);
        store.addRecentlyPlayedSong("user1", "song1");
        store.addRecentlyPlayedSong("user1", "song2");
        store.addRecentlyPlayedSong("user1", "song3");
        store.addRecentlyPlayedSong("user1", "song4");
        List<String> expectedUser1Songs = Arrays.asList("song4", "song3", "song2");
        assertEquals(store.getRecentlyPlayedSongs("user1"), expectedUser1Songs);
    }

    @Test
    public void testEvictLeastRecentlyPlayedSongs() {
    	RecentlyPlayedSongsStore store = new RecentlyPlayedSongsStore(3);
        store.addRecentlyPlayedSong("user1", "song1");
        store.addRecentlyPlayedSong("user1", "song2");
        store.addRecentlyPlayedSong("user1", "song3");
        store.addRecentlyPlayedSong("user1", "song4");
        List<String> expectedUser1Songs = Arrays.asList("song4", "song3", "song2");
        assertEquals(store.getRecentlyPlayedSongs("user1"), expectedUser1Songs);
    }

}
