/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import Interfaz.Inicio;

/**
 *
 * @author Douglas
 */
public class Hospital {
       private static String codigo_paciente;
       private static String codigo_persona;
       private static String codigo_cita;
       private static String codigo_paciente_cita;
       private static String codigo_consulta_paciente;
       private static String codigo_informe_paciente;
       private static String dpi;
       private static String dia_informe;
       private static String mes_informe;
       private static String ano_informe;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Inicio ver = new Inicio();
        ver.setVisible(true);
    }

    /**
     * @return the codigo_paciente
     */
    public static String getCodigo_paciente() {
        return codigo_paciente;
    }

    /**
     * @param aCodigo_paciente the codigo_paciente to set
     */
    public static void setCodigo_paciente(String aCodigo_paciente) {
        codigo_paciente = aCodigo_paciente;
    }

    /**
     * @return the codigo_persona
     */
    public static String getCodigo_persona() {
        return codigo_persona;
    }

    /**
     * @param aCodigo_persona the codigo_persona to set
     */
    public static void setCodigo_persona(String aCodigo_persona) {
        codigo_persona = aCodigo_persona;
    }

    /**
     * @return the codigo_cita
     */
    public static String getCodigo_cita() {
        return codigo_cita;
    }

    /**
     * @param aCodigo_cita the codigo_cita to set
     */
    public static void setCodigo_cita(String aCodigo_cita) {
        codigo_cita = aCodigo_cita;
    }

    /**
     * @return the codigo_paciente_cita
     */
    public static String getCodigo_paciente_cita() {
        return codigo_paciente_cita;
    }

    /**
     * @param aCodigo_paciente_cita the codigo_paciente_cita to set
     */
    public static void setCodigo_paciente_cita(String aCodigo_paciente_cita) {
        codigo_paciente_cita = aCodigo_paciente_cita;
    }

    /**
     * @return the codigo_consulta_paciente
     */
    public static String getCodigo_consulta_paciente() {
        return codigo_consulta_paciente;
    }

    /**
     * @param aCodigo_consulta_paciente the codigo_consulta_paciente to set
     */
    public static void setCodigo_consulta_paciente(String aCodigo_consulta_paciente) {
        codigo_consulta_paciente = aCodigo_consulta_paciente;
    }

    /**
     * @return the codigo_informe_paciente
     */
    public static String getCodigo_informe_paciente() {
        return codigo_informe_paciente;
    }

    /**
     * @param aCodigo_informe_paciente the codigo_informe_paciente to set
     */
    public static void setCodigo_informe_paciente(String aCodigo_informe_paciente) {
        codigo_informe_paciente = aCodigo_informe_paciente;
    }

    /**
     * @return the dpi
     */
    public static String getDpi() {
        return dpi;
    }

    /**
     * @param aDpi the dpi to set
     */
    public static void setDpi(String aDpi) {
        dpi = aDpi;
    }

    /**
     * @return the dia_informe
     */
    public static String getDia_informe() {
        return dia_informe;
    }

    /**
     * @param aDia_informe the dia_informe to set
     */
    public static void setDia_informe(String aDia_informe) {
        dia_informe = aDia_informe;
    }

    /**
     * @return the mes_informe
     */
    public static String getMes_informe() {
        return mes_informe;
    }

    /**
     * @param aMes_informe the mes_informe to set
     */
    public static void setMes_informe(String aMes_informe) {
        mes_informe = aMes_informe;
    }

    /**
     * @return the ano_informe
     */
    public static String getAno_informe() {
        return ano_informe;
    }

    /**
     * @param aAno_informe the ano_informe to set
     */
    public static void setAno_informe(String aAno_informe) {
        ano_informe = aAno_informe;
    }
    
}
