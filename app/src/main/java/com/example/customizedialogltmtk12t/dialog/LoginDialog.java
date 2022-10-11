package com.example.customizedialogltmtk12t.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.customizedialogltmtk12t.R;

public abstract class LoginDialog extends Dialog {

    // View
    private EditText edtUserName, edtPassword;

    private Button btnLogin;
    private TextView tvCancel;

    public LoginDialog(@NonNull Context context) {
        super(context);
    }

    public abstract void processLogin(String user, String pass);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_dialog);
        // Bind id
        btnLogin = findViewById(R.id.btnDialogLogin);
        tvCancel = findViewById(R.id.tvDialogCancel);
        edtPassword = findViewById(R.id.edtDialogPassword);
        edtUserName = findViewById(R.id.edtDialogUsername);

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lay du lieu tu 2 editText
                String userName = edtUserName.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if(userName.isEmpty()){
                    edtUserName.setError("Hãy nhập username");
                    return;
                }
                if(password.isEmpty()){
                    edtPassword.setError("Hãy nhập mật khẩu");
                    return;
                }

                processLogin(userName, password);
                dismiss();

            }
        });

    }
}
