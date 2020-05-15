package com.example.basemvp.common.helper

import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.regex.Pattern

/**
 * Created by varcant on 21,April,2020
 * nanda.kista@gmail.com
 */
object ValidationHelper {
    /**
     * Check if a specified [String] is a valid [JSONObject] or [JSONArray].
     * @param message the [String] to check
     * @return true if JSON is valid
     */
    fun isValidJson(message: String): Boolean {
        try {
            JSONObject(message)
        } catch (ex: JSONException) {
            // Check if JSONArray is valid as well…
            try {
                JSONArray(message)
            } catch (ex1: JSONException) {
                return false
            }
        }

        return true
    }

    /**
     * Checks if a [String] is empty.
     * Also checks for whitespaces, so if the text is "   " it will be treated as an empty String.
     * Only checks for visible [TextView].
     * @param textView the [TextView] containing the [String] to check
     * @return true if empty, returns a false when [TextView] isn't visible / null
     */
    fun isEmpty(textView: TextView?): Boolean {
        if (textView?.visibility == View.VISIBLE) return isEmpty(textView.text.toString())
        else return false
    }

    /**
     * Checks if a [String] is empty.
     * Also checks for whitespaces, so if the text is "   " it will be treated as an empty String.
     * @param text the string to check
     * @return true if empty
     */
    fun isEmpty(text: String?): Boolean {
        if (text.isNullOrEmpty()) return true
        if (text.replace(" ".toRegex(), "").isEmpty()) return true
        return false
    }

    /**
     * Determines if a password input is valid.
     * Only checks for visible [TextView].
     * @param textView the [TextView] containing the [String] to check
     * @return false if password is invalid, returns a true when [TextView] isn't visible / null
     */
    fun isValidPassword(textView: TextView?): Boolean {
        if (textView?.visibility == View.VISIBLE) return isValidPassword(textView.text.toString())
        else return true
    }

    /**
     * Determines if a password input is valid.
     * @param text the string to check
     * @return false if password is invalid
     */
    /*fun isValidPassword(text: String?): Boolean {
        if (text.isNullOrEmpty()) return false

        // TODO: Add your own Regex here
        // This sample pattern checks for:
        // (?=.*\d)         - At least 1 number
        // (?=.*[a-zA-Z])   - At least 1 letter
        // \S{6,}           - No whitespaces, and minimum of 6 chars
        val pattern = Pattern.compile("\\A(?=.*\\d)(?=.*[a-zA-Z])\\S{6,}\\Z")
        return pattern.matcher(text).matches()
    }*/

    /**
     * Determines if a password input is valid.
     * @param text the string to check
     * @return false if password is invalid
     */
    fun isValidPassword(text: String?): Boolean {
        if (text.isNullOrEmpty()) return false

        // TODO: Add your own Regex here
        // This sample pattern checks for:
        // (?=.*[a-zA-Z])   - At least 1 letter
        // \S{6,}           - No whitespaces, and minimum of 6 chars, maximum 8 chars
        val pattern = Pattern.compile("^[a-zA-Z0-9]{5,8}$")
        return pattern.matcher(text).matches()
    }

    /**
     * Determines if an email input is valid.
     * Only checks for visible [TextView].
     * @param textView the [TextView] containing the [String] to check
     * @return false if email is invalid, returns a true when [TextView] isn't visible / null
     */
    fun isValidEmail(textView: TextView?): Boolean {
        if (textView?.visibility == View.VISIBLE) return isValidEmail(textView.text.toString())
        else return true
    }

    /**
     * Determines if an email input is valid.
     * @param text the string to check
     * @return true if it's a valid email
     */
    fun isValidEmail(text: String?): Boolean {
        if (text.isNullOrEmpty()) return false
        return Patterns.EMAIL_ADDRESS.matcher(text).matches()
    }


    fun isValidPhoneNumber(text: String?): Boolean {
        if (text.isNullOrEmpty()) return false
        val pattern = Pattern.compile("^[0-9]{10,14}$")
        return pattern.matcher(text).matches()
    }


    /**
     * Real-time Validation for Material EditText
     */
    fun layoutChangeOnValidation(text : TextInputEditText?, layoutText: TextInputLayout): Boolean {
        val fieldInput: String =
            text?.text.toString().trim()
        return when {
            fieldInput.isEmpty() -> {
                layoutText.error = "Harap diisi terlebih dahulu!"
                false
            }
            else -> {
                layoutText.error = null
                layoutText.isErrorEnabled = false
                true
            }
        }
    }

    fun isValidMaterialEditText(etLayout: TextInputLayout, etInput: TextInputEditText, message : String) {
        etInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                RealTimeValidation(s, etLayout, etInput, message)
            }
        })
    }

    fun RealTimeValidation(
        s: Editable,
        etLayout: TextInputLayout,
        etInput: TextInputEditText,
        message: String
    ) {
        if (s.isEmpty()) {
            etLayout.error = "$message"
        } else
            if (layoutChangeOnValidation(etInput, etLayout)) {
                etLayout.error = null
            }
    }

}