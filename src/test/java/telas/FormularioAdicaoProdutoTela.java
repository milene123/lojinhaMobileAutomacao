package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioAdicaoProdutoTela extends BaseTela{
    public FormularioAdicaoProdutoTela (WebDriver app){
        super(app);
    }

    public FormularioAdicaoProdutoTela preencherNomeProduto(String produtoNome){
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys( produtoNome);
        return this;
    }
    public FormularioAdicaoProdutoTela preencherValorProduto(String produtoValor){
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoValor);
        return this;
    }
    public FormularioAdicaoProdutoTela preencherCoresProduto(String coresProduto){
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(coresProduto);
        return this;
    }
    public FormularioAdicaoProdutoTela submissaoErro(){
        app.findElement(By.id("com.lojinha:id/saveButton")).click();
        return this;
    }
    public String mensagemErro(){
        return capturarToast();
    }
}
