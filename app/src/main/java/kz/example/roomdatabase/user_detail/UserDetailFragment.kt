package kz.example.roomdatabase.user_detail

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kz.example.roomdatabase.App
import kz.example.roomdatabase.R
import javax.inject.Inject


class UserDetailFragment: Fragment(R.layout.fragment_create_user) {

    @Inject
    internal lateinit var factoryOfViewModel: UserDetailViewModel.UserDetailViewModelFactory.Factory

    override fun onAttach(context: Context) {
        (requireActivity() as App).componentDI.provideIn(this)
        super.onAttach(context)
    }

    private val viewModel: UserDetailViewModel by viewModels {
        factoryOfViewModel.create(123)
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