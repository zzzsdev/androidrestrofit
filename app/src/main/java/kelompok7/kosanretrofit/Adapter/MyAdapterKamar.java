package kelompok7.kosanretrofit.Adapter;

/**
 * Created by zs on 11/28/2017.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kelompok7.kosanretrofit.Data.Kamar;
import kelompok7.kosanretrofit.Kamar2Activity;
import kelompok7.kosanretrofit.R;

public class MyAdapterKamar extends RecyclerView.Adapter<MyAdapterKamar.MyViewHolder> {
    List<Kamar> mKamarList;
    public MyAdapterKamar(List<Kamar> KamarList) {
        mKamarList = KamarList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_kamar,parent,false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextViewIdKamar.setText("Id Kamar : "+mKamarList.get(position).getid_kamar());
        holder.mTextViewNamaKamar.setText("Nama Kamar : "+mKamarList.get(position).getnama_kamar());
        holder.mTextViewHarga.setText("Harga : "+mKamarList.get(position).getharga());
        holder.mTextViewFasilitas.setText("Fasilitas : "+mKamarList.get(position).getfasilitas());
        holder.mTextViewDeskripsi.setText("Deskripsi : "+mKamarList.get(position).getdeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), Kamar2Activity.class);
                mIntent.putExtra("idkamar",mKamarList.get(position).getid_kamar());
                mIntent.putExtra("namakamar",mKamarList.get(position).getnama_kamar());
                mIntent.putExtra("harga",mKamarList.get(position).getharga());
                mIntent.putExtra("fasilitas",mKamarList.get(position).getfasilitas());
                mIntent.putExtra("deskripsi",mKamarList.get(position).getdeskripsi());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mKamarList.size();
    }
    public class MyViewHolder extends ViewHolder {
        public TextView mTextViewIdKamar, mTextViewNamaKamar,
                mTextViewFasilitas,mTextViewHarga,mTextViewDeskripsi;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdKamar = (TextView) itemView.findViewById(R.id.tvIdKamar);
            mTextViewNamaKamar = (TextView) itemView.findViewById(R.id.tvNamaKamar);
            mTextViewHarga = (TextView) itemView.findViewById(R.id.tvHarga);
            mTextViewFasilitas = (TextView) itemView.findViewById(R.id.tvFasilitas);
            mTextViewDeskripsi = (TextView) itemView.findViewById(R.id.tvDeskripsi);
        }
    }


}
