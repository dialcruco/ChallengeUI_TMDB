package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class MovieTest extends Hooks {

    /**
     * (Test description)
     */
    @Test
    public void successfulSearch(){
        //Log: ejecutando metodo de busqueda.
        LandingPage landingPageSearch = new LandingPage(getDriver());
        landingPageSearch.searchQuery("Fight Club");

        ResultsPage resultsPageSearch = landingPageSearch.searchButtonClick();

        //Log: "Verificando successful search": info de la pelicula Fight Club.
        Assert.assertEquals(resultsPageSearch.getMovieName(),"Fight Club");

    }
    /**
     * (Test description)
     */
    @Test
    public void verifyMovieGenreFilter(){

        LandingPage landingPageGenreFilter = new LandingPage(getDriver());
        ResultsPage resultsPageFilter = landingPageGenreFilter.clickOnTopRatedMovies()
                .selectActionFilter()
                .waitForSearchButtonAppears()
                .clickOnSearch()
                .waitForNewResults();

        MoviePage movieInfo = resultsPageFilter.selectMovieFromSearch("The Dark Knight");

        String tempVerify = movieInfo.getMovieGenre();
        Assert.assertTrue(tempVerify.contains("Action"));
    }

    @Test
    public void validateActingTimeline(){
        String movie = "Gold";
        String actor = "Susie Porter";

        LandingPage landingPageActingTimeline = new LandingPage(getDriver());

        ResultsPage resultsPageValidate = landingPageActingTimeline.clickOnNowPlayingMovies();
        MoviePage movieSelectedValidate = resultsPageValidate.selectMovieFromSearch(movie);
        ActorPage actorSelectedValidate = movieSelectedValidate.selectActor(actor);

        String tempValidate = actorSelectedValidate.getMovieFromActor();
        Assert.assertTrue(tempValidate.contains(movie));


    }
    @Test
    public void sortByDatesOnAscendingOrder(){
        LandingPage landingPageSorting = new LandingPage(getDriver());
        ResultsPage resultsPageSorting = landingPageSorting.clickOnTopRatedMovies();

         resultsPageSorting.selectSortAndSearch()
                 .waitForNewResults();

        Assert.assertTrue(resultsPageSorting.verifyAscendingOrder(4));
    }
}
