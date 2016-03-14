package com.example.codydrees.myriadmobilechallenge;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cody Drees on 3/12/2016.
 */
public class KingdomAdapter extends RecyclerView.Adapter<KingdomAdapter.Holder> {

    private static final String TAG = KingdomAdapter.class.getSimpleName();
    private final KingdomClickListener mListener;
    private List<Kingdom> mKingdoms;

    public KingdomAdapter(KingdomClickListener listener){
        mKingdoms = new ArrayList<>();
        mListener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, null, false);

        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position){
        Kingdom currKingdom = mKingdoms.get(position);

        holder.mName.setText(currKingdom.getName());
       // holder.mID.setText(currKingdom.getId());

        Picasso.with(holder.itemView.getContext()).load(currKingdom.getImage()).into(holder.mImage);
    }

    @Override
    public int getItemCount(){
        return mKingdoms.size();
    }

    public void addKingdom(Kingdom kingdom){
        Log.d(TAG, kingdom.getName());
        mKingdoms.add(kingdom);
        notifyDataSetChanged();
    }

    public Kingdom getSelectedKingdom(int position){
        return mKingdoms.get(position);
    }
    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mImage;
        private TextView mName, mID;


        public Holder(View itemView){
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.kingdomImage);
            mName = (TextView) itemView.findViewById(R.id.kingdomName);
            //mID = (TextView) itemView.findViewById(R.id.kingdomID);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            mListener.onClick(getLayoutPosition());
        }
    }

    public interface KingdomClickListener{
        void onClick(int position);
    }
}
