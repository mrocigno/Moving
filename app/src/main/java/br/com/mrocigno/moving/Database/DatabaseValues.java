package br.com.mrocigno.moving.Database;

public class DatabaseValues {
    private int ID;
    private String user;
    private String password;
    private String email;

    public DatabaseValues(int ID, String user, String password, String email) {
        this.ID = ID;
        this.user = user;
        this.password = password;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
