package lld.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements IterableCollection<String> {
    private final List<String> songs = new ArrayList<>();

    public String getSongAt(int index) {
        return this.songs.get(index);
    }

    public int getSize() {
        return this.songs.size();
    }

    @Override
    public Iterator<String> createIterator() {
        return new PlaylistIterator(this);
    }
}
