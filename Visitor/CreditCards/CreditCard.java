package CreditCards;

import Offers.OfferVisitor;

public interface CreditCard {
    public String getName();

    // accept method is the entry point for extensibility for any future operations dealing with offers on a particular credit card
    public void accept(OfferVisitor v);

}
