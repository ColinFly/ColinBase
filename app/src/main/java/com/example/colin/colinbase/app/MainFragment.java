package com.example.colin.colinbase.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.colin.colinbase.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by colin on 16-3-11.
 * 主菜单下的Fragment
 */
public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView= (RecyclerView) inflater.inflate(R.layout.fragment_main_fragment, container,false);
        initRecyclerView(recyclerView);

        return recyclerView;
    }

    private void initRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleRecyclerViewAdapter(recyclerView.getContext(), getRandomData(Cheeses.sCheeseStrings,30)));
    }

    private List<String> getRandomData(String[] array, int amount) {
        ArrayList<String> list=new ArrayList<>(amount);
        Random random=new Random();
        while (list.size() < amount) {
            list.add(array[random.nextInt(array.length)]);
        }
        return list ;
    }

    static class SimpleRecyclerViewAdapter extends RecyclerView.Adapter<SimpleRecyclerViewAdapter.ViewHolder> {
        private int mBackground;
        private TypedValue mTypedValue=new TypedValue();
        private List<String> mValues;
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final ImageView mImageView;
            public final TextView mTextView;
            public String mBoundString;
            public ViewHolder(View itemView) {
                super(itemView);
                mView = itemView;
                mImageView = (ImageView) itemView.findViewById(R.id.avatar);
                mTextView = (TextView) itemView.findViewById(android.R.id.text1);
            }

            @Override
            public String toString() {
                return super.toString() + "" + mTextView.getText();
            }
        }


        public SimpleRecyclerViewAdapter(Context context,List<String> mValues) {
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
            mBackground = mTypedValue.resourceId;
            this.mValues = mValues;
        }

        @Override
        public SimpleRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
            view.setBackgroundResource(mBackground);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mBoundString = mValues.get(position);
            holder.mTextView.setText(mValues.get(position));

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, CheesesDetailAty.class);
                    intent.putExtra(CheesesDetailAty.EXTRA_NAME, holder.mBoundString);
                    context.startActivity(intent);
                }
            });

            Glide.with(holder.mImageView.getContext())
                    .load(Cheeses.getRandomCheeseDrawable())
                    .fitCenter()
                    .into(holder.mImageView);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }




    }
}
