package lld.patterns.chainofresponsibility;

public class AuthenticationRequestHandler extends AbstractRequestHandler {
    @Override
    public void handle(Request request) {
        if (request.user == null) {
            System.out.println("AuthHandler: User not authenticated.");
            return;
        }
        System.out.println("AuthHandler: Authenticated.");
        forward(request);
    }
}
