package eu.epfc.moviequotes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.epfc.moviequotes.R
import eu.epfc.moviequotes.data.MovieQuote


@Composable
fun MovieQuoteList(
    movieQuoteList: List<MovieQuote>,
    showText: Boolean,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(movieQuoteList) { movieQuote ->
            MovieQuoteCard(
                movieQuote = movieQuote,
                showText = showText,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun MovieQuoteCard(
    movieQuote: MovieQuote,
    showText: Boolean,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier
    ){
        Image(
            painter = painterResource(movieQuote.imageResourceId),
            contentDescription = null
        )
        if (showText) {
            Text(
                text = stringResource(movieQuote.stringResourceId),
                modifier = modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)

            )
        }
    }

}

@Preview
@Composable
private fun MovieQuoteCardPreview() {
    MovieQuoteCard(
        movieQuote = MovieQuote(R.string.movie1, R.drawable.image1),
        showText = true,
        modifier = Modifier.padding(8.dp)
    )
}