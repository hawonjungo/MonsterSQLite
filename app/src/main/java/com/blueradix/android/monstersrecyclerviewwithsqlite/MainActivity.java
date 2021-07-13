package com.blueradix.android.monstersrecyclerviewwithsqlite;

import android.content.Intent;
import android.os.Bundle;

import com.blueradix.android.monstersrecyclerviewwithsqlite.activities.AddMonsterScrollingActivity;
import com.blueradix.android.monstersrecyclerviewwithsqlite.entities.Monster;
import com.blueradix.android.monstersrecyclerviewwithsqlite.recyclerView.MonsterRecyclerViewAdapter;
import com.blueradix.android.monstersrecyclerviewwithsqlite.service.DataService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import static com.blueradix.android.monstersrecyclerviewwithsqlite.entities.Constants.ADD_MONSTER_ACTIVITY_CODE;

public class MainActivity extends AppCompatActivity {

    private DataService monsterDataService;
    private Monster monster;
    private View rootView;
    private List<Monster> monsters;
    private MonsterRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewMonster();
            }
        });
        rootView = findViewById(android.R.id.content).getRootView();

        /**
         * TODO: create a recycler view in content_main.xml file
         *      set as Id: monstersRecyclerview
         * 	    make it responsive by setting the constraints
         *  ____________
         *  Done !!
         * /

        /**
         * TODO: create a recycler view item call it recycler_item_view.xml (do not forget to use constraint layout)
         *      Right click on Layout package -> New -> Layout Resource File
         *      Add:
         *          MaterialCardView
         *          Constraint Layout Inside. (Set MinHeight to be able to replicate the layout)
         *              3 guidelines (0.02, 0.70, 0.98)
         * 	            ImageView  -> monsterImageView, scaleType: centerInside
         * 	            TextView -> monsterNameTextView, textAppearance: textAppeareanceHeadline6
         * 	            TextView -> monsterDescriptionTextView
         * 	            Button -> Action 1
         * 	            Button -> Action 2
         * 	            TextView -> monsterTotalVotesTextView
         * 	            RatingBar -> monsterRatingBar, style : @android:style/Widget.Material.RatingBar.Small
         * 	            checkBox
         */

        /**
         * TODO: create the viewHolder: MonsterViewHolder
         *       create the Adapter: MonsterRecyclerViewAdapter
         */


        RecyclerView monsterRecyclerView = findViewById(R.id.monstersRecyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        monsterRecyclerView.setLayoutManager(linearLayoutManager);
        /**
         * TODO: Implement the RecyclerView in onCreate
         *      create the Layout to use how to present the RecyclerView (Linear? Grid? )
         *      set the created layout to your recyclerView
         */

        //Load Data from the database
        monsterDataService = new DataService();
        monsterDataService.init(this);
        /**
         * TODO: call the database, to get allMonsters
         */

        monsters = monsterDataService.getMonsters();

        /**
         * TODO: create a RecyclerViewAdapter instance and pass the data
         */
        adapter = new MonsterRecyclerViewAdapter(monsters,this);
        /**
         * TODO: set the adapter to the RecyclerView
         */
        monsterRecyclerView.setAdapter(adapter);
    }

    private void addNewMonster() {
        Intent goToAddCreateMonster = new Intent(this, AddMonsterScrollingActivity.class);
        startActivityForResult(goToAddCreateMonster, ADD_MONSTER_ACTIVITY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_MONSTER_ACTIVITY_CODE){
            if(resultCode == RESULT_OK){
                addMonster(data);
            }
        }
    }

    private void addMonster(Intent data) {
        String message;
        Monster monster = (Monster) data.getSerializableExtra(Monster.MONSTER_KEY);
        //insert your monster into the DB
        Long result = monsterDataService.add(monster);
        //result holds the autogenerated id in the table
        if(result > 0){
            message = "Your monster was created with id: "+ result;
        }else{
            message = "We couldn't create your monster, try again";
        }
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
