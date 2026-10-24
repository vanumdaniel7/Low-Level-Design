package lld.examples.decorator;

public class PlainTextRenderer implements TextRenderer {
    private final String text;

    public PlainTextRenderer(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.print(text);
    }
}
