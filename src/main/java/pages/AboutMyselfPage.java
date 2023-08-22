package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AboutMyselfPage extends AbsBasePage {
      private String nameSelector = "fname";
      private String sNameSelector = "lname";
      private String nameLatinSelector = "fname_latin";
      private String surnameLatinSelector = "lname_latin";
      private String blogNameSelector = "blog_name";
      private String countryLocator = "//input[@name='country']/following-sibling::div";
      private String dateOfBirthSelector = "input[name='date_of_birth']";
      private String russiaSelector = "button[title='Россия']";
      private String levelOfEnglishLocator = "//input[@name='english_level']/following-sibling::div";
      private String elementaryLevelSelector = "button[title='Элементарный уровень (Elementary)']";
      private String cityLocator = "//input[@name='city']/following-sibling::div";
      private String aleksandrovSelector = "button[title='Александров']";
      private String typeOfRelationLocator = "label>div";
      private String remoteJobLocator = "//input[@value='remote']/following-sibling::span";
      private String emailPreferableLocator = "//input[@name='is_email_preferable']/following-sibling::span";
      private String buttonCommunicationLocator = "//button[contains(text(),'Способ связи')]";
      private String valueInListCommunicationLocator = "span.placeholder";
      private String skypeButtonSelector = "button[title='Skype']";
      private String fieldForSkypeLoginSelector = "input[name='contact-0-value']";
      private String genderSelector = "select[name='gender']";
      private String genderMailSelector = "option[value='m']";
      private String genderSelectedSelector = "option[selected]";
      private String companyNameSelector = "input[name='company']";
      private String ButtonSaveSelector = "button[name='continue']";
      private String professionNameSelector = "input[name='work']";
      private WebElement name;
      private WebElement sName;
      private WebElement latinName;
      private WebElement latinSurname;
      private WebElement blogName;
      private WebElement dateOfBirth;
      private WebElement readyToMoveClick = driver.findElement(By.xpath("//span[contains(text(),'Да')]"));
      private WebElement readyToMoveStatus = driver.findElement(By.cssSelector("#id_ready_to_relocate_1"));
      private WebElement flexible = (driver.findElement(By.cssSelector("input[value='flexible']")));
      private WebElement remote = (driver.findElement(By.cssSelector("input[value='remote']")));
      private WebElement emailPreferable = (driver.findElement(By.cssSelector("input[name='is_email_preferable']")));
      private WebElement fieldForSkypeLogin;
      private WebElement companyName;
      private WebElement engineer;
        public AboutMyselfPage(WebDriver driver) {
        super(driver);
        this.name = driver.findElement(By.name(nameSelector));
        this.sName = driver.findElement(By.name(sNameSelector));
        this.latinName = driver.findElement(By.name(nameLatinSelector));
        this.latinSurname = driver.findElement(By.name(surnameLatinSelector));
        this.blogName = driver.findElement(By.name(blogNameSelector));
        this.dateOfBirth = driver.findElement(By.cssSelector(dateOfBirthSelector));
        this.fieldForSkypeLogin = driver.findElement(By.cssSelector(fieldForSkypeLoginSelector));
        this.companyName = driver.findElement(By.cssSelector(companyNameSelector));
        this.engineer = driver.findElement(By.cssSelector(professionNameSelector));
    }

    public void waitingForElementContry() {
        waitingForElement(countryLocator, russiaSelector);
    }

    public void waitingForElement(String firstClick, String secondClick) {
        driver.findElement(By.xpath(firstClick)).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement webElement = driver.findElement(By.cssSelector(secondClick));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        driver.findElement(By.cssSelector(secondClick)).click();
    }

    public void waitingForElementLevelOfEnglish() {
        waitingForElement(levelOfEnglishLocator, elementaryLevelSelector);
    }

    public void waitingForElementCity() {
        waitingForElement(cityLocator, aleksandrovSelector);
    }

    public void waitingForElementTypeOfCommunication() {
        waitingForElement(buttonCommunicationLocator, valueInListCommunicationLocator);
    }

    public void clickButton(By text) {
        driver.findElement(text).click();
    }

    public void clickGender() {
        driver.findElement(By.cssSelector(genderSelector)).click();
    }

    public void clickGenderMail() {
        driver.findElement(By.cssSelector(genderMailSelector)).click();
    }

    public void clickTypeOfCommunication() {
        driver.findElements(By.cssSelector(typeOfRelationLocator)).get(3).click();
    }

    public void clickButtonSkype() {
        driver.findElement(By.cssSelector(skypeButtonSelector)).click();
    }

    public void clickButtonSave() {
        driver.findElement(By.cssSelector(ButtonSaveSelector)).click();
    }

    public void clearAndEnterName(String text) {
        name.clear();
        name.sendKeys(text);
    }

    public void clearAndEnterSName(String text) {
        sName.clear();
        sName.sendKeys(text);
    }

    public void clearAndEnterLatinName(String text) {
        latinName.clear();
        latinName.sendKeys(text);
    }

    public void clearAndEnterLatinSurname(String text) {
        latinSurname.clear();
        latinSurname.sendKeys(text);
    }

    public void clearAndEnterBlogName(String text) {
        blogName.clear();
        blogName.sendKeys(text);
    }

    public void clearAndEnterDateOfBirth(String text) {
        dateOfBirth.clear();
        dateOfBirth.sendKeys(text);
    }

    public void clearAndEnterSkypeLogin(String text) {
        fieldForSkypeLogin.clear();
        fieldForSkypeLogin.sendKeys(text);
    }

    public void clearAndEnterCompany(String text) {
        companyName.clear();
        companyName.sendKeys(text);
    }

    public void clearAndEnterSpeciality(String text) {
        engineer.clear();
        engineer.sendKeys(text);
    }

    public void checkboxFlexibleIsSelected() {
        if (flexible.isSelected()) {
            System.out.println("Гибкий график: " + flexible.isSelected());
        } else {
            flexible.click();
            System.out.println("Нажимаю Гибкий график, теперь он нажат " + flexible.isSelected());
        }
        System.out.println("Состояние удаленной работы было " + remote.isSelected());
    }

    public boolean checkCheckboxFlexibleIsSelected(){
       return flexible.isSelected();
    }
    public boolean checkCheckboxRemoteIsSelected(){
        return remote.isSelected();
    }
    public boolean checkCheckboxReadyToMoveIsSelected(){
    return readyToMoveStatus.isSelected();
    }
    public boolean checkCheckboxEmailPreferableIsSelected(){
        return emailPreferable.isSelected();
    }
    public void remoteJobIsSelected() {
        if (remote.isSelected()) {
            System.out.println("удаленная работа: " + remote.isSelected());
        } else {
            clickButton(By.xpath(remoteJobLocator));
            System.out.println("Удаленная работа, теперь  нажата " + remote.isSelected());
        }
        System.out.println("Состояние предпочтительно email было " + emailPreferable.isSelected());
    }

    public void checkboxEmailPreferableIsSelected() {
        if (emailPreferable.isSelected()) {
            System.out.println("Предпочтительно email выбран: " + emailPreferable.isSelected());
        } else {
            clickButton(By.xpath(emailPreferableLocator));
            System.out.println("Нажимаю предпочтительный способ связи email " + emailPreferable.isSelected());
        }
    }

    public void readyToMoveClick() {
        readyToMoveClick.click();
    }

    public String readValueAsAtribute(By by) {
        return driver.findElement(by).getAttribute("value");
    }
    public String readValueAsText (By by){
        return driver.findElement(by).getText();
    }
    public String checkName(){
        return readValueAsAtribute(By.name(nameSelector));
   }
    public String checkSurname(){
        return readValueAsAtribute(By.name(sNameSelector));
    }
    public String checkLatinName(){
        return readValueAsAtribute(By.name(nameLatinSelector));
    }
    public String checkLatinSurname(){
        return readValueAsAtribute(By.name(surnameLatinSelector));
    }
    public String checkBlogName(){
        return readValueAsAtribute(By.name(blogNameSelector));
    }
    public String checkCountry(){
        return readValueAsText(By.xpath(countryLocator));
    }
    public String checkCity(){
        return readValueAsText(By.xpath(cityLocator));
    }
    public String checkSkypeLogin(){
        return fieldForSkypeLogin.getAttribute("value");
    }
    public String checkGender(){
        return readValueAsText(By.cssSelector(genderSelectedSelector));
    }
    public String checkCompany(){
        return readValueAsAtribute(By.cssSelector(companyNameSelector));
    }
    public String checkProfession(){
        return readValueAsAtribute(By.cssSelector(professionNameSelector));
    }
    public void cookie() {

        driver.manage().addCookie((new Cookie("Cookie1", "Otus1")));
        driver.manage().addCookie((new Cookie("Cookie2", "Otus2")));
        Cookie cookie = new Cookie("Cooki3", "Otus3");
        driver.manage().addCookie((new Cookie("Cookie4", "Otus4")));
        System.out.println(driver.manage().getCookies());
    }
}
