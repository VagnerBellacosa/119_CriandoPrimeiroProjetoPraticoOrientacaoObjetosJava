### [MÓDULO ANTERIOR DO TUTORIAL: POLIMORFISMO](https://www.ic.unicamp.br/~cmrubira/aacesta/java/javatut11.html)   

# 4. CONCEITOS AVANÇADOS 

Neste tópico apresentaremos conceitos avançados da linguagem, estes conceitos são importantes se você deseja criar softwares relativamente grandes em Java.

## 4.1. ATRIBUTOS STATIC

Até o momento só havíamos aprendido como definir atributos de instância. Cada objeto tinha seus próprios atributos e uma modificação nos atributos de um objeto não afetava os atributos de outros objetos.

Neste tópico iremos apreender como definir atributos de classe. Esses atributos são os mesmos para todos os objetos, eles são compartilhados. Uma mudança em um destes atributos é visível por todos os objetos instanciados. Atributos de classe também são chamados de atributos static.

Neste exemplo definiremos uma classe robo que usa atributos static para saber quantos robos foram criados (instanciados). Um outro uso de atributos static seria usar uma estrutura de dados que permitisse que um robo saber a posição(coordenadas) dos demais objetos de sua classe.

```

```

------

//Classe Robo

class Robo {

public int x;

public int y;

**public static int quantos; //quantos foram instanciados**

public Robo(int ax,int ay)

{

x=ax; y=ay;

**quantos++;**

}

}

------

------

//Classe principal, Arquivo Principal.java

class Principal {

public static void main(String args[]) {

**Robo.quantos=0; //inicializando a variavel static**

Robo cnc,cnc2;

System.out.println(Robo.quantos);

cnc=new Robo(10,12);

System.out.println(Robo.quantos);

cnc2=new Robo(11,12);

System.out.println(Robo.quantos);

} //main method

} //class Principal

------

```
             0 1 2                                                                           
```

//**COMENTARIOS**:

Quando definimos atributo static, estávamos nos referindo ao sentido geral de atributo. Apesar de termos exemplificado com um inteiro, você poderia ter usado uma classe no lugar desse atributo, tomando o cuidado de chamar new antes de usá-lo.

## 4.2. MÉTODOS STATIC 

Métodos static também são chamados de métodos de classes. Estes métodos só podem operar sobre atributos de classes. Nos já vínhamos usando estes métodos. Existem exemplos de chamadas de métodos static em nossos programas anteriores porque as packages da linguagem são repletas de exemplos de métodos static. Por este motivo eu escolhi uma das definições de métodos static da Java API (Sun Microsystems) para transcrever:

*abs(double). Static method in class java.lang.Math*

*Returns the absolute double value of a.*

Neste tópico não mostraremos um exemplo propriamente dito, apenas mostraremos como definir um método static, portanto é importante que você faça os exercícios.

Métodos static são definidos assim como atributos static:

public static int MDC(int a,int b) { //maximo divisor comum de a e b

}

No exemplo da classe Fracao (1.6.1TAD FRAÇÃO), tivemos que lidar com o método mdc. Este método não fazia muito sentido para o usuário desta classe, embora fosse necessário para fazer certas operações que envolviam simplificação de fração. Naquele momento nossa opção foi por implementar o método como private na própria classe Fracao. Alguém rigoroso poderia ter dito: "Você está errado, mdc não tem nada a ver com Fracao e eu vou implementá-lo em uma classe separada chamada ServicosMatematicos". A minha resposta a esta afirmação seria: "Acho sua idéia boa, mas sem o uso de métodos static na classe ServicosMatematicos, você vai ter que declarar um objeto da classe ServicosMatematicos dentro de cada Fracao para poder usar o método mdc."

**Exercícios**:

**1**-

Defina uma classe com métodos static que permite cálculos matemáticos como MDC, FATORIAL, COMBINAÇÕES(n,k), PERMUTAÇÕES, etc.

***2**-

