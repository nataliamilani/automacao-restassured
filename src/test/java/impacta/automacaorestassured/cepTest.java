package impacta.automacaorestassured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class cepTest {
    
    @BeforeAll
    public static void setBaseURI() {
        RestAssured.baseURI = "https://viacep.com.br/ws/";
    }

    @Test
    public void testGetCepStatusOk() {
        get("/04279030/json").then().statusCode(200);
    }

    @Test
    public void testGetCepStatusBadRequest() {
        get("/0427903/json").then().statusCode(400);
    }

    @Test
    public void testGetCepResponse() {

        var body = get("/04279030/json").then().statusCode(200).extract().body();

        assertEquals("04279-030", body.path("cep"));
        assertEquals("Rua Teodoro de Beaurepaire", body.path("logradouro"));
        assertEquals("", body.path("complemento"));
        assertEquals("Vila Dom Pedro I", body.path("bairro"));
        assertEquals("São Paulo", body.path("localidade"));
        assertEquals("SP", body.path("uf"));
        assertEquals("3550308", body.path("ibge"));
        assertEquals("1004", body.path("gia"));
        assertEquals("11", body.path("ddd"));
        assertEquals("7107", body.path("siafi"));

    }

    @Test
    public void testGetCepContentTypeJson(){

        var bodyContentType = get("/04279030/json").then().statusCode(200).extract().contentType();
        assertEquals("application/json; charset=utf-8", bodyContentType);

    }

    @Test
    public void testGetCepValidaContrato(){

        get("/04279030/json").then().assertThat()
                .body(containsString("cep"))
                .and().body(containsString("logradouro"))
                .and().body(containsString("complemento"))
                .and().body(containsString("bairro"))
                .and().body(containsString("localidade"))
                .and().body(containsString("uf"))
                .and().body(containsString("ibge"))
                .and().body(containsString("gia"))
                .and().body(containsString("ddd"))
                .and().body(containsString("siafi"));

    }

    @Test
    public void testGetCepInvalido(){

        var cepInvalido = get("/00000000/json").then().statusCode(200).extract().body();

        assertEquals(true, cepInvalido.path("erro"));

    }

}
