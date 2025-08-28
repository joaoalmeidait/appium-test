package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import sofascore.SofascoreConfig;

public class SofascoreSteps {

    private SofascoreConfig appiumTest;

    @Before
    public void setUp() throws Exception {
        appiumTest = new SofascoreConfig();
        appiumTest.setUp();
    }

    @After
    public void tearDown() {
        appiumTest.tearDown();
    }

    @Dado("que o aplicativo Sofascore está aberto")
    public void abrirApp() {
        appiumTest.clickGetStarted();
    }

    @Quando("eu pesquiso por {string}")
    public void pesquisarTime(String time) {
        appiumTest.searchForTeam(time);
    }

    @Entao("o time {string} deve ser marcado como favorito")
    public void verificarFavorito(String time) {
        appiumTest.verifyFavorite(time);
    }
}