Existe uma linguagem de programação chamada Logo que é muito usada no Brasil em escolas de primeiro e segundo grau. Nesta linguagem você pode programar os movimentos na tela de uma tartaruguinha ou cursor. Este cursor descreve movimentos riscando ou não a tela, dentre os movimentos descritos estão círculos, quadrados e sequências repetitivas (loops). Modifique seu objeto robo para apresentar alguns desses recursos. Crie então um programa que lê de um arquivo texto instruções para este objeto robo executar movimentos na tela.

Logo foi criada por um cientista de computação do MIT.

3-

Você pode desejar armazenar as informações da classe Robot em outra classe, que computa outros cálculos, neste caso temos pelo menos duas alternativas a seguir:

a)Crie uma classe auxiliar externa de armazenagem e para todos objetos robo instanciados passe o ponteiro desta classe auxiliar como argumento do construtor . Assim esses objetos poderão mandar mensagens para esta classe de armazenagem. Essas mensagens, chamadas de métodos, podem ter vários significados, num sentido figurado podemos ter algo parecido com: "Classe auxiliar, armazene essa informação para mim". "Classe auxiliar, me mande uma mensagem daqui a cinco segundos, estou passando o ponteiro para mim mesmo (this)" , etc. As mensagens vistas desse modo ficam mais interessantes, você pode até achar engraçado, mas é muito prático pensar assim.

4-

Em alguma classe que você criou anteriormente defina variáveis static com o seguinte objetivo: Contar, fazer estatísticas das chamadas de métodos da classe.

5-

Use o que foi aprendido sobre "static variables" no programa contas, o objetivo é armazenar informações sobre os movimentos de todas as contas num objeto static. Para que a modificação fique a contento você pode precisar tornar o exemplo mais próximo da realidade, adicionando no construtor de contas um argumento: número de conta. Comente se você usaria alocação dinâmica para essa classe de armazenagem agregada em conta, ou não. Tenha em mente a questão do tamanho em bytes do objeto.

## 4.3. TRATAMENTO DE EXCEÇÕES 

Se os conceitos de orientação a objetos dados até agora fossem suficientes para modelar qualquer atividade ou objeto do mundo real, todos os problemas de programação estariam resolvidos. Ocorre que o mundo real é bem mais complexo que seu programa pode ser. Nem todos os objetos e iterações entre eles podem ser modelados ou previstos. Os mecanismos de tratamento de exceções se encaixam justamente nessa lacuna.

O modelo de tratamento de exceções adotado por Java é muito semelhante ao de C++. Se você já teve alguma experiência com tratamento de exceções, este tópico será bastante fácil.

### 4.3.1. TRATANDO AS EXCEÇÕES GERADAS POR TERCEIROS

Tratamento de exceções permite lidar com as condições anormais de funcionamento de seu programa. Fazer uso deste recurso tornará seu software mais robusto, seguro e bem estruturado. São exemplos de condições anormais: acesso a um índice inválido de um vetor, tentativa de uso de um objeto não inicializado, falha na transferência de uma informação, uma falha não prevista, etc.

Sem as facilidades oferecidas pela linguagem seria muito difícil lidar com essas condições anormais, isto pode ser observado nos deficientes meios de tratamento de erros usados em linguagens que não fornecem "exception handling".

Java é uma linguagem que faz forte uso do conceito de tratamento de exceções. Em algumas linguagens que implementam tratamento é perfeitamente possível programar sem usar esse recurso, mas em Java não. Isto pode ser comprovado pela necessidade de alguns blocos de código try {} catch {} em programas anteriores.

Um dos motivos de o programador Java ter que saber tratamento de exceções é que os métodos de classes definidas na linguagem podem gerar exceções e na maioria das vezes o compilador nos obriga a escrever tratadores (blocos try{} catch{}) para chamadas destes métodos.

Quando você for estruturar seu código dessa forma, haverão duas ações básicas que devem ser tomadas: levantar (jogar) uma exceção e tratar uma exceção. Uma exceção será levantada quando for verificada uma condição anormal de funcionamento do programa, então o método que esta sendo executado é imediatamente terminado e o controle passa para o método que o chamou, onde pode ocorrer um tratador da exceção ou não. Se ocorrer um tratador, na maioria dos casos a exceção para de se propagar ali mesmo. Se não ocorrer um tratador outras chamadas de métodos são "desfeitas", encerradas, podendo culminar no término do programa se toda a cadeia de chamada de métodos for desfeita até chegar em main sem que se ache um tratador para esta exceção. Existem vários modelos de tratamento de exceções, o modelo adotado por Java recebe o nome de: "termination model", justamente por essas terminações de métodos.

