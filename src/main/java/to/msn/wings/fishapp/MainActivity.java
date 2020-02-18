package to.msn.wings.fishapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SimpleDatabaseHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new SimpleDatabaseHelper(this);
        try (SQLiteDatabase db = helper.getWritableDatabase()) {
            Toast.makeText(this, "database connection is successed", Toast.LENGTH_LONG).show();
        }
    }

    public void onTsukuri(View view) {
        Intent i = new Intent(this, to.msn.wings.fishapp.TsukuriActivity.class);
        startActivity(i);
    }

    public void onYomi(View view) {
        Intent i = new Intent(this, to.msn.wings.fishapp.YomiActivity.class);
        startActivity(i);
    }
}
