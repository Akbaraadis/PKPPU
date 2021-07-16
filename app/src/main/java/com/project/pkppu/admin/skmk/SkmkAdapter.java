package com.project.pkppu.admin.skmk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.project.pkppu.R;

import java.util.List;


public class SkmkAdapter extends RecyclerView.Adapter<SkmkAdapter.ViewHolder> {

    private Context context;
    private List<Skmk> list;

    public SkmkAdapter(Context context, List<Skmk> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SkmkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new SkmkAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Skmk skmk = list.get(position);

        holder.textNik.setText(skmk.getNo_req_skmk());
        holder.textStatus.setText(skmk.getStatus());


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailSkmkActivity.class);
                intent.putExtra("no_req_skmk", skmk.no_req_skmk);
                intent.putExtra("thn_meninggal", skmk.thn_meninggal);
                intent.putExtra("file_makam", skmk.file_makam);
                intent.putExtra("file_s_materai", skmk.file_s_materai);
                intent.putExtra("ktp_pengurus", skmk.ktp_pengurus);
                intent.putExtra("kk_alm", skmk.kk_almarhum);
                intent.putExtra("ktp_alm", skmk.ktp_almarhum);
                intent.putExtra("sk_rtrw", skmk.file_rtrw);
                intent.putExtra("nik", skmk.nik);
                intent.putExtra("status", skmk.status);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textNik, textStatus;
        public ConstraintLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textNik = itemView.findViewById(R.id.item_nik);
            textStatus = itemView.findViewById(R.id.item_status);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
