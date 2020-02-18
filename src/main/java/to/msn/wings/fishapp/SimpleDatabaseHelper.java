package  to.msn.wings.fishapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SimpleDatabaseHelper extends SQLiteOpenHelper {
    static final private String DBNAME = "sample.sqlite";
    static final private int VERSION = 1;

    SimpleDatabaseHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tsukuri_tbl (id INTEGER, tsukuri TEXT PRIMARY KEY)");
        db.execSQL("INSERT INTO tsukuri_tbl (id,tsukuri) VALUES (1,'周')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (1,'鯛')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (1,'週')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (2,'春')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (2,'鰆')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (3,'京')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (3,'鯨')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (4,'冬')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (4,'柊')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (4,'終')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (4,'鮗')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (5,'樽')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (5,'噂')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (5,'尊')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (6,'鮃')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (6,'平')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (6,'秤')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (6,'巫')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (7,'鰈')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (7,'蝶')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (7,'喋')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (7,'葉')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (8,'鰺')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (8,'参')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (9,'錆')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (9,'青')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (9,'鯖')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (10,'秋')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (10,'火')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (10,'鰍')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (11,'弱')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (11,'鰯')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (12,'鰰')");
        db.execSQL("insert into tsukuri_tbl (id,tsukuri) values (12,'神')");

        db.execSQL("CREATE TABLE fish_tbl (id INTEGER PRIMARY KEY AUTOINCREMENT, katakana TEXT, hiragana TEXT, kanji TEXT, season TEXT)");
        db.execSQL("insert into fish_tbl (katakana, hiragana, kanji, season) values ('タイ', 'たい', '鯛', '晩秋～春')");
        db.execSQL("insert into fish_tbl (katakana,hiragana,kanji,season) values ('サワラ','さわら','鰆','晩秋～冬')");
        db.execSQL("insert into fish_tbl (katakana,hiragana,kanji,season) values ('クジラ','くじら','鯨','冬')");
        db.execSQL("insert into fish_tbl (katakana,hiragana,kanji,season) values ('コノシロ','このしろ','鮗','秋～冬')");
        db.execSQL("insert into fish_tbl (katakana,hiragana,kanji,season) values ('マス','ます','鱒','冬')");
        db.execSQL("insert into fish_tbl (katakana,hiragana,kanji,season) values ('ヒラメ','ひらめ','鮃','晩秋～春')");
        db.execSQL("insert into fish_tbl (katakana,hiragana,kanji,season) values ('カレイ','かれい','鰈','種類や地域による。１年中出回っている')");
        db.execSQL("insert into fish_tbl (katakana,hiragana,kanji,season) values ('アジ','あじ','鰺','５〜７月')");
        db.execSQL("insert into fish_tbl (katakana,hiragana,kanji,season) values ('サバ','さば','鯖','10〜12月')");
        db.execSQL("insert into fish_tbl (katakana,hiragana,kanji,season) values ('イナダ・ハマチ','いなだ・はまち','鰍','11〜1月')");
        db.execSQL("insert into fish_tbl (katakana,hiragana,kanji,season) values ('イワシ','いわし','鰯','9〜11月')");
        db.execSQL("insert into fish_tbl (katakana,hiragana,kanji,season) values ('ハタハタ','はたはた','鰰','メスは11月末から1月にかけては卵（ブリコ）を持ち，旬となる．一方で3月から5月は身に脂がのり，こちらも旬となる')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tsukuri_tbl");
        db.execSQL("DROP TABLE IF EXISTS fish_tbl");
        onCreate(db);
    }
}
