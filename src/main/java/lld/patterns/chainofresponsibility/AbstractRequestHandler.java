package lld.patterns.chainofresponsibility;

public abstract class AbstractRequestHandler implements RequestHandler {

    private RequestHandler next;

    @Override
    public void setNext(RequestHandler next) {
        this.next = next;
    }

    protected void forward(Request request) {
        if (this.next != null) {
            next.handle(request);
        }
    }
}
