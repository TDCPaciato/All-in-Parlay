package allin.if5b.landindo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import allin.if5b.landindo.R;
import allin.if5b.landindo.models.Destinasi;

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.MyViewHolder> {
    private List<Destinasi> resultData = new ArrayList<>();
    private View.OnClickListener listener;
    private Context context;

    private OnClickListener listenerr;

    public AdapterPost(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterPost.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPost.MyViewHolder holder, int position) {
        Destinasi result =resultData.get(position);
        holder.tvNama.setText(result.getNama());
        Glide.with(context)
                .load(result.getGambar())
                .placeholder(R.drawable.ic_launcher_background)
                .fitCenter()
                .into(holder.ivDestinasi);
        holder.cvPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listenerr != null) {
                    listenerr.onDetail(result);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivDestinasi;
        TextView tvNama;
        CardView cvPost;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivDestinasi = itemView.findViewById(R.id.iv_gambarPost);
            tvNama = itemView.findViewById(R.id.tv_nama);
            cvPost = itemView.findViewById(R.id.cv_post);
        }
    }

    public void setResultData(List<Destinasi> destinasi){
        resultData.clear();
        resultData.addAll(destinasi);
        notifyDataSetChanged();
    }

    public interface OnClickListener {
        void onDetail (Destinasi result);
    }

    public void setOnClickListener (OnClickListener listener) {
        this.listenerr = listener;
    }
}
