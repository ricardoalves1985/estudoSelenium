package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPages {
    private WebDriver navegador;

    public LoginPages(WebDriver navegador){
        this.navegador = navegador;

    }

    public LoginFormPage clicarSignIn(){
        navegador.findElement(By.linkText("Sign in")).click();
        return new LoginFormPage(navegador);

    }
}
