package me.kaes3kuch3n.serverlogin;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginGui {

    private Label lblName, lblPass, lblResult;
    private TextField txtName, txtPass;
    private Button btnLogin;

    private Insets spacing;

    private Pane spacer;
    private HBox layoutButton;

    private VBox layout;
    private Scene scene;
    private Stage window;

    public LoginGui() {
        spacing = new Insets(20, 0, 0, 0);

        //Setting up labels
        lblName = new Label("Username");
        VBox.setMargin(lblName, spacing);
        lblPass = new Label("Password");
        VBox.setMargin(lblPass, spacing);
        lblResult = new Label();

        //Setting up text fields
        txtName = new TextField();
        txtName.setPromptText("Username");
        txtPass = new TextField();
        txtPass.setPromptText("Password");

        //Setting up button
        btnLogin = new Button("Login");
        btnLogin.setOnAction(event -> lblResult.setText(Login.login(txtName.getText(), txtPass.getText())));
        HBox.setMargin(btnLogin, spacing);

        //Setting up button layout
        spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        layoutButton = new HBox(spacer, btnLogin);

        //Setting up layout
        layout = new VBox(10, lblName, txtName, lblPass, txtPass, layoutButton, lblResult);
        layout.setPadding(new Insets(20));

        //Setting up scene
        scene = new Scene(layout, 250, 300);

        //Setting up window
        window = new Stage();
        window.setTitle("ServerLogin");
        window.setScene(scene);
        window.setResizable(false);
        window.centerOnScreen();
        window.show();
    }

}
