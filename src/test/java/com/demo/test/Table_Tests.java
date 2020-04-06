package com.demo.test;

import com.demo.utilities.Driver;
import com.demo.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Table_Tests {

    @FindBy(css = "#table1>thead>tr>th")
    List<WebElement> table_head;

    @FindBy(css = "#table1>tbody>tr")
    List<WebElement> rows;

    public String read_table(int row, int col) {
        WebElement data = Driver.getDriver().findElement(By.cssSelector("#table1>thead>tr:nth-child("+row+")>th:nth-child("+col+")"));
        return data.getText();
    }

    @BeforeMethod
    public void startUP() {
        System.out.println("================START================");
        Driver.getDriver().get("http://practice.cybertekschool.com/tables");
        Driver.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        Driver.close_browser();
        System.out.println("===============END=================");
    }

    @Test
    public void test1() {
        Util.sleep(3);
        table_head.get(0).click();
        List<String> last_names = new ArrayList<>();
        for (int i = 1; i <= rows.size(); i++) {
            last_names.add(read_table(i, 1));
        }
        System.out.println("last_names = " + last_names);
    }

}
