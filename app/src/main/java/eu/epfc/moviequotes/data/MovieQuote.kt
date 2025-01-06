package eu.epfc.moviequotes.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MovieQuote(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
