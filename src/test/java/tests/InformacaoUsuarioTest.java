package tests;

import  static org.junit.Assert.*;


import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.ScreenShot;
import suporte.Web;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacaoUsuarioTest.csv") //onde fcara guardado os dados da classe
public class InformacaoUsuarioTest {

    private WebDriver navegador;
    @Rule
    public TestName test = new TestName();



    @Before
    public void steUP(){
        navegador = Web.createChrome();

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


        //clicar no link que tenha a opção "me"
        navegador.findElement(By.className("me")).click();
        //clicar em um link que tenha moredataaboutyou
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();


    }

    @Test
    public void testAdicionarUmainformacaoAdicionalUsuario(@Param(name="tipo")String tipo, @Param(name="contato")String contato,@Param(name="mensagem")String mensagemEsperada
    ){




        //clicar no botão pelo xpath
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //identificar a popup onde esta o formulario date id moredata
        WebElement popupAppMoreData = navegador.findElement(By.id("addmoredata"));

        //na combo de nam type escolher a opção phone
         WebElement campoType = popupAppMoreData.findElement(By.name("type")); //identifica elemente e coloca nome dele -2
        new Select(campoType).selectByVisibleText(tipo); //interagir com combobox
        //no campode name contact digitar o telefone
        popupAppMoreData.findElement(By.name("contact")).sendKeys(contato);

        //clicar no link de  save que está na popup
        popupAppMoreData.findElement(By.linkText("SAVE")).click();

        // na msg de id do container validar que o texto é
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));

        String mensagem = mensagemPop.getText();
        assertEquals(mensagemEsperada, mensagem);



        
    }


    //@Test
    public void removerContatoUsuario(){
        // clicar no elemento pelo seu xpath
        navegador.findElement(By.xpath("//span[text()=\"+5548999999999\"]/following-sibling::a")).click();
        // confirmar a janela javascript
        navegador.switchTo().alert().accept(); // switchTo()--> a janela vai para outro contexto, janela javascript

        // validar que a mensagem apresentada foi Rest in peace, dear phone
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));

        String mensagem = mensagemPop.getText();
        assertEquals("Rest in peace, dear phone!", mensagem);

        String screenshotArquivo = "/Users/ricardoalves/test-report/taskit/" + Generator.dataHoraParaArquivo()+ test.getMethodName()+ ".png";
        ScreenShot.tirar(navegador, screenshotArquivo);


        // aguardar até 10s para ajanela desaparecer.
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));


        // clicar no link contexto  Logout

        navegador.findElement(By.linkText("Logout")).click();
    }
    @After
    public void testDown(){
        navegador.close();

    }



}
