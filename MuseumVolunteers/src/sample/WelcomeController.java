package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;

public class WelcomeController implements Initializable {

    @FXML
    private TableView<VolunteerTable> table;
    @FXML
    private TableColumn<VolunteerTable, String> nameColumn;
    @FXML
    private TableColumn<VolunteerTable, String> timeSlotColumn;

    ObservableList<VolunteerTable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String sql = "SELECT FirstName, LastName, StartTime, EndTime FROM shifts";

        try {
            Connection con = DBConnector.connect();
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                String fullName = rs.getString("FirstName") + " " + rs.getString("LastName");
                String times = rs.getString("StartTime") + " - " + rs.getString("EndTime");
                oblist.add(new VolunteerTable(fullName, times));
            }
            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        timeSlotColumn.setCellValueFactory(new PropertyValueFactory<>("timeslot"));
        table.setItems(oblist);
    }

}
