package lld.patterns.mediator;

abstract class UIComponent {
    private UIMediator uiMediator;

    UIComponent(UIMediator uiMediator) {
        this.uiMediator = uiMediator;
    }

    public void notifyMediator() {
        uiMediator.onComponentChanged(this);
    }
}
