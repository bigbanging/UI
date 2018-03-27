package com.litte.ui.real;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.litte.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AsyncTaskActivity extends Activity {

    @BindView(R.id.pb_download)
    ProgressBar pbDownload;
    @BindView(R.id.btn_download)
    Button btnDownload;
    @BindView(R.id.tv_download)
    TextView tvDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_download)
    public void onViewClicked() {
        MyAsyncTask myAsyncTask = new MyAsyncTask(tvDownload,pbDownload);
        myAsyncTask.execute(1000);
    }

    /**
     * 演示操作，用来模拟下载
     */
    public class DelayOperate {
        public void delay() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class MyAsyncTask extends AsyncTask<Integer, Integer, String> {

        private TextView textView;
        private ProgressBar progressBar;

        public MyAsyncTask(TextView textView, ProgressBar progressBar) {
            this.textView = textView;
            this.progressBar = progressBar;
        }

        //该方法不运行在UI线程中,主要用于异步操作,通过调用publishProgress()方法
        //触发onProgressUpdate对UI进行操作
        @Override
        protected String doInBackground(Integer... params) {
            DelayOperate delayOperate = new DelayOperate();
            int i = 0;
            for (i = 10; i <= 100; i += 10) {
                delayOperate.delay();
                publishProgress(i);
            }
            return i + params[0].intValue() + "";
        }

        @Override
        protected void onPreExecute() {
            textView.setText("开始执行异步线程~~~");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int value = values[0];
            progressBar.setProgress(value);
        }
    }
}
