### [MÓDULO ANTERIOR DO TUTORIAL: CLASSES E OBJETOS](https://www.ic.unicamp.br/~cmrubira/aacesta/java/javatut9.html) 

# 2. HERANÇA 

Existe uma visão um pouco tacanha de orientação a objetos como uma simples maneira de organizar melhor o seu código. Essa visão é facilmente desmentida pelos conceitos de encapsulamento, interfaces, packages e outros já apresentados. Neste tópico apresentaremos o conceito de herança, fundamental para programação orientada a objetos e um dos fatores de sucesso desta como muito mais que uma simples maneira de organizar melhor seu código.

Um dos aspectos que distinguem objetos de procedimentos e funções é que o tempo de existência de um objeto pode ser maior do que o objeto que o criou. Isto permite que em sistemas distribuídos objetos criados em um local, sejam passados através da rede para outro local e armazenados lá quem sabe na memória ou mesmo em um banco de dados.

**Curiosidade:**

Existem classes que podem ser obtidas na Internet para fazer interface com bancos de dados SQL, servindo principalmente para facilitar esta faceta da programação na internet que é bastante limitada pelas restrições de segurança da linguagem.

## 2.1. HIERARQUIAS DE TIPOS 

Neste tópico mostraremos como construir hierarquias de tipo por generalização / especialização. Para entender o que é generalização especialização e as regras de atribuição entre elementos dessas hierarquias, acompanhe a seguinte comparação:

Se você vai a um restaurante e pede o prato de frutos do mar, é natural que você aceite uma lagosta com catupiry, ou então filé de badejo. Mas se o garçom lhe serve uma salada de tomates isto não se encaixa no pedido. Por outro lado, se o seu pedido for peixe, uma lagosta com catupiry, embora muito saborosa não serve mais, assim como a salada. Note que peixe e lagosta são especializações de frutos do mar.

Generalização e Especialização são ferramentas para lidar com complexidade, elas são abstrações. Os sistemas do mundo real apresentam complexidade muito maior que ordenar um prato listado em um cardápio. O uso de generalização e especialização permite controlar a quantidade de detalhes presente nos seus modelos do mundo real, permite capturar as características essenciais dos objetos e tratar os detalhes de forma muito mais organizada e gradual.

Existe muito mais para falar sobre herança, principalmente no que diz respeito a polimorfismo de inclusão e acoplamento dinâmico de mensagens, tópicos estes que serão abordados em separado.

### 2.1.1. UMA HIERARQUIA SIMPLES.

Construiremos uma hierarquia de tipos simples para demonstrar herança pública em Java.

```

```

**Comentários:**

O diagrama acima representa a hierarquia de classes implementada neste exemplo e foi obtido a partir da janela de edição de uma ferramenta case para programação orientada a objetos.

A classe ponto que está no topo da hierarquia é chamada de classe base, enquanto que as classes ponto_reflete e ponto_move são chamadas classes filhas ou herdeiras. As classes da hierarquia são simples, ponto_move apresenta o método move, já abordado neste tutorial em 1.2.6, ponto_reflete apresenta o método (reflete) que inverte o sinal das coordenadas.

Dada a simplicidade das classes o leitor poderia se perguntar, porque não juntar as três em uma só. A pergunta faz sentido, mas e se quiséssemos criar uma classe Ponto que não se movesse, apenas refletisse e outra que só se movesse? E se quiséssemos projetar nosso programa segundo uma hierarquia de especialização / generalização da classe Ponto? O exemplo mostra como fazê-lo.

Na herança as classes filhas passam a atender pelos mesmos métodos e atributos public da classe pai, as classes filhas podem acrescentar métodos, atributos e até redefinir métodos herdados (veremos mais tarde). Por isso é que se diz que as classes subclasses garantem pelo menos o comportamento "behaviour" das superclasses, podendo acrescentar mais características. Os atributos encapsulados (private) da classe pai não são acessíveis diretamente na classe filha a não ser que sejam qualificados como protected ou public, veja 2.1.2.

