## **Curso:** *MBA Full Stack Developer -  Automated Software Testing*
#### **Prof:** 
- *Joao Henrique Victorino da Silva*
#### **Alunos:** 
- *Alexandre Ferraz Arrichiello*
- *Flavia Ettiuya*
- *Lucas dos Santos Batista*
- *Natalia de Jesus Silva*
- *Natalia Fernanda Milani de Moraes*
- *Vanessa Alencar Cardoso Martins*

---------------------------------------------------------
#### Informações do projeto:

Projeto referente a atividade da matéria de Automated Software Testing, para realizar testes usando framework RestAssured numa API pública.

**API:** https://viacep.com.br/ws/<CEP>/json

  **Exemplo de uso da API:** https://viacep.com.br/ws/04279030/json
  
**Classe de test:** CepTest.java 
  
**Cenários de testes:**
  - Status OK (200)
  - Status BAD REQUEST (400)
  - Retorno dos valores no response body
  - Se Content Type é do tipo Json e utf-8
  - Validação do contrato da API
  - Se informar CEP inválido, validar mensagem de erro no response body
