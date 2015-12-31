package com.client.client;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.client.bean.Movie;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    /*
         * 回调接口，因为Recyclerview没有setOnitemclicklistener回调
         */
//    public interface OnItemClickLitener {
//        void onItemClick(View view, int positon);
//    }
//
//    private OnItemClickLitener mItemClickLitener;
//
//    public void setOnItemClickLitener(OnItemClickLitener mItemClickLitener) {
//        this.mItemClickLitener = mItemClickLitener;
//    }

    List<Movie> mItems;


    public CardAdapter() {
        super();

        mItems = new ArrayList<>();

        Movie movie = new Movie();
        movie.setThumbnail(R.mipmap.spiderman);
        mItems.add(movie);

        movie = new Movie();
        movie.setThumbnail(R.mipmap.xmen);
        mItems.add(movie);

        movie = new Movie();
        movie.setThumbnail(R.mipmap.hungergame);
        mItems.add(movie);

        movie = new Movie();
        movie.setThumbnail(R.mipmap.guardians_of_the_galaxy);
        mItems.add(movie);

        movie = new Movie();
        movie.setThumbnail(R.mipmap.maleficent);
        mItems.add(movie);

//        movie = new Movie();
//        movie.setThumbnail(R.mipmap.howtotrainyourdragon);
//        mItems.add(movie);
//
//        movie = new Movie();
//        movie.setThumbnail(R.mipmap.whatif);
//        mItems.add(movie);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        Movie movie = mItems.get(i);
        viewHolder.imgThumbnail.setImageResource(movie.getThumbnail());

        /*
         * 设置点击事件
		 */
        viewHolder.addOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int b = viewHolder.addOne.getCurrentTextColor();
                if(b == -9737365) {
                    v.setBackgroundResource(R.drawable.circle_good);
                    viewHolder.addOne.setTextColor(v.getResources().getColor(R.color.white));
                    String sum = viewHolder.text_good.getText().toString();
                    sum =  Integer.toString(Integer.parseInt(sum) + 1);
                    viewHolder.text_good.setText(sum);
                }else  if(b == -1){
                    v.setBackgroundResource(R.drawable.circle);
                    viewHolder.addOne.setTextColor(v.getResources().getColor(R.color.gray));
                    String sum = viewHolder.text_good.getText().toString();
                    sum =  Integer.toString(Integer.parseInt(sum) - 1);
                    viewHolder.text_good.setText(sum);
                }
            }
        });

        viewHolder.img_comment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgThumbnail;
        TextView addOne;
        ImageView img_comment;
        TextView text_good;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            addOne = (TextView) itemView.findViewById(R.id.img_good);
            img_comment = (ImageView) itemView.findViewById(R.id.img_comment);
            text_good = (TextView) itemView.findViewById(R.id.text_good);
        }
    }
}