Diagrama de acesso, visibilidade, dos elementos da classe pai para uma classe filha ou herdeira. Os atributos e métodos da classe pai são classificados quanto ao encapsulamento. A parte sombreada significa não visível, encapsulado. *As duas são consideradas como sendo do mesmo package.
![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/pvpxpvpv.gif)

**Construtores e herança:**

No construtor de uma classe filha o programador pode incluir a chamada do construtor da classe pai existente nela. Para referenciar a classe pai use a "keyword " super de modo semelhante a this.

**![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/codigo.gif)** Hierarquia de generalização e especialização.

------

```
//Classe Ponto

 

class Ponto {

 

private float x,y;

 

public Ponto(float ax,float ay) //omita o valor de retorno!

 

//garante o estado do objeto

 

{

 

this.x=ax; this.y=ay;

 

}

 

public void inicializa(float a,float b)

 

{

 

this.x=a; this.y=b;

 

}

 

public float retorna_x()

 

{

 

return x;

 

} 

 

public float retorna_y()

 

{

 

return y;

 

}

 

public void altera_x(float a)

 

{

 

this.x=a;

 

}

 

public void altera_y(float b)

 

{

 

this.y=b;

 

}

 

public void mostra()

 

{

 

System.out.println( "(" + this.x + "," + this.y

+ ")" );

 

}

 

}



 
 

//Classe PtoMove


class PtoMove extends Ponto {

 

//adicione algum atributo private se quiser

 

public PtoMove(float a,float b)

 

{ 

 

super(a,b); //chamada do construtor da classe pai

 

}

 

public void move(float dx,float dy)

 

{

 

this.altera_x(retorna_x()+dx);

 

this.altera_y(retorna_y()+dy);

 

}

 

}
 
 

//Classe PtoReflete

 

class PtoReflete extends Ponto {

 

//adicione algum atributo private se quiser

 

public PtoReflete(float a, float b) 

 

//construtor

 

{

 

super(a,b); //chamada de construtor da classe pai ou superclasse

 

}

 

void reflete()

 

//troca o sinal das coordenadas

 

{

 

this.altera_x(-retorna_x());

 

this.altera_y(-retorna_y());

 

}

 

}
```

------





------

```
//Classe principal, Arquivo Principal.java

 

class Principal {

 

public static void main(String args[]) {

 

PtoReflete p1=new PtoReflete(3.14f,2.72f);

 

System.out.println("Criando PontoReflete em 3.14,2.72");

 

p1.reflete();

 

System.out.println("Refletindo este ponto.");

 

p1.mostra();

 

PtoMove p2=new PtoMove(1.0f,1.0f);

 

System.out.println("Criando PontoMove em 1.0,1.0");

 

p2.move(.5f,.5f);

 

System.out.println("Movendo este ponto de 0.5,0.5");

 

p2.mostra();

 

}

 

}
Criando PontoReflete em 3.14,2.72 
Refletindo este ponto. (-3.14,-2.72)          
Criando PontoMove em 1.0,1.0 
Movendo este ponto de 0.5,0.5 (1.5,1.5)            
```

**//COMENTARIOS**

Os atributos x e y da classe Ponto estão declarados como private. Pelo diagrama anterior ao programa, atributos private não são visíveis aos descendentes na hierarquia. E de fato nós alteramos esses atributos (reflete e move) através de chamadas a métodos public da classe pai, chamadas de métodos que impliquem em acesso indireto a atributos da mesma classe parecem ser um pouco ineficientes. Lembre-se que os métodos public sempre são visíveis.

**Nota aos programadores C++:**

Java não permite herança private, a clausula extends equivale a herança pública de C++ e só. Para obter o efeito de herança private use agregação.



A classe forma não tem um significado prático, é uma abstração, você não pode desenhar uma forma, no entanto neste programa você poderá instanciá-la. Esta classe está na hierarquia, somente para capturar as características comuns a Ponto e Retangulo. Em 3.3 aprenderemos como definir estas classes abstratas de forma mais condizente com o paradigma de orientação a objetos.

