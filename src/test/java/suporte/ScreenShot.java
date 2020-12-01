package suporte;

import com.google.common.io.Files;
import com.sun.jna.platform.FileUtils;
import com.sun.jna.platform.mac.MacFileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import sun.reflect.misc.FieldUtil;

import java.io.File;

public class ScreenShot {
    public static void tirar(WebDriver navegador, String arquivo){
        File screenshot =((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(screenshot, new File(arquivo));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
