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

WebUI.callTestCase(findTestCase('Common/TC_Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Products_Sauce Labs Backpack_AddtoCart'))

name = WebUI.getText(findTestObject('Products_Sauce Labs Backpack_ProductName'))
detail = WebUI.getText(findTestObject('Products_Sauce Labs Backpack_DetailProdut'))
price = WebUI.getText(findTestObject('Products_Sauce Labs Backpack_Price'))

WebUI.click(findTestObject('btn_cart'))

WebUI.click(findTestObject('button_Checkout'))

HashMap<String, Object> data = new HashMap<String, Object>()

data.put('product_name', name)
data.put('product_detail', detail)
data.put('product_price', price)

return data

WebUI.verifyElementText(findTestObject('YourCart_Sauce  Labs Backpack_ProductName'), data.get('product_name'))
WebUI.verifyElementText(findTestObject('YourCart_Sauce  Labs Backpack_ProductDetail'), data.get('product_detail'))
WebUI.verifyElementText(findTestObject('YourCart_Sauce  Labs Backpack_Price'), data.get('product_price'))
