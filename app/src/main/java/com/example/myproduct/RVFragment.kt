package com.example.myproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myproduct.databinding.ActivityMainBinding
import com.example.myproduct.databinding.FragmentRVBinding


class RVFragment : Fragment() {

    private lateinit var binding: FragmentRVBinding
    private lateinit var cakesAdapter: CakesAdapter
    private val cakesList = ArrayList<Cakes>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRVBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoad()
        initRV()
    }

    private fun initRV() {
        cakesAdapter = CakesAdapter(cakesList){
            findNavController().navigate(RVFragmentDirections.actionRVFragmentToDetailFragment(name = cakesList[it].name, image = cakesList[it].image, desc = cakesList[it].desc, price = cakesList[it].price))
            /*findNavController().navigate(R.id.action_RVFragment_to_detailFragment)*/

        }
        binding.rvCakes.adapter = cakesAdapter

    }

    private fun onLoad() {
        cakesList.add(Cakes(image1,"Vanilla Birthday Cake","Old-Fashioned Vanilla Buttercream","350$"))
        cakesList.add(Cakes(image2,"Blue Ombre Cake","Soet Cakes","270$"))
        cakesList.add(Cakes(image3,"Fresh Fruit Cake","This fresh fruit cake is bursting with sweet, juicy seasonal fruit","300$"))
        cakesList.add(Cakes(image4,"Chocolate Cake","It`s Just Chocolate Cake","150$"))
        cakesList.add(Cakes(image5,"Penguin Cake","It’s made with moist, dark chocolate cake layers and sweet buttercream frosting)","400$"))

    }

}

const val image1 = "https://www.onceuponachef.com/images/2012/11/Vanilla-Birthday-Cake-18.jpg"
const val image2 = "https://soetcakes.co.za/cdn/shop/files/IMG_6312_5000x.jpg?v=1711448176"
const val image3 = "https://drivemehungry.com/wp-content/uploads/2022/09/fresh-fruit-cake-5.jpg"
const val image4 = "https://mrbrownbakery.com/image/images/GJ7uCwGiteTF24HTWBclkziVTdhpQeZWH23MvQfq.jpeg?p=full"
const val image5 = "https://chelsweets.com/wp-content/uploads/2022/11/recipe-card-penguin-cake-closer-735x980.jpg"



































