package steps;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.SofascorePage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class SofascoreSteps {

    private SofascorePage sofascorePage;

    @Before
    public void setUp() throws URISyntaxException, MalformedURLException {
        DriverManager.setUp();
        sofascorePage = new SofascorePage(DriverManager.getDriver());
    }

    @After
    public void tearDown() {
        DriverManager.tearDown();
    }

    @Dado("que o aplicativo Sofascore está aberto")
    public void abrirApp() {
        sofascorePage.clickGetStarted();
    }

    @Quando("eu pesquiso por {string}")
    public void pesquisarTime(String time) {
        sofascorePage.searchForTeam(time);
        sofascorePage.selectFirstTeamFromResults(time);
        sofascorePage.handleOnboardingPopups();
    }

    @Entao("o time {string} deve ser marcado como favorito")
    public void verificarFavorito(String time) {
        sofascorePage.navigateToFavoritesTab();
        sofascorePage.verifyFavorite(time);
    }
}