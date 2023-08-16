package com.example.netcha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sigin_up)
        val etName : EditText = findViewById(R.id.up_name_edit)
        val etId : EditText = findViewById(R.id.up_id_edit)
        val etPw : EditText = findViewById(R.id.up_pw_edit)
        val btnJoinMember : Button = findViewById(R.id.up_button)

        btnJoinMember.setOnClickListener {
            UserDatabase.addUser(etName.text.toString(), etId.text.toString(), etPw.text.toString())
        }

// 사용자 찾기
        val findName  = UserDatabase.findUserByName("여기 사용자 찾는 이름 입력란")
        val findId = UserDatabase.findUserById("여기 사용자 찾는 아이디 입력란")

        findName.let{
            Toast.makeText(this, "찾으시는 아이디는 ${it?.id} 입니다.", Toast.LENGTH_SHORT).show()
        }

        findId.let{
            Toast.makeText(this, "찾으시는 비밀번호는 ${it?.pw} 입니다.", Toast.LENGTH_SHORT).show()
        }

// 사용자 지우기
        UserDatabase.removeUser(etId.text.toString())

        val upbtn = findViewById<Button>(R.id.up_button)
        val name = findViewById<EditText>(R.id.up_name_edit)

        upbtn.setOnClickListener {
            if (areFields()) {
                val intent = Intent(this, SignInActivity::class.java)  // Update the target activity
                intent.putExtra("Name", name.text.toString())
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
}