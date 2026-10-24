package lld.examples.decorator;

public class ItalicTextRendererDecorator extends TextRendererDecorator {

    public ItalicTextRendererDecorator(TextRenderer textRenderer) {
        super(textRenderer);
    }

    @Override
    public void render() {
        System.out.print("<i>");
        textRenderer.render();
        System.out.print("</i>");
    }
}
