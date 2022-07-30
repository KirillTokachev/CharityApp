package com.example.charityapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.charityapp.databinding.FragmentHelpBinding
import com.example.charityapp.presentation.CharityApplication
import com.example.charityapp.presentation.adapters.HelpItemAdapter
import com.example.charityapp.presentation.presenter.HelpPresenter
import com.example.charityapp.presentation.views.HelpView
import kotlinx.coroutines.*
import javax.inject.Inject

const val SPAN_COUNT = 2

class HelpFragment : MvpAppCompatFragment(), HelpView {

    private var _binding: FragmentHelpBinding? = null
    private val binding
        get() = _binding ?: throw NullPointerException("FragmentHelpBinding is null")

    private val component by lazy {
        (requireActivity().application as CharityApplication).component
    }

    private val _adapter = HelpItemAdapter()

    @Inject
    lateinit var presenter: HelpPresenter

    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchHelpCategory()
        binding.recyclerViewHelp.apply {
            adapter = _adapter
            layoutManager = GridLayoutManager(context, SPAN_COUNT)
        }
        loadHelpCategory()
        isVisibleProgress()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun isVisibleProgress() {
        GlobalScope.launch(Dispatchers.Main) {
            presenter.isVisibleProgressBar(binding.progressBarHelp)
        }
    }

    override fun fetchHelpCategory() {
        scope.launch() {
            presenter.loadNetworkData()
        }
    }

    override fun loadHelpCategory() {
        scope.launch() {
            _adapter.submitList(presenter.loadHelp())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}