package com.copytexttoclipboard

import android.content.ClipData
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.copytexttoclipboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var clipboardManager: ClipboardManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
        initializeClickListener()
    }

    private fun initializeClickListener() {
        val clipData = ClipData.newPlainText("label",binding.tvCode.text.toString())
        clipboardManager.setPrimaryClip(clipData)
        binding.btCopyCode.setOnClickListener {
            Toast.makeText(this,"code copied to clipboard " + clipboardManager.primaryClip?.getItemAt(0)?.text,Toast.LENGTH_SHORT).show()
        }
    }

    private fun initialize() {
        clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
    }
}