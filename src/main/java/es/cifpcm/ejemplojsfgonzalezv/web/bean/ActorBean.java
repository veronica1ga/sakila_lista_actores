/**
 * 
 */
package es.cifpcm.ejemplojsfgonzalezv.web.bean;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;
import es.cifpcm.ejemplojsfgonzalezv.web.data.*;
import es.cifpcm.ejemplojsfgonzalezv.web.model.Actor;

/**
 * @author Veronica Gonzalez
 *
 */
@Named(value="actorBean")
@RequestScoped
public class ActorBean extends Actor{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private Integer actorId;
	//private final org.slf4j.Logger logger = LoggerFactory.getLogger(ActorBean.class);
	
    public ActorBean() {
    }
    
    @Size(min=1, message="nombre no puede estar vacío")
    public String getFirst_Name() {
        return super.getFirstName();
    }
    
    @Size(min=1, message="apellido no puede estar vacío")
    public String getLast_Name() {
        return super.getLastName();
    }
        
    

    public List<Actor> getActorList() {
    	ActorDAO listaActor = new ActorDAOImpl();
        List<Actor> ActorList=new ArrayList<Actor>();
        try{
            ActorList=listaActor.selectAll();
        }
        catch(Exception e){
            //logger.error("ERROR: {}",e.getMessage());
        }
        return ActorList;

    }



    public String save() {
    	ActorDAO actorDevuelto = new ActorDAOImpl();
        Actor datos = new Actor();
        datos.setFirstName(firstName);
        datos.setFirstName(lastName);
        try {
            datos = actorDevuelto.insert(this);
            this.firstName = datos.getFirstName();
            this.lastName = datos.getLastName();
            this.actorId=datos.getActorId();
            return "actorDetail";
        } catch (Exception e) {
            //logger.error("ERROR: {}", e.getMessage());
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error de inserción"));
        	return "error";
        }
    }

}
