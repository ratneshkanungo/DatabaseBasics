package ratnesh.com.databasebasics;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText uid,pwd;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uid= (EditText) findViewById(R.id.editText);
        pwd= (EditText) findViewById(R.id.editText2);
        db=openOrCreateDatabase("mydata",Context.MODE_PRIVATE,null);
        try{
           String table="create table  IF NOT EXISTS login_master(login_id varchar(25), password varchar(25))";
            db.execSQL(table);
        }
        catch (Exception e){}
    }

    public void registerMe(View v){
        String login_id = uid.getText().toString().trim();
        String password = pwd.getText().toString().trim();
        if (login_id.length() <=0 || password.length() <=0){
            Toast.makeText(this,"Fields Required",Toast.LENGTH_SHORT).show();
        }
        else {
           db.execSQL("insert into login_master values('"+login_id+"',' "+password+"');" );
         //  uid.setText("");
         //  pwd.setText("");
            Toast.makeText(this,"Register",Toast.LENGTH_SHORT).show();
        }
    }

}