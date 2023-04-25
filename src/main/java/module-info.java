module com.example.netsecassign3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.netsecassign3 to javafx.fxml;
    exports com.example.netsecassign3;
}