package uz.gita.tzhotel.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import uz.gita.tzhotel.R

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        color = Color.Black,
        fontSize = 22.sp,
        fontFamily = FontFamily(Font(R.font.sfprodisplaymedium)),
        fontWeight = FontWeight.W500,
        lineHeight = 26.4.sp
    ),
    displayMedium = TextStyle(
        color = BlueJasmine,
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.sfprodisplayregular)),
        fontWeight = FontWeight.W400,
        lineHeight = 19.2.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)