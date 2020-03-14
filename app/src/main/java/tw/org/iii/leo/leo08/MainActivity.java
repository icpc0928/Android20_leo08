package tw.org.iii.leo.leo08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private MainApp mainApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //打回原形才會有我的成員a跟b
        mainApp = (MainApp)getApplication();
        Log.v("leo","a = " + mainApp.a);
        Log.v("leo","b = " + mainApp.b);

        input = findViewById(R.id.input);
    }

    public void gotoPage2(View view) {
        Intent intent = new Intent(this, Page2Activity.class);
        intent.putExtra("name",input.getText().toString());
        intent.putExtra("lottery",(int)(Math.random()*49+1));
//        startActivity(intent);
        startActivityForResult(intent,2);

    }

    public void gotoPage3(View view) {
        Intent intent = new Intent(this, Page3Activity.class);
        //要有結果會回來所以多一個for result
        startActivityForResult(intent,3);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("leo","requestCode = "+ requestCode);
        Log.v("leo","resultCode = "+ resultCode );

        if (requestCode == 3){
            boolean isSoundOnOff = data.getBooleanExtra("sound",false);
            Log.v("leo","sound: " + (isSoundOnOff?"on":"off"));
        }
    }

    @Override
    protected void onRestart() {
        Log.v("leo","onRestart()");
        Log.v("leo","a = " + mainApp.a);
        Log.v("leo","b = " + mainApp.b);
        super.onRestart();

    }
}
