package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_move_for_result.view.*

class MoveForResultActivity() : AppCompatActivity(), View.onClickListener {

    private lateinit var btnChoose: Button
    private lateinit var rgNumber: RadioGroup

    constructor(parcel: Parcel) : this() {

    }

    companion object{
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btnChoose = findViewById(R.id.btn_choose)
        rgNumber = findViewById(R.id.rg_number)

        btnChoose.setOnClickListener(this)
    }
    override fun View.OnClickListener(v: View){
        if (rg_number.checkedRadioButtonId != 0){
            vsr value = 0
            when(rg_number.checkedRadioButtonId){
            R.id.rb_50 -> value = 50
            R.id.rb_100 -> value = 100
            R.id.rb_150 -> value = 150
            R.id.rb_200 -> value = 200
            }
        }
        val resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
        setResult(RESULT_CODE, resultIntent)
        finish()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoveForResultActivity> {
        override fun createFromParcel(parcel: Parcel): MoveForResultActivity {
            return MoveForResultActivity(parcel)
        }

        override fun newArray(size: Int): Array<MoveForResultActivity?> {
            return arrayOfNulls(size)
        }
    }

}
