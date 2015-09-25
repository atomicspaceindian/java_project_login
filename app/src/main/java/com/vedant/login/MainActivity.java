package com.vedant.login;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loginButton_Click(View view)
    {

        Bitmap image = Bitmap.createBitmap(600, 300, Bitmap.Config.ARGB_8888);
        for(int row = 0; row < image.getHeight(); row++)
        {
            for(int col = 0; col < image.getWidth(); col++)
            {
                if(col == 0 || row < 10 || col == image.getWidth() - 1 || row == image.getHeight() - 1)
                {
                    image.setPixel(col, row, Color.argb(1000, 255, 115, 255));
                }
            }
        }


        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageBitmap(image);

        View control = this.getCurrentFocus();

        if(control != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(control.getWindowToken(), 0);
        }

        TextView resultLabel = (TextView)findViewById(R.id.label_Result);
        EditText usernameTextBox = (EditText)findViewById(R.id.editText_Username);
        EditText passwordTextBox = (EditText)findViewById(R.id.editText_Password);


        String[] usernames = new String[3];
        String[] passwords = new String[3];

        usernames[0] = "Vedant";
        usernames[1] = "Karen";
        usernames[2] = "Kevin";
        passwords[0] = "vb";
        passwords[1] = "t1";
        passwords[2] = "t2";

        for (int i = 0; i < usernames.length; i++){
            if (usernameTextBox.getText().toString().equals(usernames[i]) && passwordTextBox.getText().toString().equals(passwords[i])){
                resultLabel.setText("Success! Welcome " + usernames[i]);
                break;
            } else {
                resultLabel.setText("Incorrect credentials");
            }
        }





        /*
        if (usernameTextBox.getText().toString().equals("Vedant") && passwordTextBox.getText().toString().equals("vb")) {
            resultLabel.setText("Success!");
        } else {
            resultLabel.setText("Failed");
        }
        */
    }
}
