package com.example.managework.mvvmtodolist.ui.add

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.managework.R
import com.example.managework.databinding.FragmentAdd2Binding
import com.example.managework.mvvmtodolist.database.TaskEntry
import com.example.managework.mvvmtodolist.viewmodel.TaskViewModel
import java.util.*


class AddFragment : Fragment(){

    private val viewModel: TaskViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentAdd2Binding.inflate(inflater)

        val myAdapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.priorities)
        )
        binding.apply {

            spinner.adapter = myAdapter
            btnAddTask.setOnClickListener {
                if (TextUtils.isEmpty((addTitle.text))){
                    Toast.makeText(requireContext(), "It's empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val title_str = addTitle.text.toString()
                val priority = spinner.selectedItemPosition

                val taskEntry = TaskEntry(
                    0,
                    title_str,
                    priority,
                    System.currentTimeMillis()
                )

                viewModel.insert(taskEntry)
                Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_addFragment_to_taskFragment)
            }
        }

        return binding.root
    }



}