Mas o que é uma jogar uma exceção? É suspender a execução do método atual e passar um objeto para o bloco catch mais próximo na cadeia de chamadas de métodos atual. Isto é feito através da declaração:

throw nomedoobjeto; //ou throw new nomedaclassedoobjeto(argumentos do construtor)

throw é como um break para métodos.

Como exceções são objetos, você pode definir hierarquias de classes de exceções, que mapeiem em termos de informações as condições anormais de seu programa contendo as mensagens de erro e as possíveis soluções

As exceções geradas pela linguagem pertencem a uma hierarquia cujo topo é a classe Throwable, imediatamente estendida por Error e Exception. Neste exemplo você verá que os tratadores de exceção são escolhidos comparando a classe da exceção jogada e a classe de exceções que o tratador diz tratar. Assim sendo o tratador:

try{ /*algo que possa gerar uma excecao*/}

catch (**Exception** erro) { /* acoes de tratamento do erro com possivelmente nova tentativa de execucao dos metodos chamados*/ }

Seria capaz de tratar todas as exceções que estejam abaixo de Exception (na hierarquia) geradas em try { }. Dispondo mais de um tratador (bloco catch) em seqüência onde os primeiros só tratam as classes exceções mais baixas da hierarquia, é possível escolher que código de tratamento usar com cada tipo de exceção gerada.

Por sorte, das exceções levantadas pela linguagem, você como programador só precisará tratar as da hierarquia de Exception. Neste exemplo iremos forçar o acontecimento da exceção ArrayIndexOutOfBoundsException, através de uma tentativa de acesso a um índice inválido de um vetor:

```
           Acesso a índice inválido do vetor sem corromper o sistema.
```

------

//Classe principal, Arquivo Principal.java

class Principal {

public static void main(String args[]) {

int a[]=new int[4];

try {

a[4]=10;

//linha acima gera excecao, os indices validos sao quatro:0,1,2,3

//qualquer codigo escrito aqui (depois de a[4]=10;)

//nunca sera executado

}

catch(Exception ae) {

//refaz a pergunta do indice a acessar ao usuario

//e descrobre que ele queria acessar o indice 3 e escrever 12

a[3]=12;

}

System.out.println(a[3]);

}

}

------

```
12                                                                              
```

//**COMENTARIOS**:

O fato do código imediatamente após o ponto onde foi gerada a exceção não ser executado te preocupa? Você gostaria por exemplo de ter uma chance de liberar recursos do sistema (ex..:fechar um arquivo) antes do método ser terminado? É para isso que existe em Java o bloco try{ } catch{} finally{} que não existe em C++, mas existe por exemplo em Modula-3.

A cláusula finally{ } é opcional, seu código vai ser executado ocorra ou não ocorra uma exceção no bloco try{} .

Exemplo clássico de uso do bloco try{} catch{} finally {}:

**try {**

//abre um arquivo

//gera uma excecao com arquivos

**}**

**catch (ExcecaoArquivo e){**

//tenta recuperar aquivo e informacoes perdidas

**}**

**finally {**

arquivo.close();

**}**

finally tem sido usado para fechar arquivos, parar threads e descartar janelas.

**Exercícios**:

1-

Em vários dos programas anteriores mencionamos que haveria uma maneira melhor de tratar situações anormais. Um desses programas era o do tipo abstrato de dados matriz. Leia este programa e adicione tratamento de exceções para as condições anormais que podem surgir, tais como acesso a índices inválidos. Complemente este exercício após ter lido os tópicos seguintes.

### 4.3.2. GERANDO SUAS PRÓPRIAS EXCEÇÕES

