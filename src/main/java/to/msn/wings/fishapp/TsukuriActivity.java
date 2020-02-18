package to.msn.wings.fishapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TsukuriActivity extends AppCompatActivity {
    private SimpleDatabaseHelper helper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsukuri);
        helper = new SimpleDatabaseHelper(this);
    }

    public void onButtonTsukuriSearch(View view) {
        EditText tsukuri = findViewById(R.id.txt_tsukuri);
        String[] cols = {"id"};
        String[] params = {tsukuri.getText().toString()};
        try (SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cs = db.query("tsukuri_tbl", cols, "tsukuri = ?", params, null, null, null, null)) {
                if(cs.moveToFirst()) {
                   // String[] cols2 ={"katakana", "hiragana", "kanji", "season"} ;
                    //Cursor cs2 = db.query("fish_tbl", cols2, "id = ?", new String[]{cs.getString(0)}, null, null, null, null);
                    Intent i;
                    i = new Intent(this, DetailActivity.class);

                    i.putExtra("id", cs.getString(0));
                    startActivity(i);
                } else {
                    Toast.makeText(this, "見つかりませんでした", Toast.LENGTH_SHORT).show();
                }
            }
    }
}