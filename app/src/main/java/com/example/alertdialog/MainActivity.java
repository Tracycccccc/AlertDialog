package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnShowLoginDialog=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowLoginDialog=(Button)findViewById(R.id.btn_show_login_dialog);
        btnShowLoginDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater=LayoutInflater.from(MainActivity.this);
                View loginView =layoutInflater.inflate(R.layout.login,null);
                final EditText etUsername = (EditText) loginView.findViewById(R.id.et_user_name);
                final EditText etPwd = (EditText) loginView.findViewById(R.id.et_password);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Android App");
                dialog.setView(loginView);
                dialog.setPositiveButton("sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String text = "username:"+etUsername.getText()+"password:"+etPwd.getText();
                        Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String cancel = "you chose cancel";
                        Toast.makeText(MainActivity.this,cancel,Toast.LENGTH_SHORT).show();

                    }
                });
                dialog.create().show();
            }
        });
    }
}
