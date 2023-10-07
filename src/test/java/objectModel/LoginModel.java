package objectModel;

public class LoginModel {
    private AccountModel account;
    private String userError;
    private String passwordError;

    public LoginModel() {
    }

    public LoginModel(String username, String password, String userError, String passwordError) {
        AccountModel accountM = new AccountModel();
        accountM.setPassword(password);
        accountM.setUsername(username);

        this.account = accountM;
        this.userError = userError;
        this.passwordError = passwordError;
    }
    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public String getUserError() {
        return userError;
    }

    public void setUserError(String userError) {
        this.userError = userError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "account={username:" + account.getUsername() + ",password:" + account.getPassword() +
                "}, userError='" + userError + '\'' +
                ", passwordError='" + passwordError + '\'' +
                '}';
    }
}
