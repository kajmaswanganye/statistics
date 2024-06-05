package com.example.statistics

import android.content.Context
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.github.mikephil.charting.utils.Utils

class MyMarkerView(context: Context, layoutResource: Int) : MarkerView(context, layoutResource) {

    private var tvContent: TextView

    init {
        tvContent = findViewById(R.id.tvContent)
    }

    // callbacks every time the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        e?.let {
            if (it is CandleEntry) {
                val ce = it
                tvContent.text = "" + Utils.formatNumber(ce.high, 0, true)
            } else {
                tvContent.text = "" + Utils.formatNumber(e.y, 0, true)
            }
        }

        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF(-(width / 2f), -height.toFloat())
    }
}