O método mostra deve imprimir na tela os atributos destas classes.

### 2.1.2. PROTECTED

Quando vimos o tópico encapsulamento, foi mencionado que private era o modo de encapsulamento mais restritivo, seguido de protected, package e depois public (o mais aberto). Neste tópico mostramos um exemplo para cada tipo de encapsulamento, exceto protected que depende da existência de uma hierarquia para ser demonstrado.

Igual ao exemplo anterior, mas agora tornando os atributos da classe pai acessíveis para as classes filhas através do uso de protected. Protected deixa os atributos da classe pai visíveis, acessíveis "hierarquia abaixo". Mas para o restante do programa tem o mesmo efeito que private.

Outra frase sobre protected: "A herança permite que uma subclasse ganhe acesso a declarações protected de sua superclasse, mas o usuário não percebe isso, para o usuário (uma classe externa) o que continua existindo é o que é public".

Diagramas de acesso, visibilidade, de atributos e métodos de uma classe pai para uma classe filha ou herdeira: Para uma classe filha em outro package (você herdando de uma classe pronta em Java)
![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/pvpxpvpx.gif)

O que o restante do programa vê das declarações da classe pai na classe filha. (por restante do programa entenda: outros packages e outras hierarquias)
![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/pvpxpxpx.gif)





![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/codigo.gif) O mesmo exemplo só que usando protected.



------

``

```
//Classe Ponto  class Ponto {   **protected** float x,y;  public Ponto(float ax,float ay) //omita o valor de retorno!  //garante o estado do objeto { this.x=ax; this.y=ay; }  public void inicializa(float a,float b) { this.x=a; this.y=b; }  public float retorna_x()  {  return x;  }   public float retorna_y()  {  return y;  }  public void altera_x(float a)  {  this.x=a;  }  public void altera_y(float b)  {  this.y=b;  }  public void mostra()  {  System.out.println( "(" + this.x + "," + this.y+ ")" );  }  }     //Classe PtoMove  class PtoMove extends Ponto {  //adicione algum atributo private se quiser  public PtoMove(float a,float b)  {   **super(a,b);**   }  public void move(float dx,float dy)  {  **x=x+dx; //aqui continuam acessiveis, em main nao**  **y=y+dy; //acesso direto, sem passar por metodo**  }  }     //Classe PtoReflete  class PtoReflete extends Ponto {  //adicione algum atributo private se quiser  public PtoReflete(float a, float b)  {  super(a,b); //chamando o construtor da classe pai  }  void reflete()  {  x=-x;  y=-y;  }  }   //Classe principal, Arquivo Principal.java  class Principal {  public static void main(String args[]) {  PtoReflete p1=new PtoReflete(3.14f,2.72f);  System.out.println("Criando PontoReflete em 3.14,2.72");  p1.reflete();  System.out.println("Refletindo este ponto.");  p1.mostra();  PtoMove p2=new PtoMove(1.0f,1.0f);  System.out.println("Criando PontoMove em 1.0,1.0");  p2.move(.5f,.5f);  System.out.println("Movendo este ponto de 0.5,0.5");  p2.mostra();  }  }    
Criando PontoReflete em 3.14,2.72 
Refletindo este ponto. (-3.14,-2.72)          
Criando PontoMove em 1.0,1.0
Movendo este ponto de 0.5,0.5 (1.5,1.5)            
```

O qualificador protected termina com os modos de encapsulamento de atributos e métodos, portanto faremos uma revisão final, utilize os números dessa tabela para checar visualmente o tipo de encapsulamento no diagrama a seguir. Você vai aprender a olhar para este diagrama e enxergar tudo o que aprendemos nesse assunto, os atributos e métodos que estamos preocupados em encapsular são os da classe mais escura:

