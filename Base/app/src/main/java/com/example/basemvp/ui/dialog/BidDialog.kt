package com.example.basemvp.ui.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.basemvp.R


class BidDialog : AppCompatDialogFragment() {

    private lateinit var listener : BidDialogListener
    private lateinit var editTextNilaiBid : EditText
   // var bidTeratas = SharedPreference.bidTeratas


    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this.activity!!)
        val inflater = activity!!.layoutInflater
        val view: View = inflater.inflate(R.layout.layout_dialog_example, null)



        builder.setView(view)
            //.setCustomTitle(layoutInflater.inflate(R.layout.title_dialog, null))
           // .setMessage("Hello")
            .setTitle("Masukkan tawaran Anda")
            .setNeutralButton("CANCEL") { _, _ ->
            }

            .setPositiveButton("OK") { _, _ ->
                val bidInput = editTextNilaiBid.text.toString()
                listener.applyTexts(bidInput)
            }


        editTextNilaiBid = view.findViewById(R.id.et_nilai_bid_dialog)
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = try {
            context as BidDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString() +
                        "must implement ExampleDialogListener"
            )
        }

    }

    interface BidDialogListener {
        fun applyTexts(nilaiBid: String?)
    }
}