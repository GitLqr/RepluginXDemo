package com.gitlqr.repluginx.host

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.qihoo360.replugin.RePlugin
import com.qihoo360.replugin.RePluginConfig

class MyApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        RePlugin.App.attachBaseContext(this, createConfig())
    }

    override fun onCreate() {
        super.onCreate()
        RePlugin.App.onCreate()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        RePlugin.App.onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        RePlugin.App.onTrimMemory(level)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        RePlugin.App.onConfigurationChanged(newConfig)
    }

    private fun createConfig(): RePluginConfig {
        val config = RePluginConfig()

        // 允许“插件使用宿主类”。默认为“关闭”
        config.isUseHostClassIfNotFound = true

        // FIXME RePlugin默认会对安装的外置插件进行签名校验，这里先关掉，避免调试时出现签名错误
        // config.verifySign = false

        // 针对“安装失败”等情况来做进一步的事件处理
        // config.eventCallbacks = HostEventCallbacks(this)

        // 在Art上，优化第一次loadDex的速度
        // config.isOptimizeArtLoadDex = true

        return config
    }
}