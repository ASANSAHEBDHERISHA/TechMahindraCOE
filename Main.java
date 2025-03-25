package reldemo;

import java.util.List;

import jakarta.persistence.EntityManager;



class Main{
	public static void main(String[] args) {
		EntityManager em=JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
//		Author author=new Author("J.K.Rowling");
//		Book book1=new Book("Harry Potter and the Sorcerer's Stone");
//		Book book2=new Book("Harry Potter and the Chamber of Secrets");
//		author.addBook(book1);
//		author.addBook(book2);
//		em.persist(author);
		em.persist(new User("dherisha","dherisha@gmail.com","ACTIVE"));
		em.persist(new User("javi","javi123@gmail.com","INACTIVE"));
		em.persist(new User("sun","sunrise@gmail.com","ACTIVE"));
		
		em.getTransaction().commit();
		
//		List<User> user=em.createQuery("select u from User u where u.name=:name",User.class)
		List<User>user=em.createNamedQuery("User.findMyName",User.class)
				.setParameter("name","dherisha").getResultList();
		for(User u:user) {
			System.out.println(u.getName());
		}
		List <User>user1=em.createNamedQuery("User.findMyMail",User.class)
				.setParameter("email","dherisha@gmail.com").getResultList();
		for(User u:user1) {
			System.out.println(u.getEmail());
		}
		
		List <User>user2=em.createNamedQuery("User.findMyStatus",User.class)
				.setParameter(1,"ACTIVE").getResultList();
		for(User u:user1) {
			System.out.println(u.getStatus());
		}
		em.close();
		JPAUtil.close();
	}
}
