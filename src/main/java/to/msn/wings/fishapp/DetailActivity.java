package to.msn.wings.fishapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    private SimpleDatabaseHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView kanji = findViewById(R.id.kanji);
        TextView hiragana = findViewById(R.id.hiragana);
        TextView katakana = findViewById(R.id.katakana);
        TextView setsumei = findViewById(R.id.setsumei);
        helper = new SimpleDatabaseHelper(this);
        /*try (SQLiteDatabase db = helper.getWritableDatabase()) {
            Toast.makeText(this, "database connection is successed", Toast.LENGTH_LONG).show();
        }*/
        Intent i = getIntent();
        String id = i.getStringExtra("id");
        //Toast.makeText(this, id,Toast.LENGTH_SHORT).show();
        String[] cols ={"katakana", "hiragana", "kanji", "season"} ;
        String[] params = {id};
        try (SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = db.query("fish_tbl", cols, "id = ?", params, null, null, null, null)) {
            if (cs.moveToFirst()) {
                kanji.setText(cs.getString(2));
                hiragana.setText(cs.getString(1));
                katakana.setText(cs.getString(0));
                setsumei.setText(cs.getString(3));
            } else {
                Toast.makeText(this, "予期せぬエラーです",Toast.LENGTH_SHORT).show();
            }
        }

    }
}