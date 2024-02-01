package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    static Properties properties = new Properties();

    public static String getProperties() throws IOException {
        String filePath = "src/main/resources/configuracoes.properties";

        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
            String uri = properties.getProperty("uri");

            return uri;

        } catch (IOException e) {
            throw new IOException("Erro ao carregar o arquivo de propriedades", e);
        }
    }

}


