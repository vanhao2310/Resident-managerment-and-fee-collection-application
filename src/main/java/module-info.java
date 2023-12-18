module com.manager.payment_manager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires mysql.connector.j;

    opens com.manager.payment_manager to javafx.fxml;
    exports com.manager.payment_manager;
    exports com.manager.payment_manager.Controllers;
    exports com.manager.payment_manager.Controllers.Leader;
    exports com.manager.payment_manager.Controllers.Manager;
    exports com.manager.payment_manager.Views;
}