O exemplo a seguir ensina como trabalhar com throw, a palavra chave usada para levantar exceções. Este exemplo se baseia na classe Fracao de 1.6.1 TAD FRAÇÃO. Nossa exceção será gerada quando nas operações de frações ocorrer uma divisão por zero.

Em Java, exceções são instâncias de classes que pertencem a hierarquia que é iniciada, encabeçada, pela classe Throwable. Neste exemplo construiremos nossa exceção herdando de Exception que por sua vez herda de Throwable.

```

```

------

public class DivisaoPorZero **extends Exception**

{

public String info;

public DivisaoPorZero(String i)

{

info=i;

}

}

Você deve modificar a classe Fracao apresentada anteriormente na página 71, para aceitar o seguinte método:

public Fracao divisao(Fracao j) **throws** **DivisaoPorZero**

{

Fracao g;

if (j.den==0) **throw new DivisaoPorZero("Na classe Fracao");**

//se for zero a execucao nao chega aqui

g=new Fracao(num*j.den,den*j.num);

return g;

}

------

------

class Principal {

public static void main(String args[])

{

Fracao a,b,c;

a=new Fracao(5,3);

b=new Fracao(2,0);

System.out.print("Esta e' a fracao a: ");

a.mostra();

System.out.print("Esta e' a fracao b: ");

b.mostra();

**try {**

c=a.divisao(b);

c.mostra();

**}**

**catch(DivisaoPorZero minhaexcecao)**

**{**

System.out.println("Nao posso dividir por zero");

**}**

}

}

------

```
             Esta e' a fracao a: (5/3) Esta e' a fracao b: (1/0) Nao posso dividir por zero  
```

//**COMENTARIOS**

Nós não apresentamos um exemplo de uma exceção propagando em uma cadeia longa de chamadas de métodos. Mas com os conhecimentos dados, você pode fazer isso.

Outro fato importante é que um bloco catch também pode gerar exceções, assim se você pegou uma exceção e resolveu que não consegue tratá-la você pode fazer um throw dela mesma ou mudar a classe da exceção e continuar propagando (throw de outra exceção), ou fazer o que você pode para reparar o erro e jogar uma exceção para que o que você fez seja completado por outros métodos. Lembre-se que se você pegou uma exceção, ela para de propagar.

**Exercícios:**

1-

Implemente, tratamento de exceções completo para o exemplo de 1.6.1 TAD FRAÇÃO. Antes faça um levantamento das exceções que podem ser geradas, lembre das restrições matemáticas para o denominador em uma divisão. Leve em conta também o overflow de variáveis int que são uma representação com número de bits finito da sequência dos números inteiros (conjunto Z da matemática). Compare este tratamento com o de outros programas por exemplo na divisão por zero, quais as vantagens que você pode apontar e as desvantagens?

## 4.4. THREADS

threads são fluxos de execução que rodam dentro de um processo (aplicação). Normalmente os threads compartilham regiões de memória, mas não necessariamente. Lembre-se de encapsulamento. Processos, os avós dos threads permitem que o seu sistema operacional execute mais de uma aplicação ao mesmo tempo enquanto que threads permitem que sua aplicação execute mais de um método ao mesmo tempo.

Todos os programas que fizemos até agora só tinham um único caminho, fio, fluxo, de execução. Nenhum deles executava duas coisas (dois pedaços de código) simultaneamente. Grande parte do software de qualidade escrito hoje faz uso de mais de uma linha de execução, mais de um thread. São os chamados programas multithreaded.

O seu browser de hipertexto consegue fazer o download de vários arquivos ao mesmo tempo, gerenciando as diferentes velocidades de cada servidor e ainda assim permite que você continue interagindo, mudando de página no hipertexto enquanto o arquivo nem foi carregado totalmente? Isto não seria possível sem o uso de threads.

O seu editor de textos permite que você vá editando o começo do arquivo, enquanto ele está sendo carregado do disco? Editar e carregar do disco são atividades que não podem ser intercaladas de maneira simples em um pedaço de código. Seu editor está usando threads, essas atividades estão sendo feitas em paralelo.

