package sef.proj;

public class User {

    private String username;
    private String password;
    private String email;
    private String tag;
    private String phone_number;
    private String role;

    public User() {
        
    }
    public User(String username,String password,String email,String tag,String phone_number,String role){
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.tag = tag;
        this.role = role;

    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public  String getUserName() {
        return username;
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
    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return  role;
    }

    public String getTag() {

        return  tag;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        if (!tag.equals(user.tag)) return false;
        return role.equals(user.role);
    }
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + tag.hashCode();
        return result;
    }
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", email='" + phone_number + '\'' +
                ", tag='" + tag + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


}
