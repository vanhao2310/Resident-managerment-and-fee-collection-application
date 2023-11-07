module com.manager.payment_manager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.manager.payment_manager to javafx.fxml;
    exports com.manager.payment_manager;
    exports com.manager.payment_manager.Controllers;
    exports com.manager.payment_manager.Controllers.Admin;
    exports com.manager.payment_manager.Controllers.Client;
    exports com.manager.payment_manager.Views;
}