Se sua máquina só possui um processador, esse paralelismo é um falso paralelismo. O processador tem seu tempo dividido em pequenos intervalos, em cada intervalo ele executa uma das atividades e você tem a sensação de que tudo está funcionando ao mesmo tempo, simultaneamente. Se você é um felizardo e sua máquina têm mais de um processador, então seu ambiente será capaz de mapear seus threads em hardware e você terá realmente processamento paralelo.

Se você olhar a tradução de threads no dicionário é até capaz que você encontre um desenho de um carretel de linha ou da rosca de um parafuso, este nome é bastante feliz. Imagine que seu programa é composto por várias linhas de execução que funcionam em paralelo (algumas vezes estas linhas podem se juntar, outras se dividir). Cada linha de execução cuida de uma tarefa: transferir um arquivo, tratar a entrada do usuário, mostrar sua janela na tela, etc.

threads é uma invenção recente se comparada com o restante da linguagem. Algumas outras linguagens (bem poucas) fornecem facilidades para lidar com threads, exemplo: Modula-3.Também conhecidos como lightweight processes, threads são um recurso extremamente difícil de se implementar, de modo que é possível dizer que ou seu ambiente de programação oferece facilidades para lidar com eles, ou você não vai querer implementá-los/usá-los.

### 4.4.1. CRIANDO THREADS USANDO INTERFACES OU HERANÇA

Existem duas maneiras básicas de criar threads em Java, usando interfaces e usando herança. Usando herança, sua classe já é um thread (is a relationship), que quando tiver seu método start() chamado vai executar tudo o que estiver no método run() em paralelo.

Usando interfaces, você define uma classe cujo método run() vai ser executado por um thread.

#### 4.4.1.1. HERANÇA USADA PARA CRIAR THREADS

```
Se você quer ter uma idéia do que vai acontecer no programinha      

                       deste exemplo, veja o desenho acima. Nós faremos uma corrida de Threads: A    

                       e B. Eles serão iniciados depois que o programa principal (main)         

                       começar. A sai com alguma vantagem pois é iniciado primeiro, depois      

                       sai B. A cada loop estes Threads são obrigados a fazer uma pausa por     

                       um intervalo aleatório até completarem 4 loops: 0,1,2,3,4.      No       

                       final, pedimos ao programa principal que espere os Threads terminarem    

                       seus ciclos para se juntar a eles (método join() da classe thread).O     

                       método join não retorna enquanto o seu threads não terminar.             

                       Existem uma série de outras primitivas para lidar com Threads: pausa.    

                       parada, retorno a execução, etc. Não explicaremos todas aqui. Você       

                       deve fazer leituras complementares, é isso que temos aconselhado.        

                       Agora estas leituras podem ser mais técnicas, tipo guias de              

                       referência, uma vez que nós já fizemos a introdução do assunto.          

                       Alguns assuntos, a exemplo de Threads exigem um conhecimento teórico     

                       forte, de modo que também aconselhamos que você adquira um livro sobre   

                       programação concorrente.                                                 

                                                                                                



                                                                                             
```

------

public class MeuThread **extends Thread** {

public MeuThread(String nome)

{

super(nome);

}

public void run() // o metodo que vai ser executado no thread tem sempre nome run

{

for (int i=0; i<5; i++) {

System.out.println(getName()+ " na etapa:"+i);

try {

sleep((int)(Math.random() * 2000)); //milisegundos

} catch (InterruptedException e) {}

}

System.out.println("Corrida de threads terminada:" + getName());

}

}

------

------

class CorridaThreads

{

public static void main (String args[])

{

**MeuThread a,b;**

**a=new MeuThread("Leonardo Xavier Rossi");**

**a.start();**

**b=new MeuThread("Andre Augusto Cesta");**

**b.start();**

try {**a.join();** } catch (InterruptedException ignorada) {}

try {**b.join();** } catch (InterruptedException ignorada) {}

}

}

------

