package ren.qinc.edit_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import ren.qinc.edit.PerformEdit;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private PerformEdit mPerformEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = ((EditText) findViewById(R.id.editText));
        mPerformEdit = new PerformEdit(mEditText){
            @Override
            protected void onTextChanged(Editable s) {
                //文本发生改变,可以是用户输入或者是EditText.setText触发.(setDefaultText的时候不会回调)
                super.onTextChanged(s);
            }
        };

        mPerformEdit.setDefaultText("这是初始值,不能撤销的值");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId ==R.id.action_undo){
            mPerformEdit.undo();
            return true;
        }else if(itemId == R.id.action_redo){
            mPerformEdit.redo();
            return true;
        }else if(itemId == R.id.action_clear){
            mPerformEdit.clearHistory();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
