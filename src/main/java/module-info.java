module com.example.app_for_chart {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.jfree.jfreechart;
    requires org.jfree.chart.fx;
    requires org.apache.logging.log4j;

    opens com.tatneft.chartingApp to javafx.fxml;
    exports com.tatneft.chartingApp;
}