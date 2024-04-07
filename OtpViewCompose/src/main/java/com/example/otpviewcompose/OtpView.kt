package com.example.otpviewcompose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun OtpView(
    otpText: String,
    otpCount: Int = 4,
    shouldFocusFirst: Boolean = false,
    modifier: Modifier = Modifier,
    paddingHorizontal : Dp = 4.dp,
    paddingInside : Dp = 4.dp,
    borderWidth: Dp = 1.dp,
    borderFocusedColor : Color = Color.Blue,
    borderNormalColor : Color = Color.LightGray,
    textColor : Color = Color.Blue,
    textStyle: TextStyle = MaterialTheme.typography.headlineMedium,
    borderShape: Shape = MaterialTheme.shapes.medium,
    onOtpTextChange: (String, Boolean) -> Unit

) {

    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        if (otpText.length > otpCount) {
            throw IllegalArgumentException("Otp text value must not have more than otpCount: $otpCount characters")
        }

        if (shouldFocusFirst) {
            focusRequester.requestFocus()
        }
    }


    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester),
        singleLine = true,
        value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
        onValueChange = {
            if (it.text.length <= otpCount) {
                onOtpTextChange.invoke(it.text, it.text.length == otpCount)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(paddingHorizontal)
            ) {

                repeat(otpCount) { index ->

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(paddingInside)
                    ) {
                        CharView(
                            index = index,
                            text = otpText,
                            borderWidth,
                            borderFocusedColor,
                            borderNormalColor,
                            textColor,
                            textStyle,
                            borderShape
                        )
                    }


                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String,
    borderWidth: Dp,
    borderFocusedColor : Color,
    borderNormalColor : Color,
    textColor : Color,
    textStyle : TextStyle,
    borderShape: Shape
) {
    val isFocused = text.length == index
    val char = when {
        index >= text.length -> ""
        else -> text[index].toString()
    }

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .border(
                borderWidth, when {
                    isFocused -> borderFocusedColor
                    else -> borderNormalColor
                }, borderShape
            ),
        contentAlignment = Alignment.Center
    ) {

        Text(
            textAlign = TextAlign.Center,
            text = char,
            style = textStyle,
            color = textColor
        )

    }


}