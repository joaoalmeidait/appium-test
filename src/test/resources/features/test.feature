Feature: Teste de busca de time no Sofascore

  Scenario Outline: Buscar e favoritar o time
    Given que o aplicativo Sofascore está aberto
    When eu pesquiso por "<time>"
    Then o time "<time>" deve ser marcado como favorito

    Examples:
      | time     |
      | Flamengo |
 ##     | Real Madrid |
##      | Manchester United |