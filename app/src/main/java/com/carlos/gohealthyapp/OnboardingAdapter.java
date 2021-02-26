package com.carlos.gohealthyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<com.carlos.gohealthyapp.OnboardingAdapter.OnboardingViewHolder> {

    private List<OnboardingItem> onboardingItems;

    public OnboardingAdapter(List<OnboardingItem> onboardingItems) {
        this.onboardingItems = onboardingItems;
    }

    @Override
    public OnboardingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_onboarding, parent, false));
    }

    @Override
    public void onBindViewHolder(OnboardingViewHolder holder, int position) {
        holder.setOnboardingData(onboardingItems.get(position));
    }

    @Override
    public int getItemCount() {
        //Devuelve el tamanio de la lista
        return onboardingItems.size();
    }

    class OnboardingViewHolder extends RecyclerView.ViewHolder{

        private TextView textTitle;
        private TextView textDescription;
        private ImageView imageOnboarding;

        public OnboardingViewHolder(View itemView) {
            super(itemView);

            textTitle       = itemView.findViewById(R.id.txtTitle);
            textDescription = itemView.findViewById(R.id.txtDescription);
            imageOnboarding = itemView.findViewById(R.id.imageOnboarding);

        }

        void setOnboardingData(OnboardingItem onboardingItem){
            textTitle.setText(onboardingItem.getTitle());
            textDescription.setText(onboardingItem.getDescription());
            imageOnboarding.setImageResource(onboardingItem.getImage());

        }
    }
}
