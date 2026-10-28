package lld.patterns.iterator;

public class PlaylistIterator implements Iterator<String> {

    private final Playlist playlist;
    private int index = 0;

    public PlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSize();
    }

    @Override
    public String getNext() {
        return playlist.getSongAt(index++);
    }
}
