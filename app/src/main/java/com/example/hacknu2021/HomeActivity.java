package com.example.hacknu2021;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Objects;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Constants;


public class HomeActivity extends AppCompatActivity {
    // private static final int ACTIVITY_EDIT_REQUEST_CODE = ;
    ColorStateList def;
    TextView item1;
    TextView item2;
    TextView select;
    ImageButton img1;
    ImageButton img2;

    FloatingActionButton contributeBtn;

    PostAdapter adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ArrayList<Post> postArrayList;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = (ImageButton) findViewById(R.id.search);

        img2 = (ImageButton) findViewById(R.id.user);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Posts");

        postArrayList = new ArrayList<Post>();

        adapter = new PostAdapter(this, R.layout.contribute_post_item, postArrayList);

        contributeBtn = findViewById(R.id.HomeContributeButton);

        ListView productsListView = findViewById(R.id.listView);
        productsListView.setAdapter(adapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                postArrayList.clear();
                for (DataSnapshot postsnap : snapshot.getChildren()) {
                    Post post = postsnap.getValue(Post.class);
                    postArrayList.add(post);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        productsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String tag = view.getTag().toString();

                // Get a reference to users
                // Attach an listener to read our users
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        Post wantedPost = null;
                        for (DataSnapshot post: snapshot.getChildren()) {
                            //this is all you need to get a specific user by Uid
                            if (post.getKey().equals(tag)){
                                wantedPost = post.getValue(Post.class);
                            }
                            //**********************************************

                        }
                        if (wantedPost != null) {
                            Toast.makeText(getApplicationContext(), "clicked: ", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), PostActivity.class);
                            intent.putExtra("id", wantedPost.getUserId());
                            intent.putExtra("title", wantedPost.getTitle());
                            intent.putExtra("desc", wantedPost.getDescription());
                            intent.putExtra("username", wantedPost.getUserName());
                            Log.d("OnItemClick", "p ne NULL");
                            startActivity(intent);
                        }
                        Log.d("OnItemClick", "onRabotaet");
                        Log.i("OnItemClick", "onDataChange: " + wantedPost.getTitle());
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        System.out.println("The read failed: " + error.getMessage());
                    }
                });

//                Query applesQuery = databaseReference.child("Posts").orderByChild("postKey").equalTo(tag);
//
//                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        Post p = null;
//                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
//                            Log.d("OnItemClick", "dataSnapshot");
//                            p = appleSnapshot.getValue(Post.class);
//                            break;
//                        }
//                        if (p != null) {
//                            Toast.makeText(getApplicationContext(), "clicked: ", Toast.LENGTH_LONG).show();
//                            Intent intent = new Intent(getApplicationContext(), PostActivity.class);
//                            intent.putExtra("id", p.getUserId());
//                            Log.d("OnItemClick", "p ne NULL");
//                            startActivity(intent);
//                        }
//                        Log.d("OnItemClick", "onRabotaet");
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                        Log.e("OnItemClick", "onCancelled", databaseError.toException());
//                    }
//                });
            }
        });


//        item1 = findViewById(R.id.item1);
//        item2 = findViewById(R.id.item2);
//        item1.setOnClickListener((View.OnClickListener) this);
//        item2.setOnClickListener((View.OnClickListener) this);

//        select = findViewById(R.id.select);
//        def = item2.getTextColors();
    }

    public void onBtnClicked(View v) {
        Intent intent;
        int id = v.getId();
        switch (id) {
            case R.id.HomeContributeButton:
                intent = new Intent(this, QuestionActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.search:
                intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.user:
                intent = new Intent(this, UserActivity.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        adapter.notifyDataSetChanged();
    }
}