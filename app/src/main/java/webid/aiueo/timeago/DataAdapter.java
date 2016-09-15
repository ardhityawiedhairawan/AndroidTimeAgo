package webid.aiueo.timeago;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private List<DataCollect> dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public DataAdapter(List<DataCollect> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataCollect dataCollect = dataList.get(position);
        holder.title.setText(dataCollect.getTitle());
        holder.genre.setText(dataCollect.getDesc());
        AppHelper apphelper = new AppHelper();
        String formatDate = apphelper.getTimeAgo(dataCollect.getDate());
        holder.year.setText(formatDate);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
