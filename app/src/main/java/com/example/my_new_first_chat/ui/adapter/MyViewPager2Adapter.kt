package com.example.my_new_first_chat.ui.adapter

import android.util.ArrayMap
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.my_new_first_chat.ui.fragments.basis.BallFragment
import com.example.my_new_first_chat.ui.fragments.basis.ProfileFragment
import com.example.my_new_first_chat.ui.fragments.basis.chat.ChatFragment
import com.example.my_new_first_chat.utils.BaseFragment
import com.example.my_new_first_chat.utils.FragmentReplacer

class MyViewPager2Adapter(container: Fragment) : FragmentStateAdapter(container),
    FragmentReplacer {

    companion object {
        private const val PAGE_COUNT = 3
    }

    override var lastReplacedPos = 0

    private val mapOfFragment = ArrayMap<Int, BaseFragment>()


    override fun replace(position: Int, newFragment: BaseFragment, isNotify: Boolean) {
        newFragment.setPageInfo(
            pagePos = position,
            fragmentReplacer = this
        )

        mapOfFragment[position] = newFragment
        if (isNotify)
            notifyItemChanged(position)
    }

    override fun replaceDef(position: Int, isNotify: Boolean): BaseFragment {
        val fragment = when (position) {
            0 -> BallFragment()
            1 -> ChatFragment()
            2 -> ProfileFragment()
            else -> throw IllegalStateException()
        }

        replace(position, fragment, isNotify)

        return fragment
    }

    override fun replaceCurrentToDef() {
        replaceDef(lastReplacedPos)
    }


    override fun createFragment(position: Int): Fragment {
        return mapOfFragment[position] ?: replaceDef(position, false)
    }

    override fun containsItem(itemId: Long): Boolean {
        var isContains = false
        mapOfFragment.values.forEach {
            if (it.pageId == itemId) {
                isContains = true
                return@forEach
            }
        }
        return isContains
    }

    override fun getItemId(position: Int) =
        mapOfFragment[position]?.pageId ?: super.getItemId(position)

    override fun getItemCount() = PAGE_COUNT
}