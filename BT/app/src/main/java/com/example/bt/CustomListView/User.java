package com.example.bt.CustomListView;

public class User {
    private String Username;
    private boolean ischecked;

    public User(String username, boolean ischecked) {
        Username = username;
        this.ischecked = ischecked;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public boolean isIschecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }
}
