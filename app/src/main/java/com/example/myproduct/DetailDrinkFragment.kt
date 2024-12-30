package com.example.myproduct

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.myproduct.databinding.FragmentDetailDrinkBinding


class DetailDrinkFragment : Fragment() {
    private lateinit var binding: FragmentDetailDrinkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailDrinkBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null){
            val args = DetailDrinkFragmentArgs.fromBundle(requireArguments())
            binding.tvName.text = args.name
            binding.tvDescription.text = args.desc
            binding.tvPrice.text = args.price
            Glide.with(requireContext()).load(args.image).into(binding.ivDrinks)

            binding.btnCall.setOnClickListener {
                val phoneNumber = "tel:996507052018"
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse(phoneNumber)
                }
                startActivity(intent)
            }


            binding.btnWhatsApp.setOnClickListener {
                val url = "https://wa.me/996507052018"
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(url)
                }
                try {
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(requireContext(), "WhatsApp не установлен", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}