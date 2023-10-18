module com.manager.payment_manager {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
                    requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            requires eu.hansolo.tilesfx;
        
    opens com.manager.payment_manager to javafx.fxml;
    exports com.manager.payment_manager;
}