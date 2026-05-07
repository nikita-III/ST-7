package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    static public void MainAct() {
        WebDriver webDriver2 = new ChromeDriver();
        try {
            webDriver2.get("https://api.ipify.org/?format=json");
            WebElement elem = webDriver2.findElement(By.tagName("pre"));
            System.out.println(elem.getText());
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.toString());
        }
    }
}