```
 thread A    Leonardo Xavier Rossi na etapa:0 Andre Augusto Cesta na etapa:0 Andre Augusto   

thread B      Cesta na etapa:1 Leonardo Xavier Rossi na etapa:1 Andre Augusto Cesta na        

              etapa:2 Leonardo Xavier Rossi na etapa:2 Leonardo Xavier Rossi na etapa:3       

              Andre Augusto Cesta na etapa:3 Andre Augusto Cesta na etapa:4 Corrida de        

              threads terminada:Andre Augusto Cesta Leonardo Xavier Rossi na etapa:4          

              Corrida de threads terminada:Leornardo Xavier Rossi                             
```

#### 4.4.1.2. INTERFACES USADAS PARA CRIAR THREADS 

Colocar sua classe abaixo da classe Threads em uma hierarquia, as vezes é um preço muito grande para ter um método dela rodando em um Thread. É por isso que Threads pode ser criados usando interfaces. Você só tem que dizer que implementa a interface Runnable, que é composta do método run(). Quando um Thread é construído usando como argumento uma classe que implementa a interface Runnable, chamar o método start para este thread faz com que o método run() de nossa classe comece a ser executado neste thread paralelo.

```

```

------

public class RodemeEmUmThread **implements Runnable** {

public String str; //nome do objeto que vai ter o metodo run rodado em um

//thread

public RodemeEmUmThread(String nome)

{

str=nome;

}

public void run()

{

for (int i=0; i<5; i++) {

System.out.println(str+ " na etapa:"+i);

}

//As mensagens de corrida terminada poderiam se postas aqui.

}

}

------

------

class ThreadsRodadores

{

public static void main (String args[])

{

**Thread a,b;**

**RodemeEmUmThread leo,andre;**

**leo=new RodemeEmUmThread("Leonardo Xavier Rossi");**

**andre=new RodemeEmUmThread("Andre Augusto Cesta");**

**a=new Thread(leo);**

**a.start();**

**b=new Thread(andre);**

**b.start();**

try { **a.join();** } catch (InterruptedException ignorada) { }

//espera thread terminar seu metodo run

try { **b.join();** } catch (InterruptedException ignorada) { }

}

}

------

```
 thread A    Leonardo Xavier Rossi na etapa:0 Andre Augusto Cesta na etapa:0 Andre Augusto   

thread B      Cesta na etapa:1 Leonardo Xavier Rossi na etapa:1 Andre Augusto Cesta na        

              etapa:2 Leonardo Xavier Rossi na etapa:2 Leonardo Xavier Rossi na etapa:3       

              Andre Augusto Cesta na etapa:3 Leonardo Xavier Rossi na etapa:4 Andre Augusto   

              Cesta na etapa:4                                                                
```

**Exercícios:**

**1-**

As tarefas de transpor uma matriz ou fazer o "espelho" de uma imagem (que pode ser representada por uma matriz) são exemplos fáceis de tarefas que podem ser divididas em dois ou mais Threads. É lógico que aqui estaremos buscando tirar vantagem da possível existência de mais de um processador e também buscando liberar o Thread principal dessa computação, para que ele possa fazer outras atividades antes do join().

Escolha uma dessas tarefas e implemente-as usando Threads. Dica: os Threads devem ser construídos de modo a conter a referência para a matriz que vai armazenar o resultado, a referência para a matriz original e os valores que indicam em que área da matriz este Thread deve trabalhar. Por exemplo: no caso da inversão da imagem um Thread trabalharia em uma metade e o outro na outra metade.

Seria interessante imprimir na tela os instantâneos da matriz resultado para você ver o trabalho sendo feito em paralelo.

### 4.4.2. PENSANDO MULTITHREADED

Este tópico discute alguns dos problemas que podem surgir quando lidando com threads e apresenta algumas das soluções da linguagem. Neste volume não nos aprofundaremos muito em threads, mas no segundo e terceiro volume, este conceito será necessário e não voltaremos a dar as explicações teóricas dadas aqui.

Existe um exemplo clássico dos problemas que podem acontecer quando você está usando concorrência. Imagine que você tem um programa que lê dados em bytes de algum lugar (teclado/disco) e os transmite via rede. Você decidiu usar threads porque não quer ficar com um programa de um único fluxo de execução bloqueado porque está esperando o teclado ou o disco enquanto poderia estar tentando transmitir parte de seu buffer pela rede.

