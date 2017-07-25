package com.imeepwni.android.nerdlauncher.ui


import android.databinding.*
import android.os.*
import android.support.v4.app.*
import android.support.v7.widget.*
import android.view.*
import com.imeepwni.android.nerdlauncher.*
import com.imeepwni.android.nerdlauncher.databinding.*
import com.imeepwni.android.nerdlauncher.model.data.*
import com.imeepwni.android.nerdlauncher.model.repository.*
import com.imeepwni.android.nerdlauncher.viewmodel.*

class NerdFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentNerdBinding>(inflater, R.layout.fragment_nerd, container, false)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = Adapter(ActivityIntentRepository.getActivityIntent(activity))
        }
        return binding.root
    }

    inner class ViewHolder(val binding: ListItemActivityIntentBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(activityIntent: ActivityIntent) {
            with(binding) {
                if (viewModel==null)
                    viewModel = ActivityIntentViewModel(activityIntent)
                else {
                    viewModel?.setActivityIntent(activityIntent)
                    executePendingBindings()
                }
            }
        }
    }

    inner class Adapter(val list: List<ActivityIntent>) : RecyclerView.Adapter<ViewHolder>() {
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount(): Int = list.size

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
            val binding = DataBindingUtil.inflate<ListItemActivityIntentBinding>(LayoutInflater.from(activity), R.layout.list_item_activity_intent, parent, false)
            binding.activity = activity
            return ViewHolder(binding)
        }
    }

    companion object {
        fun newInstance(): NerdFragment {
            val fragment = NerdFragment()
            return fragment
        }
    }

}
