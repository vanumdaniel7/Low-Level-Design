package lld.patterns.mediator;

public class FormMediator implements UIMediator {
    private TextField userNameTextField;
    private TextField passwordTextField;
    private Button loginButton;
    private Label label;

    private void setUserNameTextField(TextField userNameTextField) {
        this.userNameTextField = userNameTextField;
    }

    private void setPasswordTextField(TextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    private void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    private void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public void onComponentChanged(UIComponent uiComponent) {
        if (uiComponent == this.userNameTextField || uiComponent == this.passwordTextField) {
            boolean enableButton = !this.userNameTextField.getText().isEmpty() &&
                    !this.passwordTextField.getText().isEmpty();
            this.loginButton.setIsEnabled(enableButton);
        } else if (uiComponent == this.loginButton) {
            String username = this.userNameTextField.getText();
            String password = this.passwordTextField.getText();

            if ("admin".equals(username) && "1234".equals(password)) {
                label.setLabel("Login successful!");
            } else {
                label.setLabel("Invalid credentials.");
            }
        }
    }
}
