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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('Checkout 1 Product/TC checkout step 1, 1 product'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('CheckoutOverview_Sauce Labs Backpack_ProductName'), data.get('product_name'))

WebUI.verifyElementText(findTestObject('CheckoutOverview_Sauce Labs Backpack_ProductDetail'), data.get('product_detail'))

WebUI.verifyElementText(findTestObject('CheckoutOverview_Sauce Labs Backpack_Price'), data.get('product_price'))

String pricetemp = data.get('product_price')

String pricestring = pricetemp.replace('$', '')

Double price = Double.parseDouble(pricestring)

itemtotaltemp = WebUI.getText(findTestObject('CheckoutOverview_ItemTotal'))

String itemtotalstring = itemtotaltemp.replace('Item total: $', '')

Double itemtotal = Double.parseDouble(itemtotalstring)

taxtemp = WebUI.getText(findTestObject('CheckoutOverview_Tax'))

String taxstring = taxtemp.replace('Tax: $', '')

Double tax = Double.parseDouble(taxstring)

totaltemp = WebUI.getText(findTestObject('CheckoutOverview_Total'))

String totalstring = totaltemp.replace('Total: $', '')

Double total = Double.parseDouble(totalstring)

WebUI.verifyEqual(itemtotal, price)

WebUI.verifyEqual(total, price + tax)

WebUI.click(findTestObject('CheckoutOverview_Finish'))

