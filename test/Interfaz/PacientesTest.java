package Interfaz;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PacientesTest {
    
    public PacientesTest() {
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
    public void testInsertarPersona() {
        System.out.println("InsertarPersona");
        String dpi = "123";
        Pacientes instance = new Pacientes();
        instance.InsertarPersona(dpi);
        if(dpi == null){
           fail("The test case is a prototype."); 
        }   
    }

    @Test
    public void testCodigoPersona() {
        System.out.println("CodigoPersona");
        String dpi = "123";
        Pacientes instance = new Pacientes();
        String expResult = "123";
        String result = instance.CodigoPersona(dpi);
        assertEquals(expResult, result);
        if(result!= expResult){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testInsertarInfoAdicional() {
        System.out.println("InsertarInfoAdicional");
        String CodigoPersona = "123";
        Pacientes instance = new Pacientes();
        instance.InsertarInfoAdicional(CodigoPersona);
        if(CodigoPersona == null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testLlenarInfoAdicional() {
        System.out.println("LlenarInfoAdicional");
        String codigo_persona = "123";
        Pacientes instance = new Pacientes();
        instance.LlenarInfoAdicional(codigo_persona);
        if(codigo_persona == null){
            // TODO review the generated test code and remove the default call to fail.
           fail("The test case is a prototype."); 
        }               
    }

    @Test
    public void testLimpiar() {
        System.out.println("Limpiar");
        Pacientes instance = new Pacientes();
        instance.Limpiar();
        if(instance == null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }        
    }

    @Test
    public void testBloquear() {
        System.out.println("Bloquear");
        Pacientes instance = new Pacientes();
        instance.Bloquear();
        if(instance == null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } 
    }

    @Test
    public void testModificar() {
        System.out.println("Modificar");
        Pacientes instance = new Pacientes();
        instance.Modificar();
        if(instance == null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } 
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Pacientes.main(args);
        if(args != null){
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }        
    }
    
}
