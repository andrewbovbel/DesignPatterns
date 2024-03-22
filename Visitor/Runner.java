import CreditCards.*;
import Offers.*;

public class Runner {
    public static void main(String[] args) {
        //figure out cashback for hotel in a bronze card
        OfferVisitor visitor1 = new HotelOfferVisitor();
        OfferVisitor visitor2 = new GasOfferVisitor();

        CreditCard bronze = new BronzeCreditCard();
        CreditCard silver = new SilverCreditCard();
        CreditCard gold = new GoldCreditCard();
        
        //subtypes are calculated at runtime! double dispatch works.
        bronze.accept(visitor1);
        silver.accept(visitor1);
        gold.accept(visitor1);

        bronze.accept(visitor2);
        silver.accept(visitor2);
        gold.accept(visitor2);

        //instead of tightly coupling the different types of offers, or operations, to original data structures and API we abstracted it to make extensible operations / offers decoupled from the concrete component credit card



        
        
    }
}