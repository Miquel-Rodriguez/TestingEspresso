package cat.itb.testingespresso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textViewTtitle;
    Button button;
    EditText editTextUsername, editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTtitle = findViewById(R.id.textviewTtile);
        button = findViewById(R.id.button);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        editTextUsername = findViewById(R.id.editTextTextUsername);


        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);



        imm.hideSoftInputFromWindow(editTextUsername.getWindowToken(), 0);

        imm.hideSoftInputFromWindow(editTextPassword.getWindowToken(), 0);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText(R.string.logged);


                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                Bundle b = new Bundle();
                b.putString("userName",editTextUsername.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }
}