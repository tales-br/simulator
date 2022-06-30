package br.tales.simulator.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.tales.simulator.databinding.MatchItemBinding;
import br.tales.simulator.domain.Match;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder>
{
    private List<Match> matches;

    public MatchesAdapter(List<Match> matches)
    {
        this.matches = matches;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final MatchItemBinding binding;

        public ViewHolder(MatchItemBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    //Instancia o viewHolder. Precisa de um item de binding
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MatchItemBinding binding = MatchItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    //Adapta os dados da partida (recuperado da API do git) e atribui ao layout
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Match match = matches.get(position);

        holder.binding.tvHomeTeamName.setText(match.getHomeTeam().getName());
        holder.binding.tvAwayTeamName.setText(match.getAwayTeam().getName());
    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

}
