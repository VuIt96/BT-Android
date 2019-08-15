package com.example.bt.JSON;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bt.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class jSONLanguageActivity extends AppCompatActivity {
    ImageView imgEnglish, imgViewNam;
    TextView txtView;
    String noidug = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_sonlanguage);
        imgEnglish = (ImageView) findViewById(R.id.imgEnglish);
        imgViewNam = (ImageView) findViewById(R.id.imgVietNam);
        txtView = (TextView) findViewById(R.id.txtView);
        new ReadJson().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");
        imgViewNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadJSONLanguage("vn");
            }
        });
        imgEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadJSONLanguage("en");
            }
        });
    }

    //khi gọi có muốn truyền tham số gì không, quá trình xử lí trả về tham số kiểu gì, kqua tra về kiểu gì.
    private class ReadJson extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                // đường dẫn, nhận vào 1 String-> String chính là tham số của doIn chỉ đọc 1 đường dẫn.
                URL url = new URL(strings[0]);
                //Đọc dữ liệu vào, lấy dữ liệu từ url, mở kết nối -> trả về dữ liệu
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                // đọc dữ liệu lieen t
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";//save line data đã đọc
                //ktra xem còn dữ liệu kh
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);//thêm dữ liệu vào liên tục ->line
                }
                bufferedReader.close();//dóng khi đọc xong
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();//ép về kiểu chuoi
        }

        //đổ dữ liệu ra
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            noidug = s;
            ReadJSONLanguage("vn");

        }
    }

    private void ReadJSONLanguage(String languages) {
        try {
            //read jsonObject sum
            JSONObject jsonObject = new JSONObject(noidug);
            //nhieu json -> lay noi dung
            JSONObject objectLeng = jsonObject.getJSONObject("language");
            //read Obj VN
            JSONObject objectVN = objectLeng.getJSONObject(languages);
            String ten = objectVN.getString("name");
            String diachi = objectVN.getString("address");
            String mon1 = objectVN.getString("course1");
            String mon2 = objectVN.getString("course2");
            String mon3 = objectVN.getString("course3");
            txtView.setText(ten + "\n" + diachi + "\n" + mon1 + "\n" + mon2 + "\n" + mon3);
        } catch (JSONException e) {
            e.printStackTrace();

        }
    }
}
