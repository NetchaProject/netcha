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
        // 이름 텍스트 변경 textwatcher
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
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val text = s.toString()
                // 이름이 비어있으면 가입 버튼 비활성화
                upbutton.isEnabled = text.isNotEmpty()
                if (text.isEmpty()) {
                    val hintText = editText.hint.toString()
                    // 이름이 비어있을 때 힌트 메시지 토스트 표시
                    Toast.makeText(this@SignUpActivity, "${hintText}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun createIdTextWatcher(editText: EditText): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val text = s.toString()
//                val isEnglishAndDigits = text.matches(Regex("^[a-zA-Z0-9]*$"))
                val threeOrMore = text.length >= 3
                // 아이디가 영어와 숫자로 이루어져 있으며 최소 3자 이상이면 가입 버튼 활성화
                upbutton.isEnabled = threeOrMore
                // 아이디 체크 버튼 클릭 리스너 설정
                upidcheck.setOnClickListener {
                    if (text.isEmpty()) {
                        val hintText = editText.hint.toString()
                        // 아이디 입력이 비어있을 때 힌트 메시지 토스트 표시
                        Toast.makeText(
                            this@SignUpActivity, "$hintText 입력해주세요.", Toast.LENGTH_SHORT
                        ).show()
                    } else if (!threeOrMore) {
                        // 아이디가 최소 3자 이상이 아닐 때 에러 메시지 토스트 표시
                        Toast.makeText(
                            this@SignUpActivity,
                            "아이디는 최소 3자 이상이어야 합니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (true) {
                        // 아이디가 조건에 맞을 때 메시지 토스트 표시
                        Toast.makeText(this@SignUpActivity, "아이디가 적합합니다.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }
    private fun createPasswordTextWatcher(editText: EditText): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val password = s.toString()
                val hasSpecialChar = password.any { !it.isLetterOrDigit() }
                var errorTextView = findViewById<TextView>(R.id.up_pw_error_textview)
                // 메세지 출력
                if (!password.isEmpty() && (password.length < 3 || !hasSpecialChar)) {
                    errorTextView.visibility = View.VISIBLE
                } else {
                    errorTextView.visibility = View.INVISIBLE
                }
                // 비밀번호가 조건에 맞을 때만 가입 버튼 활성화
                upbutton.isEnabled = password.length >= 3 && hasSpecialChar }
            override fun afterTextChanged(s: Editable?) {}
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