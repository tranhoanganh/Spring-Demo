package com.anhth.spring.repository;

import com.anhth.spring.entity.AttributeEntity;
import com.anhth.spring.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttributeRepo extends JpaRepository<AttributeEntity, Integer> {

    Page<AttributeEntity> findAll(Pageable pageable);

    @Query("select c from AttributeEntity c where c.name like ?1")
    Page<AttributeEntity> findAllByName(String name, Pageable pageable);

    /*
    // version rút gọn
    Person findByLastname(String lastname);
    // verson đầy đủ
    Person findPersonByLastname(String lastname);

    Person findAllByLastname(String lastname);

    // Trung bình
    List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

    // findDistinct là tìm kiếm và loại bỏ đi các đối tượng trùng nhau
    List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
    List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

    // IgnoreCase là tìm kiếm không phân biệt hoa thường, ví dụ ở đây tìm kiếm lastname
    // lastname sẽ không phân biệt hoa thường
    List<Person> findByLastnameIgnoreCase(String lastname);

    // AllIgnoreCase là không phân biệt hoa thường cho tất cả thuộc tính
    List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

    // OrderBy là cách sắp xếp thứ tự trả về
    // Sắp xếp theo Firstname ASC
    List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
    // Sắp xếp theo Firstname Desc
    List<Person> findByLastnameOrderByFirstnameDesc(String lastname);
    // person.address.zipCode
    List<Person> findByAddressZipCode(ZipCode zipCode);

    // Khi được gắn @Query, thì tên của method không còn tác dụng nữa
    // Đây là JPQL
    @Query("select u from User u where u.emailAddress = ?1")
    User myCustomQuery(String emailAddress);

    // Đây là Native SQL
    @Query(value = "select * from User u where u.email_address = ?1", nativeQuery = true)
    User myCustomQuery2(String emailAddress);

    Nếu không thích sử dụng ?{number} thì có thể đặt tên cho tham số.
     // JPQL
    @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
    User findUserByNamedParams(@Param("status") Integer status, @Param("name") String name);

    // Native SQL
    @Query(value = "SELECT * FROM Users u WHERE u.status = :status and u.name = :name", nativeQuery = true)
    User findUserByNamedParamsNative(@Param("status") Integer status, @Param("name") String name);
     */
}
