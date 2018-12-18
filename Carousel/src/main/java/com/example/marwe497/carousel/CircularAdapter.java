package com.example.marwe497.carousel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

class CircularAdapter extends RecyclerView.Adapter<CircularAdapter.ItemViewHolder> {


    private ArrayList<ListItem> itemList;
    private Context context;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private int height = R.dimen.img_height;
    private int width = R.dimen.img_width;

    public CircularAdapter(ArrayList<ListItem> list, Context context) {
        itemList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View ItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);



        ItemViewHolder viewHolder = new ItemViewHolder(ItemView);


        ImageView img = viewHolder.imageView;
        //Sets the dimensions of the image
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(getWidth(), getHeight());

        img.setLayoutParams(params);

        return viewHolder;
    }

    /**
     * Gets the particular item with the help of modulo
     * @param position
     * @return
     */
    public ListItem getItem(int position){
        return itemList.get(position%itemList.size());
    }

    @Override
    /**
     *Gets the resources from the ListItem
     */
    public void onBindViewHolder(@Nullable ItemViewHolder viewHolder, int position) {
        viewHolder.imageView.setImageResource(getItem(position).getImgDrawable());
        viewHolder.txtview.setText(getItem(position).getText());
        viewHolder.imageView.setOnClickListener(getItem(position).onClickListener(context));
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    /**
     * Sets the carousels ItemCount to the max value of an integer
     * So that it will continue looking for more items at the end of the list
     * So it is not in fact infinite.
     */
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtview;

        public ItemViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.imageView_image);
            txtview=view.findViewById(R.id.textView);
        }
    }

    /**
     * Gets the amount of items in the carousel
     * @return
     */
    public int getTrueLength(){
        return itemList.size();
    }
}
