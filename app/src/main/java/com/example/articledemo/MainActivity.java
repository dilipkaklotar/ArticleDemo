package com.example.articledemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.adapter.ArticleAdapter;
import com.example.module.Article;
import com.example.module.Articles;
import com.example.retrofit_api_utils.ApiClient;
import com.example.retrofit_api_utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    ArticleAdapter articleAdapter;

    ArrayList<Article> articleArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        articleArrayList = new ArrayList<>();

        articleAdapter = new ArticleAdapter(this,articleArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(articleAdapter);

        articleAdapter.notifyDataSetChanged();

        //getArticles();
    }

    private void getArticles(){

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Articles> call = apiService.getArticles();
        call.enqueue(new Callback<Articles>() {
            @Override
            public void onResponse(Call<Articles> call, Response<Articles> response) {

                Articles articles = response.body();

                Log.d("Result","Result:" + response.body());
                Log.d("Result","List Size:" + articles.getArticleArrayList().size());

//                if(articles.getStatus().equalsIgnoreCase("ok"))
//                {
//                    articleArrayList= articles.getArticleArrayList();
//                }
//
//                articleAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Articles> call, Throwable t) {
                Log.e("Error", t.toString());

            }
        });
    }
}
