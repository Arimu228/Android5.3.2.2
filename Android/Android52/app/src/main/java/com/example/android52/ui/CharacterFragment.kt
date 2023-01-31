package com.example.android52.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android52.R
import com.example.android52.data.RemoteRepository
import com.example.android52.data.model.Characters
import com.example.android52.databinding.FragmentFirstBinding


@Suppress("UNREACHABLE_CODE")
class FirstFragment : Fragment() {
    private val repository = RemoteRepository()
    lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getCharacters()
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

//    swipeRefreshLayout


    private fun getCharacters() {
        repository.getCharacters(this::onSuccess, this::onFailure)
    }

    private fun onCLick(id: Int) {

    }

    private fun onSuccess(characters: Characters) {


        binding.rvMain.adapter = CharacterAdapter(characters, this::onCLick)

    }


    private fun onFailure(message: String) {
        Log.e("olo", "onFailure: $message")
    }


}