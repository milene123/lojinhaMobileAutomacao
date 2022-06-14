package modulos.usuarios.produtos;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import telas.LoginTela;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("Teste Mobile do Módulo de Produtos")
public class ProdutoTest {
    private    WebDriver app;
    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("deviceName","Moto g60");
        capacidades.setCapability("platformName","Android");
        capacidades.setCapability("udid","0074264725");
        capacidades.setCapability("appPackage","com.lojinha");
        capacidades.setCapability("appActivity","com.lojinha.ui.MainActivity");
        capacidades.setCapability("app","C:\\Users\\milen\\Documents\\Curso-Programa de Teste de Software(Julio de Lims)\\Modulo  11 - Teste Mobile\\Material Completa - Modulo Mobile\\Lojinha+Android+Nativa\\lojinha-nativa.apk");

        this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        this.app.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @DisplayName("Validação do Valor do Produto não e permitido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoEPermitido(){

        String mensagemApresentada = new LoginTela(app)
                .preencherUsuario("milenesouza")
                .preencherSenha("123456789")
                .submeterLogin()
                .abrirTelaAdicaoProduto()
                .preencherNomeProduto("Samsung A10s")
                .preencherValorProduto("7000100")
                .preencherCoresProduto("Rosa")
                .submissaoErro()
                .mensagemErro();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);

    }
    @AfterEach
    public void afterEach(){
        app.quit();
    }
}
