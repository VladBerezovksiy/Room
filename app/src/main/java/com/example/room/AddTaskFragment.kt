package com.example.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class AddTaskFragment : Fragment() {

    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_employee_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(TaskViewModel::class.java)
        val nameInput: EditText = view.findViewById(R.id.titleInputField)
        val descInput: EditText = view.findViewById(R.id.descInputField)
        val addButton: Button = view.findViewById(R.id.addButton)

        addButton.setOnClickListener {
            val name = nameInput.text.toString()
            val desc = descInput.text.toString()
            viewModel.add(name, desc)
            parentFragmentManager.popBackStack()
        }
    }
}