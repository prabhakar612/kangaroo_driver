package com.kangaroorozgar.partner.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.kangaroorozgar.partner.MvpApplication;
import com.kangaroorozgar.partner.R;
import com.kangaroorozgar.partner.common.Constants;
import com.kangaroorozgar.partner.common.SharedHelper;
import com.kangaroorozgar.partner.data.network.model.HistoryList;
import com.kangaroorozgar.partner.data.network.model.Name;

import java.util.List;

public class PastTripAdapter extends RecyclerView.Adapter<PastTripAdapter.MyViewHolder> {

    private List<HistoryList> list;
    private Context context;

    private ClickListener clickListener;

    public PastTripAdapter(List<HistoryList> list, Context con) {
        this.list = list;
        this.context = con;
    }

    public void setList(List<HistoryList> list) {
        this.list = list;
    }

    public void setClickListener(PastTripAdapter.ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_past_trip, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HistoryList historyList = list.get(position);

        holder.finishedAt.setText(historyList.getFinishedAt());
        holder.bookingId.setText(historyList.getBookingId());
        if (historyList.getPayment() != null) {

            holder.payable.setText(Constants.Currency +
                            MvpApplication.getInstance().getNewNumberFormat(historyList.getPayment().getTotal())
                    /*numberFormat.format(historyList.getPayment().getTotal())*/);

        } else holder.payable.setText(Constants.Currency + "0.00");
        if (historyList.getServicetype() != null)
            holder.lblServiceName.setText(getNameResult(historyList.getServicetype().getName()));
        Glide.with(context)
                .load(historyList.getStaticMap())
                .apply(RequestOptions.placeholderOf(R.drawable.backride)
                        .dontAnimate().error(R.drawable.backride)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(holder.staticMap);
    }
    public String getNameResult(Name value){

        String language=  SharedHelper.getKey(context,"lang_code","English");
        if (language.equalsIgnoreCase("English")){
            return value.getEn();
        }else if (language.equalsIgnoreCase("Russian")){
            return value.getRu();
        }else if (language.equalsIgnoreCase("Azerbaijan")){
            return value.getAz();
        }
        return value.getEn();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface ClickListener {
        void redirectClick(HistoryList historyList, ImageView staticMap);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView staticMap;
        private CardView itemView;
        private TextView bookingId, payable, finishedAt, lblServiceName;

        private MyViewHolder(View view) {
            super(view);

            itemView = view.findViewById(R.id.item_view);
            bookingId = view.findViewById(R.id.booking_id);
            payable = view.findViewById(R.id.payable);
            lblServiceName = view.findViewById(R.id.lblServiceName);
            finishedAt = view.findViewById(R.id.finished_at);
            staticMap = view.findViewById(R.id.static_map);

            itemView.setOnClickListener(v -> {
                if (clickListener != null)
                    clickListener.redirectClick(list.get(getAdapterPosition()), staticMap);
            });
        }
    }
}