package hs.project.bottomsheettest

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import hs.project.bottomsheettest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private var type = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //        val dialog = BottomSheetDialog()
//        supportFragmentManager.beginTransaction().add(dialog, BottomSheetDialog.TAG)
//            .commitAllowingStateLoss()

        val bottomBehavior = BottomSheetBehavior.from(binding.bottomSheet.root)

        binding.btnClick.setOnClickListener {
            if (type == 1) {
                bottomBehavior.peekHeight = 300
                type = 2
            } else {
                bottomBehavior.peekHeight = 100
                type = 1
            }
            Toast.makeText(this, "토스트", Toast.LENGTH_SHORT).show()
        }

        bottomBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        bottomBehavior.peekHeight = 150             // 하단 시트의 초기 크기
        bottomBehavior.isHideable = false           // 숨기기 사용 or 미사용
        bottomBehavior.expandedOffset = dpToPx(60f)         // 완전히 펼쳤을 때 상단의 여백 지정 값
        bottomBehavior.halfExpandedRatio = 0.5f     // BottomSheet 가 어느 정도로 펼쳐졌을 때 half 상태로 할지 결정
        bottomBehavior.skipCollapsed = false        // 완전히 펼친 상태에서 숨김 상태로 변할 때, 접힘 상태를 스킵할지 하지 않을지 여부
        bottomBehavior.isFitToContents = false      // HALF_EXPANDED 사용할 때 필요

        bottomBehavior.apply {
            addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    when (newState) {
                        BottomSheetBehavior.STATE_COLLAPSED -> { //접힘
                            binding.bottomSheet.textView20.text = "CLOSE"
                        }

                        BottomSheetBehavior.STATE_EXPANDED -> {  //펼쳐짐
                            binding.bottomSheet.textView20.text = "OPEN"
                        }

                        BottomSheetBehavior.STATE_HIDDEN -> {}    //숨겨짐
                        BottomSheetBehavior.STATE_HALF_EXPANDED -> { //절반 펼쳐짐
                            binding.bottomSheet.textView20.text = "HALF"
                        }

                        BottomSheetBehavior.STATE_DRAGGING -> {}  // 드래그하는 중
                        BottomSheetBehavior.STATE_SETTLING -> {}  // (움직이다가) 안정화되는 중
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {

                }
            })
        }

    }

//    private fun pxToDp(pixel: Float): Int {
//        return (pixel / this.resources.displayMetrics.density).toInt()
//    }

    private fun Context.dpToPx(dp: Float): Int =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

}