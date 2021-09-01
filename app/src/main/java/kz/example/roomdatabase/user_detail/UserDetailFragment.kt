package kz.example.roomdatabase.user_detail

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kz.example.roomdatabase.App
import kz.example.roomdatabase.R


class UserDetailFragment: Fragment(R.layout.fragment_create_user) {

    private val viewModel: UserDetailViewModel by viewModels {
        (requireActivity().application as App).componentDI.getAssistedFactory().create(123)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnSaveUser)
            .setOnClickListener {
                viewModel.onBtnClicked()
            }

        viewModel.observerUserIdLV().observe(this.viewLifecycleOwner, {
            Toast.makeText(requireContext(), "userId = $it", Toast.LENGTH_LONG).show()
        })
    }


}