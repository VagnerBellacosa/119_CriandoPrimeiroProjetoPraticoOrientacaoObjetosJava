# Introdução à Programação Orientada a Objetos em Java

## Veja neste artigo a história da programação orientada a objetos, conheça quem começou a praticar essa técnica. Também saiba como aplicar esses conceitos na prática, usando a linguagem Java.

- [Artigos](https://www.devmedia.com.br/artigos/)[Java](https://www.devmedia.com.br/artigos/java)Introdução à Programação Orientada a Objetos em Java

### Programação Orientada a Objetos

Nos desenvolvimentos de sistemas, existem alguns fatores importantes como: o entendimento do código, fácil manutenção, reaproveitamento entre outros. Para isso, [a **Programação Orientada a Objetos também conhecida como POO**](http://www.devmedia.com.br/curso/basico-de-java-e-orientacao-a-objetos/360), tem a intenção de ajudar nesses fatores, dando tempo e agilidade no desenvolvimento de um sistema para o programador.

A Programação Orientada a Objetos foi criada por **Alan Kay**, autor da linguagem **Smalltalk**. Antes mesmo da criação Orientada a Objetos, já existiam algumas aplicações, neste caso da linguagem Simula 67, criada por **Ole Johan Dahl** e **Kristen Nygaard** em 1967.

Veja na Figura 1 a trajetória que a programação teve para se chegar ao uso da POO.

![Linha do tempo das técnicas de programação](https://arquivo.devmedia.com.br/artigos/Thiago_Varallo/Introducao_POO_Java/Introducao_POO_Java1.jpg)**Figura 1:** Linha do tempo das técnicas de programação

Relacionado: [Curso completo de Java](https://www.devmedia.com.br/cursos/java)

### Elementos

**A Programação Orientada a Objetos é formada por alguns itens**, dentre os quais destacamos: Classes, Objetos, Atributos, Métodos, Construtores, que irão ser mostrados nesse artigo.

### Classes

**As classes de programação são projetos de um objeto, aonde têm características e comportamentos**, ou seja, permite armazenar propriedades e métodos dentro dela. Para construir uma classe é preciso utilizar o pilar da abstração. Uma classe geralmente representa um substantivo, por exemplo: uma pessoa, um lugar, algo que seja “abstrato”.

### Características das classes

- Toda classe possui um nome;
- Possuem visibilidade, exemplo: public, private, protected;
- Possuem membros como: Características e Ações;
- Para criar uma classe basta declarar a visibilidade + digitar a palavra reservada class + NomeDaClasse + abrir e fechar chaves { }.

**Listagem 1:** Declaração de uma classe na linguagem Java

```
public class Teste{
//ATRIBUTOS OU PROPRIEDADES
//MÉTODOS
}
```

Na Listagem 2, são mostrados os componentes da classe, como métodos e atributos.

**Listagem 2:** Classe Caes

```
public class Caes {

	public String nome;
	public int peso;
	public String corOlhos;
	public int quantPatas;

	public void falar(){
		//MÉTODO FALAR
	}

	public void andar(){
		//MÉTODO ANDAR
	}

	public void comer(){
		//MÉTODO COMER
	}

	public void dormir(){
		//MÉTODO DORMIR
	}
}
```

![Demonstração da classe Cães](https://arquivo.devmedia.com.br/artigos/Thiago_Varallo/Introducao_POO_Java/Introducao_POO_Java2.jpg)**Figura 2:** Demonstração da classe Cães.

Na Listagem 2 e na Figura 2, mostra que a classe Cães de um modo genérico, tem os mesmos métodos independente de qualquer cachorro, sendo que a classe é sempre um molde/projeto para o objeto cachorro.

### Objetos

Os objetos são características definidas pelas classes. Neles é permitido instanciar objetos da classe para inicializar os atributos e invocar os métodos. Veja no exemplo da Figura 3.

![Diferença entre objeto e classe](https://arquivo.devmedia.com.br/artigos/Thiago_Varallo/Introducao_POO_Java/Introducao_POO_Java3.jpg)
**Figura 3:** Diferença entre objeto e classe

A Figura 3 mostra que todo objeto é algo que existe, uma coisa concreta, já a classe é considerada como um modelo ou projeto de um objeto, sendo algo que não consegue tocar.

### Atributos

Os atributos são as propriedades de um objeto, também são conhecidos como variáveis ou campos. Essas propriedades definem o estado de um objeto, fazendo com que esses valores possam sofrer alterações. A Listagem 3 mostra as características de um cachorro, mas os valores que são guardados nas variáveis são diferentes variando para cada cachorro.

**Listagem 3:** Classe Cachorro

```
public class Cachorro{

	public String nome;
	public int peso;
	public String corOlhos;
	public int quantPatas;
}
```

Na Listagem 4 é instanciada três vezes a classe “Cachorro”, mostrando que cada cachorro instanciado tem características diferentes.

**Listagem 4:** Classe Testadora de Cachorro

```
public class TestaCaes {

	public static void main(String[] args) {
		Cachorro cachorro1 = new Cachorro();
		cachorro1.nome = "Pluto";
		cachorro1.corOlhos = "azuis";
		cachorro1.peso = 53;
		cachorro1.quantPatas = 4;

		Cachorro cachorro2 = new Cachorro();
		cachorro2.nome = "Rex";
		cachorro2.corOlhos = "amarelo";
		cachorro2.peso = 22;
		cachorro2.quantPatas = 3;

		Cachorro cachorro3 = new Cachorro();
		cachorro3.nome = "Bob";
		cachorro3.corOlhos = "marrom";
		cachorro3.peso = 13;
		cachorro3.quantPatas = 4;

	}

}
```

### Métodos

Os métodos são ações ou procedimentos, onde podem interagir e se comunicarem com outros objetos. A execução dessas ações se dá através de mensagens, tendo como função o envio de uma solicitação ao objeto para que seja efetuada a rotina desejada.

Como boas práticas, é indicado sempre usar o nome dos métodos declarados como verbos, para que quando for efetuada alguma manutenção seja de fácil entendimento. Veja algumas nomenclaturas de nomes de métodos:

- acaoVoltar
- voltar
- avançar
- correr
- resgatarValor
- pesquisarNomes

Na Listagem 5 são declaradas as características e o método, nota-se que tem uma condição de acordo com o valor informado na variável “tamanho”.

**Listagem 5:** Classe Cachorro com método

```
class Cachorro{
	int tamanho;
	String nome;


	void latir(){
		if(tamanho > 60)
			System.out.println("Wooof, Wooof!");
		else if(tamanho > 14)
			System.out.println("Ruff!, Ruff!");
		else
			System.out.println("Yip!, Yip!");
	}
}
```

A Listagem 6 mostra como uma variável pode mudar o estado de um objeto, comunicando-se com o método invocado.

**Listagem 6:** Classe Testadora

```
public class Testa_Cachorro {

	public static void main(String[] args) {

		Cachorro bob = new Cachorro();
		bob.tamanho = 70;
		Cachorro rex = new Cachorro();
		rex.tamanho = 8;
		Cachorro scooby = new Cachorro();
		scooby.tamanho = 35;

		bob.latir();
		rex.latir();
		scooby.latir();

	}
}
```

### Construtores

O construtor de um objeto é um método especial, pois inicializa seus atributos toda vez que é instanciado (inicializado).

Toda vez que é digitada a palavra reservada **new**, o objeto solicita para a memória do sistema armazená-lo, onde chama o construtor da classe para inicializar o objeto. A identificação de um construtor em uma classe é sempre o mesmo nome da classe.

Na Listagem 7, o construtor recebe um parâmetro de uma String que será um argumento de entrada na classe testadora.

**Listagem 7:** Declaração de um construtor com parâmetro

```
class ConstrutorProg{
	private String nomeCurso;


	public ConstrutorProg(String nome)
	{
		nomeCurso = nome;
	}

	public String getNome()
	{
		return "Nome do Curso retornado "+nomeCurso;
	}

}
```

**Listagem 8:** Classe Testadora do Construtor

```
public class Construtor {

	public static void main(String[] args) {

		ConstrutorProg cp = new ConstrutorProg("DevMedia - Java");
		System.out.println(cp.getNome());

	}
}
```

Na Listagem 8 é inicializada a classe “ConstrutorProg”, passando apenas um argumento no parâmetro que foi definido, se fosse apenas inicializado sem nenhum argumento estaria ocorrendo um erro de sintaxe pois já foi definido que no método construtor iria haver uma entrada de um parâmetro.

Sempre uma classe terá um construtor padrão, mesmo não sendo declarado o compilador irá fornecer um. Esse construtor não recebe argumentos e existe para possibilitar a criação de objetos para uma classe.

Espero que tenham gostado e fico por aqui. Até a próxima!

#### Links Úteis

- [Java 7](https://under-linux.org/content.php?r=6829):
  Site com informações sobre o lançamento do Java 7
- [JavaFX](http://www.oracle.com/technetwork/java/javafx/samples/index.html):
  Site para fazer download de aplicações JavaFX
- [JFXtras](https://www.devmedia.com.br/cursos/banco-de-dados):
  Site do projeto JFXtras

#### Saiba mais sobre Java ;)

- [O Que é JPA?](https://www.devmedia.com.br/curso/o-que-e-jpa/2136):
  Dominar a persistência de dados é uma necessidade indispensável aos programadores. Sem esse conhecimento nossas aplicações não terão a capacidade de armazenar e recuperar os dados por ela manipulados.
- [Preparando o ambiente para programar em Java](https://www.devmedia.com.br/curso/programar-java/2117):
  Neste curso você aprenderá a preparar seu ambiente para programar em Java. Veremos aqui o que é necessário instalar e como proceder para desenvolver aplicações com essa linguagem.
- [Criando meu primeiro projeto no Java](https://www.devmedia.com.br/curso/curso-java/2105):
  Neste curso você aprenderá a criar o seu primeiro programa com Java, e não, ele não será um simples “Hello, World!”. :) Para isso, vamos começar ensinando como instalar o Java e preparar o ambiente de desenvolvimento.

Tecnologias:

- [Java](https://www.devmedia.com.br/java/)
-  

- POO