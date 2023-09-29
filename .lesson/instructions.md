# AT 5 - Aplicação para Investimentos em Renda Fixa 

O objetivo deste projeto é desenvolver uma aplicação para investimentos em renda fixa. Sendo assim, teremos uma superclasse chamada **RendaFixa** com os seguintes atributos:

- **Nome**
- **CPF**
- **Banco**

Além disso, haverá classes filhas chamadas **CDB**, **LCI**, **LCA** e **Poupança**. Cada uma dessas classes filhas terá um atributo chamado **juros**, com os seguintes valores:

- **CDB**: 120% CDI
- **LCI**: 100% CDI
- **LCA**: 105% CDI
- **Poupança**: 0,5% a.m (não considerando a TR)

A ideia é que o usuário forneça o valor a ser investido em R$, o tempo em meses e a taxa SELIC do ano. Em seguida, o programa informará o resultado dependendo do valor da taxa SELIC informada (Sugestão: 13% e 6%). Ao término do cálculo, os resultados serão escritos em um arquivo de texto com o nome do título do investimento.

**Este programa deve conter obrigatoriamente:**

1. **Encapsulamento;**
2. **Abstração;**
3. **Classe final;**
4. **Interface;**
5. **Tratamento de erro;**

*Nota:* Não esqueça que o CDB tem IR variável de acordo com o tempo de investimento.

*Lembre-se* que o rendimento da poupança é de 0,5% a.m quando a SELIC >= 8,5%. Caso contrário, rende 70% da SELIC.
