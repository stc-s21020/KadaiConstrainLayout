package jp.suntech.s21020.kadaiconstrainlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btConfirm = findViewById(R.id.btConfirm);
        Button btSend = findViewById(R.id.btSend);
        Button btClear = findViewById(R.id.btClear);

        HelloListener listener = new HelloListener();
        btConfirm.setOnClickListener((listener));
        btSend.setOnClickListener((listener));
        btClear.setOnClickListener((listener));
    }

    private class HelloListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            EditText inputName = findViewById(R.id.etName);
            EditText inputMail = findViewById(R.id.etMail);
            EditText inputTitle = findViewById(R.id.etTitle);
            EditText inputComment = findViewById(R.id.etComment);

            int id = view.getId();
            switch (id){
                case R.id.btConfirm:
                    ConfirmDialogFragment dialogFragment = new ConfirmDialogFragment();
                    dialogFragment.show(getSupportFragmentManager(), "ConfirmDialogFragment");
                    break;
                case R.id.btSend:
                    String name = inputName.getText().toString();
                    String mail = inputMail.getText().toString();
                    String title = inputTitle.getText().toString();
                    String show ="名前："+name+", タイトル:" + title + ", メールアドレス：" + mail + "に質問内容を送信します。";
                    Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();
                    break;
                case R.id.btClear:
                    inputName.setText("");
                    inputMail.setText("");
                    inputTitle.setText("");
                    inputComment.setText("");
                    break;
            }
        }
    }
}