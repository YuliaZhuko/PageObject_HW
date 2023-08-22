package main;
import components.popups.AuthPopup;
import components.popups.ProfilPopup;
import data.PersonalsFieldsData;
import driver.DriverFactory;
import exceptions.DriverNotSupportedException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.AboutMyselfPage;
import pages.MainPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.FileNotFoundException;

public class AboutMyselfPageTest {

    private WebDriver driver;
    private Logger log = (Logger) LogManager.getLogger(AboutMyselfPageTest.class);

    @BeforeEach
    public void init() throws DriverNotSupportedException{
        this.driver = new DriverFactory().getDriver();
    }

    @AfterEach
    public void close (){
        if (this.driver != null) {
            this.driver.close();
            this.driver.quit();
        }
    }

    @Test
    public void aboutMyselfPageTestFillFields() throws FileNotFoundException {
        log.debug("Тестовое сообщение");
       MainPage mainPage = new MainPage(driver);
       ProfilPopup profilPopup = new ProfilPopup(driver);
       mainPage.open("");
       new AuthPopup(driver).auth(mainPage);
       profilPopup.clickButton();
       profilPopup.clickProfil();
       AboutMyselfPage aboutMyselfPage = new AboutMyselfPage(driver);
       aboutMyselfPage.waitingForElementContry();

        aboutMyselfPage.clearAndEnterName(PersonalsFieldsData.NAME.getTitle());
        aboutMyselfPage.clearAndEnterSName(PersonalsFieldsData.SName.getTitle());
        aboutMyselfPage.clearAndEnterLatinName(PersonalsFieldsData.LATINNAME.getTitle());
        aboutMyselfPage.clearAndEnterLatinSurname(PersonalsFieldsData.LATINSURNAME.getTitle());
        aboutMyselfPage.clearAndEnterBlogName(PersonalsFieldsData.BLOGNAME.getTitle());
        aboutMyselfPage.clearAndEnterDateOfBirth(PersonalsFieldsData.DATEOFBIRTH.getTitle());


        aboutMyselfPage.waitingForElementLevelOfEnglish();
        aboutMyselfPage.waitingForElementCity();
        aboutMyselfPage.readyToMoveClick();
        aboutMyselfPage.checkboxFlexibleIsSelected();
        aboutMyselfPage.remoteJobIsSelected();
       aboutMyselfPage.checkboxEmailPreferableIsSelected();

        aboutMyselfPage.clickTypeOfCommunication();
        aboutMyselfPage.waitingForElementTypeOfCommunication();

        aboutMyselfPage.clickButtonSkype();

        aboutMyselfPage.clearAndEnterSkypeLogin(PersonalsFieldsData.SKYPELOGIN.getTitle());

        aboutMyselfPage.clickGender();
        aboutMyselfPage.clickGenderMail();

        aboutMyselfPage.clearAndEnterCompany(PersonalsFieldsData.COMPANY.getTitle());
        aboutMyselfPage.clearAndEnterSpeciality(PersonalsFieldsData.PROFESSION.getTitle());

        aboutMyselfPage.clickButtonSave();

    }

    @Test
    public void aboutMyselfPageTestCheckFields() throws FileNotFoundException {
        log.debug("Тестовое сообщение");
        MainPage mainPageCheck = new MainPage(driver);
        ProfilPopup profilPopupCheck = new ProfilPopup(driver);
        mainPageCheck.open("");
        new AuthPopup(driver).auth(mainPageCheck);
        profilPopupCheck.clickButton();
        profilPopupCheck.clickProfil();
        AboutMyselfPage aboutMyselfPageCheck = new AboutMyselfPage(driver);
        Assertions.assertEquals(PersonalsFieldsData.NAME.getTitle(),aboutMyselfPageCheck.checkName(),"Имя не совпадает!");
        Assertions.assertEquals(PersonalsFieldsData.SName.getTitle(),aboutMyselfPageCheck.checkSurname(),"Фамилия не русском совпадает!");
        Assertions.assertEquals(PersonalsFieldsData.LATINNAME.getTitle(),aboutMyselfPageCheck.checkLatinName(),"Имя на латинском не совпадает!");
        Assertions.assertEquals(PersonalsFieldsData.LATINSURNAME.getTitle(),aboutMyselfPageCheck.checkLatinSurname(),"Фамилия на латинском не совпадает!");
        Assertions.assertEquals(PersonalsFieldsData.BLOGNAME.getTitle(),aboutMyselfPageCheck.checkBlogName(),"Имя в блоге м не совпадает!");
        Assertions.assertEquals(PersonalsFieldsData.COUNTRY.getTitle(),aboutMyselfPageCheck.checkCountry(),"Страна отличается от ожидаемой");
        Assertions.assertEquals(PersonalsFieldsData.CITY.getTitle(),aboutMyselfPageCheck.checkCity(),"Город отличается от ожидаемого");
        Assertions.assertTrue(aboutMyselfPageCheck.checkCheckboxFlexibleIsSelected());
        Assertions.assertTrue(aboutMyselfPageCheck.checkCheckboxRemoteIsSelected());
        Assertions.assertTrue(aboutMyselfPageCheck.checkCheckboxReadyToMoveIsSelected());
        Assertions.assertTrue(aboutMyselfPageCheck.checkCheckboxEmailPreferableIsSelected());
        Assertions.assertEquals(PersonalsFieldsData.SKYPELOGIN.getTitle(), aboutMyselfPageCheck.checkSkypeLogin(),"Skype логин не совпадает");
        Assertions.assertEquals(PersonalsFieldsData.GENDER.getTitle(),aboutMyselfPageCheck.checkGender(),"Пол не совпадает");
        Assertions.assertEquals(PersonalsFieldsData.COMPANY.getTitle(),aboutMyselfPageCheck.checkCompany(),"Пол не совпадает");
        Assertions.assertEquals(PersonalsFieldsData.PROFESSION.getTitle(),aboutMyselfPageCheck.checkProfession(),"Пол не совпадает");
        aboutMyselfPageCheck.cookie();
    }
}
