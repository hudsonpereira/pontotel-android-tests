package br.com.hudsonpereira.pontoteltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.hudsonpereira.pontoteltest.api.model.User;
import br.com.hudsonpereira.pontoteltest.api.model.UserList;
import br.com.hudsonpereira.pontoteltest.api.service.UserService;
import br.com.hudsonpereira.pontoteltest.ui.adapters.UsersAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://s3-sa-east-1.amazonaws.com/pontotel-docs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService service = retrofit.create(UserService.class);

        Call<UserList> users = service.getUsers();

        users.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                UserList userList = response.body();
                ArrayList<String> names = new ArrayList<>();

                Log.i("DUMP", response.raw().toString());

                for (User user : userList.getData()) {
                    names.add(user.getName());
                }

                listview.setAdapter(new UsersAdapter(MainActivity.this, R.layout.list_item, userList.getData()));
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

            }
        });
    }
}
