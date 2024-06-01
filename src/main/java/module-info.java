module org.example.rubyfinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.kordamp.bootstrapfx.core; // Add this back and test

    opens org.example.rubyfinal to javafx.fxml;
    exports org.example.rubyfinal;
}
