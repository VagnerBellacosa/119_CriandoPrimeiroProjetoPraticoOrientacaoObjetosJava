### [MÓDULO ANTERIOR DO TUTORIAL: HERANÇA](https://www.ic.unicamp.br/~cmrubira/aacesta/java/javatut10.html)  

# 3. POLIMORFISMO, CLASSES ABSTRATAS 

Existem várias classificações e tipos de polimorfismo. C++ apresenta vários tipos de polimorfismo . Java apresenta um conjunto mais reduzido evitando principalmente polimorfismos ad-hoc.

Polimorfismo, do grego: muitas formas. Polimorfismo é a capacidade de um operador executar a ação apropriada dependendo do tipo do operando. Aqui operando e operador estão definidos num sentido mais geral: operando pode significar argumentos atuais de um procedimento e operador o procedimento, operando pode significar um objeto e operador um método, operando pode significar um tipo e operador um objeto deste tipo.

## 3.1. REDEFINIÇÃO DE MÉTODOS PARA UMA CLASSE HERDEIRA 

Este exemplo já foi apresentado em 2.1.3. Também trata-se de um polimorfismo, pode ser classificado como polimorfismo de inclusão. Um método é uma redefinição de um método herdado, quando está definido em uma classe construída através de herança e possui o mesmo nome, valor de retorno e argumentos de um método herdado da classe pai. A assinatura do método tem que ser idêntica, ou seja, teremos redefinição quando uma classe filha fornece apenas uma nova implementação para o método herdado e não um novo método.

Se a classe filha fornecer um método de cabeçalho ou assinatura parecida com a do método herdado (difere ou no número ou no tipo dos argumentos, ou então no tipo do valor de retorno) então não se trata mais de redefinição, trata-se de uma sobrecarga, pois criou-se um novo método. Uma chamada ao método herdado não mais é interceptada por esse novo método de mesmo nome. O método tem o mesmo nome, mas é ligeiramente diferente na sua assinatura (o corpo ou bloco de código {} não importa), o que já implica que não proporciona o mesmo comportamento (behaviour) do método da superclasse.

## 3.2. SOBRECARGA ( MÉTODOS E OPERADORES) 

Este tipo de polimorfismo permite a existência de vários métodos de mesmo nome, porém com assinaturas levemente diferentes ou seja variando no número e tipo de argumentos e no valor de retorno. Ficaria a cargo do compilador escolher de acordo com as listas de argumentos os procedimentos ou métodos a serem executados.

### 3.2.1. SOBRECARGA DE MÉTODOS, "COPY CONSTRUCTOR"

No exemplo a seguir vamos sobrecarregar o construtor de uma classe, esta classe passará a ter duas versões de construtores, vale lembrar que assim como o construtor será sobrecarregado, qualquer outro método poderia ser. O compilador saberá qual método chamar não mais pelo nome, mas pelos argumentos.

O método Ponto(Ponto ap); é um "copy constructor", pois tem o mesmo nome que Ponto(float dx,float dy);. Tal duplicação de nomes pode parecer estranha, porém Java permite que eles coexistam **para uma mesma classe** porque não tem a mesma assinatura (nome+argumentos). Isto se chama sobrecarga de método, o compilador sabe distinguir entre esses dois construtores. Outros métodos, não só construtores poderão ser sobrecarregados para vários argumentos diferentes, esse recurso é um polimorfismo do tipo "ad-hoc".

O que é interessante para nós é o fato de o argumento do construtor **Ponto**(**Ponto** ap); ser da mesma classe para qual o construtor foi implementado, o que caracteriza um "copy constructor" é que inicializa um objeto a partir de outro da mesma classe. Outros métodos semelhantes seriam: Circulo(Circulo a); Mouse(Mouse d); . Implementar copy constructor pode ser muito importante, lembre-se dos problemas com cópias de objetos apresentados em 1.3.3.

Por questões de espaço, basearemos nosso exemplo no tipo abstrato de dados fração, apresentado em 1.6.1. Você deve modificar a classe Fracao para que ela tenha dois construtores, o que esta em negrito deverá ser acrescentado ao código original:

