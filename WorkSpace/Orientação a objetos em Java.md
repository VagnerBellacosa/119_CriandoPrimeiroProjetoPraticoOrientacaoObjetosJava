

**[Java](https://www.treinaweb.com.br/blog/categoria/java)**

# Orientação a objetos em Java

É perceptível a vocação do Java para estruturas orientadas a objetos. Veremos um pouco mais sobre neste artigo.

 11 meses atrás

[Artigos](https://www.treinaweb.com.br/blog)Orientação a objetos em Java

O Java atualmente pode ser considerada uma linguagem multiparadigma, mas é perceptível a sua vocação para estruturas orientadas a objetos. O paradigma orientado a objetos traz boas vantagens, como a reutilização de código, a legibilidade e manutenibilidade do código, a natural modularização e a produção de código mais acessível, já que as estruturas criadas geralmente representam aspectos também existentes no mundo real.

Quando lidamos com o paradigma orientado a objetos, acabamos criando diversas unidades de software através de estruturas chamadas classes. A partir destas classes, podemos criar estruturas chamadas objetos, estruturas estas que interagem entre si. Esse é o motivo pelo qual o paradigma é chamado de orientação a objetos: todas as interações necessárias para que o software funcione ocorrem através de mensagens e comandos trocados entre estes objetos.

Caso você esteja iniciando e não conheça muita coisa sobre orientação a objetos, indico primeiramente a leitura do artigo [“Os pilares da orientação a objetos”](https://www.treinaweb.com.br/blog/os-pilares-da-orientacao-a-objetos/ ““Os pilares da orientação a objetos””).

### Classe

Quando falamos sobre orientação a objetos, as classes são uma das estruturas essenciais.

Uma classe funciona como um “molde” para definição de outras estruturas. Classes geralmente são compostas pelo agrupamento de atributos ou características, e métodos ou ações. Uma classe define agrupamentos de atributos e métodos que são correlacionados e podem ser reaproveitados.

Por exemplo, imagine que você precisa criar uma aplicação para fazer a gestão de uma frota de veículos. Nessa aplicação, com certeza será necessário manipular informações de carros. E todos os carros geralmente possuem um “molde” padrão com características e ações que são comuns a todos os carros.

Todos os carros, por exemplo, possuem características como:

• Modelo; • Marca; • Fabricante; • Chassi.

E possuem ações em comum, como:

• Ligar; • Acelerar; • Frear; • Desligar.

Dessa maneira, poderíamos criar uma estrutura de código que representasse esse formato padrão para todos os veículos, agrupando justamente estas características e ações. E é exatamente essa estrutura que é uma classe. Nesse caso, poderíamos ter uma classe Carro, que define as características e ações que são comuns para todos os carros.

#### Declarando classes

No Java, podemos declarar uma classe da seguinte maneira:

Copiar

```java
package br.com.treinaweb;

public class Carro {

    // Atributos ou Características de um carro
    public String modelo;
    public String marca;
    public String chassi;
    public String fabricante;
    
    // Métodos ou ações de um carro
    public void ligar() {
        System.out.println("Carro ligado!");
    }
    
    public void desligar() {
        System.out.println("Carro desligado!");
    }
    
    public void acelerar() {
        System.out.println("Carro acelerando...");
    }
    
    public void frear() {
        System.out.println("Carro freando...");
    }

}
```

Neste momento, caso você tenha visto possíveis palavras desconhecidas ou que você não entenda o funcionamento, como public, por exemplo, seu funcionamento é abordado no artigo [“Os pilares da orientação a objetos”](https://www.treinaweb.com.br/blog/os-pilares-da-orientacao-a-objetos/ ““Os pilares da orientação a objetos””) que citamos no começo deste artigo.

Como no exemplo acima, classes geralmente possuem duas sessões distintas: uma primeira parte, onde são declaradas as características (que tecnicamente são chamadas de atributos); e uma segunda parte onde são declaradas as ações previstas por aquela classe (que tecnicamente são chamadas de métodos).

Uma classe não é obrigada a ter as duas sessões: podemos ter classes que possuem somente atributos, podemos ter classes que possuem somente métodos e podemos ter classes que possuem ambas as sessões. Tudo vai depender da necessidade.

### Objetos

Classes existem para definirmos os nossos moldes, ou seja, para definirmos o formato de estruturas que nosso código irá manipular. Mas, elas servem somente para ser moldes. Se quisermos as utilizar, precisamos colocar algo e criar uma estrutura que seja semelhante a esse molde. E é nesse momento que entram em cena os objetos.

Os objetos são estruturas que são criadas a partir das classes. Um objeto, quando criado a partir de uma determinada classe, assume que irá possuir os mesmos atributos e os mesmos métodos definidos pela classe. Uma classe pode dar origem a vários objetos distintos entre si que compartilham o mesmo molde.

#### Declarando objetos

No Java, objetos podem ser declarados da seguinte forma:

Copiar

```java
package br.com.treinaweb;

public class Aplicacao {

    public static void main(String args[]) {
      Carro corsa = new Carro();
      corsa.modelo = "Corsa";
      corsa.marca = "Chevrolet";
      corsa.chassi = "ABC123";
      corsa.fabricante = "Chevrolet";
      corsa.ligar();
      corsa.acelerar();
      corsa.frear();
      corsa.desligar();
      System.out.println("Nome do carro: " + corsa.modelo);
      
      Carro gol = new Carro();
      gol.modelo = "Gol";
      gol.marca = "Volkswagen";
      gol.chassi = "DEF456";
      gol.fabricante = "Volkswagen";
      gol.ligar();
      gol.acelerar();
      gol.frear();
      gol.desligar();
      System.out.println("Nome do carro: " + gol.modelo);
    }
}
```

Neste exemplo, usamos a nossa classe Carro para criar dois objetos a partir dela: os objetos gol e corsa.

No exemplo acima, ainda podemos afirmar que temos duas variáveis do tipo Carro: gol e corsa; embora, em termos técnicos, o correto é dizer que temos duas instâncias da classe Carro: gol e corsa, objetos também são chamados de instâncias de uma classe. Porém, em termos práticos, não há problema em dizer que temos uma variável do tipo de uma classe.

Objetos são importantes por algumas razões, logo aqui, podemos ver algumas características importantes:

• Objetos definem instâncias de classes, o que nos permite usufruir do molde de atributos e métodos definidos por uma classe; • Objetos guardam estado de maneira segregada: veja que o objeto corsa tem suas características definidas de maneira própria, como modelo, marca, chassi e fabricante. O objeto gol também tem exatamente as mesmas características, mas definidas de acordo com o objeto gol. Embora ambos os objetos venham da mesma classe, eles têm seus próprios valores de atributos, valores estes atrelados a cada instância (no caso, as instâncias gol e corsa).

### Métodos

Partindo do mesmo código acima, temos os métodos. Os métodos são comportamentos e ações que os objetos podem ter.

No código acima, os objetos gol e corsa, por virem do “molde” Carro, adquirem os atributos e métodos definidos pela classe Carro e, por isso, passam a ter as características com modelo, marca e chassi; e ganham as ações definidas pela classe Carro, como ligar, desligar e acelerar.

Copiar

```java
    public void ligar() {
        System.out.println("Carro ligado!");
    }
```

Quando temos objetos, seus atributos (ou características) e métodos (ou ações) são acessados através do “.”. Por exemplo: se eu tenho um Carro chamado corsa e quero acessar seu atributo modelo, devo escrever um código como corsa.modelo. A mesma coisa vale para métodos: se eu quiser acessar o método ligar do objeto corsa, devo escrever o código corsa.ligar().

Se você quer conhecer mais sobre essa linguagem, não se esqueça de acessar nosso [Guia da linguagem Java](https://www.treinaweb.com.br/blog/guia-da-linguagem-java/). Te esperamos lá :)

- [#Orientação a objetos](https://www.treinaweb.com.br/blog/tag/orientacao-a-objetos)
- [#Java](https://www.treinaweb.com.br/blog/tag/java)
- [#classe](https://www.treinaweb.com.br/blog/tag/classe)
- [#objeto](https://www.treinaweb.com.br/blog/tag/objeto)
- [#método](https://www.treinaweb.com.br/blog/tag/metodo)