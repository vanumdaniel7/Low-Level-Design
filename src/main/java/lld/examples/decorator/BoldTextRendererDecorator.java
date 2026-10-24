package lld.examples.decorator;

public class BoldTextRendererDecorator extends TextRendererDecorator {

    public BoldTextRendererDecorator(TextRenderer textRenderer) {
        super(textRenderer);
    }

    @Override
    public void render() {
        System.out.print("<b>");
        textRenderer.render();
        System.out.print("</b>");
    }
}
