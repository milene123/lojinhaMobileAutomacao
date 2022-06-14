package telas;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTela extends BaseTela{
    public LoginTela (WebDriver app){
        super(app);
    }

    public LoginTela preencherUsuario(String usuario) {
        app.findElement(MobileBy.id("com.lojinha:id/user")).click();
        app.findElement(MobileBy.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys(usuario);
        return this;
    }
    public LoginTela preencherSenha(String senha){
        app.findElement(MobileBy.id("com.lojinha:id/password"));
        app.findElement(MobileBy.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys(senha);
        return this;
    }
    public ListagemProdutoTela submeterLogin(){
        app.findElement(MobileBy.id("com.lojinha:id/button")).click();
        return new ListagemProdutoTela(app);
    }
}
