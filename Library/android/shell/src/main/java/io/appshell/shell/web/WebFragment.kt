package io.appshell.shell.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.appshell.bridge.WebViewBridge
import io.appshell.shell.AppShellFragment
import io.appshell.shell.R
import kotlinx.android.synthetic.main.layout_webview.*

open class WebFragment : AppShellFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.layout_webview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    fun onCreateBridge(): WebViewBridge {
        
    }
}