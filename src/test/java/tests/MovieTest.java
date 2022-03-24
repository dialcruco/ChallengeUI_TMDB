package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import org.apache.logging.log4j.*;


public class MovieTest extends Hooks {

    private String movieToSearch = "Fight Club";

    private static Logger loggerMovieTest = LogManager.getLogger(MovieTest.class);

    /**
     * (Test description)
     */
    @Test
    public void successfulSearch(){
        loggerMovieTest.info("Test: Successful search of the movie: " + movieToSearch);
        LandingPage landingPageSearch = new LandingPage(getDriver());
        landingPageSearch.searchQuery(movieToSearch);

        ResultsPage resultsPageSearch = landingPageSearch.searchButtonClick();

        Assert.assertEquals(resultsPageSearch.getMovieName(), movieToSearch);


    }
    /**
     * (Test description)
     */
    @Test
    public void verifyMovieGenreFilter(){
        loggerMovieTest.info("Test: Verify the Action Movies Filter.");
        LandingPage landingPageGenreFilter = new LandingPage(getDriver());
        ResultsPage resultsPageFilter = landingPageGenreFilter.clickOnTopRatedMovies()
                .selectActionGenre()
                .waitForSearchButtonAppears()
                .clickOnSearch()
                .waitForNewResults("Action");

        MoviePage movieInfo = resultsPageFilter.selectMovieFromSearch("The Dark Knight");

        String tempVerify = movieInfo.getMovieGenre();
        Assert.assertTrue(tempVerify.contains("Action"));
    }

    @Test
    public void validateActingTimeline(){
        loggerMovieTest.info("Test: Validating an actor appears on a movie selected.");

        String movie = "Gold";
        String actor = "Susie Porter";

        LandingPage landingPageActingTimeline = new LandingPage(getDriver());

        ResultsPage resultsPageValidate = landingPageActingTimeline.clickOnNowPlayingMovies();
        MoviePage movieSelectedValidate = resultsPageValidate.selectMovieFromSearch(movie);
        ActorPage actorSelectedValidate = movieSelectedValidate.selectActor(actor);

        String genres = actorSelectedValidate.getMovieFromActor();
        Assert.assertTrue(genres.contains(movie));


    }
    @Test
    public void sortByDatesOnAscendingOrder(){
        loggerMovieTest.info("Test: Verifying movies ascending sorting by date.");
        LandingPage landingPageSorting = new LandingPage(getDriver());
        ResultsPage resultsPageSorting = landingPageSorting.clickOnTopRatedMovies();

         resultsPageSorting.selectSortAndSearch()
                 .waitForNewResults("Release Date Ascending");

        Assert.assertTrue(resultsPageSorting.verifyAscendingOrder(4));
    }
}
