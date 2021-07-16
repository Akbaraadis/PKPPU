package com.project.pkppu.admin.skpk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;;
import com.project.pkppu.R;

import java.util.List;

public class SkpkAdapter extends RecyclerView.Adapter<SkpkAdapter.ViewHolder> {

    private Context context;
    private List<Skpk> list;

    public SkpkAdapter(Context context, List<Skpk> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Skpk skpk = list.get(position);

        holder.textNik.setText(skpk.getNo_req_skpk());
        holder.textStatus.setText(skpk.getstatus());


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailSkpkActivity.class);
                intent.putExtra("no_req_skpk", skpk.no_req_skpk);
                intent.putExtra("kk_alm", skpk.kk_alm);
                intent.putExtra("ktp_alm", skpk.ktp_alm);
                intent.putExtra("sk_rtrw", skpk.sk_rtrw);
                intent.putExtra("nik", skpk.nik);
                intent.putExtra("status", skpk.status);
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
