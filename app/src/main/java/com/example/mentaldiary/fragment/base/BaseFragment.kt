package com.example.mentaldiary.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<VIEW_BINDING : ViewBinding> : Fragment() {

    private var _binding: VIEW_BINDING? = null

    private val binding: VIEW_BINDING
        get() = _binding!!

    private var _navController: NavController? = null

    protected val navController: NavController
        get() = _navController!!

    private var requester: String = "${this::class.qualifiedName!!}#${hashCode()}"

    abstract fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): VIEW_BINDING

    abstract fun VIEW_BINDING.onBindView(saveInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _navController = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = createViewBinding(inflater, container).run {
        _binding = this
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.onBindView(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()

        _navController = null
    }


}