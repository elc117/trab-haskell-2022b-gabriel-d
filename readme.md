### Gabriel Atarão Denardi
## **Programação Funcional – Geração de Imagens Vetoriais (SVG)** 
![Logo Haskell x Java](https://imgur.com/DB7Fo8W.png)

[Código em Haskell (Repl.it)](https://replit.com/@GabrielSVS/2022b-svg-Haskell) - [Código em Java (Repl.it)](https://replit.com/@GabrielSVS/2022b-svg-Java)
### 1. **Objetivo**
Foram desenvolvidos dois códigos equivalentes, um deles sendo em *Haskell*, e o outro, em *Java*. Estes geram uma imagem composta, aproveitando-se do formato SVG (*Scalable Vector Graphics*), onde contém diferentes elementos, que com o auxílio de geradores *pseudo*-aleatórios de números, alteram a saída do programa a cada execução. Por fim, estes serão comparados de modo a definir suas diferenças, e semelhanças.

### 2.1 **Descrição do código**
O código tem como objetivo simular um jogo de dardos simples, usando como entradas a quantidade de *aneis* (círculos) desejada, e a distância entre cada *anel* (tamanho de cada círculo). A partir disso, é criado o arquivo *SVG* com suas dimensões adequadas, gerado o alvo, e por fim, gerado o dardo, definido como um losango.
![Saídas Haskell e Java](https://imgur.com/nwqAdYA.png)
Os elementos pseudo-aleatórios são aplicados em **duas instâncias**: na *saída de cores* de cada círculo gerado, e na *posição* do losango. Para tal, foram importadas bibliotecas em seus respectivos códigos, permitindo usar um ou mais geradores de acordo com a necessidade, e estratégia usada nas linguagens.

### 2.2 **Execução**
As duas implementações estão hospedadas no ambiente Repl.it, onde poderão ser feitas as execuções dos mesmos. Como as variáveis de entrada estão fixas no código, para futuros testes/alterações, precisará ser feito um _**Fork**_ do repositório a ser alterado.
Porém, a execução em si, é simples, pois como na plataforma, o projeto permite a importação de bibliotecas extras, não foram necessárias instalações adicionais.
```
-- No shell, em Haskell:
$ ghci Main.hs
$ :l Main.hs
$ main
```
```
// No shell, em Java:
$ javac Main.java
$ java Main
```

### 3. **Comparativo**
Observando as duas implementações de uma maneira mais ampla, notei a diferença clara dos paradigmas imperativo e funcional envolvido. Porém, principalmente em Java, também notei os elementos de um paradigma funcional aplicados dentro de um código predominantemente imperativo.
```
-- Geração de círculos - Haskell
genCircles :: Int -> Int -> [Circle]
genCircles n size = [(n*size,n*size,m*size) | m <- [n,n-1..1]]
-- Chamada de função
circles = genCircles ncircles size
```
Primeiramente, considerando o código em *Haskell*, todo o problema é dividido em várias funções, que simplesmente são chamadas de acordo com a necessidade. Por consequência disso, na `main`, a ordenação das chamadas de funções diminui sua importância, onde por sua vez, se releva o que será feito, não exatamente como, pois este papel está designado nas funções.

Foram notadas algumas vantagens com relação ao código, e a este paradigma, que envolvem os testes e a manutenção, por exemplo. Como os testes de cada função implementada podem ser feitos separadamente, a importância da implementação era mais focada nas funções em si, definindo os tipos de argumentos recebidos como entrada, e logo depois seu retorno, com as devidas transformações. Considerando isso, a quantia de linhas no código diminui, deixando-o também mais legível.
```
// Geração de círculos - Java
for(int aux = ncircles;aux >= 1;aux--){
      circles.add(new Circle(ncircles*size,ncircles*size,aux*size));
    }
```
Posteriormente, no código em Java, a relevância da ordenação nos procedimentos da main se torna essencial, ditando como as coisas devem ser feitas. Estas características são vistas no uso de `for`, e `try/catch`, por exemplo, que aplicam o controle de fluxo no código que foi implementado.
```
// Escrita de círculos em arquivo SVG - Java
for(Circle c : circles){
        escritaArq.write(c.svgCircle() + c.svgFillRgb(gen));
      }
```
Todavia, a função forEach implementada, tem um “*estilo*” funcional, pois a própria linguagem trata o iterador, fazendo com que a preocupação seja como o trecho de código se comporta, ainda que o laço precise ser escrito.


### 4. **Conclusão**
Depois de observadas as diferenças e semelhanças, concluí que não existe realmente um paradigma (dentre os citados na comparação) completamente superior, ou inferior ao outro, pela quantidade de possíveis soluções para diferentes problemas.
Como um adendo final, minhas dificuldades na implementação foram especialmente em Haskell, nos tipos das variáveis *I/O* envolvendo a biblioteca `System.random`, onde a grande maioria das funções retornava um valor do tipo citado, conceito que não compreendi por completo.

### 5. **Links**
* Haskell:
[SVG(W3Schools)](https://www.w3schools.com/graphics/svg_intro.asp)

[Documentação System.random](https://hackage.haskell.org/package/random-1.2.1.1)

[Random numbers in Haskell](https://www.schoolofhaskell.com/school/starting-with-haskell/libraries-and-frameworks/randoms)

* Java:

[Bibliotecas SVG em JS - Willian Justen](https://willianjusten.com.br/manipulando-svg-com-js)

[Manipulação de arquivos em Java](https://www.w3schools.com/java/java_files.asp)

* Comparativo:

[OOP vs Funcional - Lissa Ferreira](https://dev.to/feministech/qual-e-a-diferenca-entre-programacao-orientada-a-objetos-e-funcional-347e)

[Imperativa vs Funcional - Celso Junior](https://pt.linkedin.com/pulse/programação-imperativa-vs-funcional-celso-junior)

[Prog. Funcional - DevMedia (exemplos for/forEach)](https://www.devmedia.com.br/programacao-funcional-codigo-limpo-e-padroes-de-projeto/32902)
