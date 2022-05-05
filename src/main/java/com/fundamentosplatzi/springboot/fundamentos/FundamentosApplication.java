package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.*;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
    //	lo que se va a inyectar (segregar) es la interfaz
	//  Agrego las interfaces
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyFirstBeanAlone myFirstBeanAlone;
	private MyFirstBeanAloneWithDependency myFirstBeanAloneWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository; //inyectar dependencia
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyFirstBeanAlone myFirstBeanAlone,
								  MyFirstBeanAloneWithDependency myFirstBeanAloneWithDependency, MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myFirstBeanAlone = myFirstBeanAlone;
		this.myFirstBeanAloneWithDependency = myFirstBeanAloneWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo; //inyectando nuestra dependencia
		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

    /** implementacion */
	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores()
		saveUsersInDataBase();
	}

	private void saveUsersInDataBase(){
		User user1 = new User("Bryan", "bryan@domain.com", LocalDate.of(2022, 02,22));
		User user2 = new User("Maria", "maria@domain.com", LocalDate.of(2022, 02,22));
		User user3 = new User("Kimbo", "kimbo@domain.com", LocalDate.of(2022, 03,22));
		User user4 = new User("user4", "user4@domain.com", LocalDate.of(2022, 04,22));
		User user5 = new User("user5", "user5@domain.com", LocalDate.of(2022, 05,22));
		User user6 = new User("user6", "user6@domain.com", LocalDate.of(2022, 06,22));
		User user7 = new User("user7", "user7@domain.com", LocalDate.of(2022, 8,22));
		User user8 = new User("user8", "user8@domain.com", LocalDate.of(2022, 9,22));
		User user9 = new User("user9", "user9@domain.com", LocalDate.of(2022, 10,22));
		User user10 = new User("user10", "user10@domain.com", LocalDate.of(2022, 11,22));
		User user11 = new User("user11", "user11@domain.com", LocalDate.of(2022, 12,22));
		User user12 = new User("user12", "user12@domain.com", LocalDate.of(2022, 9,22));

		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
		list.stream().forEach((userRepository::save));
	}
	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myFirstBeanAlone.union_characters("[estoy uniendo esto, Genial!!]"));
		myFirstBeanAloneWithDependency.unionNumberCharacter(50);
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword() + " - " + userPojo.getAge() );
		try {
			//error
			int value = 10/0;
			LOGGER.debug("Mi valor: " + value);

		} catch (Exception e){
			LOGGER.error("Esto es un error del aplicativo al dividir por cero " + e.getMessage());
		}

	}
}
