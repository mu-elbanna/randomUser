package com.eo.randomusers.ui.usersList;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.eo.randomusers.R;
import com.eo.randomusers.databinding.RowUserBinding;
import com.eo.randomusers.model.Results;

import java.util.ArrayList;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListVH> {

    private ArrayList<Results> items;
    private UsersListCallBack callBack;

    UsersListAdapter(ArrayList<Results> items, UsersListCallBack callBack) {
        this.items = items;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public UsersListVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        RowUserBinding binding = DataBindingUtil.inflate(inflater, R.layout.row_user, viewGroup, false);
        return new UsersListVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersListVH holder, int i) {
        final Results data = items.get(i);

        holder.binding.setVar(data);
        holder.binding.setHandler(callBack);
    }

    void updateItems(ArrayList<Results> results) {
        items.addAll(results);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (items == null || items.size() == 0) {
            return 0;
        }
        return items.size();
    }
}