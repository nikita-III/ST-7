package com.mycompany.app;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.mycompany.app.Task2;
import com.mycompany.app.Task3;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // 1
        System.setProperty("webdriver.chrome.driver", "/home/nikita/Downloads/chromedriver-linux64/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.get("https://www.calculator.net/password-generator.html");
            WebElement elem = webDriver.findElement(By.className("verybigtext"));
            System.out.println(elem.getText());
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.toString());
        }
        // 2
        Task2.MainAct();
        // 3  5/10 %/min
        Task3.MainAct();
        return;
    }
}
