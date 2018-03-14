package edu.byui.whatsupp;

/**
 * Created by Dallin's PC on 3/12/2018.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Dallin's PC on 3/2/2018.
 */

public class UserAdapter extends BaseAdapter {
    private Context mContext;
    private List<User> users;
    edu.byui.whatsupp.ViewEvent activity;

    private LayoutInflater l_Inflater;
    public UserAdapter(Context c, List<User> t, Activity a) {
        mContext = c;
        users = t;
        activity = (edu.byui.whatsupp.ViewEvent) a;
        l_Inflater = LayoutInflater.from(c);
    }

    public int getCount() {
        return users.size();
    }

    public void setList(List<User> t) {
        users = t;
    }

    public Object getItem(int position) {
        return users.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageButton for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = l_Inflater.inflate(R.layout.userview, null);
            holder = new ViewHolder();
            holder.Image = (ProfilePictureView) convertView.findViewById(R.id.profilePic1);
            holder.MsgType = (TextView) convertView.findViewById(R.id.name1);
            holder.MsgType2 = (TextView) convertView.findViewById(R.id.msg2);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        User tempUser = users.get(position);
        // Set the image for the profile  pic
        holder.Image.setProfileId(tempUser.getUid());
        holder.Image.setPresetSize(-2);
        holder.MsgType.setText(tempUser.getFirstName());
        // Don't need a second text for users, maybe for creator?
        holder.MsgType2.setVisibility(View.INVISIBLE);




        return convertView;
    }

    public void displayThingToDo() {

    }

    // holder view for views
    static class ViewHolder {
        ProfilePictureView Image;
        TextView MsgType;
        TextView MsgType2;
    }


}