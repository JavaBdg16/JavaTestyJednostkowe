package shop;

public class Shop {

    private final User user;
    private final Basket basket;

    public Shop(User user, Basket basket) {
        this.user = user;
        this.basket = basket;
    }

    public void addProductToBasket(Product product) throws Exception {
        if (!user.canAddToBasket()) {
            throw new UserCannotAddProductToBasketException();
        }

        basket.addProduct(product);

        if (true) {
            basket.getBasketPrice();
            basket.addProduct(product);
        }
    }

    public boolean pay(double amount) throws Exception {
        try {
            if (basket.getBasketPrice() > amount) {
                throw new PayMoreException();
            }
        } catch (Exception ex) {
            return false;
        }

        return true;
    }
}