```
public Fracao(int umso) //sobrecarga do construtor original

 

{

 

num=umso;

 

den=1; //subentendido

 

}

 

public Fracao(Fracao copieme) //esse e' um copy constructor

e uma sobrecarga 

 

{

 

num=copieme.retorna_num();

 

dem=copieme.retorna_den();

 

}

 

public Fracao(int t,int m) //construtor original

 

{

 

num=t;

 

den=m;

 

this.simplifica(); //chamada para o mesmo objeto.

 

}



//O programa principal, sobre a modificacao em negrito

 

class Principal {

 

public static void main(String args[])

 

{

 

Fracao a,b,c;

 

a=new Fracao(5); //elimine o segundo argumento

 

b=new Fracao(2,6);

 

System.out.print("Esta e' a fracao a: ");

 

a.mostra();

 

System.out.print("Esta e' a fracao b: ");

 

b.mostra();

 

c=a.soma(b); 

 

System.out.print( "c de a+b: "); //c(a+b)

 

c.mostra();

 

System.out.print("a*b: "); 

 

c=a.multiplicacao(b);

 

c.mostra();

 

System.out.print("a+b: "); 

 

c=a.soma(b);

 

c.mostra();

 

System.out.print("a>=b: "); 

 

System.out.println(a.maiorouigual(b)); 

 

System.out.print("a==b: "); 

 

System.out.println(a.igual(b)); 

 

System.out.print("a!=b: "); 

 

System.out.println(a.diferente(b)); 

 

System.out.print("(int)a "); 

 

System.out.println(a.converteint()); 

 

System.out.print("(double)a "); 

 

System.out.println( a.convertedbl()); 

 

}

 

}
```

------

```
Esta e' a fracao a: (5/1) 

Esta e' a fracao b: (1/3) 

c de a+b: (16/3) 

a*b: (5/3) 

a+b: (16/3) 

a>=b: true 

a==b: false 

a!=b: true 

(int)a 5 

(double)a 5        
```

Teste o "copy constructor" para o tipo abstrato de dados fração apresentado acima. Quando um só número for passado para o construtor desta classe, subentende-se que o construtor chamado é o de um só argumento inteiro e que portanto o denominador será igual a 1.

Agora vamos falar do "copy constructor", que embora implementado, não foi testado em main() . Esse método, pertence a outro objeto que não o argumento copieme, então para distinguir o atributo num deste objeto, do atributo num de copieme usamos copieme.num e simplesmente num para o objeto local, objeto em questão, ou objeto dono do método chamado.

**Exercícios:**

**1-**

Faça um "copy constructor" para uma das classes já implementadas neste texto.

**2-**

Sobrecarregue o método move da classe Ponto para aceitar um Ponto como argumento, subentende-se que devemos mover a distância x e a distância y daquele ponto a origem.

**3-**

Crie um método de nome unitarizado para a classe Ponto. Este método deve interpretar o Ponto como um vetor e retornar um novo Ponto que contém as coordenadas do vetor unitarizado. Unitarizar é dividir cada coordenada pelo módulo do vetor. O módulo é a raiz quadrada da soma dos quadrados das componentes.



### 3.2.2. SOBRECARGA DE OPERADOR

### 

Java não fornece recursos para sobrecarga de operador, o que é perfeitamente condizente com a filosofia da linguagem. Seus criadores que acreditavam que a linguagem deveria ser pequena, simples, segura de se programar e de se usar (simple, small, safe and secure).

A ausência de sobrecarga de operadores pode ser contornada definindo apropriadamente classes e métodos.



## 3.3. CLASSES ABSTRATAS E CONCRETAS 

Em um dos exercícios anteriores (no tópico sobre herança) pedíamos que você definisse uma hierarquia composta de três classes. A classe pai tinha o nome de Forma, e as classes herdeiras desta eram Ponto e Retangulo. Embora a classe forma não possuísse sentido prático, ela permitia certas operações como move, altera_x(int nx), entre outras (retorne a este exercício).

Na verdade o que desejávamos era que esta classe Forma se comportasse como um esqueleto para as suas classes filhas, nós não queríamos instanciá-la. Classes abstratas permitem exatamente isto pois não podem ser instanciadas embora possam ser usadas de outras maneiras.

Classes abstratas são poderosas, elas permitem: criação de listas heterogêneas, ocorrência de "dynamic binding" e maior clareza no projeto de sistemas. Os packages que vem com a linguagem estão repletos de exemplos de classes abstratas.

