package io.appshell.shell.web

import android.os.Bundle
import io.appshell.bridge.WebViewBridge
import io.appshell.bridge.addAppShellBridge
import io.appshell.shell.AppShellActivity
import io.appshell.shell.R
import kotlinx.android.synthetic.main.webview.*

open class WebActivity : AppShellActivity() {

    protected var delegate: WebDelegate<WebActivity>? = null
    protected val contentResource: Int get() = R.layout.webview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentResource)

        val delegate = this.delegate ?: Delegate()
        val bridge = delegate.onCreateBridge(this)
        webView.addAppShellBridge(bridge)
    }

    inner class Delegate : WebDelegate<WebActivity> {
        override fun onCreateBridge(context: WebActivity): WebViewBridge {
            return WebViewBridge(webView)
        }
    }

}