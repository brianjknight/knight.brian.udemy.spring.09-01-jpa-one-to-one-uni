package knight.brian.spring.boot.cruddemo;

import knight.brian.spring.boot.cruddemo.dao.AppDAO;
import knight.brian.spring.boot.cruddemo.entity.Instructor;
import knight.brian.spring.boot.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 2;

		System.out.println("Deleting instructor ID: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Done deleting");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor for id: " + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("tempInstructor instructorDetails: " + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {
		// create instructorChad
		Instructor instructorChad = new Instructor(
				"Chad",
				"Darby",
				"darby@luv2code.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"http://www.luv2code.com/youtube",
				"Luv 2 Code");

		instructorChad.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructorChad: " + instructorChad);
		// save instructorChad which also saved InstructorDetail due to CascadeType.ALL
		appDAO.save(instructorChad);

		Instructor instructorMadhu = new Instructor(
				"Madhu",
				"Patel",
				"madhu@luv2code.com");

		InstructorDetail instructorDetailMadhu = new InstructorDetail(
				"http://www.luv2code.com/youtube",
				"Guitar");

		instructorMadhu.setInstructorDetail(instructorDetailMadhu);

		System.out.println("Saving instructorMadhu: " + instructorMadhu);
		// save instructorChad which also saved InstructorDetail due to CascadeType.ALL
		appDAO.save(instructorMadhu);

		System.out.println("Done saving!");


	}
}