Métodos abstratos, obrigatoriamente pertencem a classes abstratas, e são métodos desprovidos de implementação, são apenas definições que serão aproveitadas por outras classes da hierarquia. Voltando ao exemplo da hierarquia Forma, Ponto e Retangulo. O método mostra poderia ter sido definido na classe base abstrata (Forma) como um método abstrato.

```
 Classes abstratas 
```

------

``

```
//Classe Forma

 

abstract class Forma {

 

protected float x,y; //visivel hierarquia abaixo

 

public void move(float dx,float dy)

 

{

 

this.x+=dx; this.y+=dy;

 

}

 

abstract public void mostra(); //metodo abstrato

 

} 

 

//Classe ponto

 

class Ponto extends Forma {

 

public Ponto(float ax,float ay) //omita o valor de retorno!

 

//garante o estado do objeto

 

{

 

this.x=ax; this.y=ay;

 

}

 

//move nao precisa ser redefinido

 

public void mostra()

 

{

 

System.out.println("("+this.x+","+this.y+")");

 

}

 

} 






//Classe Retangulo

 

class Retangulo extends Forma {

 

protected float dx,dy; //delta x e delta y

 

//protected acaba sendo menos inflexivel e mais eficiente que

private

 

public Retangulo(float ax,float ay,float dx,float dy) 

 

//garante o estado do objeto

 

{

 

x=ax; y=ay;

 

this.dx=dx; this.dy=dy; //this usado para eliminar ambiguidade

 

}

 

//metodo move nao precisa ser redefinido

 

public void mostra()

 

{

 

System.out.println("("+this.x+","+this.y+")("+dx+","+dy+")");

 

}

 

} 






//Classe principal, Arquivo Principal.java

 

class Principal {

 

public static void main(String args[]) {

 

Retangulo ar=new Retangulo(0,0,13,14);

 

ar.mostra();

 

ar.move(1,1);

 

ar.mostra();

 

}

 

}
(0,0)(13,14) 
(1,1)(13,14)                                                       
```

//**COMENTARIOS**:

Observe que a classe Forma que é abstrata, não possui um construtor, porque não pode ser instanciada. Agora também temos um novo qualificador de classe e de métodos: abstract.

**Classes abstratas X Interfaces:**

Você deve estar achando que classes abstratas e interfaces são conceitos parecidos e que podem ser usados com objetivos semelhantes. Cuidado! Uma classe pode estender uma única classe (que pode ser abstrata ou não), mas pode implementar várias interfaces. Além disso, interfaces não permitem declaração de atributos, enquanto que classes abstratas permitem. Interfaces estão mais ligadas a comportamento, enquanto que classes abstratas estão mais ligadas a implementação.

**Exercícios**:

1-

Defina uma classe abstrata tipo numérico que deve servir como classe base para a montagem de classes como a classe fração ou a classe número complexo. Uma boa medida da qualidade de sua implementação é a quantidade de mudanças necessárias para por exemplo trocar a classe fração usada em um algoritmo de cálculo numérico pela classe número complexo. É bem verdade que existem operações que se aplicam a uma dessas classes, mas não a outra, mas essas disparidades deverão ser mantidas fora da classe base abstrata.

### 3.3.1. CLASSE ABSTRATA ITERADOR

Neste exemplo iremos criar uma classe base abstrata iterador, que servirá como topo de uma hierarquia para iteradores de estruturas de dados como listas, vetores e árvores. O iterador de vetor é definido por herança da classe base abstrata de iteradores.

Perceba que alguns métodos da classe base são desprovidos de implementação, porém nada impede que você coloque como código desses métodos uma mensagem de erro do tipo "Erro, método deveria ter sido redefinido", mas agora o compilador não pode mais te lembrar de redefini-los.



**"SHOPPING LIST APPROACH" PARA A CLASSE ABSTRATA ITERADOR**

(As operações implementadas estão marcadas com, existem outras operações úteis, não mencionadas por motivos de espaço. Esta classe base abstrata não tem a funcionalidade de uma classe que possa estar instanciada, perceba a ausência de um método para avançar na iteração).

Método de inicialização da iteração

Retorno do conteúdo da atual posição na iteração

Atribuição de valor a atual posição da iteração

Método que verifica se a iteração não chegou ao fim

**"SHOPPING LIST APPROACH" PARA A CLASSE ABSTRATA ITERADOR VETOR**

