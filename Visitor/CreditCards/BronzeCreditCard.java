package CreditCards;

import Offers.OfferVisitor;

public class BronzeCreditCard implements CreditCard{
    public String getName() {
        return "bronze";
    }

    public void accept(OfferVisitor v) {
        v.visitBronzeCreditCard(this);
    }
}
