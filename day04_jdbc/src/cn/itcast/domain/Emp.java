package cn.itcast.domain;

public class Emp {
    private String username;
    private String password;
    private int id;
    private int nu;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNu() {
        return nu;
    }

    public void setNu(int nu) {
        this.nu = nu;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", nu='" + nu + '\'' +
                '}';
    }
}
