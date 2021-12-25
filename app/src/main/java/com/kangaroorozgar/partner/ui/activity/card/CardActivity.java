package com.kangaroorozgar.partner.ui.activity.card;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kangaroorozgar.partner.R;
import com.kangaroorozgar.partner.base.BaseActivity;
import com.kangaroorozgar.partner.data.network.model.Card;
import com.kangaroorozgar.partner.ui.activity.add_card.AddCardActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class CardActivity extends BaseActivity implements CardIView {

    @BindView(R.id.cards_rv)
    RecyclerView cardsRv;
    @BindView(R.id.llCardContainer)
    LinearLayout llCardContainer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.addCard)
    Button addCard;
    List<Card> cardsList = new ArrayList<>();
    private CardPresenter<CardActivity> presenter = new CardPresenter<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_card;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        presenter.attachView(this);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.card));
        CardAdapter adapter = new CardAdapter(cardsList);
        cardsRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        cardsRv.setAdapter(adapter);

    }

    @Override
    public void onSuccess(Object card) {
        hideLoading();
        Toasty.success(activity(), getString(R.string.card_deleted_successfully), Toast.LENGTH_SHORT).show();
        showLoading();
        presenter.card();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.card();
    }

    @Override
    public void onSuccess(List<Card> cards) {
        hideLoading();
        cardsList.clear();
        cardsList.addAll(cards);
        cardsRv.setAdapter(new CardAdapter(cardsList));
    }


    @Override
    public void onError(Throwable e) {
        hideLoading();
        if (e != null)
            onErrorBase(e);
    }

    @Override
    public void onSuccessChangeCard(Object card) {
        hideLoading();
        Toasty.success(this, card.toString(), Toast.LENGTH_SHORT).show();
        showLoading();
        presenter.card();
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    private void showCardChangeAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.AlertDialogCustom)
                .setMessage(getResources().getString(R.string.are_sure_you_want_to_change_default_card))
                .setPositiveButton(getResources().getString(R.string.change_card),
                        (dialog, which) -> {
                            startActivity(new Intent(this, AddCardActivity.class));
                        })
                .setNegativeButton(getResources().getString(R.string.no),
                        (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick({R.id.addCard})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.addCard:
                startActivity(new Intent(this, AddCardActivity.class));
                break;
        }
    }

    public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

        private List<Card> list;

        CardAdapter(List<Card> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_card, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Card item = list.get(position);
            holder.card.setText(getString(R.string.card_) + item.getLastFour());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private RelativeLayout itemView;
            private TextView card;
            private TextView changeText;

            MyViewHolder(View view) {
                super(view);
                itemView = view.findViewById(R.id.item_view);
                card = view.findViewById(R.id.card);
                changeText = view.findViewById(R.id.text_change);
                changeText.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                Card card = list.get(position);
                switch (view.getId()) {
                    case R.id.text_change:
                        showCardChangeAlert();
                        break;

                    default:
                        break;
                }
            }
        }
    }
}
