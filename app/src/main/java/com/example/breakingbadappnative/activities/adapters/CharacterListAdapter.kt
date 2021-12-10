package com.example.breakingbadapp.activities.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.breakingbadapp.R
import com.example.breakingbadapp.activities.models.Character
import com.example.breakingbadapp.databinding.CharacterListItemBinding

class CharacterListAdapter(private val characterList: List<Character>) : RecyclerView.Adapter<CharacterListAdapter.ViewHolder>(){
    lateinit var onClickItem: (Character) -> Unit
    inner class ViewHolder (private val binding: CharacterListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {

            binding.character.text = character.name
            binding.nickname.text = character.nickname
            Glide
                .with(binding.root)
                .load(character.img)
                .circleCrop()
                .placeholder(R.drawable.ic_carga)
                .into(binding.Character1)

            when (character.status) {
                "Alive" -> {
                    Glide
                        .with(binding.root)
                        .load(R.drawable.ic_alive)
                        .circleCrop()
                        .placeholder(R.drawable.ic_carga)
                        .into(binding.status)
                }
                "Deceased" -> {
                    Glide
                        .with(binding.root)
                        .load(R.drawable.ic_deceased)
                        .circleCrop()
                        .placeholder(R.drawable.ic_carga)
                        .into(binding.status)
                }

                "Presumed dead" -> {
                    Glide
                        .with(binding.root)
                        .load(R.drawable.ic_pressumeddead)
                        .circleCrop()
                        .placeholder(R.drawable.ic_carga)
                        .into(binding.status)
                }

                "Unknown" -> {
                    Glide
                        .with(binding.root)
                        .load(R.drawable.ic_unknow)
                        .circleCrop()
                        .placeholder(R.drawable.ic_carga)
                        .into(binding.status)
                }
            }

            binding.root.setOnClickListener() {
                if (::onClickItem.isInitialized)
                    onClickItem(character)
                else
                    Log.i(
                        "CA",
                        "ClickAdapter is not Initialialized"
                    )
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterListItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.count()
    }

}