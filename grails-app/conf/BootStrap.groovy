import java.util.Date;

import cumpleempleados.Empleado
import cumpleempleados.Regalo

class BootStrap {

    def init = { servletContext ->
     
        //fecha cumpleaños empleados
		Date d1 = new Date("02/10/1987")
		Date d2 = new Date("03/11/1970")
		Date d3 = new Date("05/09/1988")
		
		//fecha de cumpleaños regalados		
		Date f1 = new Date("02/10/2014")
		Date f2 = new Date("03/11/2013")
		Date f3 = new Date("03/11/2012")			
		
		
		Regalo r1 = CreateRegalo("ipod",0,f1,"imagen de la foto")
		r1.save(failOnError:true)
		Regalo r2 = CreateRegalo("nokia",0,f2,"imagen de la foto")
		r2.save(failOnError:true)
		Regalo r3 = CreateRegalo("ps4",0,f3,"imagen de la foto")
		r3.save(failOnError:true)
		
		Empleado e2 = CreateEmpleado("Pepe","sapo","123456","sapo@hotmail.com",d1)				
		e2.regalos.add(r1)		
		Empleado e3 = CreateEmpleado("Lucas","sopo","12345678","luca@hotmail.com",d2)
		e3.regalos.add(r2)
		e3.regalos.add(r3)
		
		Empleado e4 = CreateEmpleado("Martin","mar","12345678","mar@hotmail.com",d3)		
		
		e2.save(failOnError:true)
		e3.save(failOnError:true)
		e4.save(failOnError:true)			
    }

	def CreateEmpleado (a,b,c,d,e){
		Empleado e1 = new Empleado (nombre:a,apellido:b,password:c,mail:d,cumpleaños:e);			
		e1.regalos = new ArrayList();
		return e1
	}
	
	def CreateRegalo(a,b,c,d){		
        Regalo r1 = new Regalo (descripcion:a , estado:b , fecha:c , url:d);
	    return r1		
	}
	
	def destroy = {
	  
	}
	
}	