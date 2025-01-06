package eu.epfc.moviequotes.data

import eu.epfc.moviequotes.R

object DataSource {
    fun loadMovieQuotes(): List<MovieQuote> {
        return listOf<MovieQuote>(
            MovieQuote(R.string.movie1, R.drawable.image1),
            MovieQuote(R.string.movie2, R.drawable.image2),
            MovieQuote(R.string.movie3, R.drawable.image3),
            MovieQuote(R.string.movie4, R.drawable.image4),
            MovieQuote(R.string.movie5, R.drawable.image5),
            MovieQuote(R.string.movie6, R.drawable.image6),
            MovieQuote(R.string.movie7, R.drawable.image7),
            MovieQuote(R.string.movie8, R.drawable.image8),
            MovieQuote(R.string.movie9, R.drawable.image9),
            MovieQuote(R.string.movie10, R.drawable.image10)
        )
    }
}