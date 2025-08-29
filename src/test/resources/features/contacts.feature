Feature: Contatos

  Scenario Outline: Adicionar novo contato
    Given que o aplicativo Contatos está aberto
    When adiciono um novo contato com nome "<nome>" e telefone "<telefone>"
    And salvo o contato
    Then o contato com nome "<nome>" deve ser encontrado na lista de contatos
    Examples:
      | nome        | telefone     |
      | João Silva  | 1234567890   |
  ##    | Maria Souza | 0987654321   |
  ##    | Pedro Lima  | 1122334455   |