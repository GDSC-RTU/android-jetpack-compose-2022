package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    UnitConverterApp()
                }
            }
        }
    }
}

@Composable
fun UnitConverterApp() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "CM to M",
            modifier = Modifier.align(Alignment.Start),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
//        Spacer(modifier = Modifier.height(7.dp))
        var cmTom =  EditTextFieldCmToM()
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "M to CM",
            modifier = Modifier.align(Alignment.Start),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        var mTocm = EditTextFieldMToCm()

    }
}

@Composable
fun EditTextFieldCmToM( ) : Double{
    var field by remember {
        mutableStateOf("")
    }
    var value = field.toDoubleOrNull() ?: 0.0
    var convert = cmToM(value)

    OutlinedTextField(
        modifier = Modifier.background(color = Color.LightGray),
//        colors : TextFieldColors = TextFieldDefaults.textFieldColors(textColor = Color.black),
        value = field ,
        onValueChange = { field = it },
        label = { Text(text = stringResource(id = R.string.cm)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    Text(text = "$convert M")

    return convert;

}

private fun cmToM(amount: Double, ): Double {
    var convertCmToM = amount / 100
    return convertCmToM;
}


@Composable
fun EditTextFieldMToCm( ) : Double{
    var field by remember {
        mutableStateOf("")
    }
    var value = field.toDoubleOrNull() ?: 0.0
    var convert = mToCm(value)

    TextField(
//       TextFieldColors.textColor(enabled = Color.Black)
        modifier = Modifier.background(color = Color.LightGray),
        value = field ,
        onValueChange = { field = it },
        label = { Text(text = stringResource(id = R.string.m)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    Text(text = "$convert CM")

    return convert;

}

private fun mToCm(amount: Double, ): Double {
    var convertMToCm = amount * 100
    return convertMToCm;
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UnitConverterTheme {
        UnitConverterApp();
    }
}