package data;

import static payloads.ReaderPayload.readerJson;

public class Data {

    public static String getSucessClaim() {
        return readerJson("src/main/resources/payloads/payload_sucesso.json");
    }

    public static String getInvalidClaim() {
        return readerJson("src/main/resources/payloads/payload_invalido.json");
    }

    public static String getNumeroClaim() {
        return readerJson("src/main/resources/payloads/payload_numero_claim.json");
    }

    public static String getMaisTresClaim() {
        return readerJson("src/main/resources/payloads/payload_mais_tres_claim.json");
    }

    public static String getClaimRoleSemValor() {
        return readerJson("src/main/resources/payloads/payload_key_roule_sem_valor.json");
    }

    public static String getClaimSeedNumeroNaoPrimo() {
        return readerJson("src/main/resources/payloads/payload_claim_seed_numero_nao_primo.json");
    }

    public static String getClaimNameCaracteresMaximo256() {
        return readerJson("src/main/resources/payloads/payload_claim_name_caractere_max_256.json");
    }

    public static String getClaimNameCaracteresMaior256() {
        return readerJson("src/main/resources/payloads/payload_claim_name_caractere_maior_256.json");
    }

    public static String getJwtValido() {
        return "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";
    }

    public static String getJwtInvalida() {
        return "eyJhbGciOiJzI1NiJ9.dfsdfsfryJSr2xrIjoiQWRtaW4iLCJTZrkIjoiNzg0MSIsIk5hbrUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05fsdfsIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";
    }

    public static String getJwtNumero() {
        return "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRXh0ZXJuYWwiLCJTZWVkIjoiODgwMzciLCJOYW1lIjoiTTRyaWEgT2xpdmlhIn0.6YD73XWZYQSSMDf6H0i3-kylz1-TY_Yt6h1cV2Ku-Qs";
    }

    public static String getJwtMaisTresClaim() {
        return "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiTWVtYmVyIiwiT3JnIjoiQlIiLCJTZWVkIjoiMTQ2MjciLCJOYW1lIjoiVmFsZGlyIEFyYW5oYSJ9.cmrXV_Flm5mfdpfNUVopY_I2zeJUy4EZ4i3Fea98zvY";
    }
}

