package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.entity.Customer;
import lk.ijse.model.tm.CustomerTm;
import lk.ijse.repository.CustomerRepo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class CustomerFormController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private AnchorPane rootNode;

    @FXML
     private TableView<CustomerTm> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    @FXML
    private Button btnEnter;

    @FXML
    private TextField txtTelSearch;

    CustomerBO customerBO= (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    public void initialize(){
        setCellValueFactory();
        loadAllCustomer();
        addRegex(txtId);
        addRegex(txtTel);
    }

    private void addRegex(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtId && !newValue.matches("^C.*$")){
                txtId.setStyle("-fx-focus-color:#f21e0f");
                txtId.clear();
            }else {
                txtId.setStyle("-fx-focus-color:#c4c1c0");
            }
        });

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtTel && !newValue.matches("^\\d{1,10}$")){
                txtTel.setStyle("-fx-focus-color:#f21e0f");
                txtTel.clear();
            }else {
                txtTel.setStyle("-fx-focus-color:#c4c1c0");
            }
        });
    }

   private void setCellValueFactory(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));

   }

   private void loadAllCustomer(){
       ObservableList<CustomerTm> obList= FXCollections.observableArrayList();

       try{
           List<Customer> customerList= CustomerRepo.getAll();
           for(Customer customer : customerList){
               CustomerTm tm=new CustomerTm(
                       customer.getId(),
                       customer.getName(),
                       customer.getAddress(),
                       customer.getEmail(),
                       customer.getTel()

               );
               obList.add(tm);
           }
           tblCustomer.setItems(obList);

       }catch (SQLException e){
           throw new RuntimeException(e);
       }


   }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane= FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Stage stage=(Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
    }
    boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerBO.existCustomer(id);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event)    {
        String id=txtId.getText();

       // String sql="DELETE FROM Customer WHERE id=?";

        try{
           boolean isDeleted=customerBO.deleteCustomer(id);
           if(isDeleted){
               new Alert(Alert.AlertType.CONFIRMATION,"Customer deleted!").show();
               tblCustomer.refresh();
           }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the customer " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        initialize();

    }



    @FXML
    void btnExitOnAction(ActionEvent event) throws IOException{
        AnchorPane anchorPane=FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Stage stage=(Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Login Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnSavetOnAction(ActionEvent event) throws ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String tel = txtTel.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();


        //String sql="INSERT INTO Customer VALUES(?,?,?,?,?)";

        if (btnSave.getText().equalsIgnoreCase("Save")) {
            try {
                // Check if customer with the same ID already exists
                if (existCustomer(id)) {
                    new Alert(Alert.AlertType.ERROR, id + " already exists").show();
                } else {
                    // Save customer if it doesn't exist
                    customerBO.saveCustomer(new CustomerDTO(id, name, address, email, tel));
                    tblCustomer.getItems().add(new CustomerTm(id, name,email,address,tel));
                }
            } catch (SQLException | ClassNotFoundException e) {
                new Alert(Alert.AlertType.ERROR, "Error saving customer: " + e.getMessage()).show();
            }
        }

        initialize();
    }



    @FXML
    void btnSearchOnAction(ActionEvent event) throws ClassNotFoundException {
        String id=txtId.getText();
        String name=txtName.getText();
        String address=txtAddress.getText();
        String email=txtEmail.getText();
        String tel=txtTel.getText();

        //String sql="SELECT * FROM Customer WHERE id=?";
        try{
            if(!existCustomer(id)){
        CustomerDTO customer=customerBO.searchCustomer(new CustomerDTO(id,name,tel,address,email));

        txtName.setText(customer.getName());
        txtTel.setText(customer.getTel());
        txtTel.setText(customer.getAddress());
        txtEmail.setText(customer.getEmail());

            }else {
                //clearFields();
                tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
                tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
                tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Tel"));
                tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
                tblCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("email"));
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws ClassNotFoundException {
        String id=txtId.getText();
        String name=txtName.getText();
        String address=txtAddress.getText();
        String email=txtEmail.getText();
        String tel=txtTel.getText();

        //String sql = "UPDATE Customer SET name = ?, number = ?, address = ?, email=? WHERE id = ?";
        try {
           if(!existCustomer(id)){
               new Alert(Alert.AlertType.ERROR,"Can't updated");
           }
           customerBO.updateCustomer(new CustomerDTO(id,name,email,tel,address));
           tblCustomer.getItems().add(new CustomerTm(id, name,email,tel,address));
            }catch(SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        initialize();

    }


    private void clearFields(){
        txtId.setText("");
        txtName.setText("");
        txtTel.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {
        txtEmail.requestFocus();
    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {

    }

    @FXML
    void txtIdOnAction(ActionEvent event) {
        txtName.requestFocus();
    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtTel.requestFocus();
    }

    @FXML
    void txtTelOnAction(ActionEvent event) {
        txtAddress.requestFocus();
    }

    @FXML
    void btnEnterOnAction(ActionEvent event) throws SQLException {
        String tele=txtTelSearch.getText();

        Customer customer= CustomerRepo.searchByNumber(tele);
        if(customer !=null){
            txtId.setText(customer.getId());
            txtName.setText(customer.getName());
            txtAddress.setText(customer.getAddress());
            txtEmail.setText(customer.getEmail());
            txtTel.setText(customer.getTel());
        }else {
            new Alert(Alert.AlertType.INFORMATION, "Supplier not found !").show();

        }

    }


}
