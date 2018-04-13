package br.com.stv.appos

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View


class SeparatorDecoration(private val context: Context) : RecyclerView.ItemDecoration() {

    private var divider: Drawable

    init {
        divider = context.getResources().getDrawable(R.drawable.line_divider);
    }

    override fun onDrawOver(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        drawVertical(c!!, parent!!, state!!)

    }

    fun drawVertical(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0..childCount - 1) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + divider.intrinsicHeight
            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        outRect?.set(0, 0, 0, divider.intrinsicHeight)
    }
//    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView?) {
//        outRect.set(0, 0, 0, divider.intrinsicHeight)
//
//    }
}