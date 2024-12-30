package com.example.myproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myproduct.databinding.FragmentRVDrinksBinding


class RVDrinksFragment : Fragment() {

    private lateinit var binding: FragmentRVDrinksBinding
    private lateinit var drinksAdapter: DrinksAdapter
    private val drinksList = ArrayList<Drinks>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRVDrinksBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoad()
        initRV()
    }

    private fun initRV() {
        drinksAdapter = DrinksAdapter(drinksList){
            findNavController().navigate(RVDrinksFragmentDirections.actionRVDrinksFragmentToDetailDrinkFragment(name = drinksList[it].name, image = drinksList[it].image, desc = drinksList[it].desc, price = drinksList[it].price))
        }
        binding.rvDrinks.adapter = drinksAdapter

    }

    private fun onLoad() {
        drinksList.add(Drinks("https://i.ytimg.com/vi/YLcaX5q6eks/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLD7GcCGs2lz9MaAhgnja3y2GUoSqg","Beers","Budweiser, Heineken, Corona, Guinness, Stella Artois.","5$"))
        drinksList.add(Drinks("https://146837091.cdn6.editmysite.com/uploads/1/4/6/8/146837091/s689082932990932060_p98_i1_w1800.jpeg","Soda","Coca-Cola, Pepsi, Sprite, Fanta, Dr Pepper.","7$"))
        drinksList.add(Drinks("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShxK2QV1fG8KWdfgjOJ71_neEbObsvB6lFPQ&s","Juice","Tropicana, Minute Maid, Capri Sun, Ocean Spray, Simply Orange.","10$"))
        drinksList.add(Drinks("https://www.wines.by/upload/iblock/4aa/4aa5f82c7db8af716ec2cfe940ba686d.jpg","Wine", "Merlot, Chardonnay, Pinot Noir, Sauvignon Blanc, Cabernet Sauvignon.","500$"))
        drinksList.add(Drinks("https://click-or-die.ru/app/uploads/2020/08/energetiki-zlo.jpg","Energy Drink", "Red Bull, Monster Energy, Rockstar, Bang Energy, Celsius.","2$"))

    }

}



