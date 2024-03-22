package CreditCards;

import Offers.OfferVisitor;

public class GoldCreditCard implements CreditCard{
    public String getName() {
        return "gold";
    }

    public void accept(OfferVisitor v) {
        v.visitGoldCreditCard(this);
    }
    
}
