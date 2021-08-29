package one.digitalinnovation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import one.digitalinnovation.dominio.Bootcamp;
import one.digitalinnovation.dominio.Conteudo;
import one.digitalinnovation.dominio.Curso;
import one.digitalinnovation.dominio.Dev;
import one.digitalinnovation.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		Curso cursoJavaBasico = new Curso();
		cursoJavaBasico.setTitulo("Java B�sico");
		cursoJavaBasico.setDescricao("Aprenda os conceitos b�sicos sobre Java.");
		cursoJavaBasico.setCargaHoraria(8);
		
		Curso cursoDotNet = new Curso();
		cursoDotNet.setTitulo("Java .NET");
		cursoDotNet.setDescricao("Aprenda os conceitos b�sicos sobre C#.");
		cursoDotNet.setCargaHoraria(8);
		
		Curso cursoJavaAvancado = new Curso();
		cursoJavaAvancado.setTitulo("Java Avan�ado");
		cursoJavaAvancado.setDescricao("Aprenda os conceitos avan�ados sobre Java.");
		cursoJavaAvancado.setCargaHoraria(8);
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Aprendendo Orienta��o a Objetos com Java");
		mentoria.setDescricao("Imers�o sobre os pilares da Orienta��o a Objetos.");
		mentoria.setData(LocalDateTime.now());
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("GFT START #2 Java");
		bootcamp.setInicio(LocalDate.now());
		bootcamp.setFim(bootcamp.getInicio().plusDays(45));
		List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJavaBasico, cursoJavaAvancado, mentoria);
		bootcamp.setConteudos(conteudosBootcamp);
		
		Dev felipao = new Dev();
		felipao.setNome("Felip�o");
		
		Dev venilton = new Dev();
		venilton.setNome("Venilton");
		
		felipao.inscrever(cursoDotNet);
		felipao.inscrever(bootcamp);
		felipao.progredir();
		felipao.progredir();
		
		venilton.inscrever(bootcamp);
		venilton.progredir();
		venilton.progredir();
		venilton.progredir();

		System.out.println(String.format("XP Felip�o: %.2f", felipao.calcularTotalXp()));
		System.out.println(String.format("XP Venilton: %.2f", venilton.calcularTotalXp()));
		
		List<Dev> ranking = Arrays.asList(felipao, venilton).stream()
								  .sorted((dev1, dev2) -> Double.compare(dev2.calcularTotalXp(), dev1.calcularTotalXp()))
								  .collect(Collectors.toList());
		
		for (Dev dev : ranking) {
			System.out.println(dev.getNome());
		}
	}

}
