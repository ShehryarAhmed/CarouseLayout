package com.technexia.user.newhorizontalcardview;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 2/23/2018.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @SuppressWarnings("UnsecureRandomNumberGeneration")
    private final Random mRandom = new Random();
    private final int[] mColors;
    public final int[] mPosition;
    private Context context;

    private final int[] image={
            R.drawable.ic_mosque,
            R.drawable.ic_noun_174041_cc,
            R.drawable.ic_noun_197054_cc,
            R.drawable.ic_noun_1216338_cc,
    };

    private final String[] title={
            "Hasib Prince",
            "Ifakhar Hossain",
            "Jin Yean",
            "Victor 2.0",
            "Badiuzzaman",
            "Minhazur Rahman",
            "Jeeva",
            "Anik Islam Abhi",
            "Saad Mahmood",
            "Chin Sze Yen",
    };


    private int mItemsCount = 4;
    LayoutInflater inflater;

    Adapter(Context context) {
        this.context=context;

        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mColors = new int[4];
        mPosition = new int[4];

        for (int i = 0; 4 > i; ++i) {
            //noinspection MagicNumber
            mColors[i] = Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
            mPosition[i] = i;

        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = inflater.inflate( R.layout.single_item, null) ;
        RecyclerView.ViewHolder holder = new RowNewsViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((RowNewsViewHolder) holder).cItem1.setText(title[position]);

        ((RowNewsViewHolder) holder).pp.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), image[position], null));

        //((RowNewsViewHolder) holder).pp.setBackgroundResource(image[position]);
        //((RowNewsViewHolder) holder).cItem2.setText(String.valueOf(mPosition[position]));

        //holder.itemView.setBackgroundColor(mColors[position]);
    }

    @Override
    public int getItemCount() {
        return mItemsCount;
    }

    public static class RowNewsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView apraisorProfilePic;
        TextView cItem1;
        CircleImageView pp;


        public RowNewsViewHolder(View itemView) {
            super(itemView);

            cItem1 = (TextView) itemView.findViewById(R.id.c_item_1);
            pp = (CircleImageView)itemView.findViewById(R.id.profilePicture);
            // cItem2 = (TextView) itemView.findViewById(R.id.c_item_2);

        }
    }
}