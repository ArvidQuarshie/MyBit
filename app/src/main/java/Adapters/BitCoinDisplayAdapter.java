package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.mybit.R;

import java.util.List;

import Models.BitCoinObject;

/**
 * Created by android on 10/11/17.
 */

public class BitCoinDisplayAdapter extends RecyclerView.Adapter<BitCoinDisplayAdapter.MyViewHolder> {

    private List<BitCoinObject> bitCoinObjectList;
    Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView usd, eur,btc;
        public View mView;

        public MyViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            itemView.setOnClickListener(this);

            //instantiate all the textviews

            usd = itemView.findViewById(R.id.usd);
            eur = itemView.findViewById(R.id.eur);
            btc =  itemView.findViewById(R.id.btc);

        }


        @Override
        public void onClick(View view) {

        }
    }

    public BitCoinDisplayAdapter(List<BitCoinObject> bitCoinObjectList) {
        this.bitCoinObjectList = bitCoinObjectList;
        Log.v("size", String.valueOf(bitCoinObjectList.size()));
    }


    @Override
    public BitCoinDisplayAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        mContext = parent.getContext();

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BitCoinDisplayAdapter.MyViewHolder holder, int position) {
        final BitCoinObject bcObject = bitCoinObjectList.get(position);
        Log.v("usd",bcObject.getUSD());
        holder.usd.setText(bcObject.getUSD());
        holder.btc.setText(bcObject.getBTC().toString());
        holder.eur.setText(bcObject.getEUR());



    }

    @Override
    public int getItemCount() {
        return bitCoinObjectList.size();

    }
}
