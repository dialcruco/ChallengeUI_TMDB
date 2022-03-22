package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class MovieTest extends Hooks {

    @Test
    public void successfulSearch(){
        //Log: ejecutando metodo de busqueda.
        LandingPage landingPageSearch = new LandingPage(getDriver());
        landingPageSearch.searchQuery("Fight Club");

        ResultsPage resultsPageSearch = landingPageSearch.searchButtonClick();

        //Log: "Verificando successful search": info de la pelicula Fight Club.
        Assert.assertEquals(resultsPageSearch.getMovieName(),"Fight Club");

    }
    @Test
    public void verifyMovieGenreFilter(){
        LandingPage landingPageGenreFilter = new LandingPage(getDriver());
        ResultsPage resultsPageFilter = landingPageGenreFilter.clickOnTopRatedMovies()
                .selectActionFilter()
                .waitForSearchButtonAppears()
                .clickOnSearch()
                .waitForNewResults();

        MoviePage movieInfo = resultsPageFilter.selectMovieFromSearch("Bring the Soul: The Movie");

        String tempVerify = movieInfo.getMovieGenre();
        Assert.assertTrue(tempVerify.contains("Action"));
    }

    @Test
    public void validateActingTimeline(){

        LandingPage landingPageActingTimeline = new LandingPage(getDriver());

        ResultsPage resultsPageValidate = landingPageActingTimeline.clickOnNowPlayingMovies();
        MoviePage movieSelectedValidate = resultsPageValidate.selectMovieToValidate();
        ActorPage actorSelectedValidate = movieSelectedValidate.selectActor();

        String tempValidate = actorSelectedValidate.getMovieFromActor();
        Assert.assertTrue(tempValidate.contains("Blacklight"));


    }
    @Test
    public void sortByDatesOnAscendingOrder(){
        LandingPage landingPageSorting = new LandingPage(getDriver());
        ResultsPage resultsPageSorting = landingPageSorting.clickOnTopRatedMovies();

         resultsPageSorting.selectSortAndSearch()
                 .waitForResults()
                 .verifyAscendingOrder(); //No está haciendo la espera y por ende guarda la misma página sin los filtros.

        //Assert.assertEquals(resultsPageSorting.getPopMovie1(),"Passage of Venus");


    }
}
