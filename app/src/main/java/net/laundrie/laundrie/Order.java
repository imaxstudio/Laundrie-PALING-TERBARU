package net.laundrie.laundrie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Order extends AppCompatActivity {

    String[] paket = { "Regular","Medium","VIP" };
    TextView txt_id;
    String sessionId, sessionNama, sessionNomor_telp, berat, alamat;
    Button btn_order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        txt_id = (TextView) findViewById(R.id.txt_id);
        final EditText edittxt_alamat = (EditText) findViewById(R.id.edittxt_alamat);
        final EditText edittxt_berat = (EditText) findViewById(R.id.edittxt_berat);
        btn_order = (Button) findViewById(R.id.btn_order);


        sessionId = getIntent().getStringExtra("EXTRA_SESSION_ID");
        sessionNama = getIntent().getStringExtra("EXTRA_SESSION_NAMA");
        sessionNomor_telp = getIntent().getStringExtra("EXTRA_SESSION_NOMOR_TELP");
        berat = ""+edittxt_berat.getText().toString();
        alamat = ""+edittxt_alamat.getText().toString();

        txt_id.setText("ID ANDA : " + sessionId);


        Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, paket);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this, ConfirmOrder.class);
                intent.putExtra("EXTRA_SESSION_ID", sessionId);
                intent.putExtra("EXTRA_SESSION_NAMA", sessionNama);
                intent.putExtra("EXTRA_SESSION_NOMOR_TELP", sessionNomor_telp);
                intent.putExtra("EXTRA_SESSION_BERAT", berat);
                intent.putExtra("EXTRA_SESSION_ALAMAT", alamat);
                startActivity(intent);
            }
        });

    }
}
