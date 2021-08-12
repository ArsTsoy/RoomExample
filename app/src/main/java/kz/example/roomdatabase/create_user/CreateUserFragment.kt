package kz.example.roomdatabase.create_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kz.example.roomdatabase.App
import kz.example.roomdatabase.R
import kz.example.roomdatabase.databinding.FragmentCreateUserBinding
import kz.example.roomdatabase.model.User


class CreateUserFragment :
    Fragment(R.layout.fragment_create_user) {

    //region Vars
    private val viewModel: CreateUserViewModel by viewModels{
        CreateUserViewModelFactory(
            requireActivity().application,
            (requireActivity().application as App).componentDI.getDB().getUserDao()
        )
    }
    private var binding: FragmentCreateUserBinding? = null
        get() = requireNotNull(field)
    //endregion

    //region Overridden
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateUserBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
    //endregion

    //region UI
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding!!) {
            btnSaveUser.setOnClickListener {
                val user = User(
                    name = etFirstName.text.toString(),
                    lastName = etLastName.text.toString(),
                    age = etAge.text.toString().toInt(),
                    comment = etComment.text.toString()
                )
                viewModel.createUser(user)
            }
        }
    }
    //endregion

}