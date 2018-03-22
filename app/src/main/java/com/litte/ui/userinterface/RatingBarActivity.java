package com.litte.ui.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RatingBarActivity extends Activity {

    @BindView(R.id.ratingBar)
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        ButterKnife.bind(this);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(RatingBarActivity.this, "你给出的评分："+String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
