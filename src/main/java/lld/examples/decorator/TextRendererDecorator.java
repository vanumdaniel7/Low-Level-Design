package lld.examples.decorator;

public abstract class TextRendererDecorator implements TextRenderer {
    protected TextRenderer textRenderer;

    public TextRendererDecorator(TextRenderer textRenderer) {
        this.textRenderer = textRenderer;
    }
}
