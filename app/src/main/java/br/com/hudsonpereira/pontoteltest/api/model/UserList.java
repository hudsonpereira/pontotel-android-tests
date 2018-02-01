package br.com.hudsonpereira.pontoteltest.api.model;

import java.util.List;

/**
 * Created by hudson on 31/01/18.
 */

public class UserList {
    private List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
