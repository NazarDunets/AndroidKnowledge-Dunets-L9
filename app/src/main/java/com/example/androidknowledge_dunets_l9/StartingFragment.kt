package com.example.androidknowledge_dunets_l9

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager

private const val ARG_RESULT = "arg_service_result"

class StartingFragment() : Fragment() {

    private lateinit var resultText: TextView
    private var serviceResult: Int? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            serviceResult = it.getInt(ARG_RESULT)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_starting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultText = view.findViewById(R.id.result_text)
        resultText.text = serviceResult.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(serviceResult: Int) =
            StartingFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_RESULT, serviceResult)
                }
            }
    }
}