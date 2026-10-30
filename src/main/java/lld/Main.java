package lld;

import lld.patterns.chainofresponsibility.*;
import lld.patterns.decorator.HouseBlend;
import lld.patterns.decorator.Latte;
import lld.patterns.decorator.Mocha;
import lld.patterns.decorator.Beverage;

public class Main {
    static void main(String[] args) {
        AbstractRequestHandler auth = new AuthenticationRequestHandler();
        AbstractRequestHandler authorization = new AuthorizationRequestHandler();
        AbstractRequestHandler rateLimit = new RateLimitRequestHandler();

        auth.setNext(authorization);
        authorization.setNext(rateLimit);

        Request goodRequest = new Request("john", "ADMIN", 10, "{ \"data\": \"valid\" }");
        auth.handle(goodRequest);

        System.out.println("\n--- Trying an invalid request ---");
        Request badRequest = new Request(null, "USER", 150, "");
        auth.handle(badRequest);
    }
}
