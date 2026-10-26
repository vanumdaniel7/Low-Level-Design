package lld.patterns.proxy;

public class ImageProxy implements Image {
    private String filename;
    private HighResolutionImage highResolutionImage;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public void display() {
        if (this.highResolutionImage == null) {
            this.highResolutionImage = new HighResolutionImage(filename);
        }
        this.highResolutionImage.display();
    }
}
