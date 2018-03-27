package com.litte.ui.real;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.litte.ui.R;
import com.litte.ui.adapter.MyAdapter;
import com.litte.ui.bean.Weather;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherIconActivity extends Activity {

    @BindView(R.id.grid_view_weather_icon)
    GridView gridViewWeatherIcon;
    BaseAdapter adapter = null;
//    ArrayList<Weather> weathers;
    public int[] imgId = new int[]{R.drawable.aaa,R.drawable.aaa1,R.drawable.aaa2,R.drawable.aaa3,R.drawable.aaa4,
            R.drawable.aaa5,R.drawable.aaa6,R.drawable.aaa7,R.drawable.aaa8,R.drawable.aaa9,R.drawable.aa10,
            R.drawable.aa11,R.drawable.aa12,R.drawable.aa14};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_icon);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        /*weathers = new ArrayList<>();
        weathers.add(new Weather(R.drawable.aaa));
        weathers.add(new Weather(R.drawable.aaa1));
        weathers.add(new Weather(R.drawable.aaa2));
        weathers.add(new Weather(R.drawable.aaa3));
        weathers.add(new Weather(R.drawable.aaa4));
        weathers.add(new Weather(R.drawable.aaa5));
        weathers.add(new Weather(R.drawable.aaa6));
        weathers.add(new Weather(R.drawable.aaa7));
        weathers.add(new Weather(R.drawable.aaa8));
        weathers.add(new Weather(R.drawable.aaa9));
        weathers.add(new Weather(R.drawable.aa10));
        weathers.add(new Weather(R.drawable.aa11));
        weathers.add(new Weather(R.drawable.aa12));
        weathers.add(new Weather(R.drawable.aa14));
        adapter = new MyAdapter<Weather>(weathers,R.layout.weather_item) {
            @Override
            public void bindView(ViewHolder holder, Weather obj) {
                holder.setImageResource(R.id.iv_weather_item, obj.getWeather_icon());
            }
        };*/
        adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imgId.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;
                if (convertView == null){
                    imageView = new ImageView(WeatherIconActivity.this);
                    //设置图片宽高
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(100);
                    imageView.setMaxWidth(100);
                    imageView.setPadding(5, 5, 5, 5);
                }else {
                    imageView = (ImageView) convertView;
                }
                imageView.setImageResource(imgId[position]);
                return imageView;
            }
        };
        gridViewWeatherIcon.setAdapter(adapter);
        gridViewWeatherIcon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();

                bundle.putInt("imgId", imgId[position]);
                intent.putExtras(bundle);
                setResult(0x123, intent);
                finish();
            }
        });
    }
}
