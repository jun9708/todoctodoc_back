package kr.co.todoctodoc_back.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserJPARepository extends JpaRepository<User, Integer> {

    //userId 검사
    public Optional<User> findByUserId(String UserId);

    //user -> tel 전화번호 중복검사
    public Optional<User> findByTel(String tel);

    @Query(value = "SELECT * FROM user_tb WHERE (username LIKE CONCAT('%', :keyword ,'%') or nickname LIKE CONCAT('%', :keyword ,'%')) and role = true", nativeQuery = true)
    Page<User> mfindSearchPageAll(String keyword, Pageable pageable);

    @Query(value = "SELECT * FROM user_tb WHERE (username LIKE CONCAT('%', :keyword ,'%') or nickname LIKE CONCAT('%', :keyword ,'%')) and role = true", nativeQuery = true)
    List<User> mfindSearchAll(@Param("keyword") String keyword);

    User findByUsername(String username);
}
