package hs.project.bottomsheettest

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import hs.project.bottomsheettest.databinding.DialogBottomSheetBinding


class BottomSheetDialog : BottomSheetDialogFragment() {

    private lateinit var binding: DialogBottomSheetBinding

    companion object {
        val TAG = "BottomSelectGoDialog"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DialogBottomSheetBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun getTheme(): Int = R.style.BottomSheetDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun getBottomSheetDialogDefaultHeight(): Int {
        return getWindowHeight() * 85 / 100
    }

    private fun getWindowHeight(): Int {
        // Calculate window height for fullscreen use
        val displayMetrics = DisplayMetrics()
        (context as Activity?)!!.windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

    private fun initRecyclerView() {
//        bottomGoContestAdapter.setOnItemListener(object : BottomGoContestAdapter.OnBottomSheetListener {
//            override fun onItemClick(data: ResponseNowRunContestRow) {
//                eventListener?.onContestItemClicked(data)
//                dismissAllowingStateLoss()
//            }
//        })
//
//        with(binding.rvMyContest) {
//            adapter = bottomGoContestAdapter
//            layoutManager = LinearLayoutManager(context)
//            itemAnimator = null
//            isNestedScrollingEnabled = false
//        }
    }

}