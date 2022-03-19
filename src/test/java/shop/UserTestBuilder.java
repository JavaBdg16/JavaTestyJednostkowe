package shop;

public class UserTestBuilder {

    public static User getUserWithAddProductToBasketBlock() {
        return new User() {
            @Override
            public boolean canAddToBasket() {
                return false;
            }
        };
    }
}
