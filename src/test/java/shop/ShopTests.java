package shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShopTests {

    @Test
    public void when_user_cannot_add_to_basket_then_throws_eception() {

        // Arrange
        User user = new User() {
            @Override
            public boolean canAddToBasket() {
                return false;
            }
        };

        Basket basket = new Basket() {
            @Override
            public void addProduct(Product product) {

            }

            @Override
            public double getBasketPrice() {
                return 0;
            }
        };

        Shop shop = new Shop(user, basket);

        try {
            // Act
            shop.addProductToBasket(new Product() {});
            Assertions.fail("Exception is expected");
        } catch (Exception e) {
            // Assert
            Assertions.assertTrue(e instanceof UserCannotAddProductToBasketException);
        }
    }

    @Test
    public void when_concreteUser_cannot_add_to_basket_then_throws_eception() {

        // Arrange
        ConcreteUser user = new ConcreteUser(false);

        Basket basket = new Basket() {
            @Override
            public void addProduct(Product product) {

            }

            @Override
            public double getBasketPrice() {
                return 0;
            }
        };

        Shop shop = new Shop(user, basket);

        try {
            // Act
            shop.addProductToBasket(new Product() {});
            Assertions.fail("Exception is expected");
        } catch (Exception e) {
            // Assert
            Assertions.assertTrue(e instanceof UserCannotAddProductToBasketException);
        }
    }

    @Test
    public void using_mockito_when_user_cannot_add_to_basket_then_throws_eception() {

        // Arrange
        User user = Mockito.mock(User.class);
        Mockito.when(user.canAddToBasket()).thenReturn(true);

        Basket basket = Mockito.mock(Basket.class);

        Shop shop = new Shop(user, basket);

        try {
            // Act
            shop.addProductToBasket(new Product() {});
            Assertions.fail("Exception is expected");
        } catch (Exception e) {
            // Assert
            Assertions.assertTrue(e instanceof UserCannotAddProductToBasketException);
        }
    }
}
