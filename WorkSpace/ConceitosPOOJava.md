# Conceitos de POO em Java

Nesta página, aprenderemos sobre o básico de POO. A Programação Orientada a Objetos é um paradigma que fornece muitos conceitos, como **herança, data binding** (ligação de dados), **polimorfismo**, etc.

**Simula** é considerada a primeira linguagem de programação orientada a objetos. O paradigma de programação em que tudo é representado como um objeto é conhecido de verdade como uma linguagem de programação orientada a objetos.

O **Smalltalk** é considerado a primeira linguagem de programação orientada a objetos.

As linguagens orientadas a objetos populares são Java, C#, PHP, Python, C++, etc.

O principal objetivo da programação orientada a objetos é implementar entidades do mundo real, por exemplo, objeto, classes, abstração, herança, polimorfismo, etc.

## POO (Programação Orientados a Objetos)

**Objeto** (Object) significa uma entidade do mundo real, como caneta, cadeira, mesa, computador, relógio, etc. **Programação Orientada a Objetos** é uma metodologia ou paradigma para projetar um programa usando classes e objetos. Simplifica o desenvolvimento e a manutenção de software, fornecendo alguns conceitos:

- Objeto
- Classe
- Herança
- Polimorfismo
- Abstração
- Encapsulamento

Além desses conceitos, existem outros termos usados no design orientado a objetos:

- Acoplamento
- Coesão
- Associação
- Agregação
- Composição

