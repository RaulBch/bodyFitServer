/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author entrar
 */
@WebService(serviceName = "BodyFitWS")
@Stateless()
public class BodyFitWS {

    /**
     * Web service operation
     * @param altura
     * @param peso
     * @return 
     */
    @WebMethod(operationName = "calculoIMC")
    public Float calculoIMC(@WebParam(name = "altura") float altura, @WebParam(name = "peso") float peso) {
        Float calculoIMC = (peso/(altura*altura));
        return calculoIMC;
    }

    /**
     * Web service operation
     * @param imc
     * @return 
     */
    @WebMethod(operationName = "clasificacionIMC")
    public String clasificacionIMC(@WebParam(name = "imc") float imc) {
        
        String resultadoIMC;
        if(imc< 18.5) {
            resultadoIMC = "Infrapeso";
        } else if(imc< 25) {
            resultadoIMC = "Peso Normal";
        } else if(imc< 30) {
            resultadoIMC= "Sobrepeso";
        } else {
            resultadoIMC ="Obeso";
        }
        return resultadoIMC;
    }

    /**
     * Web service operation
     * @param lb
     * @return 
     */
    @WebMethod(operationName = "weightConverter")
    public Float weightConverter(@WebParam(name = "lb") float lb) {
        float kg = (float)(lb * 0.45);
        return kg;
    }

    /**
     * Web service operation
     * @param feet
     * @return 
     */
    @WebMethod(operationName = "HeightConverter")
    public Float HeightConverter(@WebParam(name = "feet") float feet) {
        //TODO write your implementation code here:
        float m = (float)(feet*0.3048);
        return m;
    }
}
