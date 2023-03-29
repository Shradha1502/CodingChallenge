package JavaStreamsDemoandUsageInSelenium;

import java.util.*;


public class RecentlyPlayedSongsStore {

    private int capacity;
    private Map<String, List<String>> userToSongsMap;

    public RecentlyPlayedSongsStore(int capacity) {
        this.capacity = capacity;
        userToSongsMap = new HashMap<>();
    }

    public void addRecentlyPlayedSong(String user, String song) {
        List<String> userSongs = userToSongsMap.getOrDefault(user, new ArrayList<>());
        userSongs.add(0, song);
        if (userSongs.size() > capacity) {
            userSongs.remove(capacity);
        }
        userToSongsMap.put(user, userSongs);
    }

    public List<String> getRecentlyPlayedSongs(String user) {
        List<String> userSongs = userToSongsMap.get(user);
        if (userSongs == null) {
            return Collections.emptyList();
        }
        return userSongs.stream().limit(capacity).toList();
    }

}


