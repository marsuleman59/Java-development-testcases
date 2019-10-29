package com.example.demo;

import java.io.File;
import java.io.FileFilter;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Java8Application {



	private File file = new File("C:\\Users\\marsu\\Documents");

/*	FileFilter fileFilter = new FileFilter() {
		@Override
		public boolean accept(File file) {

			return file.getName().endsWith(".java");
		}
	};*/

	FileFilter fileFilter = (File file) -> file.getName().endsWith(".java");

	File[] javaFiles = file.listFiles(fileFilter);

	private static Logger logger = LoggerFactory.getLogger(Java8Application.class);

	
	public static void main(String[] args)  {
		SpringApplication.run(Java8Application.class, args);
		logger.info(">>>> Java 8 application started successfully >>>>");
		Java8Application application = new Java8Application();
		Arrays.stream(application.javaFiles).forEach(file->System.out.println("***"+file));
		for (File file : application.javaFiles) {
			System.out.println(file);
		}


		List<String>  names = Arrays.asList(new String[]{"Suleman","Mohammed","Abdul","Rasheed","MARS"});
		String findName = "Suleman";
		boolean matchCase = names.stream().anyMatch(p -> p.equals(findName));
		System.out.println(findName+" : "+matchCase);

		Stream<String> names1 = Stream.of("Suleman","Mohammed","Abdul","Rasheed","MARS");
		Predicate<String> namesLengthFilter = (s -> s.endsWith("d"));
		names1.filter(namesLengthFilter).forEach(System.out::println);
		names.forEach(s-> System.out.println("Length of : "+s+ " is -> "+s.length()));

		String nameList;
		System.out.println(names.stream().filter(s -> s.length()<12).map(s -> s.toLowerCase()).collect(Collectors.joining(",")));
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		List<Integer> list2 = Arrays.asList(1,3,5,7);
		List<Integer> list3 = Arrays.asList(2,4,6);
		List<List<Integer>> lists = Arrays.asList(list1,list2,list3);

		Function<List<?>, Integer> sizeFunction = s-> s.size();
		Function<List<Integer>, Stream<Integer>> printFunction = s-> s.stream();


		lists.stream()
				.flatMap(printFunction)
				.forEach(System.out::println);

		Integer num =
		list1.stream().reduce(0,Integer::max);
		System.out.println("Sum is : "+num);
 	}

}

