package redis;

public class Info {
    private String userName;
    private String password;

    @Override
    public String toString() {
        return "Info{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Info(String userName, String password){
        this.password=password;
        this.userName=userName;
    }
}
