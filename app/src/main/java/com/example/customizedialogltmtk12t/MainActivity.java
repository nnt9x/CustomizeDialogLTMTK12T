package com.example.customizedialogltmtk12t;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.customizedialogltmtk12t.dialog.LoginDialog;

public class MainActivity extends AppCompatActivity {

    private LoginDialog loginDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showLoginDialog(View view) {
        // Hiển thị dialog lên
        if(loginDialog == null){
            loginDialog = new LoginDialog(this) {
                @Override
                public void processLogin(String user, String pass) {
                    // Fake: user = bkacad, pass = 123
                    if(user.equals("bkacad") && pass.equals("123")){
                        Toast.makeText(MainActivity.this,"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            };
        }

        loginDialog.show();
    }
    public void processLogin(){

    }
}