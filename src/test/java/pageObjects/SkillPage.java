package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SkillPage extends BasePage {
    public String skillPageUrl = "https://otus.ru/lk/biography/skills/";

    @FindBy(xpath = ".//label[.//input[@data-title='Направление специализации']]/div")
    public WebElement DIRECTION_FIELD;

    @FindBy(xpath = ".//label[.//input[@data-title='Название специализации']]/div")
    public WebElement SPECIALIZATION_FIELD;

    @FindBy(css="div.lk-cv-action-buttons > button[title=\"Сохранить и заполнить позже\"]")
    public WebElement SAVE_AND_FILL_LATER_BTN;

    @FindBy(css="div.notification-lib")
    public WebElement ERROR_NOTIFICATION;



    public SkillPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver,this);
    }

    public void selectValueFromDropdownList(String value){
        clickOn(driver.findElement(By.xpath(String.format(".//button[@title=\"%s\"]", value))));
    }

    public String getDirectionValue(WebElement element){
        return element.getText();
    }

    public void checkErrorMessageAppears(){
        wait.until(ExpectedConditions.visibilityOf(ERROR_NOTIFICATION));
    }


}
