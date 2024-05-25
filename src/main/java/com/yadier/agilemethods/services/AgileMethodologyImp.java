package com.yadier.agilemethods.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yadier.agilemethods.models.Methodology;
import com.yadier.agilemethods.models.ResultMethod;



@Service
public class AgileMethodologyImp implements AgileMethodologyService {
	
    public static final String scrum = "Scrum";
    public static final String kanban = "Kanban";
    public static final String xp = "ExtremeProgramming";
    public static final String lean = "LeanStartup";
    public static final String crystal = "Crystal";
    
	@Override
	public ResultMethod chooseMethodology(Methodology methodology) {

		 Map<String, Integer> metodologias = new HashMap<>();
	      
	        metodologias.put(scrum, 0);
	        metodologias.put(kanban, 0);
	        metodologias.put(xp, 0);
	        metodologias.put(lean, 0);
	        metodologias.put(crystal, 0);
	        
	        String[] preguntas = {
	                "Naturaleza del Proyecto",
	                "Nivel de incertidumbre o cambios esperados durante el desarrollo",
	                "Tamaño del equipo de desarrollo",
	                "Posibilidad de colaboración cercana y continua con los interesados",
	                "Velocidad de entrega requerida para el producto final o las iteraciones",
	                "Experiencia previa del equipo en metodologías ágiles",
	                "Definición de requisitos",
	                "Nivel de autonomía y autoridad del equipo para tomar decisiones",
	                "Nivel de comunicación entre los miembros del equipo",
	                "Presupuesto disponible para el proyecto",
	                "Restricciones en cuanto a herramientas o recursos"
	                
	                };
	        
	        String[] respuestas = methodology.toStringArray();
	        for (int i = 0; i < preguntas.length; i++) {
	         //   System.out.println(preguntas[i]);
	            String respuesta = respuestas[i];
	         //   System.out.println(respuesta);
	            asignarPuntajes(metodologias,i, respuesta);
	        }
	       String metodologiaIdeal = seleccionarMetodologiaIdeal(metodologias);
	       try {

		        System.out.println("La metodología ideal para este proyecto es: " + metodologiaIdeal);
		       
	            Thread.sleep(1000); 
	        } catch (InterruptedException e) {
	            
	            e.printStackTrace();
	        }
	       return detalleMetodolgia(metodologiaIdeal);
	      
	}	
	
