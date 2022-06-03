package reqres;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static listenters.CustomAllureListener.withCustomTemplates;
import static org.hamcrest.Matchers.is;

public class Example {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://leads.kamnipiter.ru/";
    }

    @Test
    @DisplayName("Добавить товар 1 в корзину")
    void addJewelryToCart() {
        given()
                .filter(withCustomTemplates())
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                //.cookie("Nop.customer=16d5f2e3-1840-400f-9e7a-cf319a2733fd;")
                .body("product_id=472789&visitor_uuid=f9b30810-ec08-4113-8924-999173f1ea2d")
                .when()
                .post("leads_catcher/add_to_cart/")
                .then()
                .log().all()
           //     .body("product_id", is(472788))
     //           .body("visitor_uuid", is("f9b30810-ec08-4113-8924-999173f1ea2d"))
                .statusCode(200);
    }


}

