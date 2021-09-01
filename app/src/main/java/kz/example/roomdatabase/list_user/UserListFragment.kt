package kz.example.roomdatabase.list_user

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kz.example.roomdatabase.App
import kz.example.roomdatabase.R
import kz.example.roomdatabase.model.User


class UserListFragment: Fragment(R.layout.fragment_user_list) {

    private val viewModel: UserListViewModel by viewModels {
        (requireActivity().application as App).componentDI.getUserListVMFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvUsers: TextView = view.findViewById(R.id.tvUsers)
        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)

        viewModel.observeUsers().observe(this.viewLifecycleOwner, {
            tvUsers.text = it.asString()
        })

        viewModel.observeIsLoading().observe(this.viewLifecycleOwner, {
            if(it == true) progressBar.show() else progressBar.hide()
        })
    }

    // Kotlin Extensions
    private fun List<User>.asString(): String {
        val res = StringBuilder()
        forEach {
            res.append(it.asString())
        }
        return res.toString()
    }

    private fun User.asString(): String {
        return "user: ${id}, ${name}, ${age}\n"
    }

    private fun View.show() {
        this.visibility = View.VISIBLE
    }

    private fun View.hide() {
        this.visibility = View.GONE
    }



}