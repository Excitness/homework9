package com.askat.cw9_m3.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.askat.cw9_m3.databinding.JoblistBinding;
import com.askat.cw9_m3.model.JobListModel;

import java.util.ArrayList;
import java.util.List;

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.JoblistHolder> {
    private List<JobListModel> models =new ArrayList<>();
    private JoblistBinding binding;

    public void setList(List<JobListModel> models) {
        this.models = models;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JoblistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = JoblistBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new JoblistHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull JoblistHolder holder, int position) {
    holder.binding.nameOfJob.setText(models.get(position).getNameJob());
        holder.binding.nameOfCompany.setText(models.get(position).getNameCompany());
        holder.binding.position.setText(models.get(position).getPosition());
        holder.binding.availability.setText(models.get(position).getAvailability());
        holder.binding.location.setText(models.get(position).getLocation());
        holder.binding.salary.setText(models.get(position).getSalary());
        holder.binding.time.setText(models.get(position).getTime());


    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class JoblistHolder extends RecyclerView.ViewHolder {
        JoblistBinding binding;
        public JoblistHolder(@NonNull JoblistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
