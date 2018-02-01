package br.com.hudsonpereira.pontoteltest.api.service;

import java.util.List;

import br.com.hudsonpereira.pontoteltest.api.model.UserList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hudson on 31/01/18.
 */

public interface UserService {
    @GET("data.json")
    Call<UserList> getUsers();
}
