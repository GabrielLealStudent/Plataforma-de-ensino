package applications;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Lesson> list = new ArrayList<>();

		int sum = 0;

		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.printf("Dados da %da aula:%n", i + 1);
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();

			System.out.print("Título: ");
			String title = sc.nextLine();

			if (ch == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();

				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();

				list.add(new Video(title, url, seconds));
			} else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();

				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();

				list.add(new Task(title, description, questionCount));
			}
			System.out.println();

		}

		for (Lesson less : list) {
			sum += less.duration();
		}
		
		System.out.printf("DURAÇÃO TOTAL DO CURSO = %d segundos", sum);

		sc.close();

	}

}
