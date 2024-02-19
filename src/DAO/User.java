package DAO;

public class User {
    private int userId;
    private String userType;
    private String password;
    public User(int userId, String userType, String password){
        setPassword(password);
        setUserId(userId);
        setUserType(userType);
    }
    public User(int userId){
        setUserId(userId);
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
}
