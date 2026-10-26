package lld.patterns.proxy;

public class HighResolutionImage implements Image {

    private String filename;
    private Byte[] imageData;

    public HighResolutionImage(String filename) {
        this.filename = filename;
        this.imageData = new Byte[10 * 1024 * 1024];
    }

    @Override
    public String getFilename() {
        return this.filename;
    }

    @Override
    public void display() {
        System.out.println("Displaying high resolution image...");
    }
}