(Uma tarefa desagradável quando iterando sobre vetores é manter os índices das iterações atualizados durante avanços e retrocessos. Note que retrocessos não fariam sentido em uma lista simplesmente ligada, por isso essa operação somente é definida neste nível da hierarquia.)

 Retorno do valor numérico ou índice da atual posição da iteração

 Retrocesso na iteração

 Avanço na iteração

 Avanço e retrocesso com saltos (inclusive é mais genérico que os dois anteriores).

```

```

------

```
//Classe IteradorI

 
abstract class IteradorI {


abstract public void comeca();
 

abstract public int retorna(); //metodos abstrato
 

abstract public void atribui(int a); 
 

abstract public boolean fim();
 

} 

 

//Classe IteradorVetorI

 
class IteradorVetorI extends IteradorI {

 
protected int[] vet; //itero sobre ele

 
private int conta; //posicao atual da iteracao

 
public IteradorVetorI(int[] itereme) 
 {
  vet=itereme;
  conta=0;
 }

 

public void comeca()
 {
  conta=0;
 }


public void comeca(int p)
 {
   conta=(p%vet.length);
 }

 
public void atribui(int novo)
 {
   vet[conta]=novo;
 }

 

public int retorna()
 {
   return vet[conta];
 }

 
public boolean fim()
 {
  return conta==vet.length-1;
 }

 
public int retorna_conta()
 {
  return conta;
 }

 
public void avanca()
 {
  if (conta<(vet.length-1)) conta++;
 }

 
public void retrocede()
 {
  if (conta>0) conta--;
 } 

 
} 






import java.io.DataInputStream;

 

//Classe principal, Arquivo Principal.java

 

class Principal {

 

public static void main(String args[]) {

 

int[] vet=new int[6];

 

vet[0]=0; vet[1]=1; vet[2]=2; vet[3]=3; vet[4]=4; vet[5]=5;

 

IteradorVetorI mit=new IteradorVetorI(vet);

 

char o; //o=opcao, 

 

int e; //temporario

 

String line; //linha a ser lida do teclado

 

DataInputStream meuDataInputStream=new DataInputStream(System.in);

 

try{ 

 

do 

 

{

 

do { o=meuDataInputStream.readLine().charAt(0); } 

 

while (o=='\n');

 

switch (o) {

 

case 'a': //atribui

 

line=meuDataInputStream.readLine();

 

try {

 

e=Integer.valueOf(line).intValue();

 

mit.atribui(e);

 

}

 

catch (Exception erro) {

 

System.out.println("Entrada invalida!");

 

}

 

break;

 

case 'r': //retorna

 

e=mit.retorna();

 

System.out.println(e);

 

break;

 

case 'f': //frente 

 

mit.avanca();

 

break;

 

case 't': //tras

 

mit.retrocede();

 

break;

 

case 'c': //comeca iteracao?

 

mit.comeca();

 

break;

 

case 'e': //fim da iteracao?

 

System.out.println(mit.fim());

 

break;

 

case 'v': //valor atual

 

System.out.println("V:"+mit.retorna_conta());

 

break;

 

case 'm': //mostra vetor

 

for(int j=0;j<vet.length;j++)

 

{ System.out.print("["+vet[j]+"]"); }

 

System.out.println();

 

break;

 

default: ;

 

} //switch

 

} while (o!='q');

 

} //try block

 

catch (Exception erro) { /* nao faco nada */ } 

 

} //main method

 

} //class Principal



             

m 

[0][1][2][3][4][5] 

a 9 

m 

[9][1][2][3][4][5] 

f f f 

a 33 

t 

a 22 

m               



[9][1][22][33][4][5] 

c 

v 

V:0 

q                                                  
```

``

**Exercícios**:

1-

Defina uma classe de nome ArrayServices que fornece serviços para vetores. Implemente os "serviços" de: ordenação de subvetor (vetor interno menor ou igual ao vetor em questão) , busca, troca de posições, etc. Esta classe opera sobre os vetores passados como argumentos de seus métodos (passagem implícita do ponteiro para o vetor). Os vetores devem ser de tipos numéricos definidos na linguagem (conte com a existência de operadores + - < ==, etc).

Você terá que definir uma versão desta classe para cada tipo da linguagem (byte, float, etc). Na verdade isto não é trabalhoso, basta você definir para um tipo, depois alterar só as partes necessárias e recompilar para os demais.

