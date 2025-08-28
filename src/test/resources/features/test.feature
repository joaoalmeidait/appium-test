Feature: Teste de busca de time no Sofascore

  Scenario: Buscar e favoritar o time Flamengo
    Given que o aplicativo Sofascore está aberto
    When eu pesquiso por "Flamengo"
    Then o time "Flamengo" deve ser marcado como favorito