package net.laundrie.laundrie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmOrder extends AppCompatActivity {

    TextView txt_id, txt_nama, txt_nomor_telp, txt_berat, txt_alamat;
    String sessionId, sessionNama, sessionNomor_telp, berat, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_nama = (TextView) findViewById(R.id.txt_nama);
        txt_nomor_telp = (TextView) findViewById(R.id.txt_nomor_telp);
        txt_alamat = (TextView) findViewById(R.id.txt_alamat);
        txt_berat = (TextView) findViewById(R.id.txt_berat);

        sessionId = getIntent().getStringExtra("EXTRA_SESSION_ID");
        sessionNama = getIntent().getStringExtra("EXTRA_SESSION_NAMA");
        sessionNomor_telp = getIntent().getStringExtra("EXTRA_SESSION_NOMOR_TELP");
        berat = getIntent().getStringExtra("EXTRA_SESSION_BERAT");
        alamat = getIntent().getStringExtra("EXTRA_SESSION_ALAMAT");

        txt_id.setText("ID ANDA : "+ sessionId);
        txt_nama.setText(""+sessionNama);
        txt_nomor_telp.setText("0"+sessionNomor_telp);
        txt_berat.setText(""+berat);
        txt_alamat.setText(""+alamat);
    }
}
