package sv.edu.udb.thesalon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class mainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_menu);
    }

    //go to addDate1
    public void addDate(View view){
        Intent intent = new Intent(this, addDate1.class);
        startActivity(intent);
        finish();
    }

    public void seeReports(View view){
        Intent intent = new Intent(this,lastServices.class);
        startActivity(intent);
        finish();
    }
}