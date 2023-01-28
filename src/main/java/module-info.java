module com.project.david {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.project.david to javafx.fxml;
    exports com.project.david;
    opens com.project.models;
    exports com.project.models;
    opens com.project.dbhandler;
    exports com.project.dbhandler;
}