Pense como fazer a classe ArrayServices trabalhar em conjunto com a classe Iterador vetor. Não confunda estas duas classes, elas executam tarefas distintas.



### 3.3.2. ACOPLAMENTO DINÂMICO DE MENSAGENS 

Por acoplamento entenda a escolha certa de um método a ser executado para uma variável declarada como de uma classe, mas podendo conter um objeto de uma subclasse desta. Por dinâmico entenda em tempo de execução.

Já dissemos que um objeto de uma classe filha garante no mínimo o comportamento "behaviour" de seu pai. Por este motivo podemos atribuir um objeto da classe filha a uma variável da classe pai, mas não o contrário.

Acoplamento dinâmico mostrará que é possível fazer com que o compilador execute a implementação desejada de um método redefinido para classes herdeiras, mesmo no caso de chamada de método ocorrer para uma variável de superclasse (classe pai) contendo um objeto de uma subclasse (classe filha). Isto nos permitirá construir listas heterogêneas 3.3.3.

Fazendo uma comparação com linguagens procedurais:

O trabalho do dynamic binding normalmente é feito desta forma em linguagens procedurais:

``

```
//ComputaContaBancaria



if type(a)==ContaCorrente then ComputaContaCorrente(a);



else if type(a)==Poupanca then ComputaPoupanca(a); //chamadas

de procedimentos



Já em linguagens orientadas a objetos como Java temos o

seguinte:



Conta ContVet=new conta[3]; //Vetor de objetos da classe conta



ContVet[0]=new Poupanca(1000,.10); //toda Poupanca é uma

Conta



ContVet[1]=new ContaCorrente(1000,.10,0); //toda ContaCorrente

é uma Conta



ContVet[2]=new Poupanca(1030,.15);



ContVet[x].computa(); //nao importa para que classe da hierarquia

de contas, computa 



//computa definida e o compilador acopla dinamicamente, em tempo

de execucao a



//mensagem
```

**Diagrama das classes:**



![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/filhopai.gif)



A classe filha garante no mínimo o mesmo comportamento, "behaviour" da classe pai, podendo acrescentar ou redefinir parte do que foi herdado. Por este motivo, uma variável da classe pai pode receber um objeto da classe filha, o comportamento da classe pai fica garantido e o restante (o que a classe filha acrescentou) é perdido. Já uma variável da classe filha não pode receber um objeto da classe pai, porque os métodos definidos para variáveis desta classe passam a não fazer sentido para o objeto contido nesta variável.

O diagrama reflete o aspecto das características acrescentadas pela classe filha a classe pai, mas não o fato de uma variável da classe pai poder receber um elemento da classe filha, isto porque como no desenho o pai é desenhado menor que o filho, o leitor tem a tendência de inferir que o pai cabe no filho o que é justamente o contrário do que acontece em termos de variáveis.



#### 3.3.2.1. UM EXEMPLO ESCLARECEDOR

O exemplo a seguir cria dois objetos (pai e filho) e faz atribuições e chamadas de métodos entre eles.

```

```

------



```
 //Classe SuperClasse  class SuperClasse {  public void nome()  {  System.out.println("Metodo da superclasse");  }  }   //Classe SubClasse  class SubClasse extends SuperClasse {  public int novoatributo;  public void nome() //redefinicao {  System.out.println("Metodo da subclasse");  }  public void novometodo()  {  System.out.println("Novo metodo:"+novoatributo);  }  }   //Classe principal, Arquivo Principal.java  class Principal {  public static void main(String args[]) {  SubClasse esub1=new SubClasse();  SuperClasse esuper1=new SuperClasse(); //poderia ter alocado uma SubClasse aqui  esub1.nome();  esub1.novoatributo=10;  esuper1.nome();  esuper1=esub1;  esuper1.nome();  } //main method  } //class Principal    **![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/result~2.gif)** Metodo da subclasse Metodo da superclasse Metodo da subclasse                        **//COMENTARIOS:** 
 Note que o método é escolhida de acordo com o conteúdo da variável e não de acordo com a classe desta.  
```



#### 3.3.2.2. O QUE ACONTECE COM O QUE FOI ACRESCENTADO 

Depois do programa anterior, você deve estar se perguntando o que acontece com o que foi acrescentado pela classe filha quando um objeto desta classe é atribuído a classe pai.

