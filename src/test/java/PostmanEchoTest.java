import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


class PostmanEchoTest {
    @Test
    void shouldTest() {
// Предусловия
        given()
                .baseUri("https://postman-echo.com")

             //   .header("header1", "123")

                .body("some value") // отправляемые данные (заголовки и query можно выставлять аналогично)
                .queryParam("Some_data", "bla-bla")
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some valu"))
                .body("args.Some_data", equalTo("bla-bla"))

              //  .header("header1", equalTo("123"))
        ;
    }
}
