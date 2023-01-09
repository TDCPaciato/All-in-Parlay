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

import java.util.ArrayList;
import java.util.List;

import allin.if5b.landindo.R;
import allin.if5b.landindo.models.Destinasi;

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.MyViewHolder> {
    private List<Destinasi> resultData = new ArrayList<>();
    private View.OnClickListener listener;
    private Context context;

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
}
