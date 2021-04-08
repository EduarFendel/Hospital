package Interfaz;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Pacientes_2Test {
    
    public Pacientes_2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInsertarPaciente() {
        System.out.println("InsertarPaciente");
        Pacientes_2 instance = new Pacientes_2();
        instance.InsertarPaciente();
        if(instance == null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }  
    }

    @Test
    public void testCodigoPaciente() {
        System.out.println("CodigoPaciente");
        Pacientes_2 instance = new Pacientes_2();
        instance.CodigoPaciente();
        if(instance == null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testInsertarReferencia() {
        System.out.println("InsertarReferencia");
        Pacientes_2 instance = new Pacientes_2();
        instance.InsertarReferencia();
        if(instance == null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testBloquear() {
        System.out.println("Bloquear");
        Pacientes_2 instance = new Pacientes_2();
        instance.Bloquear();
        if(instance == null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Pacientes_2.main(args);
        if(args != null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
    
}