```
MODO          REPRESENTAÇÃO            LIMITE DE VISIBILIDADE                         

4)private     Representação no diagrama: a      Este é o nível de encapsulamento mais          

              própria classe escura.            restritivo. A visibilidade das declarações     

                                                limita-se ao envoltório da classe.             

3) protected  Representação no diagrama: a      A visibilidade das declarações se limita       

              hierarquia abaixo da classe       própria classe e as classes herdeiras dela.    

              escura.                                                                          

2)Nada        Representação no diagrama:        A visibilidade das declarações se limita a     

especificado  retângulo envolvendo as classes   própria classe e as classes do mesmo           

"package"     pintadas.                         package, mas não às classes herdeiras, .       

                                                Classes herdeiras não precisam ser do mesmo    

                                                package.                                       

1 )public     Representação no diagrama:        Estas declarações são sempre acessíveis.       

              todas as classes.                                                                



                                                                                                

                                                                                               
                                                                                            
```

O diagrama acima mostra as áreas de visibilidade de cada tipo de modificador aplicado aos atributos da classe destacada. Os retângulos grandes, representam os packages, optamos por construir a hierarquia da esquerda dentro do mesmo package o que nem sempre é feito. Normalmente quando você estende uma classe das packages que vem com a linguagem, sua classe herdeira não pertence a aquela package, mas pertence a hierarquia, saindo fora dos retângulos maiores como na hierarquia da direita. Suponha que todas as classes são declaradas como public. Existem algumas declarações de qualificadores de atributos que não fazem sentido com classes private e são erros de compilação.



### 2.1.3. REDEFINIÇÃO DE MÉTODOS HERDADOS 

Uma classe filha pode fornecer uma outra implementação para um método herdado, caracterizando uma redefinição "overriding" de método. Importante: o método deve ter a mesma assinatura (nome, argumentos e valor de retorno), senão não se trata de uma redefinição e sim sobrecarga "overloading". A redefinição garante que o método terá o mesmo comportamento que o anterior isto faz com que as subclasses possam ser atribuídas a variáveis da superclasse pois atendem a todas as operações desta.

Este exemplo é igual ao exemplo anterior, mas agora redefinindo o método mostra para a classe filha PtoReflete. Na verdade este exemplo deveria pertencer ao tópico de polimorfismo, contudo, nos exemplos seguintes usaremos também redefinições de métodos, portanto faz-se necessário introduzi-lo agora. Teremos mais explicações sobre o assunto.

No nosso exemplo a classe PtoReflete redefine o método mostra da classe pai, enquanto que a classe herdeira PtoMove aceita a definição do método mostra dada pela classe Ponto que é sua classe pai.



![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/codigo.gif)

```
//Insira aqui o arquivo da classe Ponto do exemplo anterior: PROTECTED




//Insira aqui o arquivo da classe PtoMove do exemplo anterior:PROTECTED



//Classe PtoReflete


class PtoReflete extends Ponto {


//adicione algum atributo private se quiser


public PtoReflete(float a, float b)


{


super(a,b); //chamando o construtor da classe pai


}


public void mostra()


{


System.out.println( "X:" + this.x + " Y:"+ this.y );


}


void reflete()


{


x=-x;


y=-y;


}


}




//Insira aqui o arquivo da classe Principal do exemplo anterior: PROTECTED
```

**//COMENTARIOS**

No caso de redefinição de métodos, a busca da implementação do método a ser executado ocorre de baixo para cima na hierarquia. Exemplo: se você tem um objeto PtoReflete e chama o método retorna_x() para ele, primeiro o compilador procura se PtoReflete possui ou não uma implementação para este método, no caso não possui, então a busca é feita nos métodos public da superclasse, onde a implementação de retorna_x() é achada                                                                                                                        ![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/esqu.gif)                                                                                                                                                                   

**Exercícios:** 

**1-**

Teste redefinição de métodos colocando "System.out's" em métodos da hierarquia, tais como: 

` System.out.println("Metodo redefinido na classe X, chamado.") ` ; 





## 2.2. INTERFACES, UMA ALTERNATIVA PARA HERANÇA MÚLTIPLA 

 Herança múltipla:
![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/radiorel.gif)

