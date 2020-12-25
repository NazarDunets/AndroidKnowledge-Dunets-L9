package com.example.androidknowledge_dunets_l9

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidknowledge_dunets_l9.databinding.FragmentStartingBinding

class StartingFragment : Fragment() {

    private var _binding: FragmentStartingBinding? = null
    private val binding get() = requireNotNull(_binding)

    companion object {
        @JvmStatic
        fun newInstance() = StartingFragment()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        activity?.registerReceiver(updateReceiver, IntentFilter(SERVICE_ACTION))
    }

    override fun onPause() {
        super.onPause()
        activity?.unregisterReceiver(updateReceiver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val updateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val serviceResult = intent.getIntExtra("result", 0)
            binding.resultText.text = serviceResult.toString()
        }
    }
}