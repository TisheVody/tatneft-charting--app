module com.example.app_for_chart {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.jfree.jfreechart;
    requires org.jfree.chart.fx;
    requires org.apache.logging.log4j;

    opens com.tatneft.chartingApp to javafx.fxml;
//    opens com.tatneft.chartingApp.models to javafx.base;
//    opens com.tatneft.chartingApp.Charts to javafx.base;
//    opens com.tatneft.chartingApp.utility to javafx.base;
    
    exports com.tatneft.chartingApp;
}