![Java OOPs Concepts](https://static.javatpoint.com/images/java-oops.png)

### Object

![Java Object](https://static.javatpoint.com/images/objects.png)

Qualquer entidade que tenha estado e comportamento é conhecida como um objeto. Por exemplo, uma cadeira, caneta, mesa, teclado, bicicleta etc. Pode ser físico ou lógico.

Um objeto pode ser definido como uma instância de uma classe. Um objeto contém um endereço e ocupa algum espaço na memória. Os objetos podem se comunicar sem conhecer os detalhes dos dados ou código um do outro. A única coisa necessária é o tipo de mensagem aceita e o tipo de resposta retornada pelos objetos.

**Exemplo:** um cachorro é um objeto porque possui estados como cor, nome, raça, etc., além de comportamentos como abanar a cauda, latir, comer etc.

### Class

Uma coleção de objetos é chamada de classe. É uma entidade lógica.

Uma classe também pode ser definida como um blueprint a partir do qual você pode criar um objeto individual. A classe não consome nenhum espaço.

### Herança

Quando um objeto adquire todas as propriedades e comportamentos de um objeto pai, é conhecido como herança. Fornece reutilização de código. É usado para obter polimorfismo em tempo de execução.

### Polimorfismo

Se uma tarefa é executada de maneiras diferentes, é conhecida como polimorfismo. Por exemplo: para convencer o cliente de maneira diferente, para desenhar algo, por exemplo, forma, triângulo, retângulo etc.

Em Java, usamos sobrecarga de método e substituição de método para obter polimorfismo.

Outro exemplo pode ser falar alguma coisa; um gato mia, um cachorro late, etc.

![Polymorphism in Java](https://static.javatpoint.com/images/polymorphism.gif)

### Abstração

Ocultar detalhes internos e mostrar funcionalidade é conhecido como abstração. Por exemplo, telefonema, não sabemos o processamento interno.

Em Java, usamos classe e interface abstratas para obter abstração.

### Encapsulamento

![Encapsulation in Java OOPs Concepts](https://static.javatpoint.com/images/capsule.png)

Vincular (ou agrupar) código e dados em uma única unidade é conhecido como encapsulamento. Por exemplo, uma cápsula, é embalada com diferentes medicamentos.

Uma classe java é o exemplo de encapsulamento. Java bean é a classe totalmente encapsulada porque todos os membros de dados são privados aqui.

### Acoplamento

Acoplamento refere-se ao conhecimento, informação ou dependência de outra classe. Surge quando as classes se conhecem. Se uma classe possui informações detalhadas de outra classe, há um forte acoplamento. Em Java, usamos modificadores privados, protegidos e públicos para exibir o nível de visibilidade de uma classe, método e campo. Você pode usar interfaces para o acoplamento mais fraco, porque não há implementação concreta.

### Coesão

Coesão refere-se ao nível de um componente que executa uma única tarefa bem definida. Uma única tarefa bem definida é realizada por um método altamente coeso. O método pouco coeso dividirá a tarefa em partes separadas. O pacote java.io é um pacote altamente coeso, porque possui classes e interface relacionadas a E / S. No entanto, o pacote java.util é um pacote pouco coeso, porque possui classes e interfaces não relacionadas.

### Associação

Associação representa o relacionamento entre os objetos. Aqui, um objeto pode ser associado a um objeto ou a vários objetos. Pode haver quatro tipos de associação entre os objetos:

- Um a um
- Um para muitos
- Muitos para um e
- Muitos para muitos

Vamos entender o relacionamento com exemplos em tempo real. Por exemplo, um país pode ter um primeiro ministro (um a um) e um primeiro ministro pode ter muitos ministros (um a muitos). Além disso, muitos deputados podem ter um primeiro ministro (muitos para um) e muitos ministros podem ter muitos departamentos (muitos para muitos).

A associação pode ser unidirecional ou bidirecional.

### Agregação

A agregação é uma maneira de alcançar a associação. A agregação representa o relacionamento em que um objeto contém outros objetos como parte de seu estado. Representa o relacionamento fraco entre objetos. Também é denominado como um relacionamento has-a em Java. Assim, a herança representa o relacionamento é um. É outra maneira de reutilizar objetos.

### Composição

A composição também é uma maneira de obter associação. A composição representa o relacionamento em que um objeto contém outros objetos como parte de seu estado. Existe uma forte relação entre o objeto que contém e o objeto dependente. É o estado em que os objetos que contêm não têm uma existência independente. Se você excluir o objeto pai, todos os objetos filhos serão excluídos automaticamente.

### Vantagem de POO sobre linguagem de programação orientada a procedimentos

\1) POO facilita o desenvolvimento e a manutenção, enquanto que, em uma linguagem de programação orientada a procedimentos, não é fácil gerenciar se o código cresce à medida que o tamanho do projeto aumenta.

\2) POO fornece ocultação de dados, enquanto que, em uma linguagem de programação orientada a procedimentos, os dados globais podem ser acessados de qualquer lugar.

\3) POO fornece a capacidade de simular eventos do mundo real com muito mais eficiência. Nós podemos fornecer a solução do problema de palavras reais se estivermos usando a linguagem de programação orientada a objetos.

### Qual é a diferença entre uma linguagem de programação orientada a objetos e uma linguagem de programação baseada em objetos?

A linguagem de programação baseada em objetos segue todos os recursos da POO, exceto a Herança. JavaScript e VBScript são exemplos de linguagens de programação baseadas em objetos.





Você sabe?

- Podemos sobrecarregar o método principal?
- Um construtor Java retorna um valor, mas, o que?
- Podemos criar um programa sem o método principal?
- Quais são as seis maneiras de usar a palavra-chave this?
- Por que a herança múltipla não é suportada em Java?
- Por que usar agregação?
- Podemos substituir o método estático?
- Qual é o tipo de retorno covariante?
- Quais são os três usos da super palavra-chave Java?
- Por que usar o bloco inicializador de instância?
- Qual é o uso de uma variável final em branco?
- O que é um marcador ou interface marcada?
- O que é polimorfismo de tempo de execução ou despacho de método dinâmico?
- Qual é a diferença entre ligação estática e dinâmica?
- Como o downcasting é possível em Java?
- Qual é o propósito de um construtor privado?
- O que é clonagem de objetos?



O que aprenderemos nos conceitos de POO?

- Vantagem de POO
- Convenção de nomes
- Objeto e classe
- Sobrecarga de método
- Construtor
- palavra-chave static
- palavra-chave this com seis usos
- Herança
- Agregação
- Substituição de método
- Tipo de retorno
- palavra-chave super
- Bloco Inicializador de Instância
- palavra-chave final
- Classe abstrata
- Interface
- Polimorfismo de tempo de execução
- Ligação estática e dinâmica
- Downcasting com operador instanceof
- Pacote
- Modificadores de acesso
- Encapsulamento
- Clonagem de Objetos

------

Próximo tópico[Convenções de nomenclatura Java](https://www.javatpoint.com/pt/convenções-de-nomenclatura-java)