module com.jolles.formulaone {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.jolles.formulaone;
    exports com.jolles.formulaone.utils;
    exports com.jolles.formulaone.model;
    opens com.jolles.formulaone.model to javafx.fxml;
    opens com.jolles.formulaone to javafx.controls, javafx.fxml;
    opens com.jolles.formulaone.utils to javafx.controls, javafx.fxml;
}