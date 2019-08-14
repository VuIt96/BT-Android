package com.example.bt.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bt.R;

public class AsyncTaskActivity extends AppCompatActivity {
    Button btAsyncTask;
    TextView txtInfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        btAsyncTask = (Button) findViewById(R.id.btAsyncTask);
        txtInfor = (TextView) findViewById(R.id.txtInfor);
        btAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CongViec().execute();
            }
        });
    }

    private class CongViec extends AsyncTask<Void, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtInfor.setText("Bat dau." + "\n");
        }

        @Override
        protected String doInBackground(Void... voids) {

            for (int i = 1; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("Xong viec " + i +" \n");
            }
            return "xong roi.\n";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtInfor.append(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtInfor.append(values[0]);
        }
    }
}
