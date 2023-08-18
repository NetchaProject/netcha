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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sigin_up)

        // XML에서 레이아웃 요소들과 연결
        nameText = findViewById(R.id.up_name_edit)
        idText = findViewById(R.id.up_id_edit)
        pwText = findViewById(R.id.up_pw_edit)
        upbutton = findViewById(R.id.up_button)
        upidcheck = findViewById(R.id.up_id_check)

        // 닉네임 텍스트 변경 textwatcher
        nameText.addTextChangedListener(createNameTextWatcher(nameText))

        // 아이디 텍스트 변경 textwatcher
        idText.addTextChangedListener(createIdTextWatcher(idText))

        // 비밀번호 텍스트 변경 textwatcher
        pwText.addTextChangedListener(createPasswordTextWatcher(pwText))

        // 가입 버튼 클릭  설정
        upbutton.setOnClickListener {
            if (areFields()) {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
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

                if (!name.isEmpty() && name != englishText) {
                    nameErrorTextView.visibility = View.VISIBLE
                    nameCorrectTextView.visibility = View.INVISIBLE
                    upbutton.isEnabled = false // 이름에 영어 이외의 문자가 있을 때 버튼 비활성화
                } else if (name.isEmpty()) {
                    nameErrorTextView.visibility = View.INVISIBLE
                    nameCorrectTextView.visibility = View.INVISIBLE
                    upbutton.isEnabled = false // 모든 조건이 충족될 때 버튼 비활성화
                } else {
                    nameErrorTextView.visibility = View.INVISIBLE
                    nameCorrectTextView.visibility = View.VISIBLE
                    upbutton.isEnabled = true // 모든 조건이 충족될 때 버튼 활성화
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
                } else if(id.isEmpty()){
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
                var pwErrorTextView = findViewById<TextView>(R.id.up_pw_error_textview)
                val pwCorrectTextView = findViewById<TextView>(R.id.up_pw_correct_textview)

                // 메세지 출력
                if (!password.isEmpty() && (password.length < 3 || !hasSpecialChar)) {
                    pwErrorTextView.visibility = View.VISIBLE
                    pwCorrectTextView.visibility = View.INVISIBLE
                    upbutton.isEnabled = false
                } else if(password.isEmpty()) {
                    pwErrorTextView.visibility = View.INVISIBLE
                    pwCorrectTextView.visibility = View.INVISIBLE
                    upbutton.isEnabled = false
                } else{
                    pwErrorTextView.visibility = View.INVISIBLE
                    pwCorrectTextView.visibility = View.VISIBLE
                    upbutton.isEnabled = true
                }
            }
             override fun afterTextChanged(s: Editable?) {
                }
            }
        }
    }


// 싱글톤!!
//        val etName : EditText = findViewById(R.id.up_name_edit)
//        val etId : EditText = findViewById(R.id.up_id_edit)
//        val etPw : EditText = findViewById(R.id.up_pw_edit)
//        val btnJoinMember : Button = findViewById(R.id.up_button)
//        btnJoinMember.setOnClickListener {
//            UserDatabase.addUser(etName.text.toString(), etId.text.toString(), etPw.text.toString())
//        }
// 사용자 찾기
//        val findName  = UserDatabase.findUserByName("여기 사용자 찾는 이름 입력란")
//        val findId = UserDatabase.findUserById("여기 사용자 찾는 아이디 입력란")
//        findName.let{
//            Toast.makeText(this, "찾으시는 아이디는 ${it?.id} 입니다.", Toast.LENGTH_SHORT).show()
//        }
//        findId.let{
//            Toast.makeText(this, "찾으시는 비밀번호는 ${it?.pw} 입니다.", Toast.LENGTH_SHORT).show()
//        }
// 사용자 지우기
//        UserDatabase.removeUser(etId.text.toString())
//        val upbtn = findViewById<Button>(R.id.up_button)
//        val name = findViewById<EditText>(R.id.up_name_edit)
//        upbtn.setOnClickListener {
//            if (areFields()) {
//                val intent = Intent(this, SignInActivity::class.java)  // Update the target activity
//                intent.putExtra("Name", name.text.toString())
//                startActivity(intent)
//                overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
//            }
//        }

