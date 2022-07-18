package pageObjects.jQuery.dataTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		// nhan enter
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
		// verify
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);

	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size = " + totalPage);

		List<String> allRowValueAllPage = new ArrayList<String>();
		// Set<String> allRowValueUniqueAllPage = new HashSet<String>();

		// duyệt qua tất cả page number(paning)
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));

			// get text của all row mỗi page đưa vào ArrayList
			// List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}

		// In ra tất cả giá trị trong row ra- tất cả các page
		for (String value : allRowValueAllPage) {
			System.out.println("----------------------------------");
			System.out.println(value);
		}

		return allRowValueAllPage;

	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
			//column index dựa vào tên cột
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;

		//sendkey vào dòng nào
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		//tbody//tr[1]/td[2]/input
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber,String.valueOf(columnIndex));
	
	}
	
	public void selectDropdownByColumnNameAtRowNumber(String columnName,String rowNumber,String valueToSelect) {
		int columnIndex = getElementSize(driver,HomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;
		waitForElementClickable(driver,HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
		selectItemDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,valueToSelect, rowNumber,String.valueOf(columnIndex));
	}
	
	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver,HomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;
		waitForElementClickable(driver,HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
		
	}

	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver,HomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;
		waitForElementClickable(driver,HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
		uncheckToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
		
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver,HomePageUI.ICON_NAME_BY_ROW_NUMBER,rowNumber,iconName);
		clickToElement(driver,HomePageUI.ICON_NAME_BY_ROW_NUMBER,rowNumber,iconName);
	}
}
