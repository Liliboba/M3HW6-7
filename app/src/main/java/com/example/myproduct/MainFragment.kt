package com.example.myproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myproduct.databinding.ActivityMainBinding
import com.example.myproduct.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.constantLayout.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_RVFragment)
        }

        binding.constantLayout2.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_RVDrinksFragment)
        }
    }


}