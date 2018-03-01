package edu.byui.whatsupp;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.StorageReference;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static android.net.wifi.WifiConfiguration.Status.strings;

/**
 * Created by Dallin's PC on 2/26/2018.
 */

public class ThingToDoPresenter {
    ThingToDoActivity thingToDoActivity;
    static List<ThingToDo> things = new ArrayList<ThingToDo>();

    public ThingToDoPresenter() {

    }

    public List<ThingToDo> getListThings(Activity activity){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("thingsToDo")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                //ThingToDo tempThing = new ThingToDo((StorageReference) document.get("storageRef"), (String)document.get("title"), (String)document.get("address"), (String)document.get("city"), (int) document.get("zipCode"), (String)document.get("description"));
                                //things.add(tempThing);
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });


        return(things);
    }





}


