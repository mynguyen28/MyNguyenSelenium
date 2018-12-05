package Common.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Common.Constant.Constant;
import Common.Constant.Constant.Browser;

public class WebdriverManager {

	private static Browser driverType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebdriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		
	}

	public WebDriver getDriver() {
        switch (driverType) {	    
        case FIREFOX : Constant.WEBDRIVER = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty(CHROME_DRIVER_PROPERTY, Utilities.getProjectPath()+FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	Constant.WEBDRIVER = new ChromeDriver();
    		break;
        case INTERNETEXPLORER : Constant.WEBDRIVER = new InternetExplorerDriver();
    		break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) Constant.WEBDRIVER.manage().window().maximize();
		return Constant.WEBDRIVER;
	}
	
	

}
