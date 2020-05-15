package com.example.basemvp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.basemvp.R
import com.example.basemvp.ui.activity.login.LoginActivity
import com.example.bidder.sharedpreference.SharedPreference
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = SharedPreference(requireContext())
        val username = sharedPref.getValueString("USERNAME")
        val email = sharedPref.getValueString("EMAIL")

        if (username!!.isNullOrEmpty() && email!!.isNullOrEmpty()) {
            tv_nama_user_profile.text = "Admin"
            tv_email_profile.text = "admin@otoklasik.com"
        } else {
            tv_nama_user_profile.text = username
            tv_email_profile.text = email
        }

        btn_logout_profile.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            sharedPref.clearSharedPreference()
            startActivity(intent)
            activity?.finish()
        }
    }

}
