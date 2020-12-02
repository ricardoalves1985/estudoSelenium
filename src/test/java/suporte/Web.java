package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "/Users/ricardoalves/IdeaProjects/chromedriver");

         WebDriver navegador = new ChromeDriver(); //abre o navegador
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("http://www.juliodelima.com.br/taskit");


        return navegador;
    }
}
