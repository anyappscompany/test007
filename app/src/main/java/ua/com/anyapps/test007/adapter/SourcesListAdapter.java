package ua.com.anyapps.test007.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ua.com.anyapps.test007.R;
import ua.com.anyapps.test007.pojo.sources.Sources;

public class SourcesListAdapter extends RecyclerView.Adapter<SourcesListAdapter.ViewHolder> {
    private List<Sources> sourcesList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public SourcesListAdapter(Context context, List<Sources> sourcesList) {
        this.mInflater = LayoutInflater.from(context);
        this.sourcesList = sourcesList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rv_sources_one_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Sources source = sourcesList.get(position);
        holder.tvChannelName.setText(source.getName());
        holder.tvChannelDescription.setText(source.getDescription());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return sourcesList.size();
    }

    public  Sources getSourceAt(int position){
        return sourcesList.get(position);
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvChannelName;
        TextView tvChannelDescription;

        ViewHolder(View itemView) {
            super(itemView);
            tvChannelName = itemView.findViewById(R.id.tvChannelName);
            tvChannelDescription = itemView.findViewById(R.id.tvChannelDescription);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    Sources getItem(int id) {
        return sourcesList.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
