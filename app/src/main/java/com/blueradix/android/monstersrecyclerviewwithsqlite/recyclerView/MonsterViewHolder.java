package com.blueradix.android.monstersrecyclerviewwithsqlite.recyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.android.monstersrecyclerviewwithsqlite.R;
import com.blueradix.android.monstersrecyclerviewwithsqlite.entities.Monster;

public class MonsterViewHolder extends RecyclerView.ViewHolder{

    public final ImageView monsterImageView;
    public final TextView monsterNameEditText;
    public final TextView monsterDescriptionEditText;
    public final TextView monsterTotalVotesTextView;

    public MonsterViewHolder(@NonNull  View itemView) {
        super(itemView);

        monsterImageView = itemView.findViewById(R.id.monsterImageView);
        monsterNameEditText = itemView.findViewById(R.id.monsterNameEditText);
        monsterDescriptionEditText = itemView.findViewById(R.id.monsterDescriptionEditText);
        monsterTotalVotesTextView = itemView.findViewById(R.id.totalVotesTextView);
    }

    public void updateMonster(Monster m){
        View rootView = monsterImageView.getRootView();
        int resId = rootView.getResources().getIdentifier(m.getImageFileName(),"drawable",rootView.getContext().getOpPackageName());
        monsterImageView.setImageResource(resId);

        this.monsterNameEditText.setText(m.getName());
        this.monsterDescriptionEditText.setText(m.getDescription());
        this.monsterTotalVotesTextView.setText(m.getVotes()+"");

    }
}