Para tal você dividiu o seu programa em dois threads que ficam repetindo o mesmo conjunto de ações:

Thread A, Enfileirando valores do teclado (Leitura):

1-Lê valor do fonte.

2-Consulta o número de elementos da fila.

3-Soma um a esse número.

4-Enfilera o valor lido.

Thread B, Desenfileirando os valores (E escrevendo-os na saída):

1-Consulta o tamanho da fila se for maior que zero executa próximo passo

2-Retira elemento da fila.

3-Decrementa contador de elementos.

Os seus threads podem não rodar em intervalos definidos, regulares de tempo. Alguns problemas podem surgir pois a mesma região de memória é acessada por dois fluxos de execução distintos que podem ter executados apenas alguns de seus "passsos":

```
public class ThreadA {                                            public class ThreadB {        

//Leitura   while                                                 //Escrita  while              

(!fimLeitura)   {                                                 (!fimEscrita)  {              

EnfileraUm();    } }                                              Escreve(DesenfileraUm());     

                                                                  } }                           



                                                                                              

         Thread A               Atributo No            Fila:                Thread B            

                                 elementos                                                      

                                     3            >-[D]-[R]-[O]->                            .  

1-Consulta No                        3            >-[D]-[R]-[O]->                            .  

elementos-----                                                                                  

2-Incrementa No                      4            >-[D]-[R]-[O]->                               

elementos--                                                                                     

.                                    4            >-[D]-[R]-[O]->     -----Consulta tamanho da  

                                                                                        fila-3  

.                                    4            >-[D]-[R]->             -----------Retira um  

                                                                                    elemento-4  

.                                    3            >-[D]-[R]->                 ---Decrementa No  

                                                                                   elementos-5  

.                                    3            >-[D]-[R]->                                .  

                                                                                              
```

A sequência de operações **1,2,3,4,5** corrompe o estado de sua estrutura de dados. Se um só thread estivesse executando sobre a mesma estrutura, ainda assim poderiam também haver momentos em que o atributo número de elementos não reflete exatamente quantos estão na fila, mas isso logo seria consertado. Só que com dois threads, um outro thread pode usar essa informação inconsistente sem que haja tempo para ela ser reparada. Seu programa pode falhar quando você tentar retirar um elemento de uma fila vazia.

Alguns dos passos dos programas acima podem ser divididos em passos menores, mas o que importa nesse exemplo é que sem o uso dos recursos específicos da linguagem é impossível tornar este programa seguro. O ideal para este nosso exemplo seria que um Thread tivesse que esperar um ciclo do outro Thread terminar para iniciar o seu próximo ciclo e vice versa, ou seja os ciclos teriam que ser sincronizados, ocorrer um após o outro, podendo intercalar ciclos do Thread A com ciclos do Thread B, mas não pedaços desses ciclos. Em casos assim , costuma dizer que cada ciclo compõe um conjunto de ações indivisível.

Agora que você já sabe a solução, basta saber como implementá-la. Os métodos EnfileraUm(); e DesenfileraUm(); devem ser especificados como sincronizados. Evite especificar métodos muito grandes como sincronizados, pois outros Threads terão que esperar muito tempo para começar a executar.

public synchronized void EnfileraUm(byte a) {

//esta parte voce ja sabe

}

public synchronized Byte DesenfileraUm() {

//Byte e uma classe wrapper, ela e igual a null se nao ha elementos

//o restante voce ja sabe

}

Agora sua classe é segura. Você só deve se preocupar com a sincronização dos métodos do seu programa. Os métodos e as classes da linguagem já são escritos para serem "Thread safe", o que gerou muito trabalho para os programadores do "Java team".

**//COMENTARIOS**

Acabamos agora o tópico sobre threads e também o primeiro volume. Antes de você começar a ler o segundo volume, um comentário final: Se você quiser rodar um método de uma classe já pronta em um thread, lembre-se de colocá-lo (a sua chamada) dentro de um método com o nome run().

### [PRÓXIMO MÓDULO DO TUTORIAL: BIBLIOGRAFIA](https://www.ic.unicamp.br/~cmrubira/aacesta/java/BIBLIO.html)