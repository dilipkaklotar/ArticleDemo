package com.example.adapter;

import android.content.Context;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Utils.AssetsFont;
import com.example.articledemo.R;
import com.example.module.Article;

import java.util.ArrayList;

/**
 * Created by
 * Dilipkumar R. Kaklotar
 * [ Senior Android Developer ]
 * Mobile: +91 8000722607
 * Skype: dilipkaklotar
 * Created On 2019-06-13.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    private Context context = null;
    private ArrayList<Article> articleArrayList;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextTitle, mTextAuthor,mTextPublishedDate;
        private CardView card_view;
        private ImageView imgPhoto;


        public MyViewHolder(View view) {
            super(view);
            mTextTitle = (TextView) view.findViewById(R.id.mTextTitle);
            mTextAuthor = (TextView) view.findViewById(R.id.mTextAuthor);
            mTextPublishedDate = (TextView)view.findViewById(R.id.mTextPublishedDate);

            card_view = (CardView) view.findViewById(R.id.card_view);

            imgPhoto = (ImageView) view.findViewById(R.id.imgPhoto);

        }
    }


    public ArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.articleArrayList = articleArrayList;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Article article = articleArrayList.get(position);
        holder.mTextTitle.setText(article.getTitle());
        holder.mTextTitle.setTypeface(AssetsFont.setHeaderTypeface(context));
        holder.mTextAuthor.setText(article.getAuthor());
        holder.mTextPublishedDate.setText(article.getPublishedAt());

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent next = new Intent(context, ViewAadharDetailActivity.class);
//                next.putExtra("aadhar_number", aadharData.getStrUID());
//                next.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//                ((Activity) context).startActivity(next);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }
}
