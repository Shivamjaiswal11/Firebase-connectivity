package com.example.tablayoutfragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class FragementAdapter(
    fm:
    FragmentManager
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Market1()
            }
            1 -> {
                Market2()
            }
            2 -> {
                Market3()
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0->"Market 1"
            1->"Market 2"
            2->"Market 3"
            else ->{
                return "Market 4"

            }
        }

    }
}