	public static ResultMethod detalleMetodolgia(String metodologia) {
		String nombre=null;
		String descripcion= null;
		String image= null; 
		String url=null;
		
		if(metodologia.equals(scrum)) {
			 nombre = "Scrum";
			  descripcion = "Scrum es una metodología centrada en equipos autogestionados y entregas incrementales.";
		        image = "/images/scrum1.png";
		        url = "/my-scrum";
		}
		
		else if(metodologia.equals(xp)) {
			 nombre = "Extreme Programming (XP)";
			  descripcion ="La metodología XP es un conjunto de técnicas que dan agilidad y flexibilidad en la gestión de proyectos. También es conocida como Programación Extrema (Extreme Programming) y se centra crear un producto según los requisitos exactos del cliente.";
		        image = "/images/extremeProgramming.png";
		        url = "/my-xp";
		}else 
		{
		nombre = "Scrum";
		  descripcion = "Scrum es una metodología centrada en equipos autogestionados y entregas incrementales.";
	        image = "/images/scrum1.png";
	        url = "/my-scrum";
		}
		
	
		 ResultMethod resultMethod = new ResultMethod(nombre, descripcion,
	        		image, url);
		 
	        return resultMethod;
	}
	public static void asignarPuntajes(Map<String, Integer> metodologias,int pregunta, String respuesta) {
	    
		 switch (pregunta) {
         case 0:
        	 if (respuesta.contains("A")) {
     	        metodologias.put(kanban, metodologias.get(kanban) + 1); 
     	        metodologias.put(scrum, metodologias.get(scrum) + 1);
     	        metodologias.put(xp, metodologias.get(xp) + 1);
     	    }
        	 if (respuesta.contains("B")) {
        		 metodologias.put(kanban, metodologias.get(kanban) + 1);
      	         metodologias.put(lean, metodologias.get(lean) + 1);
        	 }
      	     if (respuesta.contains("C")) {
      	       metodologias.put(kanban, metodologias.get(kanban) + 1); 
    	       metodologias.put(scrum, metodologias.get(scrum) + 1);
      	    }
        	break;
         case 1: 
        	 if (respuesta.contains("A")) {
        		 metodologias.put(kanban, metodologias.get(kanban) + 1); 
      	        metodologias.put(scrum, metodologias.get(scrum) + 1);
      	    }
        	if (respuesta.contains("B")) {
        		 metodologias.put(scrum, metodologias.get(scrum) + 1);
        		  metodologias.put(lean, metodologias.get(lean) + 1);
       	    }
        	if(respuesta.contains("C")){
        		 metodologias.put(xp, metodologias.get(xp) + 1);
       	    }
             break;
         case 2: 
        	 if (respuesta.contains("A")) {
        		 metodologias.put(scrum, metodologias.get(scrum) + 1);
        		 metodologias.put(kanban, metodologias.get(kanban) + 1); 
      	    }
        	if (respuesta.contains("B")) {
        		 metodologias.put(scrum, metodologias.get(scrum) + 1);
        		 metodologias.put(lean, metodologias.get(lean) + 1);
       	    }
        	if(respuesta.contains("C")){
        		 metodologias.put(xp, metodologias.get(xp) + 1);
       	    }
             break;
         case 3: 
        	 if (respuesta.contains("A")) {
        		 metodologias.put(scrum, metodologias.get(scrum) + 1);
        		 metodologias.put(xp, metodologias.get(xp) + 1);
      	    }
        	if (respuesta.contains("B")) {
        		 metodologias.put(kanban, metodologias.get(kanban) + 1); 
        		 metodologias.put(lean, metodologias.get(lean) + 1);
       	    }
        	if(respuesta.contains("C")){
        		 metodologias.put(kanban, metodologias.get(kanban) + 1); 
        		 metodologias.put(crystal, metodologias.get(crystal) + 1);
       	    }
             break;
         case 4: 
        	 if (respuesta.contains("A")) {
        		 metodologias.put(scrum, metodologias.get(scrum) + 1);
        		 metodologias.put(xp, metodologias.get(xp) + 1);
      	    }
        	if (respuesta.contains("B")) {
        		 metodologias.put(kanban, metodologias.get(kanban) + 1); 
        		 metodologias.put(lean, metodologias.get(lean) + 1);
       	    }
        	if(respuesta.contains("C")){
        		 metodologias.put(crystal, metodologias.get(crystal) + 1);
       	    }
             break; 
         case 5: 
        	 if (respuesta.contains("A")) {
        		 metodologias.put(scrum, metodologias.get(scrum) + 1);
        		 metodologias.put(xp, metodologias.get(xp) + 1);
      	    }
        	if (respuesta.contains("B")) {
        		 metodologias.put(kanban, metodologias.get(kanban) + 1); 
        		 metodologias.put(lean, metodologias.get(lean) + 1);
       	    }
        	if(respuesta.contains("C")){
        		 metodologias.put(crystal, metodologias.get(crystal) + 1);
        		 metodologias.put(lean, metodologias.get(lean) + 1);
       	    }
             break; 
         case 6: 
        	 if (respuesta.contains("A")) {
        		 metodologias.put(kanban, metodologias.get(kanban) + 1); 
        		 metodologias.put(lean, metodologias.get(lean) + 1);
      	    }
        	if (respuesta.contains("B")) {
        		 metodologias.put(scrum, metodologias.get(scrum) + 1);
       	    }
        	if(respuesta.contains("C")){
        		metodologias.put(xp, metodologias.get(xp) + 1);
       	    }
             break; 
         case 7: 
        	 if (respuesta.contains("A")) {
        		 metodologias.put(xp, metodologias.get(xp) + 1);
        		 metodologias.put(scrum, metodologias.get(scrum) + 1);
      	    }
        	if (respuesta.contains("B")) {
        		metodologias.put(kanban, metodologias.get(kanban) + 1); 
       		 metodologias.put(lean, metodologias.get(lean) + 1);
       	    }
        	if(respuesta.contains("C")){
        		 metodologias.put(crystal, metodologias.get(crystal) + 1);
       	    }
             break;
         case 8: 
        	 if (respuesta.contains("A")) {
        		 metodologias.put(scrum, metodologias.get(scrum) + 1);
           		 metodologias.put(xp, metodologias.get(xp) + 1);
      	    }
        	if (respuesta.contains("B")) {
        		metodologias.put(kanban, metodologias.get(kanban) + 1); 
        		metodologias.put(crystal, metodologias.get(crystal) + 1);
       	    }
        	break; 
         case 9: 
        	 if (respuesta.contains("A")) {
        		 metodologias.put(scrum, metodologias.get(scrum) + 1);
      	    }
        	if (respuesta.contains("B")) {
        		metodologias.put(kanban, metodologias.get(kanban) + 1); 
        		 metodologias.put(lean, metodologias.get(lean) + 1);
       	    }
        	if(respuesta.contains("C")){
        		metodologias.put(crystal, metodologias.get(crystal) + 1);
       	    }
             break;
         case 10: 
        	 if (respuesta.contains("A")) {
        		 metodologias.put(scrum, metodologias.get(scrum) + 1);
        		 metodologias.put(kanban, metodologias.get(kanban) + 1);
      	    }
        	if (respuesta.contains("B")) {
        		 metodologias.put(xp, metodologias.get(xp) + 1);
        		 metodologias.put(lean, metodologias.get(lean) + 1);
       	    }
        	if(respuesta.contains("C")){
        		metodologias.put(crystal, metodologias.get(crystal) + 1);
       	    }
             break;
        
         default:
             break;    
		 }
	   
	}
	
	 public static String seleccionarMetodologiaIdeal(Map<String, Integer> metodologias) {
	        // Seleccionar la metodología con el puntaje más alto
	        String metodologiaIdeal = "";
	        int puntajeMaximo = Integer.MIN_VALUE;

	        for (Map.Entry<String, Integer> entry : metodologias.entrySet()) {
	            if (entry.getValue() > puntajeMaximo) {
	                puntajeMaximo = entry.getValue();
	                metodologiaIdeal = entry.getKey();
	            }
	        }

	        return metodologiaIdeal;
	    }

}