package com.tatneft.chartingApp.utility;

import org.jfree.data.xy.XYSeries;

public class Utility {

    public static XYSeries createRandomData(final String name, final double baseRadius, final double thetaInc) {
        final XYSeries series = new XYSeries(name);
        for (double coeff = 0.0; coeff < 365.0; coeff += thetaInc) {
            final double radius = baseRadius * (1.1 + Math.random());
            series.add(coeff, radius);
        }
        return series;
    }
}
