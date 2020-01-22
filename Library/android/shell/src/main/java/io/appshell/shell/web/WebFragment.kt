package io.appshell.shell.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.appshell.bridge.WebViewBridge
import io.appshell.bridge.addAppShellBridge
import io.appshell.shell.AppShellFragment
import io.appshell.shell.R
import kotlinx.android.synthetic.main.webview.*

open class WebFragment : AppShellFragment() {

    protected var delegate: WebDelegate<WebFragment>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.webview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val delegate = this.delegate ?: Delegate()
        val bridge = delegate.onCreateBridge(this)
        webView.addAppShellBridge(bridge)
    }

    inner class Delegate : WebDelegate<WebFragment> {
        override fun onCreateBridge(context: WebFragment): WebViewBridge {
            return WebViewBridge(webView)
        }
    }

}