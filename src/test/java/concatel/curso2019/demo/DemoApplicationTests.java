package concatel.curso2019.demo;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class DemoApplicationTests {   //test suite

	@BeforeClass
	public static void beforeClass(){
		System.out.println("before class!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

	}
	@Before
	public void beforeMethod(){
		System.out.println("before method!!!!!!!!!!!!!!!!!!!!!!!!!");

	}
	@AfterClass
	public static void afterClass(){
		System.out.println("after class!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

	}
	@After
	public void afterMethod(){
		System.out.println("after method!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

	}


	@Test //test case
	public void contextLoads() {
	}

	@Test //test case calculo_saldo_entrada_mayor_100
	public void calculo_saldo_entrada_mayor_100() {  // calculo_saldo_entrada_mayor_100
	}

	@Test(expected = Exception.class) //test case calculo_saldo_entrada_mayor_100_erronea
	public void calculo_saldo_entrada_mayor_100_erronea() throws Exception {  // calculo_saldo_entrada_mayor_100_erronea
		throw new Exception();
	}

	@Test(timeout = 50) //test case calculo_saldo_tiempo_max
	public void calculo_saldo_tiempo_max() throws InterruptedException {
		Thread.sleep(25);
	}

}
