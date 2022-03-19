package shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.*;

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
            shop.addProductToBasket(new Product() {
                @Override
                public boolean setPrice(double price) {
                    return true;
                }
            });
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
            shop.addProductToBasket(new Product() {
                @Override
                public boolean setPrice(double price) {
                    return true;
                }
            });
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
        Mockito.when(user.canAddToBasket()).thenReturn(false);

        Basket basket = Mockito.mock(Basket.class);

        Shop shop = new Shop(user, basket);

        try {
            // Act
            shop.addProductToBasket(new Product() {
                @Override
                public boolean setPrice(double price) {
                    return true;
                }
            });
            Assertions.fail("Exception is expected");
        } catch (Exception e) {
            // Assert
            Assertions.assertTrue(e instanceof UserCannotAddProductToBasketException);
        }
    }

    @Test
    public void using_mockito_when_user_can_add_to_basket_then_success() {
        // Arrange
        User user = Mockito.mock(User.class);
        Mockito.when(user.canAddToBasket()).thenReturn(true);
        Basket basket = Mockito.mock(Basket.class);

        Product product = Mockito.mock(Product.class);
        Shop shop = new Shop(user, basket);


        try {
            // Act
            shop.addProductToBasket(product);

            // Assert
            Mockito.verify(
                    basket,
                    Mockito.times(2)
            ).addProduct(Mockito.any(Product.class));

            Mockito.verify(
                    basket,
                    Mockito.times(1)
            ).getBasketPrice();

            InOrder then = Mockito.inOrder(basket);
            then.verify(basket).getBasketPrice();
            then.verify(basket).addProduct(Mockito.any(Product.class));

            Mockito.verifyNoMoreInteractions(basket);
        } catch (Exception e) {
            Assertions.fail("Exception is not expected");
        }
    }

    @Test
    public void using_mockito_when_user_pay_not_enough_money_then_exception() {
        // Arrange
        User user = Mockito.mock(User.class);
        Basket basket = Mockito.mock(Basket.class);
        Mockito.when(basket.getBasketPrice()).thenReturn(100.0);
        Shop shop = new Shop(user, basket);

        try {
            // Act
            boolean succes = shop.pay(50.0);
            Assertions.fail("Exception is expected");
        } catch (Exception e) {
            // Assert
            Assertions.assertTrue(e instanceof PayMoreException);
        }
    }

    @Test
    public void using_mockito_when_user_pay_enough_money_then_true() {
        // Arrange
        User user = Mockito.mock(User.class);
        Basket basket = Mockito.mock(Basket.class);
        Mockito.when(basket.getBasketPrice()).thenReturn(100.0);
        Shop shop = new Shop(user, basket);

        try {
            // Act
            boolean success = shop.pay(100.0);

            // Assert
            Assertions.assertTrue(success);
        } catch (Exception e) {
            Assertions.fail("Exception is not expected");
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 10.0, 20.0, 30.0, 40.0})
    public void using_stub_when_user_pay_not_enough_money_then_exception(double val) {
        // Arrange
        User user = new User() {
            @Override
            public boolean canAddToBasket() {
                return true;
            }
        };

        Basket basket = new Basket() {
            @Override
            public void addProduct(Product product) {

            }

            @Override
            public double getBasketPrice() {
                return 100.0;
            }
        };

        Shop shop = new Shop(user, basket);

        try {
            // Act
            boolean succes = shop.pay(val);
            Assertions.fail("Exception is expected");
        } catch (Exception e) {
            // Assert
            Assertions.assertTrue(e instanceof PayMoreException);
        }
    }

    @Test
    public void using_stub_when_user_pay_enough_money_then_true() {
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
                return 100.0;
            }
        };

        Shop shop = new Shop(user, basket);

        try {
            // Act
            boolean success = shop.pay(100.0);

            // Assert
            Assertions.assertTrue(success);
        } catch (Exception e) {
            Assertions.fail("Exception is not expected");
        }
    }

    @Test
    public void exception_test() {

        // Arrange
        User user = Mockito.mock(User.class);
        Basket basket = Mockito.mock(Basket.class);

        // BDDMockito.given(basket.getBasketPrice()).willThrow(new RuntimeException());
        Mockito.when(basket.getBasketPrice()).thenThrow(new RuntimeException("Mocked exception"));

        Shop shop = new Shop(user, basket);
        try {
            // Act
            boolean success = shop.pay(50.0);

            // Assert
            Assertions.assertFalse(success);
        } catch (Exception e) {
            Assertions.fail("Exception is not expected");
        }
    }

    @Test
    public void multiple_value_test() {

        Basket basket = Mockito.mock(Basket.class);
        Mockito.when(basket.getBasketPrice()).thenReturn(100.0, 110.0, 120.0);

        Assertions.assertEquals(basket.getBasketPrice(), 100.0);
        Assertions.assertEquals(basket.getBasketPrice(), 110.0);
        Assertions.assertEquals(basket.getBasketPrice(), 120.0);
        Assertions.assertEquals(basket.getBasketPrice(), 120.0);
    }

    @Test
    public void argument_matchers() {
        Basket basket = Mockito.mock(Basket.class);
        Mockito.when(basket.getBasketPrice()).thenReturn(100.0);

        Product product = Mockito.mock(Product.class);
        Mockito.when(product.setPrice(ArgumentMatchers.anyDouble())).thenReturn(true);
        Mockito.when(product.setPrice(ArgumentMatchers.doubleThat(new ArgumentMatcher<Double>() {
            @Override
            public boolean matches(Double aDouble) {
                return aDouble > 100;
            }
        })));
    }
}