Herança múltipla é a capacidade de uma classe herdar de duas ou                            mais classes, por exemplo a classe radio-relógio herdar da                                     classe rádio e da classe relógio. C++ apresenta herança                                        múltipla, e também maneiras de tratar os problemas decorrentes                                 de seu uso. Um dos problemas que podem surgir é o conflito de                                  nomes de atributos ou métodos herdados desse tipo de herança.                                  Uma das estratégias adotadas para resolver estes conflitos é o                                 "renaming" ou renomeamento desses nomes iguais presentes nas                                   superclasses. Tendo o seguinte significado: A classe herdeira                                  tem comportamento, "behaviour", semelhante ao das duas classes                                 pais. Um outro exemplo de interface seria a classe audio-vídeo                                 que herda da classe audio e da classe vídeo.                                                  

Java por motivos de simplicidade, abandona a idéia de herança múltipla, cedendo lugar ao uso de interfaces. Interfaces são um conjunto de métodos e constantes (não contém atributos). Os métodos definidos na interface são "ocos" ou desprovidos de implementação. Classes podem dizer que implementam uma interface, estabelecendo um compromisso, uma espécie de contrato, com seus clientes no que se refere a prover uma implementação para cada método da referida interface.. Ao cliente, pode ser dada a definição da interface, ele acaba não sabendo o que a classe é, mas sabe o que faz. Quem programa em Objective C, deve ver as interfaces como algo semelhante ao conceito de protocolos.

Neste exemplo usaremos uma interface de nome imprimível para capturar as características comuns as classe que podem ser imprimidas em algum dispositivo de saída de dados.

```
 **![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/codigo.gif)** Interfaces                                                                       public **interface Imprimivel** { //alem das classes, so interfaces pode ocupar um arquivo   final char nlin='\n'; //nova linha   public String toString();   //forma preferida para impressao na tela   public void toSystemOut();   }    public class Produto **implements Imprimivel** {   //um produto comercial qualquer    protected String descricao;   protected int quantidade;   public Produto(String d,int q)   {   descricao=d;   quantidade=q;   }   public String toString()   {   return new String(" "+descricao+" "+quantidade);   }   //forma preferida para impressao na tela   public void toSystemOut()    {   System.out.print(descricao + quantidade);   }   }    //Classe principal, Arquivo Principal.java   class Principal {   public static void main(String args[]) {   Produto ump=new Produto("macarrao", 100);    ump.toSystemOut();   System.out.println();   System.out.println(ump.toString());   }   }   **![img](https://www.ic.unicamp.br/~cmrubira/aacesta/java/images/result~2.gif)**     macarrao100   macarrao 100                                                        
```

**//COMENTARIOS**

O paradigma de orientação a objetos está refletido na capacidade de herança e encapsulamento das interfaces. No caso deste exemplo, a interface foi declarada como public, mas se nada fosse especificado ela pertenceria ao package dela, ou seja os modos de encapsulamentos são semelhantes aos de classes.

Uma **interface** poderia **estender** a **interface** Imprimivel:

interface Imprimivel2 extends Imprimivel {

}

Interfaces tem sido representadas por retângulos de bordas arredondadas ligadas as classes que as implementam por linhas tracejadas. 

Muitos confundem interfaces com classes e o ato de implementar uma interface com o ato de estender ou herdar uma classe. Por isso a relação entre interfaces e herança será explicada só agora, depois que você já pensou no assunto.

Uma classe Produto2 herda da classe Produto(nosso exemplo) que implementa a interface Imprimivel. A classe produto já fez a parte difícil que é implementar a interface, agora a classe Produto2 pode optar por aceitar ou redefinir os métodos herdados, ou seja: "A interface é um dos ítems que é herdado de uma classe, assim como os atributos e métodos".

**Exercícios:**

**1-**

Defina uma interface para um conjunto de classes que representam figuras geométricas que podem ser desenhadas na tela. 

### [PRÓXIMO MÓDULO DO TUTORIAL: POLIMORFISMO](https://www.ic.unicamp.br/~cmrubira/aacesta/java/javatut11.html)