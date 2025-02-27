/*
 * Copyright (c) 2022. Stefanus Ayudha.
 */
package com.singularity_code.core.common.util.activity

import android.app.Activity
import androidx.activity.ComponentActivity
import com.singularity_code.core.common.util.gson.JsonConvertAble

interface ActivityResultEmitter<O : JsonConvertAble> {
    enum class KEY {
        PAYLOAD,
        RESULT
    }

    fun Activity.activityReturnOK(data: O) {
        intent.putExtra(KEY.RESULT.name, data.toStringJSON())
        setResult(ComponentActivity.RESULT_OK, intent)
        finish()
    }

    fun Activity.activityReturnCancel() {
        setResult(ComponentActivity.RESULT_CANCELED)
        finish()
    }
}