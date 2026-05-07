package com.mycompany.app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    static public void MainAct() {
        WebDriver webDriver3 = new ChromeDriver();
        try {
            // code so bad it creeps even me out
            webDriver3.get("https://api.open-meteo.com/v1/forecast?latitude=56&longitude=44&hourly=temperature_2m,rain&current=cloud_cover&timezone=Europe%2FMoscow&forecast_days=1&wind_speed_unit=ms");
            String elem = webDriver3.getPageSource();//webDriver3.findElement(By.name("hourly"));
            ArrayList<String> sts = new ArrayList<String>();
            //System.out.println(elem.substring(elem.lastIndexOf("time") + "time: ".length(), elem.lastIndexOf("temperature_2m") - 2));
            int ind = elem.lastIndexOf("time") + "time".length() + 3;
            while (ind < elem.length() && !elem.substring(ind, ind + "_2026-05-07T00:00_".length()).contains("temperature_2m")) {
                System.out.println(elem.substring(ind + 1, ind + "_2026-05-07T00:00_".length() - 1));
                sts.add(elem.substring(ind + 1, ind + "_2026-05-07T00:00_".length() - 1).replace('T', ' '));
                ind += "_2026-05-07T00:00__".length();
            }
            //System.out.println(elem.substring(elem.lastIndexOf("temperature_2m") + "temperature_2m: ".length(), elem.lastIndexOf("rain") - 2));
            ind = elem.lastIndexOf("temperature_2m") + "temperature_2m".length() + 3;
            ArrayList<String> shs = new ArrayList<String>();
            int indd = 0;
            String ds = "";
            while (ind < elem.length() && !elem.substring(ind, ind + indd).contains("rain")) {
                indd = elem.substring(ind).indexOf(",");
                ds = elem.substring(ind, ind + indd);
                if(ds.contains("]")) {
                    ds = ds.substring(0, ds.length() - 1);
                }
                System.out.println(ds);
                shs.add(ds);
                ind += indd + 1;
            }
            //System.out.println(elem.substring(elem.lastIndexOf("rain") + "rain: ".length(), elem.lastIndexOf("]") + 1));
            ArrayList<String> srs = new ArrayList<String>();
            ind = elem.lastIndexOf("rain") + "rain".length() + 3;
            while (ind < elem.length() && !ds.contains("]")) {
                indd = elem.substring(ind).indexOf(",");
                if (indd < 0) {
                    indd = elem.substring(ind).indexOf("}");
                }
                ds = elem.substring(ind, ind + indd);
                if(ds.contains("]")) {
                    System.out.println(ds.substring(0, ds.length() - 1));
                    srs.add(ds.substring(0, ds.length() - 1));
                } else {
                    System.out.println(ds);
                    srs.add(ds);
                }
                ind += indd + 1;
            }
            // time temperature_2m rain _2026-05-07T00:00_,
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("result/forecast.txt"))) {
                for (int i = 0; i < sts.size(); i++) {
                    writer.write(sts.get(i) + '\t' + shs.get(i) + '\t' + srs.get(i));
                    writer.newLine();
                    System.out.println(sts.get(i) + '\t' + shs.get(i) + '\t' + srs.get(i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.toString());
        }
    }
}
