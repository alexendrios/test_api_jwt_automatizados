package tests.claims.test;

import io.qameta.allure.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.claims.request.ClaimsRequest;
import java.io.IOException;
import static config.ConfigProperties.getProperties;
import static data.Data.*;
import static org.hamcrest.CoreMatchers.containsString;

@Slf4j
@Feature("Claims")
@Owner("ITAU")
public class ClaimsTest {
    private final String uri;
    {
        try {
            uri = getProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private final String jwtValido = "/" + getJwtValido();

    @Test
    @Tag("regressao")
    @DisplayName("TC03 - Cadastro de um Claim com Sucesso - POST.")
    @Description("Deve realizar o cadastro de um Claim com Sucesso - POST.")
    public void deveRealizarOCadastroDeUmClaimComSucesso() {
        new ClaimsRequest().cadastroClaim(uri + jwtValido, getSucessClaim())
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_CREATED)
                .assertThat()
                .body("message", containsString("As informações contidas atendem à descrição"));
    }

    @Test
    @Tag("regressao")
    @DisplayName("TC04 - Cadastro de um Claim - JWT Inválido - POST.")
    @Description("Deve realizar o cadastro de um Claim - JWT Inválido - POST.")
    public void deveRealizarOCadastroDeUmClaimJwtInvalido() {
        String jwtInvalido = "/" + getJwtInvalida();
        new ClaimsRequest().cadastroClaim(uri + jwtInvalido, getInvalidClaim())
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .assertThat()
                .body("message", containsString("JWT inválido"));
    }

    @Test
    @Tag("regressao")
    @DisplayName("TC05 - Cadastro de um Claim - Claim Name com Números - POST.")
    @Description("Deve realizar o cadastro de um Claim - Claim Name com Números - POST.")
    public void deveRealizarOCadastroDeUmClaimClaimNameComNumeros() {
        String jwtNumero = "/" + getJwtNumero();
        new ClaimsRequest().cadastroClaim(uri + jwtNumero, getNumeroClaim())
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .assertThat()
                .body("message", containsString("A propriedade Name não pode conter caracteres numéricos."));
    }

    @Test
    @Tag("regressao")
    @DisplayName("TC06 - Cadastro de um Claim - Mais de três (03) Claim - POST.")
    @Description("Deve realizar o cadastro de um Claim - Mais de três Claim - POST.")
    public void deveRealizarOCadastroDeUmClaimMaisTresClaim() {
        String jwtMaisTresClaim = "/" + getJwtMaisTresClaim();
        new ClaimsRequest().cadastroClaim(uri + jwtMaisTresClaim, getMaisTresClaim())
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .assertThat()
                .body("message", containsString("O payload deve conter exatamente 3 propriedades."));
    }

    @Test
    @Tag("regressao")
    @DisplayName("TC07 - Cadastro de um Claim - A Key Role sem valor - POST.")
    @Description("Deve realizar o cadastro de um Claim - A Key Role sem valor - POST.")
    public void deveRealizarOCadastroDeUmClaimAkeyRoleSemValor() {
        new ClaimsRequest().cadastroClaim(uri + jwtValido, getClaimRoleSemValor())
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .assertThat()
                .body("message", containsString("A propriedade Role deve conter um dos valores: Admin, Member ou External."));
    }

    @Test
    @Tag("regressao")
    @DisplayName("TC08 - Cadastro de um Claim - A Key Seed seu valor deve ser um número primo - POST.")
    @Description("Deve realizar o cadastro de um Claim - A Key Seed seu valor deve ser um número primo - POST.")
    public void deveRealizarOCadastroDeUmClaimAkeySeedSeuValorDdeveDerUmNumeroPrimor() {
        new ClaimsRequest().cadastroClaim(uri + jwtValido, getClaimSeedNumeroNaoPrimo())
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .assertThat()
                .body("message", containsString("A propriedade Seed deve ser um número primo."));
    }

    @Test
    @Tag("regressao")
    @DisplayName("TC09 - Cadastro de um Claim - O tamanho máximo da claim Name é de 256 caracteres - POST.")
    @Description("Deve realizar o cadastro de um Claim - O tamanho máximo da claim Name é de 256 caracteres. - POST.")
    public void deveRealizarOCadastroDeUmClaimOtamanhoMaximoEde256Caracteres() {
        new ClaimsRequest().cadastroClaim(uri + jwtValido, getClaimNameCaracteresMaximo256())
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_CREATED)
                .assertThat()
                .body("message", containsString("As informações contidas atendem à descrição"));
    }

    @Test
    @Tag("regressao")
    @DisplayName("TC10 - Cadastro de um Claim - O tamanho da claim Name é maior que 256 caracteres - POST.")
    @Description("Deve realizar o cadastro de um Claim - O tamanho da claim Name é maior que 256 caracteres. - POST.")
    public void deveRealizarOCadastroDeUmClaimOtamanhoEmaiorQue256Caracteres() {
        new ClaimsRequest().cadastroClaim(uri + jwtValido, getClaimNameCaracteresMaior256())
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .assertThat()
                .body("message", containsString("O tamanho máximo da propriedade Name é de 256 caracteres."));
    }

}
