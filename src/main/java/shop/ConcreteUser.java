package shop;

public class ConcreteUser implements User {

    private boolean canAddToBasket;

    public ConcreteUser(boolean canAddToBasket) {
        this.canAddToBasket = canAddToBasket;
    }

    @Override
    public boolean canAddToBasket() {
        return canAddToBasket;
    }
}
