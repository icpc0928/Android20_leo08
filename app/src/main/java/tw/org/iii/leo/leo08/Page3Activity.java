package tw.org.iii.leo.leo08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;

public class Page3Activity extends AppCompatActivity {
    private SwitchCompat soundSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        soundSwitch = findViewById(R.id.soundOnOff);
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("sound",soundSwitch.isChecked());
//        setResult(123);  //這招只帶結果
        setResult(123,intent);   //這招帶結果跟資料
        super.finish();
    }
}
