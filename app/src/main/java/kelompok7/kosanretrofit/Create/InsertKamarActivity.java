package kelompok7.kosanretrofit.Create;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import kelompok7.kosanretrofit.KamarActivity;
import kelompok7.kosanretrofit.PutDelData.PostPutDelKamar;
import kelompok7.kosanretrofit.R;
import kelompok7.kosanretrofit.Rest.ApiClient;
import kelompok7.kosanretrofit.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertKamarActivity extends AppCompatActivity {
    EditText edtIdKamar, edtNamaKamar, edtHarga, edtDeskripsi, edtFasilitas;
    Button btInsert, btBack;
    TextView tvMessage;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_kamar);

        edtIdKamar = (EditText) findViewById(R.id.edtIdKamar);
        edtNamaKamar = (EditText) findViewById(R.id.edtNamaKamar);
        edtHarga = (EditText) findViewById(R.id.edtHarga);
        edtDeskripsi = (EditText) findViewById(R.id.edtDeskripsi);
        edtFasilitas = (EditText) findViewById(R.id.edtFasilitas);
        tvMessage = (TextView) findViewById(R.id.tvMessage2);

        btInsert = (Button) findViewById(R.id.btInsert2);

        btBack = (Button) findViewById(R.id.btBack);

        Intent mIntent = getIntent();
        edtIdKamar.setText(mIntent.getStringExtra("idkamar"));
        edtNamaKamar.setText(mIntent.getStringExtra("namakamar"));
        edtHarga.setText(mIntent.getStringExtra("harga"));
        edtFasilitas.setText(mIntent.getStringExtra("fasilitas"));
        edtDeskripsi.setText(mIntent.getStringExtra("deskripsi"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelKamar> postKamarCall =
                        mApiInterface.postKamar(
                                edtIdKamar.getText().toString(),
                                edtNamaKamar.getText().toString(),
                                edtHarga.getText().toString(),
                                edtFasilitas.getText().toString(),
                                edtDeskripsi.getText().toString());
                postKamarCall.enqueue(new Callback<PostPutDelKamar>() {
                    @Override
                    public void onResponse(Call<PostPutDelKamar> call,
                                           Response<PostPutDelKamar> response) {
                        tvMessage.setText(" Retrofit Insert: " +
                                "\n " + " Status Insert : "
                                + response.body().getStatus() +
                                "\n " + " Message Insert : " +
                                response.body().getMessage());
                    }

                    @Override
                    public void onFailure(Call<PostPutDelKamar> call, Throwable t) {
                        tvMessage.setText("Retrofit Insert: \n Status Insert :" +
                                t.getMessage());
                    }
                });
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getApplicationContext(),
                        KamarActivity.class);
                startActivity(mIntent);
            }
        });
    }
}
