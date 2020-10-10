package edu.bluejack20_1.dearmory.fragments

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import edu.bluejack20_1.dearmory.R
import edu.bluejack20_1.dearmory.ThemeManager
import java.util.*


class TimePickerDialogFragment : DialogFragment(), OnTimeSetListener {
    private lateinit var listener: TimePickerDialogListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val date = Date()
        val calendar: Calendar = GregorianCalendar.getInstance()
        calendar.setTime(date)
        val currentHour: Int = calendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute: Int = calendar.get(Calendar.MINUTE)
        var theme = R.style.DialogDarkTheme
        when(ThemeManager.THEME_INDEX){
            ThemeManager.LIGHT_THEME_INDEX -> theme = R.style.DialogLightTheme
            ThemeManager.GALAXY_THEME_INDEX -> theme = R.style.DialogGalaxyTheme
        }
        return TimePickerDialog(context, theme, this, currentHour, currentMinute, false)
    }

    override fun onTimeSet(timePicker: TimePicker, i: Int, i1: Int) {
        listener!!.onTimePickerDialogTimeSet(i, i1)
        dialog!!.dismiss()
    }

    fun setListener(listener: TimePickerDialogListener) {
        this.listener = listener
    }

    /**
     * listener
     */
    interface TimePickerDialogListener {
        fun onTimePickerDialogTimeSet(hour: Int, minute: Int)
    }
}