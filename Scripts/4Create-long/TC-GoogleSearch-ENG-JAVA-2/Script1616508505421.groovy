import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.jsoup.Jsoup as Jsoup
import org.jsoup.nodes.Document as Document
import org.jsoup.nodes.Element as Element

WebUI.openBrowser('https://www.google.com/?hl=en')

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('4Create/SearchBox'), '4Create')

WebUI.click(findTestObject('4Create/GoogleSearchBttn'))

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

WebUI.delay(2)

urlGoogleSearchENG = WebUI.getUrl()

System.out.println(urlGoogleSearchENG)

String USER_AGENT = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36'

Document doc = Jsoup.connect(urlGoogleSearchENG).userAgent(USER_AGENT).get()

for (Element link : doc.select("div.g a")) {
		
		final String urls = link.attr("href");
		
		if(urls.startsWith(urlStartsWith)) {
			
			System.out.println("Prvi link Google Search-a je ---: " + urlStartsWith);
		}

}

WebUI.navigateToUrl(urlStartsWith)
	
WebUI.waitForPageLoad(1)
	
url4CreateFromSite = WebUI.getUrl()
	
WebUI.verifyEqual(url4CreateExpected, url4CreateFromSite)
	
WebUI.delay(1)
	
WebUI.closeBrowser()
