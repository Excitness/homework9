package com.askat.cw9_m3.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.askat.cw9_m3.databinding.ItemWorksBinding;
import com.askat.cw9_m3.model.WorksModel;

import java.util.ArrayList;
import java.util.List;

public class WorksAdapter extends RecyclerView.Adapter<WorksAdapter.WorksHolder> {
    private List<WorksModel> models =new ArrayList<>();
    private ItemWorksBinding binding;

    public void setList(List<WorksModel> models) {
        this.models = models;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WorksHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemWorksBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new WorksHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorksHolder holder, int position) {
    holder.binding.nameOfJob.setText(models.get(position).getNameJob());
        holder.binding.nameOfCompany.setText(models.get(position).getNameCompany());
        holder.binding.position.setText(models.get(position).getPosition());
        holder.binding.timeLoad.setText(models.get(position).getTimeLoad());
        holder.binding.salary.setText(models.get(position).getSalary());
        holder.binding.time.setText(models.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class WorksHolder extends RecyclerView.ViewHolder {
        ItemWorksBinding binding;
        public WorksHolder(@NonNull ItemWorksBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
