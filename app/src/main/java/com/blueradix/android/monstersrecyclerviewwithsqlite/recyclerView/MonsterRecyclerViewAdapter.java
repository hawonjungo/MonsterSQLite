package com.blueradix.android.monstersrecyclerviewwithsqlite.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.android.monstersrecyclerviewwithsqlite.R;
import com.blueradix.android.monstersrecyclerviewwithsqlite.entities.Monster;

import java.util.List;

public class MonsterRecyclerViewAdapter extends RecyclerView.Adapter<MonsterViewHolder> {

    private List<Monster> monsters;
    private Context context;

    public MonsterRecyclerViewAdapter(List<Monster> monsters, Context context) {
        this.monsters = monsters;
        this.context = context;
    }


    @NonNull

    @Override
    public MonsterViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View monsterView = inflater.inflate(R.layout.recycler_item_view,parent,false);

        MonsterViewHolder monsterViewHolder = new MonsterViewHolder(monsterView);

        return monsterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  MonsterViewHolder holder, int position) {
        Monster monster = monsters.get(position);
        holder.updateMonster(monster);
    }

    @Override
    public int getItemCount() {
        return monsters.size();
    }
}
