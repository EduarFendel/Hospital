package Interfaz;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Pacientes_3Test {
    
    public Pacientes_3Test() {
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
    public void testComboPadecimiento() {
        System.out.println("comboPadecimiento");
        Pacientes_3 instance = new Pacientes_3();
        instance.comboPadecimiento();
        if(instance==null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testComboAlergias() {
        System.out.println("comboAlergias");
        Pacientes_3 instance = new Pacientes_3();
        instance.comboAlergias();
        if(instance==null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testInsertarPadecimientoPaciente() {
        System.out.println("InsertarPadecimientoPaciente");
        String Codigo = "01";
        Pacientes_3 instance = new Pacientes_3();
        instance.InsertarPadecimientoPaciente(Codigo);
        if(Codigo==null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testInsertarAlergiaPaciente() {
        System.out.println("InsertarAlergiaPaciente");
        String Codigo = "10";
        Pacientes_3 instance = new Pacientes_3();
        instance.InsertarAlergiaPaciente(Codigo);
        if(instance==null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testCortadorPadecimiento() {
        System.out.println("cortadorPadecimiento");
        Pacientes_3 instance = new Pacientes_3();
        instance.cortadorPadecimiento();
        if(instance==null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testCortadorAlergia() {
        System.out.println("cortadorAlergia");
        Pacientes_3 instance = new Pacientes_3();
        instance.cortadorAlergia();
        if(instance==null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Pacientes_3.main(args);
        if(args!=null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
    
}
