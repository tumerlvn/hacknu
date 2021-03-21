package com.example.hacknu2021;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends ArrayAdapter<Post> {

    Context mContext;
    private int resource;
    ArrayList<Post> mData;

    public PostAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Post> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.resource = resource;
        this.mData = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(resource, null);

        TextView tvTitle = view.findViewById(R.id.postTitle);
        TextView tvDescription = view.findViewById(R.id.postDescription);
        TextView tvName = view.findViewById(R.id.postName);

        tvTitle.setText(mData.get(position).getTitle());
        tvDescription.setText(mData.get(position).getDescription());
        tvName.setText(mData.get(position).getUserName());

        view.setTag(mData.get(position).getPostKey());

        return view;
    }

    public void refresh(ArrayList<Post> mData) {
        this.mData = mData;
    notifyDataSetChanged();
    }

//    postList = new ArrayList<Post>();
//                for (
//    DataSnapshot postsnap: snapshot.getChildren()) {
//        Post post = postsnap.getValue(Post.class);
//        postList.add(post);
//    }

}
