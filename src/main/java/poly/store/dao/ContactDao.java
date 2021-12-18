package poly.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.store.entity.Contact;

public interface ContactDao extends JpaRepository<Contact, Integer> {
	
	@Query("SELECT c FROM Contact c WHERE c.status = 0")
	List<Contact> getListContactPending();
	
	@Query("SELECT c FROM Contact c WHERE c.status = 1")
	List<Contact> getListContactChecked();
	
	@Query("SELECT c FROM Contact c WHERE c.id = :uid")
	Contact getContactByContactId(@Param("uid") Integer id);
}
