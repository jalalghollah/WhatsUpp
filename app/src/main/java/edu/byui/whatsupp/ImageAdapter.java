package edu.byui.whatsupp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import static edu.byui.whatsupp.ThingToDoForm.EXTRA_MESSAGE;

/**
 * <h1>Image Adapter</h1>
 * This creates the things that are needed to
 * be displayed in the gridview on the home
 * page
 * <p>
 *
 *
 * @author  Dallin Wrathall
 * @version 1.0
 * @since   2018-03-21
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<ThingToDo> things;
    edu.byui.whatsupp.HomePage activity;

    public ImageAdapter(Context c, List<ThingToDo> t, Activity a) {
        mContext = c;
        things = t;
        activity = (edu.byui.whatsupp.HomePage) a;
    }

    /**
     * Get the amount of ThingsToDo that are going into the gridView
     * @return things.size();
     */
    public int getCount() {
        return things.size();
    }

    /**
     * The list of ThingsToDo that want to be displayed
     * @param t
     */
    public void setList(List<ThingToDo> t) {
        things = t;
    }

    /**
     * Does nothing
     * @param position
     * @return null
     */
    public Object getItem(int position) {
        return null;
    }

    /**
     * Does nothing
     * @param position
     * @return 0
     */
    public long getItemId(int position) {
        return 0;
    }

    /**
     * create a new ImageView for each item referenced by the Adapter
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageButton imageButton;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageButton = new ImageButton(mContext);
            imageButton.setLayoutParams(new GridView.LayoutParams(225, 225));
            imageButton.setScaleType(ImageButton.ScaleType.CENTER_CROP);
            imageButton.setPadding(8, 8, 8, 0);
        } else {
            imageButton = (ImageButton) convertView;
        }
        final ThingToDo tempThing = things.get(position);


        imageButton.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                activity.thingClick(tempThing.getTitle());
            }

        });
        String imageUrl = tempThing.getUrl();
        Picasso.with(mContext).load(imageUrl).into(imageButton);

        return imageButton;
    }



}