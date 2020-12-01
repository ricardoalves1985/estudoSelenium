package tests;

import  static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacaoUsuárioTest {
    @Test
    public void testAdicionarUmainformacaoAdicionalUsuario(){
        System.setProperty("webdriver.chrome.driver", "/Users/ricardoalves/IdeaProjects/chromedriver");
        WebDriver navegador = new ChromeDriver(); //abre o navegador
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("http://www.juliodelima.com.br/taskit");
        assertEquals(1, 1);

        //Clicar no navegador que possui texto Sing-In
        navegador.findElement(By.linkText("Sign in")).click();

        //Clicar no campo com nome Login.
        WebElement formularioSingInBox = navegador.findElement(By.id("signinbox"));

        //digitar dentro do campo Login
        formularioSingInBox.findElement(By.name("login")).sendKeys("julio0001");

        //digitar no campo senha
        formularioSingInBox.findElement(By.name("password")).sendKeys("123456");

        //clicar no botão sing in
        navegador.findElement(By.linkText("SIGN IN")).click();

        //validar que dentro do elemento com class "me" que está no texto "Hi Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoElementoMe = me.getText();
        assertEquals("Hi, Julio", textoElementoMe);


        navegador.close();
    }



}
