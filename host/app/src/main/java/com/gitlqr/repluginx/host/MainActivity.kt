package com.gitlqr.repluginx.host

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.qihoo360.replugin.RePlugin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnStart).setOnClickListener {

            val pluginName = "plugin"
            val pluginInfo = RePlugin.getPluginInfo(pluginName)
            if (pluginInfo == null) {
                Toast.makeText(this, "插件${pluginName}未安装", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = RePlugin.createIntent(
                "plugin",
                "com.gitlqr.repluginx.plugin.MainActivity"
            )
            RePlugin.startActivity(this, intent)
        }
    }
}