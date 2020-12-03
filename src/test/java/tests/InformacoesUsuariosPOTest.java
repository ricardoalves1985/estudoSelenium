package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPages;
import suporte.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuariosPOTest.csv")
public class InformacoesUsuariosPOTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();

    }

    @Test
    public void testAdicionarUmainformacaoAdicionalUsuario(
            @Param(name="login")String login,
            @Param(name="senha")String senha,
            @Param(name="tipo")String tipo,
            @Param(name="contato")String contato,
            @Param(name="mensagem")String mensagemEsperada
    ){

        String textoToast = new LoginPages(navegador)
                .clicarSignIn()
                .fazerLogin(login, senha)
                .clicarMe()
                .clicarAbaMoreDataAboutYou()
                .clicarBotaoAdicionarMoreDataAboutyou()
                .adicionarContato(tipo, contato)
                .capturarTextoToast();
        assertEquals(mensagemEsperada, textoToast);
    }


    @After
    public void testDown(){
        navegador.quit();
    }
}