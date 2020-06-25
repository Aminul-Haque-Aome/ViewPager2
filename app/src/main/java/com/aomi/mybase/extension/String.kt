package com.aomi.mybase.extension

import android.graphics.Color
import android.graphics.Typeface
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan

fun String.commaReplaceWithNewLine() = replace(", ", ",\n")

fun String.commaReplaceWithBulletCharacter() = replace(",", "  \u00B7  ")

fun String.ellipsize(limit: Int) = if (length > limit) substring(0, limit) + "..." else this

fun String.removeStartingComma() = if (startsWith(",")) substring(1) else this

fun String.removeLastComma() = if (endsWith(",")) substring(0, length - 1) else this

fun String.concat(string: String?) = "$this $string"

fun String.getStringList(): List<String> {
    return split(", ")
}

fun List<String>.separateItemWithComma() = joinToString { it }

fun isNullOrEmpty(vararg fields: String?): Boolean {
    for (field in fields) {
        if (field == null || field.isEmpty()) {
            return true
        }
    }
    return false
}

fun SpannableString.bold(start: Int, end: Int): SpannableString {
    setSpan(StyleSpan(Typeface.BOLD), start, end, 0)
    return this
}
fun SpannableString.bold(): SpannableString {
    setSpan(StyleSpan(Typeface.BOLD), 0, length, 0)
    return this
}

fun SpannableString.underline(start: Int, end: Int): SpannableString {
    setSpan(UnderlineSpan(), start, end, 0)
    return this
}
fun SpannableString.underline(): SpannableString {
    setSpan(UnderlineSpan(), 0, length, 0)
    return this
}

fun SpannableString.italic(start: Int, end: Int): SpannableString {
    setSpan(StyleSpan(Typeface.ITALIC), start, end, 0)
    return this
}
fun SpannableString.italic(): SpannableString {
    setSpan(StyleSpan(Typeface.ITALIC), 0, length, 0)
    return this
}

fun SpannableString.strike(start: Int, end: Int): SpannableString {
    setSpan(StrikethroughSpan(), start, end, 0)
    return this
}
fun SpannableString.strike(): SpannableString {
    setSpan(StrikethroughSpan(), 0, length, 0)
    return this
}

fun SpannableString.color(color: String, start: Int, end: Int): SpannableString {
    setSpan(ForegroundColorSpan(Color.parseColor(color)), start, end, 0)
    return this
}

fun SpannableString.color(color: String): SpannableString {
    setSpan(ForegroundColorSpan(Color.parseColor(color)), 0, length, 0)
    return this
}