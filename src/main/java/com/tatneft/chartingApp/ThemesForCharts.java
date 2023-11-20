package com.tatneft.chartingApp;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.StandardChartTheme;

import java.awt.*;

public class ThemesForCharts {

    public static void setStandardChartTheme() {
        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("______", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("______", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("______", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);
    }
}
