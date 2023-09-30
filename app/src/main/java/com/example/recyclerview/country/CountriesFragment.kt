package com.example.recyclerview.country

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerview.R
import com.example.recyclerview.databinding.FragmentCountriesBinding


class CountriesFragment : Fragment() {
    private var _binding: FragmentCountriesBinding? = null
    private val binding
        get() = _binding!!

    private val countriesAdapter = CountriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountriesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.adapter = countriesAdapter
        countriesAdapter.setData(countries)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private val countries = listOf(
            Country(1, "Россия", R.drawable.ru),
            Country(2, "США", R.drawable.us),
            Country(3, "Китай", R.drawable.cn),
            Country(4, "Индия", R.drawable.`in`),
            Country(5, "Бразилия", R.drawable.br),
            Country(6, "Австралия", R.drawable.au),
            Country(7, "Канада", R.drawable.ca),
            Country(8, "Франция", R.drawable.fr),
            Country(9, "Германия", R.drawable.de),
            Country(10, "Япония", R.drawable.jp),
            Country(11, "Великобритания", R.drawable.gb),
            Country(12, "Италия", R.drawable.it),
            Country(13, "Испания", R.drawable.es),
            Country(14, "Мексика", R.drawable.mx),
            Country(15, "Турция", R.drawable.tr),
            Country(16, "Иран", R.drawable.ir),
            Country(17, "Индонезия", R.drawable.id),
            Country(18, "Южная Корея", R.drawable.kr),
            Country(19, "Саудовская Аравия", R.drawable.sa),
            Country(20, "Южно-Африканская Республика", R.drawable.za),
            Country(21, "Египет", R.drawable.eg),
            Country(22, "Нигерия", R.drawable.ng),
            Country(23, "Пакистан", R.drawable.pk),
            Country(24, "Аргентина", R.drawable.ar),
            Country(25, "Польша", R.drawable.pl),
            Country(26, "Украина", R.drawable.ua),
            Country(27, "Колумбия", R.drawable.co),
            Country(28, "Таиланд", R.drawable.th),
            Country(29, "Швеция", R.drawable.se),
            Country(30, "Нидерланды", R.drawable.nl)
        )

        @JvmStatic
        fun newInstance() = CountriesFragment()
    }
}