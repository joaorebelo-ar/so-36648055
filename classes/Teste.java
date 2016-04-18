package classes;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class Teste {

    @PersistenceContext(name="Testing")
    private EntityManager em;
    
    @PostConstruct
    private void initialize(){
	
	Child c1 = new Child();
	c1.setId(1L);
	
	Child c2 = new Child();
	c2.setId(2L);
	Child c3 = new Child();
	c3.setId(3L);
	
	Parent p1 = new Parent();
	p1.setId(1L);
	p1.setChildren(Arrays.asList(c1, c2));
	
	Parent p2 = new Parent();
	p2.setId(2L);
	p2.setChildren(Arrays.asList(c3));
	
	System.out.println(c1);
	System.out.println(c2);
	System.out.println(c3);
	System.out.println(p1);
	System.out.println(p2);
	
	em.persist(p1);
	em.persist(p2);

	
	em.flush();
	
	em.merge(c1);
	em.merge(c2);
	em.merge(c3);
	
	em.flush();
	
	em.refresh(c1);
	em.refresh(c2);
	em.refresh(c3);
	em.refresh(p1);
	em.refresh(p2);
	
	c1 = em.find(Child.class, 1L);
	
	System.out.println(c1.getParent().getChildren());
	System.out.println(c1);
	System.out.println(c2);
	System.out.println(c3);
	System.out.println(p1);
	System.out.println(p2);
	

	p1.getChildren().clear();
	
	em.merge(p1);
	em.flush();

	em.refresh(p1);
	em.refresh(p2);

	System.out.println(c1);
	System.out.println(c2);
	System.out.println(c3);
	System.out.println(p1);
	System.out.println(p2);
    }
    
}
