package br.com.hudsonpereira.pontoteltest.api.model;

/**
 * Created by hudson on 31/01/18.
 */

public class User {
    private String name;

    private String id;

    private String pwd;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
