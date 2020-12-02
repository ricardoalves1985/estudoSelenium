package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPages;
import suporte.Web;

public class InformacoesUsuariosPOTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();

    }

    @Test
    public void testAdicionarUmainformacaoAdicionalUsuario(){
        new LoginPages(navegador)
                .clicarSignIn()
                .fazerLogin("julio0001", "123456");

    }


    @After
    public void testDown(){
        navegador.quit();
    }
}
