## Signup Screen

<a href="https://github.com/vishaltorgal/SignupScreen/raw/master/signup.apk"><img src="https://github.com/vishaltorgal/SendingEmails/blob/master/dlapk.png" width="150" height="80" title="aura" alt="aura"></a>

<br>
<img src="https://github.com/vishaltorgal/SignupScreen/blob/master/1.png " alt="alt text" width="300" height="450">
<br>
<img src="https://github.com/vishaltorgal/SignupScreen/blob/master/2.png " alt="alt text" width="300" height="450">
<br>
<img src="https://github.com/vishaltorgal/SignupScreen/blob/master/3.png " alt="alt text" width="300" height="450">
<br>


<h6> Email Validation </h6>

```java

public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

```

<h6> Password Strength </h6>

```java

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

```
