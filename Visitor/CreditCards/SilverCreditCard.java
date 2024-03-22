package CreditCards;

import Offers.OfferVisitor;

public class SilverCreditCard implements CreditCard {
    public String getName() {
        return "silver";
    }

    public void accept(OfferVisitor v) {
        v.visitSilverCreditCard(this);
    }
}
