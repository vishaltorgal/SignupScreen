package learn.android.signupscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_mobile,et_email,et_password;
    Button bt_submit;
    TextView tv_error;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(learn.android.signupscreen.R.layout.activity_main);

        et_name = (EditText)findViewById(learn.android.signupscreen.R.id.et_name);
        et_mobile = (EditText)findViewById(learn.android.signupscreen.R.id.et_mobile);
        et_email = (EditText)findViewById(learn.android.signupscreen.R.id.et_email);
        et_password = (EditText)findViewById(learn.android.signupscreen.R.id.et_password);
        bt_submit = (Button) findViewById(learn.android.signupscreen.R.id.bt_submit);
        tv_error = (TextView) findViewById(learn.android.signupscreen.R.id.tv_error);


        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_error.setVisibility(View.VISIBLE);

                    if(et_name.length() < 2){

                        tv_error.setText("Name is Invalid");

                    }else if(et_mobile.length() != 10){

                        tv_error.setText("Mobile number is Invalid");

                    }else if(!isValidEmail(et_email.getText().toString()))
                    {
                        tv_error.setText("Invalid Email");

                    }else if(!checkPassword(et_password.getText().toString())) {

                        if(et_password.length() == 0){
                            tv_error.setText("Enter Password");
                        }else{
                            tv_error.setText("Password is Weak");
                        }


                    }else{
                        tv_error.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_LONG).show();
                    }

                }
        });

    }



    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private boolean checkPassword(String password) {

        boolean status = false;
        int uprChars = 0, lwrChars = 0, num = 0,
                splChars = 0, otrChars = 0, points = 0;
        char c;

        int pwdLt = password.length();

        if (pwdLt <= 5) {
            points =1;
        }

        else if (pwdLt <= 10) {
            points = 2;
        }

        else
            points = 3;



        for (int i = 0; i < pwdLt; i++) {
            c = password.charAt(i);

            if (c >= 'a' && c <= 'z') {
                if (lwrChars == 0) points++;
                lwrChars = 1;
            }

            else if (c >= 'A' && c <= 'Z') {
                if (uprChars == 0) points++;
                uprChars = 1;
            }

            else if (c >= '0' && c <= '9') {
                if (num == 0) points++;
                num = 1;
            }

            else if (c == '_' || c == '@') {
                if (splChars == 0) points += 1;
                splChars = 1;
            }

            else {
                if (otrChars == 0) points += 2;
                otrChars = 1;
            }
        }


        if (points <= 3)
        {
            status = false;
        }
        else if (points <= 6) {
            status = false;
        }
        else if (points <= 9){
            status = true;
        }

        return status;
    }

}