```

```

**//Insira aqui o arquivo da SuperClasse do exemplo anterior//Insira aqui o arquivo da SubClasse do exemplo anterior//Classe principal, Arquivo Principal.javaclass Principal {public static void main(String args[]) {SubClasse esub1=new SubClasse();SuperClasse esuper1=new SuperClasse(); //poderia ter alocado uma SubClasse aquiesub1.nome();esub1.novoatributo=10;esuper1.nome();esuper1=esub1;esuper1.nome();esub1=(SubClasse)esuper1; //castesub1.nome();esub1.novometodo();} //main method} //class Principal`\**![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/result~2.gif)\**              Metodo da subclasse  Metodo da superclasse  Metodo da subclasse  Metodo da subclasse  Novo metodo:10                                                          `\**//COMENTARIOS\**Embora você seja capaz de recuperar os métodos e atributos acrescentados através do type casting, enquanto isto não for feito, estes métodos e atributos estão inacessíveis.\**Exercícios:\**1-Implemente em suas classes métodos que imprimem uma frase identificando o tipo da classe, por exemplo: "Eu sou a classe conta corrente, especialização de conta bancaria."2-Modele e implemente uma hierarquia de CONTAS BANCÁRIAS, use os recursos que achar conveniente: classes abstratas, interfaces, variáveis static. Você deve definir classes semelhantes as contas bancárias como poupança, conta corrente, etc. Os métodos devem ter nomes como deposita, saca, computa, etc.
3.3.3. LISTA HETEROGÊNEA DE FORMAS (geométricas)Este exemplo lida com um vetor de objetos da classe forma definida em 3.3\*CLASSES ABSTRATAS E CONCRETAS\* , estes objetos são retângulos, pontos, etc. O objetivo é mostrar: subclasses contidas em variáveis (posições de vetor) da superclasse e acoplamento dinâmico de mensagens.O nosso vetor de formas conterá objetos gráficos de classes heterogêneas. Trataremos todos de maneira uniforme, chamando os métodos mostra e move. Você já viu nos exemplos anteriores como recuperar o objeto em uma variável de sua própria classe e não superclasse.`\**![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/codigo.gif)\** Recompile com esse novo método main:``//Insira aqui a definicao da classe Forma dada em 3.3\*CLASSES ABSTRATAS E CONCRETAS\*//Insira aqui a definicao da classe Ponto dada em 3.3\*CLASSES ABSTRATAS E CONCRETAS\*//Insira aqui a definicao da classe Retangulo dada em 3.3\*CLASSES ABSTRATAS E CONCRETAS\*//Classe principal, Arquivo Principal.javaclass Principal {public static void main(String args[]) {Forma vetorgrafico[]=new Forma[4];vetorgrafico[0]=new Retangulo(0,0,20,10);vetorgrafico[1]=new Ponto(0,1);vetorgrafico[2]=new Retangulo(100,100,20,20); //lados iguaisvetorgrafico[3]=new Ponto(2,1);for(int i=0;i<4;i++){vetorgrafico[i].mostra();}for(int j=0;j<4;j++){vetorgrafico[j].move(12.0f,12.0f);vetorgrafico[j].mostra();}}}\**![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/result~2.gif)\**              (0,0)(20,10) (0,1) (100,100)(20,20) (2,1) (12,12)(20,10) (12,13) (112,112)(20,20) (14,13)                                                          `//\**COMENTARIOS\**:Observe que a implementação correta do método mostra é escolhida em tempo de execução de acordo com a classe do objeto que está naquela posição do vetor.
\**Exercícios:\**\**1\**Considere as seguintes declarações em Java:```public class T  {  public void f(void) { System.out.println( "Estou em T");}  };  public class S extends T  {  public void f(void) { System.out.println("Estou em S");}  };  T x= new T();  S y=new S();  T p=new T();  `e as seguintes invocações de operações:``` p.f(); //primeira  p=y;  p.f(); //segunda  x.f(); //terceira  y.f(); //quarta  x=y;  x.f() //quinta  `Responda qual é o resultado na tela de cada uma destas chamadas.[PRÓXIMO MÓDULO DO TUTORIAL: POLIMORFISMO](https://www.ic.unicamp.br/~cmrubira/aacesta/java/javatut12.html)**