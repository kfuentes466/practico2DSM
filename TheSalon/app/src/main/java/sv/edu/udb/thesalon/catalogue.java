package sv.edu.udb.thesalon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class catalogue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);
    }

    public void back(View view){
        Intent intent = new Intent(this, mainMenu.class);
        startActivity(intent);
        finish();
    }
}