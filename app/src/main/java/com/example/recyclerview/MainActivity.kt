package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.contacts.ContactsFragment
import com.example.recyclerview.country.CountriesFragment
import com.example.recyclerview.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val fragments = listOf(
        CountriesFragment.newInstance(),
        ContactsFragment.newInstance()
    )

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabBarAdapter = TabBarAdapter(this, fragments)
        binding.viewPager.adapter = tabBarAdapter
        TabLayoutMediator(binding.tabBar, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.countries)
                else -> getString(R.string.contacts)
            }
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}