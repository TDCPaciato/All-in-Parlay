package allin.if5b.landindo.Activities;

public class UserModels {
    private String username, email, nomortelpon;

    public UserModels(String username, String email, String nomortelpon) {
        this.username = username;
        this.email = email;
        this.nomortelpon = nomortelpon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomortelpon() {
        return nomortelpon;
    }

    public void setNomortelpon(String nomortelpon) {
        this.nomortelpon = nomortelpon;
    }
}
