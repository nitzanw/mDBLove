package com.example.mdblove.utils

import android.util.Log

object Logger {


    private val LOGGING_ENABLED: Boolean = true

    private val STACK_TRACE_LEVELS_UP = 5

    /**
     * Get the current line number. Note, this will only work as called from
     * this class as it has to go a predetermined number of steps up the stack
     * trace. In this case 5.
     *
     * @author kvarela
     * @return int - Current line number.
     */
    private val lineNumber: Int
        get() = Thread.currentThread().stackTrace[STACK_TRACE_LEVELS_UP].lineNumber

    /**
     * Get the current class name. Note, this will only work as called from this
     * class as it has to go a predetermined number of steps up the stack trace.
     * In this case 5.
     *
     * @author kvarela
     * @return String - Current line number.
     */
    private val className: String
        get() {
            val fileName = Thread.currentThread().stackTrace[STACK_TRACE_LEVELS_UP].fileName
            return fileName!!.substring(0, fileName.length - 5)
        }

    /**
     * Get the current method name. Note, this will only work as called from
     * this class as it has to go a predetermined number of steps up the stack
     * trace. In this case 5.
     *
     * @author kvarela
     * @return String - Current line number.
     */
    private val methodName: String
        get() = Thread.currentThread().stackTrace[STACK_TRACE_LEVELS_UP].methodName

    /**
     * Returns the class name, method name, and line number from the currently
     * executing log call in the form .()-
     *
     * @author kvarela
     * @return String - String representing class name, method name, and line
     * number.
     */
    private val classNameMethodNameAndLineNumber: String
        get() = "[$className.$methodName()-$lineNumber]: "

    fun verbose(tag: String, message: String) {
        if (LOGGING_ENABLED) {
            Log.v(tag, classNameMethodNameAndLineNumber + message)
        }
    }
}