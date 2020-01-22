package io.appshell.shell.web

import io.appshell.bridge.WebViewBridge

interface WebDelegate<T> {

    fun onCreateBridge(context: T): WebViewBridge

}