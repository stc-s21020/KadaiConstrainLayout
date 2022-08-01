package jp.suntech.s21020.kadaiconstrainlayout;

import androidx.appcompat.app.AppCompatActivity;
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
            String name = inputName.getText().toString();
            String mail = inputMail.getText().toString();
            String title = inputTitle.getText().toString();
            String comment = inputComment.getText().toString();
            String show = mail + "\n" +name+"さん宛てに\n" + title + "：\n" + comment + "\nを送信します。";
            Bundle args = new Bundle();
            args.putString("name", name);
            args.putString("mail", mail);
            args.putString("title", title);
            args.putString("comment", comment);

            int id = view.getId();
            switch (id){
                case R.id.btConfirm:
                    ConfirmDialogFragment dialogFragment = new ConfirmDialogFragment();
                    dialogFragment.setArguments(args);
                    dialogFragment.show(getSupportFragmentManager(), "ConfirmDialogFragment");
                    break;
                case R.id.btSend:
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