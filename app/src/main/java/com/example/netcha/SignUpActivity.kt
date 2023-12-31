package com.example.netcha
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Timer
import java.util.TimerTask
class SignUpActivity : AppCompatActivity() {
    lateinit var nameText: EditText
    lateinit var idText: EditText
    lateinit var pwText: EditText
    lateinit var upbutton: Button
    lateinit var upidcheck: Button
    lateinit var upnamecheck: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sigin_up)
        // XML에서 레이아웃 요소들과 연결
        nameText = findViewById(R.id.up_name_edit)
        idText = findViewById(R.id.up_id_edit)
        pwText = findViewById(R.id.up_pw_edit)
        upbutton = findViewById(R.id.up_button)
        upidcheck = findViewById(R.id.up_id_check)
        upnamecheck = findViewById(R.id.up_name_check)
        // 닉네임 텍스트 변경 textwatcher
        nameText.addTextChangedListener(createNameTextWatcher(nameText))
        // 아이디 텍스트 변경 textwatcher
        idText.addTextChangedListener(createIdTextWatcher(idText))
        // 비밀번호 텍스트 변경 textwatcher
        pwText.addTextChangedListener(createPasswordTextWatcher(pwText))
        // 가입 버튼 클릭  설정
        upbutton.setOnClickListener {
            if (areFields()) {
                UserDatabase.addUser(
                    nameText.text.toString(),
                    idText.text.toString(),
                    pwText.text.toString()
                )
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
            }
        }
        upnamecheck.setOnClickListener {
            val tempUser = UserDatabase.findUserByName(nameText.text.toString())
            if (!upnamecheck.text.toString().trim()
                    .isEmpty() && tempUser?.name != nameText.text.toString() && upbutton.isEnabled
            ) {
                Toast.makeText(this, "사용 가능한 닉네임 입니다.", Toast.LENGTH_SHORT).show()
                upnamecheck.isEnabled = false
            } else {
                Toast.makeText(this, "잘못된 닉네임 입니다. 다시 적어 주세요", Toast.LENGTH_SHORT).show()
            }
        }

        upidcheck.setOnClickListener {
            val tempUser = UserDatabase.findUserById(idText.text.toString())
            if (!upidcheck.text.toString().trim()
                    .isEmpty() && tempUser?.id != idText.text.toString() && upbutton.isEnabled
            ) {
                Toast.makeText(this, "사용 가능한 아이디 입니다.", Toast.LENGTH_SHORT).show()
                upidcheck.isEnabled = false
            } else {
                Toast.makeText(this, "중복된 아이디 입니다. 다시 적어 주세요", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun areFields(): Boolean {
        val upname = findViewById<EditText>(R.id.up_name_edit)
        val upid = findViewById<EditText>(R.id.up_id_edit)
        val uppw = findViewById<EditText>(R.id.up_pw_edit)
        val name = upname.text.toString()
        val id = upid.text.toString()
        val pw = uppw.text.toString()
        if (name.isEmpty() || id.isEmpty() || pw.isEmpty()) {
            Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            return false
        } else if (upnamecheck.isEnabled || upidcheck.isEnabled) {
            Toast.makeText(this, "중복 체크를 확인해 주세요.", Toast.LENGTH_SHORT).show()
            return false
        }
        Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
        return true
    }

    private fun createNameTextWatcher(editText: EditText): TextWatcher {
        val nameErrorTextView = findViewById<TextView>(R.id.up_name_error_textview)
        val nameCorrectTextView = findViewById<TextView>(R.id.up_name_correct_textview)
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val name = s.toString()
                val englishText = name.replace(Regex("[^a-zA-Z ]"), "")
                if (!name.isEmpty() && name == englishText && name.length > 3) {
                    nameErrorTextView.visibility = View.INVISIBLE
                    nameCorrectTextView.visibility = View.VISIBLE
                    upbutton.isEnabled = true
                    upnamecheck.isEnabled = true
                } else if (name.isEmpty()) {
                    nameErrorTextView.visibility = View.INVISIBLE
                    nameCorrectTextView.visibility = View.INVISIBLE
                    upbutton.isEnabled = false
                } else {
                    nameErrorTextView.visibility = View.VISIBLE
                    nameCorrectTextView.visibility = View.INVISIBLE
                    upbutton.isEnabled = false
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        }
    }

    private fun createIdTextWatcher(editText: EditText): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val id = s.toString()
                val idText = id.replace(Regex("[^a-zA-Z]"), "",)
                val idText1 = id.replace(Regex("[^0-9]"), "")
                val idErrorTextView = findViewById<TextView>(R.id.up_id_error_textview)
                val idCorrectTextView = findViewById<TextView>(R.id.up_id_correct_textview)
                // 조건에 맞지 않을 때 메세지 출력
                if (!id.isEmpty() && idText != id && idText1 != id) {
                    idErrorTextView.visibility = View.INVISIBLE
                    idCorrectTextView.visibility = View.VISIBLE
                    upbutton.isEnabled = true
                    upnamecheck.isEnabled = true
                } else if (id.isEmpty()) {
                    idErrorTextView.visibility = View.INVISIBLE
                    idCorrectTextView.visibility = View.INVISIBLE
                    upbutton.isEnabled = false // 모든 조건이 충족될 때 버튼 비활성화
                } else {
                    idErrorTextView.visibility = View.VISIBLE
                    idCorrectTextView.visibility = View.INVISIBLE
                    upbutton.isEnabled = false
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }
    }

    private fun createPasswordTextWatcher(editText: EditText): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val password = s.toString()
                val hasSpecialChar = password.any { !it.isLetterOrDigit() }
                val englishText = password.replace(Regex("[^a-zA-Z ]"), "")
                var pwErrorTextView = findViewById<TextView>(R.id.up_pw_error_textview)
                val pwCorrectTextView = findViewById<TextView>(R.id.up_pw_correct_textview)
//                 메세지 출력
                if (!password.isEmpty() && (password.length > 2 && hasSpecialChar && password != englishText)) {
                    pwErrorTextView.visibility = View.INVISIBLE
                    pwCorrectTextView.visibility = View.VISIBLE
                    upbutton.isEnabled = true
                } else if (password.isEmpty()) {
                    pwErrorTextView.visibility = View.INVISIBLE
                    pwCorrectTextView.visibility = View.INVISIBLE
                    upbutton.isEnabled = false
                } else {
                    pwErrorTextView.visibility = View.VISIBLE
                    pwCorrectTextView.visibility = View.INVISIBLE
                    upbutton.isEnabled = false
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }
    }
}
