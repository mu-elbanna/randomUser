package com.eo.randomusers.ui.usersList;

import androidx.recyclerview.widget.RecyclerView;

import com.eo.randomusers.databinding.RowUserBinding;

 class UsersListVH extends RecyclerView.ViewHolder {

     final RowUserBinding binding;

     UsersListVH(final RowUserBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }
}