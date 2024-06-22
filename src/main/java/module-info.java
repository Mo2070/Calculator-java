module de.upb.se.profcalculator {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;

    opens de.upb.se.profcalculator.main to javafx.fxml;
    exports de.upb.se.profcalculator.main;
}
