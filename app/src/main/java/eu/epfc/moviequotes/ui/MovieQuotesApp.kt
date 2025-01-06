package eu.epfc.moviequotes.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.List
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.epfc.moviequotes.R
import eu.epfc.moviequotes.data.DataSource
import eu.epfc.moviequotes.ui.screens.MovieQuoteList
import eu.epfc.moviequotes.ui.theme.MovieQuotesTheme

@Composable
fun MovieQuotesApp(modifier: Modifier = Modifier) {

    var movieQuoteList by remember { mutableStateOf(DataSource.loadMovieQuotes()) }
    var showText by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            MovieQuoteAppBar(
                showText = showText,
                onClickEditButton = { showText = !showText}
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {movieQuoteList = movieQuoteList.reversed()}) {
                Icon(Icons.AutoMirrored.Sharp.List, contentDescription = "Sort")
            }
        }

    ) { contentPadding ->

        MovieQuoteList(
            movieQuoteList = movieQuoteList,
            showText = showText,
            modifier = modifier
                .padding(contentPadding)
                .fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieQuoteAppBar(
    showText: Boolean,
    onClickEditButton: () -> Unit,
    modifier: Modifier = Modifier
) {

    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.movie_icon),
                    contentDescription = null,
                    Modifier.size(32.dp)
                )
                Text(
                    text = stringResource(R.string.app_name),
                    modifier = Modifier
                )
            }
        },
        actions = {
            IconButton(
                onClick = onClickEditButton
            ) {
                Icon(
                    imageVector = if (showText) Icons.Filled.Edit  else Icons.Outlined.Edit,
                    contentDescription = "Edit button"
                )
            }
        }
    )
}




@Preview
@Composable
private fun MovieQuoteAppBarPreview() {
    MovieQuoteAppBar(
        showText = true,
        onClickEditButton = {}
    )
}


@Preview(showBackground = true)
@Composable
private fun MovieQuotesAppPreview() {
    MovieQuotesTheme {
        MovieQuotesApp()
    }
}
